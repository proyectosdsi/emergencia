/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.org.mined.emergencia.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author MISanchez
 */
@Entity
@Table(name = "EMER_OBSERVACIONES")
@NamedQueries({
    @NamedQuery(name = "EmerObservaciones.findAll", query = "SELECT e FROM EmerObservaciones e")})
public class EmerObservaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CORRELATIVO_OBSERVACION")
    private Integer correlativoObservacion;
    @Column(name = "OBSERVACION")
    private String observacion;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "CORRELATIVO_REGISTRO", referencedColumnName = "CORRELATIVO_REGISTRO")
    @ManyToOne(fetch = FetchType.LAZY)
    private EmerRegistroAlbergue correlativoRegistro;

    public EmerObservaciones() {
    }

    public EmerObservaciones(Integer correlativoObservacion) {
        this.correlativoObservacion = correlativoObservacion;
    }

    public Integer getCorrelativoObservacion() {
        return correlativoObservacion;
    }

    public void setCorrelativoObservacion(Integer correlativoObservacion) {
        this.correlativoObservacion = correlativoObservacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
        hash += (correlativoObservacion != null ? correlativoObservacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmerObservaciones)) {
            return false;
        }
        EmerObservaciones other = (EmerObservaciones) object;
        if ((this.correlativoObservacion == null && other.correlativoObservacion != null) || (this.correlativoObservacion != null && !this.correlativoObservacion.equals(other.correlativoObservacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.org.mined.emergencia.model.EmerObservaciones[ correlativoObservacion=" + correlativoObservacion + " ]";
    }
    
}
