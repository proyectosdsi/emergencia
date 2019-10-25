/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.org.mined.emergencia.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author MISanchez
 */
@Embeddable
public class EmerRutaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID_RUTA")
    private int idRuta;
    @Basic(optional = false)
    @Column(name = "ID_PERSONAL")
    private String idPersonal;

    public EmerRutaPK() {
    }

    public EmerRutaPK(int idRuta, String idPersonal) {
        this.idRuta = idRuta;
        this.idPersonal = idPersonal;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public String getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(String idPersonal) {
        this.idPersonal = idPersonal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idRuta;
        hash += (idPersonal != null ? idPersonal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmerRutaPK)) {
            return false;
        }
        EmerRutaPK other = (EmerRutaPK) object;
        if (this.idRuta != other.idRuta) {
            return false;
        }
        if ((this.idPersonal == null && other.idPersonal != null) || (this.idPersonal != null && !this.idPersonal.equals(other.idPersonal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.org.mined.emergencia.model.EmerRutaPK[ idRuta=" + idRuta + ", idPersonal=" + idPersonal + " ]";
    }
    
}
