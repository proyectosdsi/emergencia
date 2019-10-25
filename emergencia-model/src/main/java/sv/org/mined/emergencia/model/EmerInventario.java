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
@Table(name = "EMER_INVENTARIO")
@NamedQueries({
    @NamedQuery(name = "EmerInventario.findAll", query = "SELECT e FROM EmerInventario e")})
public class EmerInventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CORRELATIVO_INVENTARIO")
    private Integer correlativoInventario;
    @Column(name = "CANTIDAD_INVENTARIO")
    private BigInteger cantidadInventario;
    @JoinColumn(name = "ID_INVENTARIO_DONACION", referencedColumnName = "ID_INVENTARIO_DONACION")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmerInvDonacion idInventarioDonacion;
    @JoinColumn(name = "CORRELATIVO_REGISTRO", referencedColumnName = "CORRELATIVO_REGISTRO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmerRegistroAlbergue correlativoRegistro;

    public EmerInventario() {
    }

    public EmerInventario(Integer correlativoInventario) {
        this.correlativoInventario = correlativoInventario;
    }

    public Integer getCorrelativoInventario() {
        return correlativoInventario;
    }

    public void setCorrelativoInventario(Integer correlativoInventario) {
        this.correlativoInventario = correlativoInventario;
    }

    public BigInteger getCantidadInventario() {
        return cantidadInventario;
    }

    public void setCantidadInventario(BigInteger cantidadInventario) {
        this.cantidadInventario = cantidadInventario;
    }

    public EmerInvDonacion getIdInventarioDonacion() {
        return idInventarioDonacion;
    }

    public void setIdInventarioDonacion(EmerInvDonacion idInventarioDonacion) {
        this.idInventarioDonacion = idInventarioDonacion;
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
        hash += (correlativoInventario != null ? correlativoInventario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmerInventario)) {
            return false;
        }
        EmerInventario other = (EmerInventario) object;
        if ((this.correlativoInventario == null && other.correlativoInventario != null) || (this.correlativoInventario != null && !this.correlativoInventario.equals(other.correlativoInventario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.org.mined.emergencia.model.EmerInventario[ correlativoInventario=" + correlativoInventario + " ]";
    }
    
}
