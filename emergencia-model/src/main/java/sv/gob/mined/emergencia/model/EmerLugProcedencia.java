/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.emergencia.model;

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
@Table(name = "EMER_LUG_PROCEDENCIA")
@NamedQueries({
    @NamedQuery(name = "EmerLugProcedencia.findAll", query = "SELECT e FROM EmerLugProcedencia e")})
public class EmerLugProcedencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_LUGAR_PROCE")
    private Integer idLugarProce;
    @Column(name = "CODIGO_DEPARTAMENTO")
    private String codigoDepartamento;
    @Column(name = "CODIGO_MUNICIPIO")
    private String codigoMunicipio;
    @Column(name = "NUMERO_FAMILIAS")
    private BigInteger numeroFamilias;
    @Column(name = "LUGAR_PROCE")
    private String lugarProce;
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @JoinColumn(name = "CORRELATIVO_REGISTRO", referencedColumnName = "CORRELATIVO_REGISTRO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmerRegistroAlbergue correlativoRegistro;

    public EmerLugProcedencia() {
    }

    public EmerLugProcedencia(Integer idLugarProce) {
        this.idLugarProce = idLugarProce;
    }

    public Integer getIdLugarProce() {
        return idLugarProce;
    }

    public void setIdLugarProce(Integer idLugarProce) {
        this.idLugarProce = idLugarProce;
    }

    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(String codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public BigInteger getNumeroFamilias() {
        return numeroFamilias;
    }

    public void setNumeroFamilias(BigInteger numeroFamilias) {
        this.numeroFamilias = numeroFamilias;
    }

    public String getLugarProce() {
        return lugarProce;
    }

    public void setLugarProce(String lugarProce) {
        this.lugarProce = lugarProce;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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
        hash += (idLugarProce != null ? idLugarProce.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmerLugProcedencia)) {
            return false;
        }
        EmerLugProcedencia other = (EmerLugProcedencia) object;
        if ((this.idLugarProce == null && other.idLugarProce != null) || (this.idLugarProce != null && !this.idLugarProce.equals(other.idLugarProce))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.org.mined.emergencia.model.EmerLugProcedencia[ idLugarProce=" + idLugarProce + " ]";
    }
    
}
