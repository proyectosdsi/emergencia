/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.emergencia.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;
import sv.gob.mined.emergencia.ejb.DonacionEJB;
import sv.gob.mined.emergencia.model.EmerEstadoAlbergue;
import sv.gob.mined.emergencia.model.EmerTipoEmergencia;
import sv.gob.mined.emergencia.model.pojo.VwCatalogoEntidad;
import sv.gob.mined.emergencia.util.Parametros;

/**
 *
 * @author MISanchez
 */
@ManagedBean
@ViewScoped
public class RegistroEmergenciaMB implements Serializable {

    @EJB
    private DonacionEJB donacionEJB;

    public VwCatalogoEntidad vwCatalogoEntidad = new VwCatalogoEntidad();
    public Short estadoAlbergue;
    public String codigoEntidad;

    public EmerTipoEmergencia emergenciaSeleccionada = new EmerTipoEmergencia();

    //public List<EmerTipoEmergencia> lstTipoEmergencia = new ArrayList<>();
    @PostConstruct
    public void init() {
    }

    public List<EmerTipoEmergencia> getLstTipoEmergencia() {
        return donacionEJB.getListadoTipoEmergenciaActivas();
    }

    public List<EmerEstadoAlbergue> getLstEstadoAlbergue() {
        return donacionEJB.getLstEstadoAlbergue();
    }

    public void showDialogEmergencia() {
        PrimeFaces.current().executeScript("PF('dlgEmergencia').show()");
    }

    public EmerTipoEmergencia getEmergenciaSeleccionada() {
        return emergenciaSeleccionada;
    }

    public void setEmergenciaSeleccionada(EmerTipoEmergencia emergenciaSeleccionada) {
        this.emergenciaSeleccionada = emergenciaSeleccionada;
    }

    public Short getEstadoAlbergue() {
        return estadoAlbergue;
    }

    public void setEstadoAlbergue(Short estadoAlbergue) {
        this.estadoAlbergue = estadoAlbergue;
    }

    public String getCodigoEntidad() {
        return codigoEntidad;
    }

    public void setCodigoEntidad(String codigoEntidad) {
        this.codigoEntidad = codigoEntidad;
    }

    public DonacionEJB getDonacionEJB() {
        return donacionEJB;
    }

    public VwCatalogoEntidad getVwCatalogoEntidad() {
        return vwCatalogoEntidad;
    }

    public void buscarEntidad() {
        vwCatalogoEntidad = donacionEJB.getLstEntidad(codigoEntidad);

        if (vwCatalogoEntidad == null) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informarción", "No se ha encontrado el centro educativo con código: " + codigoEntidad));
        }
    }
}
