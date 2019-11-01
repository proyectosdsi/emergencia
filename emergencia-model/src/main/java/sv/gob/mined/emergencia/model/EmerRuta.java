/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.emergencia.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author MISanchez
 */
@Entity
@Table(name = "EMER_RUTA")
@NamedQueries({
    @NamedQuery(name = "EmerRuta.findAll", query = "SELECT e FROM EmerRuta e")})
public class EmerRuta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmerRutaPK emerRutaPK;
    @Column(name = "FECHA_RUTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRuta;
    @Column(name = "NUMERO_RUTA")
    private BigInteger numeroRuta;
    @Column(name = "OBSERVACION_RUTA")
    private String observacionRuta;
    @Basic(optional = false)
    @Column(name = "ID_PERSONAL_DOS")
    private String idPersonalDos;
    @JoinColumn(name = "CORRELATIVO_REGISTRO", referencedColumnName = "CORRELATIVO_REGISTRO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmerRegistroAlbergue correlativoRegistro;

    public EmerRuta() {
    }

    public EmerRuta(EmerRutaPK emerRutaPK) {
        this.emerRutaPK = emerRutaPK;
    }

    public EmerRuta(EmerRutaPK emerRutaPK, String idPersonalDos) {
        this.emerRutaPK = emerRutaPK;
        this.idPersonalDos = idPersonalDos;
    }

    public EmerRuta(int idRuta, String idPersonal) {
        this.emerRutaPK = new EmerRutaPK(idRuta, idPersonal);
    }

    public EmerRutaPK getEmerRutaPK() {
        return emerRutaPK;
    }

    public void setEmerRutaPK(EmerRutaPK emerRutaPK) {
        this.emerRutaPK = emerRutaPK;
    }

    public Date getFechaRuta() {
        return fechaRuta;
    }

    public void setFechaRuta(Date fechaRuta) {
        this.fechaRuta = fechaRuta;
    }

    public BigInteger getNumeroRuta() {
        return numeroRuta;
    }

    public void setNumeroRuta(BigInteger numeroRuta) {
        this.numeroRuta = numeroRuta;
    }

    public String getObservacionRuta() {
        return observacionRuta;
    }

    public void setObservacionRuta(String observacionRuta) {
        this.observacionRuta = observacionRuta;
    }

    public String getIdPersonalDos() {
        return idPersonalDos;
    }

    public void setIdPersonalDos(String idPersonalDos) {
        this.idPersonalDos = idPersonalDos;
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
        hash += (emerRutaPK != null ? emerRutaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmerRuta)) {
            return false;
        }
        EmerRuta other = (EmerRuta) object;
        if ((this.emerRutaPK == null && other.emerRutaPK != null) || (this.emerRutaPK != null && !this.emerRutaPK.equals(other.emerRutaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.org.mined.emergencia.model.EmerRuta[ emerRutaPK=" + emerRutaPK + " ]";
    }
    
}
