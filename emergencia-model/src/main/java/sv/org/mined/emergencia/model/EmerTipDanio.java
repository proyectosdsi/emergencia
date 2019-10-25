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
@Table(name = "EMER_TIP_DANIO")
@NamedQueries({
    @NamedQuery(name = "EmerTipDanio.findAll", query = "SELECT e FROM EmerTipDanio e")})
public class EmerTipDanio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TIPO_DANIO")
    private Integer idTipoDanio;
    @Column(name = "NOMBRE_TIPO_DANIO")
    private String nombreTipoDanio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoDanio", fetch = FetchType.LAZY)
    private List<EmerRegDanio> emerRegDanioList;

    public EmerTipDanio() {
    }

    public EmerTipDanio(Integer idTipoDanio) {
        this.idTipoDanio = idTipoDanio;
    }

    public Integer getIdTipoDanio() {
        return idTipoDanio;
    }

    public void setIdTipoDanio(Integer idTipoDanio) {
        this.idTipoDanio = idTipoDanio;
    }

    public String getNombreTipoDanio() {
        return nombreTipoDanio;
    }

    public void setNombreTipoDanio(String nombreTipoDanio) {
        this.nombreTipoDanio = nombreTipoDanio;
    }

    public List<EmerRegDanio> getEmerRegDanioList() {
        return emerRegDanioList;
    }

    public void setEmerRegDanioList(List<EmerRegDanio> emerRegDanioList) {
        this.emerRegDanioList = emerRegDanioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoDanio != null ? idTipoDanio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmerTipDanio)) {
            return false;
        }
        EmerTipDanio other = (EmerTipDanio) object;
        if ((this.idTipoDanio == null && other.idTipoDanio != null) || (this.idTipoDanio != null && !this.idTipoDanio.equals(other.idTipoDanio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.org.mined.emergencia.model.EmerTipDanio[ idTipoDanio=" + idTipoDanio + " ]";
    }
    
}
