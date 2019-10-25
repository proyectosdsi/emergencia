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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author MISanchez
 */
@Entity
@Table(name = "ZONA_GEOGRAFICA")
@NamedQueries({
    @NamedQuery(name = "ZonaGeografica.findAll", query = "SELECT z FROM ZonaGeografica z")})
public class ZonaGeografica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO_ZONA")
    private String codigoZona;
    @Column(name = "NOMBRE")
    private String nombre;

    public ZonaGeografica() {
    }

    public ZonaGeografica(String codigoZona) {
        this.codigoZona = codigoZona;
    }

    public String getCodigoZona() {
        return codigoZona;
    }

    public void setCodigoZona(String codigoZona) {
        this.codigoZona = codigoZona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoZona != null ? codigoZona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ZonaGeografica)) {
            return false;
        }
        ZonaGeografica other = (ZonaGeografica) object;
        if ((this.codigoZona == null && other.codigoZona != null) || (this.codigoZona != null && !this.codigoZona.equals(other.codigoZona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.org.mined.emergencia.model.ZonaGeografica[ codigoZona=" + codigoZona + " ]";
    }
    
}
