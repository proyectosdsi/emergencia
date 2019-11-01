/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.emergencia.model;

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
@Table(name = "EMER_PELIGRO_ALB")
@NamedQueries({
    @NamedQuery(name = "EmerPeligroAlb.findAll", query = "SELECT e FROM EmerPeligroAlb e")})
public class EmerPeligroAlb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO_PELIGRO")
    private Integer codigoPeligro;
    @Column(name = "DESCR_PELIGRO")
    private String descrPeligro;
    @OneToMany(mappedBy = "codigoPeligro", fetch = FetchType.LAZY)
    private List<EmerRegistroAlbergue> emerRegistroAlbergueList;

    public EmerPeligroAlb() {
    }

    public EmerPeligroAlb(Integer codigoPeligro) {
        this.codigoPeligro = codigoPeligro;
    }

    public Integer getCodigoPeligro() {
        return codigoPeligro;
    }

    public void setCodigoPeligro(Integer codigoPeligro) {
        this.codigoPeligro = codigoPeligro;
    }

    public String getDescrPeligro() {
        return descrPeligro;
    }

    public void setDescrPeligro(String descrPeligro) {
        this.descrPeligro = descrPeligro;
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
        hash += (codigoPeligro != null ? codigoPeligro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmerPeligroAlb)) {
            return false;
        }
        EmerPeligroAlb other = (EmerPeligroAlb) object;
        if ((this.codigoPeligro == null && other.codigoPeligro != null) || (this.codigoPeligro != null && !this.codigoPeligro.equals(other.codigoPeligro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.org.mined.emergencia.model.EmerPeligroAlb[ codigoPeligro=" + codigoPeligro + " ]";
    }
    
}
