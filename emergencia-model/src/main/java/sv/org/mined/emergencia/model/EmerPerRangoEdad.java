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
@Table(name = "EMER_PER_RANGO_EDAD")
@NamedQueries({
    @NamedQuery(name = "EmerPerRangoEdad.findAll", query = "SELECT e FROM EmerPerRangoEdad e")})
public class EmerPerRangoEdad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CORRELATIVO_POR_RANGO")
    private Integer correlativoPorRango;
    @Column(name = "MASCULINO")
    private BigInteger masculino;
    @Column(name = "FEMENINO")
    private BigInteger femenino;
    @Column(name = "ANALFABETAS")
    private BigInteger analfabetas;
    @Column(name = "ESCOLARIDAD")
    private BigInteger escolaridad;
    @Column(name = "NO_ESCOLARIDAD")
    private BigInteger noEscolaridad;
    @JoinColumn(name = "CORRELATIVO_REGISTRO", referencedColumnName = "CORRELATIVO_REGISTRO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmerRegistroAlbergue correlativoRegistro;
    @JoinColumn(name = "CODIGO_RANGOS", referencedColumnName = "CODIGO_RANGOS")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmerTipRanEdad codigoRangos;

    public EmerPerRangoEdad() {
    }

    public EmerPerRangoEdad(Integer correlativoPorRango) {
        this.correlativoPorRango = correlativoPorRango;
    }

    public Integer getCorrelativoPorRango() {
        return correlativoPorRango;
    }

    public void setCorrelativoPorRango(Integer correlativoPorRango) {
        this.correlativoPorRango = correlativoPorRango;
    }

    public BigInteger getMasculino() {
        return masculino;
    }

    public void setMasculino(BigInteger masculino) {
        this.masculino = masculino;
    }

    public BigInteger getFemenino() {
        return femenino;
    }

    public void setFemenino(BigInteger femenino) {
        this.femenino = femenino;
    }

    public BigInteger getAnalfabetas() {
        return analfabetas;
    }

    public void setAnalfabetas(BigInteger analfabetas) {
        this.analfabetas = analfabetas;
    }

    public BigInteger getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(BigInteger escolaridad) {
        this.escolaridad = escolaridad;
    }

    public BigInteger getNoEscolaridad() {
        return noEscolaridad;
    }

    public void setNoEscolaridad(BigInteger noEscolaridad) {
        this.noEscolaridad = noEscolaridad;
    }

    public EmerRegistroAlbergue getCorrelativoRegistro() {
        return correlativoRegistro;
    }

    public void setCorrelativoRegistro(EmerRegistroAlbergue correlativoRegistro) {
        this.correlativoRegistro = correlativoRegistro;
    }

    public EmerTipRanEdad getCodigoRangos() {
        return codigoRangos;
    }

    public void setCodigoRangos(EmerTipRanEdad codigoRangos) {
        this.codigoRangos = codigoRangos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (correlativoPorRango != null ? correlativoPorRango.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmerPerRangoEdad)) {
            return false;
        }
        EmerPerRangoEdad other = (EmerPerRangoEdad) object;
        if ((this.correlativoPorRango == null && other.correlativoPorRango != null) || (this.correlativoPorRango != null && !this.correlativoPorRango.equals(other.correlativoPorRango))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.org.mined.emergencia.model.EmerPerRangoEdad[ correlativoPorRango=" + correlativoPorRango + " ]";
    }
    
}
