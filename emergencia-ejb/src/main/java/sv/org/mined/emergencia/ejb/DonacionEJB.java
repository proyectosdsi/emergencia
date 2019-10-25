/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.org.mined.emergencia.ejb;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.org.mined.emergencia.model.EmerDonacion;
import sv.org.mined.emergencia.model.EmerTipoEmergencia;

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
    
    
    public List<EmerTipoEmergencia> getListadoTipoEmergencia(){
        Query q = em.createQuery("SELECT t FROM EmerTipoEmergencia t", EmerTipoEmergencia.class);
        return q.getResultList();
    }
}
