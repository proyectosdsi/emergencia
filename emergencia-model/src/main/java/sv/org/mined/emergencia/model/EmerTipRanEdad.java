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
@Table(name = "EMER_TIP_RAN_EDAD")
@NamedQueries({
    @NamedQuery(name = "EmerTipRanEdad.findAll", query = "SELECT e FROM EmerTipRanEdad e")})
public class EmerTipRanEdad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO_RANGOS")
    private Integer codigoRangos;
    @Column(name = "DESCRIPCION_RANGOS")
    private String descripcionRangos;
    @Column(name = "OBSERVACION_RANGOS")
    private String observacionRangos;
    @Column(name = "ESTADO")
    private Character estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoRangos", fetch = FetchType.LAZY)
    private List<EmerPerRangoEdad> emerPerRangoEdadList;

    public EmerTipRanEdad() {
    }

    public EmerTipRanEdad(Integer codigoRangos) {
        this.codigoRangos = codigoRangos;
    }

    public Integer getCodigoRangos() {
        return codigoRangos;
    }

    public void setCodigoRangos(Integer codigoRangos) {
        this.codigoRangos = codigoRangos;
    }

    public String getDescripcionRangos() {
        return descripcionRangos;
    }

    public void setDescripcionRangos(String descripcionRangos) {
        this.descripcionRangos = descripcionRangos;
    }

    public String getObservacionRangos() {
        return observacionRangos;
    }

    public void setObservacionRangos(String observacionRangos) {
        this.observacionRangos = observacionRangos;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public List<EmerPerRangoEdad> getEmerPerRangoEdadList() {
        return emerPerRangoEdadList;
    }

    public void setEmerPerRangoEdadList(List<EmerPerRangoEdad> emerPerRangoEdadList) {
        this.emerPerRangoEdadList = emerPerRangoEdadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoRangos != null ? codigoRangos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmerTipRanEdad)) {
            return false;
        }
        EmerTipRanEdad other = (EmerTipRanEdad) object;
        if ((this.codigoRangos == null && other.codigoRangos != null) || (this.codigoRangos != null && !this.codigoRangos.equals(other.codigoRangos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.org.mined.emergencia.model.EmerTipRanEdad[ codigoRangos=" + codigoRangos + " ]";
    }
    
}
