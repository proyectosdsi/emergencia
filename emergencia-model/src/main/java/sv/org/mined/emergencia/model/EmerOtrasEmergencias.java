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
@Table(name = "EMER_OTRAS_EMERGENCIAS")
@NamedQueries({
    @NamedQuery(name = "EmerOtrasEmergencias.findAll", query = "SELECT e FROM EmerOtrasEmergencias e")})
public class EmerOtrasEmergencias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_OTRAS_EMERGENCIAS")
    private Integer idOtrasEmergencias;
    @Column(name = "DESCRIPCION_OTRA_EMEREGENCIA")
    private String descripcionOtraEmeregencia;
    @Column(name = "DANOS_METERIALES")
    private Character danosMeteriales;
    @Column(name = "PERDIDA_HUMANOS")
    private Character perdidaHumanos;
    @Column(name = "HERIDOS_OTRAS")
    private Character heridosOtras;
    @Column(name = "AYUDA_PSICOLOGICA")
    private Character ayudaPsicologica;
    @Column(name = "CANTIDAD_HUMANOS_PERDIDA")
    private Long cantidadHumanosPerdida;
    @Column(name = "CANTIDAD_HERIDOS")
    private Long cantidadHeridos;
    @JoinColumn(name = "CORRELATIVO_REGISTRO", referencedColumnName = "CORRELATIVO_REGISTRO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmerRegistroAlbergue correlativoRegistro;

    public EmerOtrasEmergencias() {
    }

    public EmerOtrasEmergencias(Integer idOtrasEmergencias) {
        this.idOtrasEmergencias = idOtrasEmergencias;
    }

    public Integer getIdOtrasEmergencias() {
        return idOtrasEmergencias;
    }

    public void setIdOtrasEmergencias(Integer idOtrasEmergencias) {
        this.idOtrasEmergencias = idOtrasEmergencias;
    }

    public String getDescripcionOtraEmeregencia() {
        return descripcionOtraEmeregencia;
    }

    public void setDescripcionOtraEmeregencia(String descripcionOtraEmeregencia) {
        this.descripcionOtraEmeregencia = descripcionOtraEmeregencia;
    }

    public Character getDanosMeteriales() {
        return danosMeteriales;
    }

    public void setDanosMeteriales(Character danosMeteriales) {
        this.danosMeteriales = danosMeteriales;
    }

    public Character getPerdidaHumanos() {
        return perdidaHumanos;
    }

    public void setPerdidaHumanos(Character perdidaHumanos) {
        this.perdidaHumanos = perdidaHumanos;
    }

    public Character getHeridosOtras() {
        return heridosOtras;
    }

    public void setHeridosOtras(Character heridosOtras) {
        this.heridosOtras = heridosOtras;
    }

    public Character getAyudaPsicologica() {
        return ayudaPsicologica;
    }

    public void setAyudaPsicologica(Character ayudaPsicologica) {
        this.ayudaPsicologica = ayudaPsicologica;
    }

    public Long getCantidadHumanosPerdida() {
        return cantidadHumanosPerdida;
    }

    public void setCantidadHumanosPerdida(Long cantidadHumanosPerdida) {
        this.cantidadHumanosPerdida = cantidadHumanosPerdida;
    }

    public Long getCantidadHeridos() {
        return cantidadHeridos;
    }

    public void setCantidadHeridos(Long cantidadHeridos) {
        this.cantidadHeridos = cantidadHeridos;
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
        hash += (idOtrasEmergencias != null ? idOtrasEmergencias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmerOtrasEmergencias)) {
            return false;
        }
        EmerOtrasEmergencias other = (EmerOtrasEmergencias) object;
        if ((this.idOtrasEmergencias == null && other.idOtrasEmergencias != null) || (this.idOtrasEmergencias != null && !this.idOtrasEmergencias.equals(other.idOtrasEmergencias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.org.mined.emergencia.model.EmerOtrasEmergencias[ idOtrasEmergencias=" + idOtrasEmergencias + " ]";
    }
    
}
