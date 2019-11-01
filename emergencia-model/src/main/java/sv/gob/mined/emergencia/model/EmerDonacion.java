/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.emergencia.model;

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
@Table(name = "EMER_DONACION")
@NamedQueries({
    @NamedQuery(name = "EmerDonacion.findAll", query = "SELECT e FROM EmerDonacion e")
    ,
@NamedQuery(name = "EmerDonacion.findByPk", query = "SELECT e FROM EmerDonacion e WHERE e.correlativoDonacion = :valor")})
public class EmerDonacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CORRELATIVO_DONACION")

    @SequenceGenerator(name = "donacion", sequenceName = "SEQ_DONACION", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "donacion")

    private Integer correlativoDonacion;
    @Column(name = "COLCHO_CANTIDAD")
    private Long colchoCantidad;
    @Column(name = "FRAZADAS_CANTIDAD")
    private Long frazadasCantidad;
    @Column(name = "SILLAS_CANTIDAD")
    private Long sillasCantidad;
    @Column(name = "CAMAS_CANTIDAD")
    private Long camasCantidad;
    @Column(name = "OTROS_CANTIDAD")
    private Long otrosCantidad;
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @Column(name = "SECRETARIA_INCLUSION")
    private Character secretariaInclusion;
    @Column(name = "ALIMENTOS_PROPIOS")
    private Character alimentosPropios;
    @Column(name = "CANTIDAD_DIAS")
    private Long cantidadDias;
    @Column(name = "DETALLES_TIPO")
    private String detallesTipo;
    @JoinColumn(name = "CORRELATIVO_REGISTRO", referencedColumnName = "CORRELATIVO_REGISTRO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmerRegistroAlbergue correlativoRegistro;

    public EmerDonacion() {
    }

    public EmerDonacion(Integer correlativoDonacion) {
        this.correlativoDonacion = correlativoDonacion;
    }

    public Integer getCorrelativoDonacion() {
        return correlativoDonacion;
    }

    public void setCorrelativoDonacion(Integer correlativoDonacion) {
        this.correlativoDonacion = correlativoDonacion;
    }

    public Long getColchoCantidad() {
        return colchoCantidad;
    }

    public void setColchoCantidad(Long colchoCantidad) {
        this.colchoCantidad = colchoCantidad;
    }

    public Long getFrazadasCantidad() {
        return frazadasCantidad;
    }

    public void setFrazadasCantidad(Long frazadasCantidad) {
        this.frazadasCantidad = frazadasCantidad;
    }

    public Long getSillasCantidad() {
        return sillasCantidad;
    }

    public void setSillasCantidad(Long sillasCantidad) {
        this.sillasCantidad = sillasCantidad;
    }

    public Long getCamasCantidad() {
        return camasCantidad;
    }

    public void setCamasCantidad(Long camasCantidad) {
        this.camasCantidad = camasCantidad;
    }

    public Long getOtrosCantidad() {
        return otrosCantidad;
    }

    public void setOtrosCantidad(Long otrosCantidad) {
        this.otrosCantidad = otrosCantidad;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Character getSecretariaInclusion() {
        return secretariaInclusion;
    }

    public void setSecretariaInclusion(Character secretariaInclusion) {
        this.secretariaInclusion = secretariaInclusion;
    }

    public Character getAlimentosPropios() {
        return alimentosPropios;
    }

    public void setAlimentosPropios(Character alimentosPropios) {
        this.alimentosPropios = alimentosPropios;
    }

    public Long getCantidadDias() {
        return cantidadDias;
    }

    public void setCantidadDias(Long cantidadDias) {
        this.cantidadDias = cantidadDias;
    }

    public String getDetallesTipo() {
        return detallesTipo;
    }

    public void setDetallesTipo(String detallesTipo) {
        this.detallesTipo = detallesTipo;
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
        hash += (correlativoDonacion != null ? correlativoDonacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmerDonacion)) {
            return false;
        }
        EmerDonacion other = (EmerDonacion) object;
        if ((this.correlativoDonacion == null && other.correlativoDonacion != null) || (this.correlativoDonacion != null && !this.correlativoDonacion.equals(other.correlativoDonacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.org.mined.emergencia.model.EmerDonacion[ correlativoDonacion=" + correlativoDonacion + " ]";
    }

}
