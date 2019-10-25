/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.org.mined.emergencia.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author MISanchez
 */
@Entity
@Table(name = "EMER_ESTADO_ALBERGUE")
@NamedQueries({
    @NamedQuery(name = "EmerEstadoAlbergue.findAll", query = "SELECT e FROM EmerEstadoAlbergue e")})
public class EmerEstadoAlbergue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO_ESTADO")
    private Short codigoEstado;
    @Column(name = "NOMBRE_ESTADO")
    private String nombreEstado;
    @OneToMany(mappedBy = "codigoEstado", fetch = FetchType.LAZY)
    private List<EmerRegistroAlbergue> emerRegistroAlbergueList;

    public EmerEstadoAlbergue() {
    }

    public EmerEstadoAlbergue(Short codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public Short getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(Short codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
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
        hash += (codigoEstado != null ? codigoEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmerEstadoAlbergue)) {
            return false;
        }
        EmerEstadoAlbergue other = (EmerEstadoAlbergue) object;
        if ((this.codigoEstado == null && other.codigoEstado != null) || (this.codigoEstado != null && !this.codigoEstado.equals(other.codigoEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.org.mined.emergencia.model.EmerEstadoAlbergue[ codigoEstado=" + codigoEstado + " ]";
    }
    
}
