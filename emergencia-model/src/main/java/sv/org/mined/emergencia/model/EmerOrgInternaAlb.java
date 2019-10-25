/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.org.mined.emergencia.model;

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
@Table(name = "EMER_ORG_INTERNA_ALB")
@NamedQueries({
    @NamedQuery(name = "EmerOrgInternaAlb.findAll", query = "SELECT e FROM EmerOrgInternaAlb e")})
public class EmerOrgInternaAlb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CORRELATIVO_INTERNA_ALBERGUE")
    private Integer correlativoInternaAlbergue;
    @Column(name = "NOMBRE_INTERNA")
    private String nombreInterna;
    @Column(name = "TEL_INTERNA")
    private String telInterna;
    @Column(name = "CARGO_INTERNA")
    private String cargoInterna;
    @Column(name = "HORA_ATEN")
    private String horaAten;
    @Column(name = "TELEFONO_ATEN")
    private String telefonoAten;
    @JoinColumn(name = "CORRELATIVO_REGISTRO", referencedColumnName = "CORRELATIVO_REGISTRO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmerRegistroAlbergue correlativoRegistro;

    public EmerOrgInternaAlb() {
    }

    public EmerOrgInternaAlb(Integer correlativoInternaAlbergue) {
        this.correlativoInternaAlbergue = correlativoInternaAlbergue;
    }

    public Integer getCorrelativoInternaAlbergue() {
        return correlativoInternaAlbergue;
    }

    public void setCorrelativoInternaAlbergue(Integer correlativoInternaAlbergue) {
        this.correlativoInternaAlbergue = correlativoInternaAlbergue;
    }

    public String getNombreInterna() {
        return nombreInterna;
    }

    public void setNombreInterna(String nombreInterna) {
        this.nombreInterna = nombreInterna;
    }

    public String getTelInterna() {
        return telInterna;
    }

    public void setTelInterna(String telInterna) {
        this.telInterna = telInterna;
    }

    public String getCargoInterna() {
        return cargoInterna;
    }

    public void setCargoInterna(String cargoInterna) {
        this.cargoInterna = cargoInterna;
    }

    public String getHoraAten() {
        return horaAten;
    }

    public void setHoraAten(String horaAten) {
        this.horaAten = horaAten;
    }

    public String getTelefonoAten() {
        return telefonoAten;
    }

    public void setTelefonoAten(String telefonoAten) {
        this.telefonoAten = telefonoAten;
    }

    public EmerRegistroAlbergue getCorrelativoRegistro() {
        return correlativoRegistro;
    }

    public void setCorrelativoRegistro(EmerRegistroAlbergue correlativoRegistro) {
        this.correlativoRegistro = correlativoRegistro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (correlativoInternaAlbergue != null ? correlativoInternaAlbergue.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmerOrgInternaAlb)) {
            return false;
        }
        EmerOrgInternaAlb other = (EmerOrgInternaAlb) object;
        if ((this.correlativoInternaAlbergue == null && other.correlativoInternaAlbergue != null) || (this.correlativoInternaAlbergue != null && !this.correlativoInternaAlbergue.equals(other.correlativoInternaAlbergue))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.org.mined.emergencia.model.EmerOrgInternaAlb[ correlativoInternaAlbergue=" + correlativoInternaAlbergue + " ]";
    }
    
}
