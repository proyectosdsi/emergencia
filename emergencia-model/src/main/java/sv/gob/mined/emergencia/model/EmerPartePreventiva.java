/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.emergencia.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author MISanchez
 */
@Entity
@Table(name = "EMER_PARTE_PREVENTIVA")
@NamedQueries({
    @NamedQuery(name = "EmerPartePreventiva.findAll", query = "SELECT e FROM EmerPartePreventiva e")})
public class EmerPartePreventiva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PREVENTIVA")
    private Integer idPreventiva;
    @Column(name = "TIPO_ORGANIZACION")
    private String tipoOrganizacion;
    @Column(name = "PLAN_EMERGENCIA")
    private Character planEmergencia;
    @Column(name = "ACTIVACION_PLAN")
    private Character activacionPlan;
    @Column(name = "APLICACION_MECANISMO")
    private String aplicacionMecanismo;
    @JoinColumn(name = "CORRELATIVO_REGISTRO", referencedColumnName = "CORRELATIVO_REGISTRO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmerRegistroAlbergue correlativoRegistro;
    @JoinColumn(name = "ID_RESPONSABILIDAD", referencedColumnName = "ID_RESPONSABILIDAD")
    @ManyToOne(fetch = FetchType.LAZY)
    private EmerTiposResponble idResponsabilidad;

    public EmerPartePreventiva() {
    }

    public EmerPartePreventiva(Integer idPreventiva) {
        this.idPreventiva = idPreventiva;
    }

    public Integer getIdPreventiva() {
        return idPreventiva;
    }

    public void setIdPreventiva(Integer idPreventiva) {
        this.idPreventiva = idPreventiva;
    }

    public String getTipoOrganizacion() {
        return tipoOrganizacion;
    }

    public void setTipoOrganizacion(String tipoOrganizacion) {
        this.tipoOrganizacion = tipoOrganizacion;
    }

    public Character getPlanEmergencia() {
        return planEmergencia;
    }

    public void setPlanEmergencia(Character planEmergencia) {
        this.planEmergencia = planEmergencia;
    }

    public Character getActivacionPlan() {
        return activacionPlan;
    }

    public void setActivacionPlan(Character activacionPlan) {
        this.activacionPlan = activacionPlan;
    }

    public String getAplicacionMecanismo() {
        return aplicacionMecanismo;
    }

    public void setAplicacionMecanismo(String aplicacionMecanismo) {
        this.aplicacionMecanismo = aplicacionMecanismo;
    }

    public EmerRegistroAlbergue getCorrelativoRegistro() {
        return correlativoRegistro;
    }

    public void setCorrelativoRegistro(EmerRegistroAlbergue correlativoRegistro) {
        this.correlativoRegistro = correlativoRegistro;
    }

    public EmerTiposResponble getIdResponsabilidad() {
        return idResponsabilidad;
    }

    public void setIdResponsabilidad(EmerTiposResponble idResponsabilidad) {
        this.idResponsabilidad = idResponsabilidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPreventiva != null ? idPreventiva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmerPartePreventiva)) {
            return false;
        }
        EmerPartePreventiva other = (EmerPartePreventiva) object;
        if ((this.idPreventiva == null && other.idPreventiva != null) || (this.idPreventiva != null && !this.idPreventiva.equals(other.idPreventiva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.org.mined.emergencia.model.EmerPartePreventiva[ idPreventiva=" + idPreventiva + " ]";
    }
    
}
