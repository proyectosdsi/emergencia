/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.emergencia.web.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;
import sv.gob.mined.emergencia.ejb.RegistroEmergenciaEJB;
import sv.gob.mined.emergencia.model.EmerEstadoAlbergue;
import sv.gob.mined.emergencia.model.EmerIntervencion;
import sv.gob.mined.emergencia.model.EmerRegistroAlbergue;
import sv.gob.mined.emergencia.model.EmerTipoEmergencia;
import sv.gob.mined.emergencia.model.pojo.VwCatalogoEntidad;

/**
 *
 * @author MISanchez
 */
@ManagedBean
@ViewScoped
public class RegistroEmergenciaMB implements Serializable {

    @EJB
    private RegistroEmergenciaEJB registroEmergenciaEJB;
    //Pojo que mapea a la vista de catalogo de entidades 
    public VwCatalogoEntidad vwCatalogoEntidad = new VwCatalogoEntidad();
    public Short estadoAlbergue;
    public String codigoEntidad;
    //listadoi para selecccionar las emergencia creadas
    public EmerTipoEmergencia emergenciaSeleccionada = new EmerTipoEmergencia();
    //listado de tipo de reguistro de la emergencia
    public EmerRegistroAlbergue emerRegistroAlbergue = new EmerRegistroAlbergue();

    private EmerIntervencion emerIntervencion = new EmerIntervencion();

    //public List<EmerTipoEmergencia> lstTipoEmergencia = new ArrayList<>();
    @PostConstruct
    public void init() {
    }

    public EmerIntervencion getEmerIntervencion() {
        return emerIntervencion;
    }

    public void setEmerIntervencion(EmerIntervencion emerIntervencion) {
        this.emerIntervencion = emerIntervencion;
    }

    public List<EmerTipoEmergencia> getLstTipoEmergencia() {
        return registroEmergenciaEJB.getListadoTipoEmergenciaActivas();
    }

    public List<EmerEstadoAlbergue> getLstEstadoAlbergue() {
        return registroEmergenciaEJB.getLstEstadoAlbergue();
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

    public RegistroEmergenciaEJB getRegistroEmergenciaEJB() {
        return registroEmergenciaEJB;
    }

    public VwCatalogoEntidad getVwCatalogoEntidad() {
        return vwCatalogoEntidad;
    }

    public EmerRegistroAlbergue getEmerRegistroAlbergue() {
        return emerRegistroAlbergue;
    }

    public void buscarEntidad() {
        vwCatalogoEntidad = registroEmergenciaEJB.getLstEntidad(codigoEntidad);

        if (vwCatalogoEntidad == null) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informarción", "No se ha encontrado el centro educativo con código: " + codigoEntidad));
        }
    }

    public void guardar() {
        emerIntervencion.setCorrelativoRegistro(emerRegistroAlbergue);
        emerRegistroAlbergue.getEmerIntervencionList().add(emerIntervencion);

        emerRegistroAlbergue.setCodigoEmergencia(emergenciaSeleccionada);
        emerRegistroAlbergue.setCodigoEntidad(vwCatalogoEntidad.getCodigoEntidad());

        registroEmergenciaEJB.guardar(emerRegistroAlbergue);
    }
}
