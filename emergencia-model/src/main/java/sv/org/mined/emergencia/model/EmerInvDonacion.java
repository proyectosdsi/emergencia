/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.org.mined.emergencia.model;

import java.io.Serializable;
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

/**
 *
 * @author MISanchez
 */
@Entity
@Table(name = "EMER_INV_DONACION")
@NamedQueries({
    @NamedQuery(name = "EmerInvDonacion.findAll", query = "SELECT e FROM EmerInvDonacion e")})
public class EmerInvDonacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_INVENTARIO_DONACION")
    private Integer idInventarioDonacion;
    @Column(name = "DESCRIP_INV_DONACION")
    private String descripInvDonacion;
    @Column(name = "OBSERVACION_INV_DONACION")
    private String observacionInvDonacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInventarioDonacion", fetch = FetchType.LAZY)
    private List<EmerInventario> emerInventarioList;

    public EmerInvDonacion() {
    }

    public EmerInvDonacion(Integer idInventarioDonacion) {
        this.idInventarioDonacion = idInventarioDonacion;
    }

    public Integer getIdInventarioDonacion() {
        return idInventarioDonacion;
    }

    public void setIdInventarioDonacion(Integer idInventarioDonacion) {
        this.idInventarioDonacion = idInventarioDonacion;
    }

    public String getDescripInvDonacion() {
        return descripInvDonacion;
    }

    public void setDescripInvDonacion(String descripInvDonacion) {
        this.descripInvDonacion = descripInvDonacion;
    }

    public String getObservacionInvDonacion() {
        return observacionInvDonacion;
    }

    public void setObservacionInvDonacion(String observacionInvDonacion) {
        this.observacionInvDonacion = observacionInvDonacion;
    }

    public List<EmerInventario> getEmerInventarioList() {
        return emerInventarioList;
    }

    public void setEmerInventarioList(List<EmerInventario> emerInventarioList) {
        this.emerInventarioList = emerInventarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInventarioDonacion != null ? idInventarioDonacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmerInvDonacion)) {
            return false;
        }
        EmerInvDonacion other = (EmerInvDonacion) object;
        if ((this.idInventarioDonacion == null && other.idInventarioDonacion != null) || (this.idInventarioDonacion != null && !this.idInventarioDonacion.equals(other.idInventarioDonacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.org.mined.emergencia.model.EmerInvDonacion[ idInventarioDonacion=" + idInventarioDonacion + " ]";
    }
    
}
