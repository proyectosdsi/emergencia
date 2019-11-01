/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.emergencia.model;

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
@Table(name = "EMER_INTERVENCION")
@NamedQueries({
    @NamedQuery(name = "EmerIntervencion.findAll", query = "SELECT e FROM EmerIntervencion e")})
public class EmerIntervencion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_INTERVENCION")
    private Integer idIntervencion;
    @Column(name = "TIPO_INTERVENCION")
    private String tipoIntervencion;
    @Column(name = "FECHA_INTERVENCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIntervencion;
    @Column(name = "DESCRIPCION_INTERVENCION")
    private String descripcionIntervencion;
    @Column(name = "ESTADO_INTERVENCION")
    private Character estadoIntervencion;
    @Column(name = "INT_PSICOLOGICA")
    private Character intPsicologica;
    @Column(name = "INT_PEDAGOGICA")
    private Character intPedagogica;
    @Column(name = "INT_RECONSTRUCCION")
    private Character intReconstruccion;
    @Column(name = "OBSERVACION")
    private String observacion;
    @JoinColumn(name = "CORRELATIVO_REGISTRO", referencedColumnName = "CORRELATIVO_REGISTRO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmerRegistroAlbergue correlativoRegistro;

    public EmerIntervencion() {
    }

    public EmerIntervencion(Integer idIntervencion) {
        this.idIntervencion = idIntervencion;
    }

    public Integer getIdIntervencion() {
        return idIntervencion;
    }

    public void setIdIntervencion(Integer idIntervencion) {
        this.idIntervencion = idIntervencion;
    }

    public String getTipoIntervencion() {
        return tipoIntervencion;
    }

    public void setTipoIntervencion(String tipoIntervencion) {
        this.tipoIntervencion = tipoIntervencion;
    }

    public Date getFechaIntervencion() {
        return fechaIntervencion;
    }

    public void setFechaIntervencion(Date fechaIntervencion) {
        this.fechaIntervencion = fechaIntervencion;
    }

    public String getDescripcionIntervencion() {
        return descripcionIntervencion;
    }

    public void setDescripcionIntervencion(String descripcionIntervencion) {
        this.descripcionIntervencion = descripcionIntervencion;
    }

    public Character getEstadoIntervencion() {
        return estadoIntervencion;
    }

    public void setEstadoIntervencion(Character estadoIntervencion) {
        this.estadoIntervencion = estadoIntervencion;
    }

    public Character getIntPsicologica() {
        return intPsicologica;
    }

    public void setIntPsicologica(Character intPsicologica) {
        this.intPsicologica = intPsicologica;
    }

    public Character getIntPedagogica() {
        return intPedagogica;
    }

    public void setIntPedagogica(Character intPedagogica) {
        this.intPedagogica = intPedagogica;
    }

    public Character getIntReconstruccion() {
        return intReconstruccion;
    }

    public void setIntReconstruccion(Character intReconstruccion) {
        this.intReconstruccion = intReconstruccion;
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
        hash += (idIntervencion != null ? idIntervencion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmerIntervencion)) {
            return false;
        }
        EmerIntervencion other = (EmerIntervencion) object;
        if ((this.idIntervencion == null && other.idIntervencion != null) || (this.idIntervencion != null && !this.idIntervencion.equals(other.idIntervencion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.org.mined.emergencia.model.EmerIntervencion[ idIntervencion=" + idIntervencion + " ]";
    }
    
}
