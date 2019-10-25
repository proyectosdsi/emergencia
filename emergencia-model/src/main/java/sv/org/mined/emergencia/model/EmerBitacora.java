/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.org.mined.emergencia.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author MISanchez
 */
@Entity
@Table(name = "EMER_BITACORA")
@NamedQueries({
    @NamedQuery(name = "EmerBitacora.findAll", query = "SELECT e FROM EmerBitacora e")})
public class EmerBitacora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_BITACORA")
    
    @SequenceGenerator(name = "bitacora", sequenceName = "SEQ_BITACORA", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bitacora")
    
    private Integer idBitacora;
    @Column(name = "OBSERVACION_BITACORA")
    private String observacionBitacora;
    @Column(name = "HALLAZGOS_BITACORA")
    private String hallazgosBitacora;
    @JoinColumn(name = "CORRELATIVO_REGISTRO", referencedColumnName = "CORRELATIVO_REGISTRO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmerRegistroAlbergue correlativoRegistro;

    public EmerBitacora() {
    }

    public EmerBitacora(Integer idBitacora) {
        this.idBitacora = idBitacora;
    }

    public Integer getIdBitacora() {
        return idBitacora;
    }

    public void setIdBitacora(Integer idBitacora) {
        this.idBitacora = idBitacora;
    }

    public String getObservacionBitacora() {
        return observacionBitacora;
    }

    public void setObservacionBitacora(String observacionBitacora) {
        this.observacionBitacora = observacionBitacora;
    }

    public String getHallazgosBitacora() {
        return hallazgosBitacora;
    }

    public void setHallazgosBitacora(String hallazgosBitacora) {
        this.hallazgosBitacora = hallazgosBitacora;
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
        hash += (idBitacora != null ? idBitacora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmerBitacora)) {
            return false;
        }
        EmerBitacora other = (EmerBitacora) object;
        if ((this.idBitacora == null && other.idBitacora != null) || (this.idBitacora != null && !this.idBitacora.equals(other.idBitacora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.org.mined.emergencia.model.EmerBitacora[ idBitacora=" + idBitacora + " ]";
    }
    
}
