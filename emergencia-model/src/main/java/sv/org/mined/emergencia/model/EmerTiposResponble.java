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
@Table(name = "EMER_TIPOS_RESPONBLE")
@NamedQueries({
    @NamedQuery(name = "EmerTiposResponble.findAll", query = "SELECT e FROM EmerTiposResponble e")})
public class EmerTiposResponble implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_RESPONSABILIDAD")
    private Integer idResponsabilidad;
    @Column(name = "DESCRIPCION_RESPONSABILIDAD")
    private String descripcionResponsabilidad;
    @OneToMany(mappedBy = "idResponsabilidad", fetch = FetchType.LAZY)
    private List<EmerPartePreventiva> emerPartePreventivaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idResponsabilidad", fetch = FetchType.LAZY)
    private List<EmerResMined> emerResMinedList;

    public EmerTiposResponble() {
    }

    public EmerTiposResponble(Integer idResponsabilidad) {
        this.idResponsabilidad = idResponsabilidad;
    }

    public Integer getIdResponsabilidad() {
        return idResponsabilidad;
    }

    public void setIdResponsabilidad(Integer idResponsabilidad) {
        this.idResponsabilidad = idResponsabilidad;
    }

    public String getDescripcionResponsabilidad() {
        return descripcionResponsabilidad;
    }

    public void setDescripcionResponsabilidad(String descripcionResponsabilidad) {
        this.descripcionResponsabilidad = descripcionResponsabilidad;
    }

    public List<EmerPartePreventiva> getEmerPartePreventivaList() {
        return emerPartePreventivaList;
    }

    public void setEmerPartePreventivaList(List<EmerPartePreventiva> emerPartePreventivaList) {
        this.emerPartePreventivaList = emerPartePreventivaList;
    }

    public List<EmerResMined> getEmerResMinedList() {
        return emerResMinedList;
    }

    public void setEmerResMinedList(List<EmerResMined> emerResMinedList) {
        this.emerResMinedList = emerResMinedList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResponsabilidad != null ? idResponsabilidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmerTiposResponble)) {
            return false;
        }
        EmerTiposResponble other = (EmerTiposResponble) object;
        if ((this.idResponsabilidad == null && other.idResponsabilidad != null) || (this.idResponsabilidad != null && !this.idResponsabilidad.equals(other.idResponsabilidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.org.mined.emergencia.model.EmerTiposResponble[ idResponsabilidad=" + idResponsabilidad + " ]";
    }
    
}
