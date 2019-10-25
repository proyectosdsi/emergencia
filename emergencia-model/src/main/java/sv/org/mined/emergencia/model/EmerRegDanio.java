/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.org.mined.emergencia.model;

import java.io.Serializable;
import java.math.BigInteger;
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

/**
 *
 * @author MISanchez
 */
@Entity
@Table(name = "EMER_REG_DANIO")
@NamedQueries({
    @NamedQuery(name = "EmerRegDanio.findAll", query = "SELECT e FROM EmerRegDanio e")})
public class EmerRegDanio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CORRELATIVO_REGISTRO_DANIO")
    private Integer correlativoRegistroDanio;
    @Column(name = "CANTIDAD_REGISTRO_DANIO")
    private BigInteger cantidadRegistroDanio;
    @Column(name = "OBSERVACION_REGISTRO_DANIO")
    private String observacionRegistroDanio;
    @JoinColumn(name = "CORRELATIVO_REGISTRO", referencedColumnName = "CORRELATIVO_REGISTRO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmerRegistroAlbergue correlativoRegistro;
    @JoinColumn(name = "ID_TIPO_DANIO", referencedColumnName = "ID_TIPO_DANIO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmerTipDanio idTipoDanio;

    public EmerRegDanio() {
    }

    public EmerRegDanio(Integer correlativoRegistroDanio) {
        this.correlativoRegistroDanio = correlativoRegistroDanio;
    }

    public Integer getCorrelativoRegistroDanio() {
        return correlativoRegistroDanio;
    }

    public void setCorrelativoRegistroDanio(Integer correlativoRegistroDanio) {
        this.correlativoRegistroDanio = correlativoRegistroDanio;
    }

    public BigInteger getCantidadRegistroDanio() {
        return cantidadRegistroDanio;
    }

    public void setCantidadRegistroDanio(BigInteger cantidadRegistroDanio) {
        this.cantidadRegistroDanio = cantidadRegistroDanio;
    }

    public String getObservacionRegistroDanio() {
        return observacionRegistroDanio;
    }

    public void setObservacionRegistroDanio(String observacionRegistroDanio) {
        this.observacionRegistroDanio = observacionRegistroDanio;
    }

    public EmerRegistroAlbergue getCorrelativoRegistro() {
        return correlativoRegistro;
    }

    public void setCorrelativoRegistro(EmerRegistroAlbergue correlativoRegistro) {
        this.correlativoRegistro = correlativoRegistro;
    }

    public EmerTipDanio getIdTipoDanio() {
        return idTipoDanio;
    }

    public void setIdTipoDanio(EmerTipDanio idTipoDanio) {
        this.idTipoDanio = idTipoDanio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (correlativoRegistroDanio != null ? correlativoRegistroDanio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmerRegDanio)) {
            return false;
        }
        EmerRegDanio other = (EmerRegDanio) object;
        if ((this.correlativoRegistroDanio == null && other.correlativoRegistroDanio != null) || (this.correlativoRegistroDanio != null && !this.correlativoRegistroDanio.equals(other.correlativoRegistroDanio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.org.mined.emergencia.model.EmerRegDanio[ correlativoRegistroDanio=" + correlativoRegistroDanio + " ]";
    }
    
}
