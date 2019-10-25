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
@Table(name = "EMER_TIP_AULAS")
@NamedQueries({
    @NamedQuery(name = "EmerTipAulas.findAll", query = "SELECT e FROM EmerTipAulas e")})
public class EmerTipAulas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TIPO_AULA")
    private Integer idTipoAula;
    @Column(name = "NOMBRE_TIPO_AULA")
    private String nombreTipoAula;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoAula", fetch = FetchType.LAZY)
    private List<EmerCapAlbergue> emerCapAlbergueList;

    public EmerTipAulas() {
    }

    public EmerTipAulas(Integer idTipoAula) {
        this.idTipoAula = idTipoAula;
    }

    public Integer getIdTipoAula() {
        return idTipoAula;
    }

    public void setIdTipoAula(Integer idTipoAula) {
        this.idTipoAula = idTipoAula;
    }

    public String getNombreTipoAula() {
        return nombreTipoAula;
    }

    public void setNombreTipoAula(String nombreTipoAula) {
        this.nombreTipoAula = nombreTipoAula;
    }

    public List<EmerCapAlbergue> getEmerCapAlbergueList() {
        return emerCapAlbergueList;
    }

    public void setEmerCapAlbergueList(List<EmerCapAlbergue> emerCapAlbergueList) {
        this.emerCapAlbergueList = emerCapAlbergueList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoAula != null ? idTipoAula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmerTipAulas)) {
            return false;
        }
        EmerTipAulas other = (EmerTipAulas) object;
        if ((this.idTipoAula == null && other.idTipoAula != null) || (this.idTipoAula != null && !this.idTipoAula.equals(other.idTipoAula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.org.mined.emergencia.model.EmerTipAulas[ idTipoAula=" + idTipoAula + " ]";
    }
    
}
