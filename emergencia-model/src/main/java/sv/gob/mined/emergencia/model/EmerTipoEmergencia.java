/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.emergencia.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author MISanchez
 */
@Entity
@Table(name = "EMER_TIPO_EMERGENCIA")
@NamedQueries({
    @NamedQuery(name = "EmerTipoEmergencia.findAll", query = "SELECT e FROM EmerTipoEmergencia e")})
public class EmerTipoEmergencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO_EMERGENCIA")
    private Integer codigoEmergencia;
    @Column(name = "NOMBRE_EMERGENCIA")
    private String nombreEmergencia;
    @Column(name = "FEC_EMERGENCIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecEmergencia;
    @Column(name = "OBSERVACION_EMERGENCIA")
    private String observacionEmergencia;
    @Column(name = "ACTIVO")
    private Character activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoEmergencia", fetch = FetchType.LAZY)
    private List<EmerRegistroAlbergue> emerRegistroAlbergueList;

    public EmerTipoEmergencia() {
    }

    public EmerTipoEmergencia(Integer codigoEmergencia) {
        this.codigoEmergencia = codigoEmergencia;
    }

    public Integer getCodigoEmergencia() {
        return codigoEmergencia;
    }

    public void setCodigoEmergencia(Integer codigoEmergencia) {
        this.codigoEmergencia = codigoEmergencia;
    }

    public String getNombreEmergencia() {
        return nombreEmergencia;
    }

    public void setNombreEmergencia(String nombreEmergencia) {
        this.nombreEmergencia = nombreEmergencia;
    }

    public Date getFecEmergencia() {
        return fecEmergencia;
    }

    public void setFecEmergencia(Date fecEmergencia) {
        this.fecEmergencia = fecEmergencia;
    }

    public String getObservacionEmergencia() {
        return observacionEmergencia;
    }

    public void setObservacionEmergencia(String observacionEmergencia) {
        this.observacionEmergencia = observacionEmergencia;
    }

    public Character getActivo() {
        return activo;
    }

    public void setActivo(Character activo) {
        this.activo = activo;
    }

    public List<EmerRegistroAlbergue> getEmerRegistroAlbergueList() {
        return emerRegistroAlbergueList;
    }

    public void setEmerRegistroAlbergueList(List<EmerRegistroAlbergue> emerRegistroAlbergueList) {
        this.emerRegistroAlbergueList = emerRegistroAlbergueList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoEmergencia != null ? codigoEmergencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmerTipoEmergencia)) {
            return false;
        }
        EmerTipoEmergencia other = (EmerTipoEmergencia) object;
        if ((this.codigoEmergencia == null && other.codigoEmergencia != null) || (this.codigoEmergencia != null && !this.codigoEmergencia.equals(other.codigoEmergencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.org.mined.emergencia.model.EmerTipoEmergencia[ codigoEmergencia=" + codigoEmergencia + " ]";
    }
    
}
