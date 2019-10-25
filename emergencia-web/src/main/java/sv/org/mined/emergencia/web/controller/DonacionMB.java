/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.org.mined.emergencia.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sv.org.mined.emergencia.ejb.DonacionEJB;
import sv.org.mined.emergencia.model.EmerDonacion;
import sv.org.mined.emergencia.model.EmerTipoEmergencia;

/**
 *
 * @author MISanchez
 */
@ManagedBean
@ViewScoped
public class DonacionMB implements Serializable{
    
    private EmerTipoEmergencia tipoEmergencia;

    public EmerTipoEmergencia getTipoEmergencia() {
        return tipoEmergencia;
    }

    public void setTipoEmergencia(EmerTipoEmergencia tipoEmergencia) {
        this.tipoEmergencia = tipoEmergencia;
    }
    
    private List<EmerDonacion> lstDonacion = new ArrayList();
    private List<EmerTipoEmergencia> lstTipoEmergencia = new ArrayList();
    
    
    @EJB
    public DonacionEJB donacionEJB;
    
    
    @PostConstruct
    public void init(){
        lstDonacion = donacionEJB.getListaDonacion();
        lstTipoEmergencia = donacionEJB.getListadoTipoEmergencia();
    }

    public List<EmerDonacion> getLstDonacion() {
        return lstDonacion;
    }

    public List<EmerTipoEmergencia> getLstTipoEmergencia() {
        return lstTipoEmergencia;
    }
    
    
}
