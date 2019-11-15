/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.emergencia.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import sv.gob.mined.emergencia.ejb.DonacionEJB;
import sv.gob.mined.emergencia.model.EmerDonacion;
import sv.gob.mined.emergencia.model.EmerTipoEmergencia;
import sv.gob.mined.emergencia.util.Parametros;

/**
 *
 * @author MISanchez
 */
@ManagedBean
@ViewScoped
public class DonacionMB implements Serializable {

    private EmerTipoEmergencia tipoEmergencia = new EmerTipoEmergencia();

    private List<EmerTipoEmergencia> lstTiposEmerSeleccionado = new ArrayList<>();

    public List<EmerTipoEmergencia> getLstTiposEmerSeleccionado() {
        return lstTiposEmerSeleccionado;
    }

    public void setLstTiposEmerSeleccionado(List<EmerTipoEmergencia> lstTiposEmerSeleccionado) {
        this.lstTiposEmerSeleccionado = lstTiposEmerSeleccionado;
    }

    public EmerTipoEmergencia getTipoEmergencia() {
        return tipoEmergencia;
    }

    public void setTipoEmergencia(EmerTipoEmergencia tipoEmergencia) {
        if (tipoEmergencia == null) {

        } else {
            this.tipoEmergencia = tipoEmergencia;
        }
    }

    private List<EmerDonacion> lstDonacion = new ArrayList();
    private List<EmerTipoEmergencia> lstTipoEmergencia = new ArrayList();

    @EJB
    public DonacionEJB donacionEJB;

    @PostConstruct
    public void init() {
        lstDonacion = donacionEJB.getListaDonacion();
        lstTipoEmergencia = donacionEJB.getListadoTipoEmergencia();
    }

    public List<EmerDonacion> getLstDonacion() {
        return lstDonacion;
    }

    public List<EmerTipoEmergencia> getLstTipoEmergencia() {
        return lstTipoEmergencia;
    }

    public void guardar() {
        HashMap<String, String> param = donacionEJB.guardar(tipoEmergencia);

        if (param.containsKey(Parametros.MSJ_INFO)) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informarción", param.get(Parametros.MSJ_INFO)));
            lstTipoEmergencia = donacionEJB.getListadoTipoEmergencia();
        }
        if (param.containsKey(Parametros.MSJ_ERROR)) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", param.get(Parametros.MSJ_ERROR)));
        }

    }

    public void nuevo() {
        tipoEmergencia = new EmerTipoEmergencia();

    }

    public void eliminar() {
        if (tipoEmergencia != null && tipoEmergencia.getCodigoEmergencia() != null) {
            donacionEJB.eliminar(tipoEmergencia.getCodigoEmergencia());
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informarción", "No se ha seleccionado un registro valido"));
        }
    }

    public void eliminar(Integer codigoEmergencia) {
        donacionEJB.eliminar(codigoEmergencia);
    }

    public void eliminacionMultiple() {
        donacionEJB.eliminacionMultiple(lstTiposEmerSeleccionado);
        
        lstTipoEmergencia = donacionEJB.getListadoTipoEmergencia();
    }
}
