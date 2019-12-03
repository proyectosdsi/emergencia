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
import sv.gob.mined.emergencia.model.EmerDonacion;
import sv.gob.mined.emergencia.model.EmerEstadoAlbergue;
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
public class DonacionEJB {

    @PersistenceContext
    private EntityManager em;

    public List<EmerDonacion> getListaDonacion() {
        Query q = em.createQuery("SELECT e FROM EmerDonacion e", EmerDonacion.class);

        q = em.createNamedQuery("EmerDonacion.findAll", EmerDonacion.class);

        q = em.createNativeQuery("SELECT * FROM EMER_DONACION", EmerDonacion.class);

        return q.getResultList();
    }

    public EmerDonacion getDonacionByPK(Integer pk) {
        Query q = em.createQuery("SELECT e FROM EmerDonacion e WHERE e.correlativoDonacion = :valor", EmerDonacion.class);
        q.setParameter("valor", pk);

        q = em.createNamedQuery("EmerDonacion.findByPk", EmerDonacion.class);
        q.setParameter("valor", pk);

        q = em.createNativeQuery("SELECT * FROM EMER_DONACION WHERE CORRELATIVO_DONACION = ?1", EmerDonacion.class);
        q.setParameter(1, pk);

        return (EmerDonacion) q.getSingleResult();
    }

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
        /*
        EmerTipoEmergencia emer = em.find(EmerTipoEmergencia.class, codigoEmergencia);
        em.detach(emer);
         */

        //forma de poner en cola las peticiones realizadas a este bloque de codigo
        //synchronized (this) {
        Query q = em.createQuery("DELETE FROM EmerTipoEmergencia e WHERE e.codigoEmergencia=:codEmer");
        q.setParameter("codEmer", codigoEmergencia);

        /*Query q = em.createNativeQuery("DELETE FROM Emer_Tipo_Emergencia WHERE codigo_Emergencia=?1");
        q.setParameter(1, codigoEmergencia);*/
        q.executeUpdate();
        //}
    }

    public void eliminacionMultiple(List<EmerTipoEmergencia> lstEliminar) {
        for (EmerTipoEmergencia emer : lstEliminar) {
            eliminar(emer.getCodigoEmergencia());
        }

        /* el arreglo debe de ser del tipo de dato del where
        Query q = em.createQuery("DELETE FROM EmerTipoEmergencia e WHERE e.codigoEmergencia in :codigos");
        q.setParameter("codigos", lstEliminar);
         */
    }

    public List<EmerEstadoAlbergue> getLstEstadoAlbergue() {
        Query q = em.createQuery("SELECT e FROM EmerEstadoAlbergue e ORDER BY e.codigoEstado", EmerEstadoAlbergue.class);
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
}
