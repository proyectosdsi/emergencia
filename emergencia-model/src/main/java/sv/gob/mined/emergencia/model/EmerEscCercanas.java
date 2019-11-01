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
@Table(name = "EMER_ESC_CERCANAS")
@NamedQueries({
    @NamedQuery(name = "EmerEscCercanas.findAll", query = "SELECT e FROM EmerEscCercanas e")})
public class EmerEscCercanas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CORRELATIVO_ESCUELAS")
    private Integer correlativoEscuelas;
    @Column(name = "CODIGO_ENTIDAD")
    private String codigoEntidad;
    @Column(name = "OBSERVACION")
    private String observacion;
    @JoinColumn(name = "CORRELATIVO_REGISTRO", referencedColumnName = "CORRELATIVO_REGISTRO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmerRegistroAlbergue correlativoRegistro;

    public EmerEscCercanas() {
    }

    public EmerEscCercanas(Integer correlativoEscuelas) {
        this.correlativoEscuelas = correlativoEscuelas;
    }

    public Integer getCorrelativoEscuelas() {
        return correlativoEscuelas;
    }

    public void setCorrelativoEscuelas(Integer correlativoEscuelas) {
        this.correlativoEscuelas = correlativoEscuelas;
    }

    public String getCodigoEntidad() {
        return codigoEntidad;
    }

    public void setCodigoEntidad(String codigoEntidad) {
        this.codigoEntidad = codigoEntidad;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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
        hash += (correlativoEscuelas != null ? correlativoEscuelas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmerEscCercanas)) {
            return false;
        }
        EmerEscCercanas other = (EmerEscCercanas) object;
        if ((this.correlativoEscuelas == null && other.correlativoEscuelas != null) || (this.correlativoEscuelas != null && !this.correlativoEscuelas.equals(other.correlativoEscuelas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.org.mined.emergencia.model.EmerEscCercanas[ correlativoEscuelas=" + correlativoEscuelas + " ]";
    }
    
}
