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
@Table(name = "EMER_COMITE_PLAN")
@NamedQueries({
    @NamedQuery(name = "EmerComitePlan.findAll", query = "SELECT e FROM EmerComitePlan e")})
public class EmerComitePlan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_COMITE_INTEGRA")
    private Integer idComiteIntegra;
    @Column(name = "NOMBRE_INTEGRA")
    private String nombreIntegra;
    @Column(name = "CARGO_INTEGRA")
    private String cargoIntegra;
    @Column(name = "FECHA_CREACION_COMITE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacionComite;
    @JoinColumn(name = "CORRELATIVO_REGISTRO", referencedColumnName = "CORRELATIVO_REGISTRO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmerRegistroAlbergue correlativoRegistro;

    public EmerComitePlan() {
    }

    public EmerComitePlan(Integer idComiteIntegra) {
        this.idComiteIntegra = idComiteIntegra;
    }

    public Integer getIdComiteIntegra() {
        return idComiteIntegra;
    }

    public void setIdComiteIntegra(Integer idComiteIntegra) {
        this.idComiteIntegra = idComiteIntegra;
    }

    public String getNombreIntegra() {
        return nombreIntegra;
    }

    public void setNombreIntegra(String nombreIntegra) {
        this.nombreIntegra = nombreIntegra;
    }

    public String getCargoIntegra() {
        return cargoIntegra;
    }

    public void setCargoIntegra(String cargoIntegra) {
        this.cargoIntegra = cargoIntegra;
    }

    public Date getFechaCreacionComite() {
        return fechaCreacionComite;
    }

    public void setFechaCreacionComite(Date fechaCreacionComite) {
        this.fechaCreacionComite = fechaCreacionComite;
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
        hash += (idComiteIntegra != null ? idComiteIntegra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmerComitePlan)) {
            return false;
        }
        EmerComitePlan other = (EmerComitePlan) object;
        if ((this.idComiteIntegra == null && other.idComiteIntegra != null) || (this.idComiteIntegra != null && !this.idComiteIntegra.equals(other.idComiteIntegra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.org.mined.emergencia.model.EmerComitePlan[ idComiteIntegra=" + idComiteIntegra + " ]";
    }
    
}
