/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.emergencia.ejb;

import java.util.HashMap;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.gob.mined.emergencia.model.EmerDonacion;
import sv.gob.mined.emergencia.model.EmerTipoEmergencia;
import sv.gob.mined.emergencia.util.Parametros;

/**
 *
 * @author MISanchez
 */
@Stateless
@LocalBean
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
        Query q = em.createQuery("SELECT t FROM EmerTipoEmergencia t", EmerTipoEmergencia.class);
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
}
