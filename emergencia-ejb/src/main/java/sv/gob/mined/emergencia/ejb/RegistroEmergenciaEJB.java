/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.emergencia.ejb;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.ejb.AccessTimeout;
import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.gob.mined.emergencia.model.EmerEstadoAlbergue;
import sv.gob.mined.emergencia.model.EmerRegistroAlbergue;
import sv.gob.mined.emergencia.model.EmerTipoEmergencia;
import sv.gob.mined.emergencia.model.pojo.VwCatalogoEntidad;
import sv.gob.mined.emergencia.util.Parametros;

/**
 *
 * @author MISanchez
 */
@Stateless
@LocalBean
@AccessTimeout(unit = TimeUnit.MILLISECONDS, value = 8000)
public class RegistroEmergenciaEJB {

    @PersistenceContext
    private EntityManager em;

    public List<EmerTipoEmergencia> getListadoTipoEmergencia() {
        Query q = em.createQuery("SELECT t FROM EmerTipoEmergencia t ORDER BY t.codigoEmergencia", EmerTipoEmergencia.class);
        return q.getResultList();
    }

    public List<EmerTipoEmergencia> getListadoTipoEmergenciaActivas() {
        Query q = em.createQuery("SELECT e FROM EmerTipoEmergencia e WHERE e.activo='1'", EmerTipoEmergencia.class);
        return q.getResultList();
    }

    public HashMap<String, String> guardar(EmerTipoEmergencia tipoEmergencia) {
        HashMap<String, String> param = new HashMap();

        //String msj = "";
        try {
            Query q = em.createQuery("SELECT e FROM EmerTipoEmergencia e wHERE e.nombreEmergencia=:nomEmergencia", EmerTipoEmergencia.class);
            q.setParameter("nomEmergencia", tipoEmergencia.getNombreEmergencia());

            if (q.getResultList().isEmpty()) {
                if (tipoEmergencia.getCodigoEmergencia() == null) {
                    em.persist(tipoEmergencia);
                    param.put(Parametros.MSJ_INFO, "Se ha creado la emergencia con nombre: " + tipoEmergencia.getNombreEmergencia());
                }
            } else {
                if (tipoEmergencia.getCodigoEmergencia() == null) {
                    param.put(Parametros.MSJ_ERROR, "No se puede crear la emergencia");
                } else {
                    em.merge(tipoEmergencia);
                    param.put(Parametros.MSJ_INFO, "Se ha actualizado la emergencia seleccionada.");
                }
            }
        } catch (Exception e) {
            param.put(Parametros.MSJ_ERROR, "Ah ocurrido un error en el proceso de regristro");
        }

        return param;
    }

    @Lock(LockType.WRITE)
    public void eliminar(Integer codigoEmergencia) {
        Query q = em.createQuery("DELETE FROM EmerTipoEmergencia e WHERE e.codigoEmergencia=:codEmer");
        q.setParameter("codEmer", codigoEmergencia);
        q.executeUpdate();

    }

    public List<EmerEstadoAlbergue> getLstEstadoAlbergue() {
        Query q = em.createQuery("SELECT e FROM EmerEstadoAlbergue e ORDER BY e.codigoEstado", EmerEstadoAlbergue.class);
        return q.getResultList();
    }

    public List<EmerRegistroAlbergue> getLstRegistroAlbergue() {
        Query q = em.createQuery("SELECT e FROM EmerRegistroAlbergue e ORDER BY e.codigoEnyidad", EmerRegistroAlbergue.class);
        return q.getResultList();
    }

    public VwCatalogoEntidad getLstEntidad(String codigoEntdad) {
        Query q = em.createNamedQuery("Emergencia.VwCatalogoEntidad", VwCatalogoEntidad.class);
        q.setParameter(1, codigoEntdad);

        List<VwCatalogoEntidad> lst = q.getResultList();

        if (lst.isEmpty()) {
            return null;
        } else {
            return lst.get(0);
        }
    }

    public EmerRegistroAlbergue guardar(EmerRegistroAlbergue emerRegistroAlbergue) {
        if (emerRegistroAlbergue.getCorrelativoRegistro() == null) {
            em.persist(emerRegistroAlbergue);
        } else {
            emerRegistroAlbergue = em.merge(emerRegistroAlbergue);
        }

        return emerRegistroAlbergue;
    }
}
