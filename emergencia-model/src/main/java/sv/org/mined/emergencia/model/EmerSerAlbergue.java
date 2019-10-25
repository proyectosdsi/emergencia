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
@Table(name = "EMER_SER_ALBERGUE")
@NamedQueries({
    @NamedQuery(name = "EmerSerAlbergue.findAll", query = "SELECT e FROM EmerSerAlbergue e")})
public class EmerSerAlbergue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CORRELATIVO_SERVICIOS")
    private Integer correlativoServicios;
    @Column(name = "OBSERVACION_SERVICIO")
    private String observacionServicio;
    @Column(name = "ALIMENTOS_SERVICIO")
    private String alimentosServicio;
    @Column(name = "BRIGADISTAS_JUVENIL_SERVICIO")
    private Character brigadistasJuvenilServicio;
    @Column(name = "INST_BRIGADISTA_SERVICIO")
    private String instBrigadistaServicio;
    @Column(name = "DESCRIPCION_ASIS_SERVICIO")
    private String descripcionAsisServicio;
    @Column(name = "NECESIDADES_ASISTENACIA")
    private String necesidadesAsistenacia;
    @Column(name = "OBSERVACION_ASIS_SERVICIO")
    private String observacionAsisServicio;
    @Column(name = "ORGANIZACIONES_APOYO")
    private String organizacionesApoyo;
    @JoinColumn(name = "CORRELATIVO_REGISTRO", referencedColumnName = "CORRELATIVO_REGISTRO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmerRegistroAlbergue correlativoRegistro;

    public EmerSerAlbergue() {
    }

    public EmerSerAlbergue(Integer correlativoServicios) {
        this.correlativoServicios = correlativoServicios;
    }

    public Integer getCorrelativoServicios() {
        return correlativoServicios;
    }

    public void setCorrelativoServicios(Integer correlativoServicios) {
        this.correlativoServicios = correlativoServicios;
    }

    public String getObservacionServicio() {
        return observacionServicio;
    }

    public void setObservacionServicio(String observacionServicio) {
        this.observacionServicio = observacionServicio;
    }

    public String getAlimentosServicio() {
        return alimentosServicio;
    }

    public void setAlimentosServicio(String alimentosServicio) {
        this.alimentosServicio = alimentosServicio;
    }

    public Character getBrigadistasJuvenilServicio() {
        return brigadistasJuvenilServicio;
    }

    public void setBrigadistasJuvenilServicio(Character brigadistasJuvenilServicio) {
        this.brigadistasJuvenilServicio = brigadistasJuvenilServicio;
    }

    public String getInstBrigadistaServicio() {
        return instBrigadistaServicio;
    }

    public void setInstBrigadistaServicio(String instBrigadistaServicio) {
        this.instBrigadistaServicio = instBrigadistaServicio;
    }

    public String getDescripcionAsisServicio() {
        return descripcionAsisServicio;
    }

    public void setDescripcionAsisServicio(String descripcionAsisServicio) {
        this.descripcionAsisServicio = descripcionAsisServicio;
    }

    public String getNecesidadesAsistenacia() {
        return necesidadesAsistenacia;
    }

    public void setNecesidadesAsistenacia(String necesidadesAsistenacia) {
        this.necesidadesAsistenacia = necesidadesAsistenacia;
    }

    public String getObservacionAsisServicio() {
        return observacionAsisServicio;
    }

    public void setObservacionAsisServicio(String observacionAsisServicio) {
        this.observacionAsisServicio = observacionAsisServicio;
    }

    public String getOrganizacionesApoyo() {
        return organizacionesApoyo;
    }

    public void setOrganizacionesApoyo(String organizacionesApoyo) {
        this.organizacionesApoyo = organizacionesApoyo;
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
        hash += (correlativoServicios != null ? correlativoServicios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmerSerAlbergue)) {
            return false;
        }
        EmerSerAlbergue other = (EmerSerAlbergue) object;
        if ((this.correlativoServicios == null && other.correlativoServicios != null) || (this.correlativoServicios != null && !this.correlativoServicios.equals(other.correlativoServicios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.org.mined.emergencia.model.EmerSerAlbergue[ correlativoServicios=" + correlativoServicios + " ]";
    }
    
}
