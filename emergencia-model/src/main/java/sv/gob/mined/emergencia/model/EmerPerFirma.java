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
@Table(name = "EMER_PER_FIRMA")
@NamedQueries({
    @NamedQuery(name = "EmerPerFirma.findAll", query = "SELECT e FROM EmerPerFirma e")})
public class EmerPerFirma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CORRELATIVO_PERSONAL")
    private Integer correlativoPersonal;
    @Column(name = "NOMBRE_COORDINADO")
    private String nombreCoordinado;
    @Column(name = "POSEIBLE_DESALOJO")
    private String poseibleDesalojo;
    @Column(name = "OBSERVACION_PERSONAL")
    private String observacionPersonal;
    @JoinColumn(name = "ID_PERSONAL", referencedColumnName = "ID_PERSONAL")
    @ManyToOne(fetch = FetchType.LAZY)
    private EmerMinedPer idPersonal;
    @JoinColumn(name = "CORRELATIVO_REGISTRO", referencedColumnName = "CORRELATIVO_REGISTRO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmerRegistroAlbergue correlativoRegistro;

    public EmerPerFirma() {
    }

    public EmerPerFirma(Integer correlativoPersonal) {
        this.correlativoPersonal = correlativoPersonal;
    }

    public Integer getCorrelativoPersonal() {
        return correlativoPersonal;
    }

    public void setCorrelativoPersonal(Integer correlativoPersonal) {
        this.correlativoPersonal = correlativoPersonal;
    }

    public String getNombreCoordinado() {
        return nombreCoordinado;
    }

    public void setNombreCoordinado(String nombreCoordinado) {
        this.nombreCoordinado = nombreCoordinado;
    }

    public String getPoseibleDesalojo() {
        return poseibleDesalojo;
    }

    public void setPoseibleDesalojo(String poseibleDesalojo) {
        this.poseibleDesalojo = poseibleDesalojo;
    }

    public String getObservacionPersonal() {
        return observacionPersonal;
    }

    public void setObservacionPersonal(String observacionPersonal) {
        this.observacionPersonal = observacionPersonal;
    }

    public EmerMinedPer getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(EmerMinedPer idPersonal) {
        this.idPersonal = idPersonal;
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
        hash += (correlativoPersonal != null ? correlativoPersonal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmerPerFirma)) {
            return false;
        }
        EmerPerFirma other = (EmerPerFirma) object;
        if ((this.correlativoPersonal == null && other.correlativoPersonal != null) || (this.correlativoPersonal != null && !this.correlativoPersonal.equals(other.correlativoPersonal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.org.mined.emergencia.model.EmerPerFirma[ correlativoPersonal=" + correlativoPersonal + " ]";
    }
    
}
