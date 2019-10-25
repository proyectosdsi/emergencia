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
@Table(name = "EMER_RES_MINED")
@NamedQueries({
    @NamedQuery(name = "EmerResMined.findAll", query = "SELECT e FROM EmerResMined e")})
public class EmerResMined implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CORRELATIVO_PERSONAL")
    private Integer correlativoPersonal;
    @Column(name = "NOMBRE_RESPONSABLE")
    private String nombreResponsable;
    @Column(name = "DIRECCION_CASA_RESPONSABLE")
    private String direccionCasaResponsable;
    @Column(name = "DUI_RESPPONSABLE")
    private String duiRespponsable;
    @Column(name = "TELEFONO_RESPONSABLE")
    private String telefonoResponsable;
    @JoinColumn(name = "CORRELATIVO_REGISTRO", referencedColumnName = "CORRELATIVO_REGISTRO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmerRegistroAlbergue correlativoRegistro;
    @JoinColumn(name = "ID_RESPONSABILIDAD", referencedColumnName = "ID_RESPONSABILIDAD")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmerTiposResponble idResponsabilidad;

    public EmerResMined() {
    }

    public EmerResMined(Integer correlativoPersonal) {
        this.correlativoPersonal = correlativoPersonal;
    }

    public Integer getCorrelativoPersonal() {
        return correlativoPersonal;
    }

    public void setCorrelativoPersonal(Integer correlativoPersonal) {
        this.correlativoPersonal = correlativoPersonal;
    }

    public String getNombreResponsable() {
        return nombreResponsable;
    }

    public void setNombreResponsable(String nombreResponsable) {
        this.nombreResponsable = nombreResponsable;
    }

    public String getDireccionCasaResponsable() {
        return direccionCasaResponsable;
    }

    public void setDireccionCasaResponsable(String direccionCasaResponsable) {
        this.direccionCasaResponsable = direccionCasaResponsable;
    }

    public String getDuiRespponsable() {
        return duiRespponsable;
    }

    public void setDuiRespponsable(String duiRespponsable) {
        this.duiRespponsable = duiRespponsable;
    }

    public String getTelefonoResponsable() {
        return telefonoResponsable;
    }

    public void setTelefonoResponsable(String telefonoResponsable) {
        this.telefonoResponsable = telefonoResponsable;
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
        hash += (correlativoPersonal != null ? correlativoPersonal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmerResMined)) {
            return false;
        }
        EmerResMined other = (EmerResMined) object;
        if ((this.correlativoPersonal == null && other.correlativoPersonal != null) || (this.correlativoPersonal != null && !this.correlativoPersonal.equals(other.correlativoPersonal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.org.mined.emergencia.model.EmerResMined[ correlativoPersonal=" + correlativoPersonal + " ]";
    }
    
}
