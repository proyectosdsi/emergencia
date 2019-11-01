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
@Table(name = "EMER_CAP_ALBERGUE")
@NamedQueries({
    @NamedQuery(name = "EmerCapAlbergue.findAll", query = "SELECT e FROM EmerCapAlbergue e")})
public class EmerCapAlbergue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CORRELATIVO_CAPACIDAD")
    private Integer correlativoCapacidad;
    @Column(name = "NUMERO_PERSONAS_AULAS")
    private BigInteger numeroPersonasAulas;
    @Column(name = "PERSONAS_POR_AULA_CAPACIDAD")
    private BigInteger personasPorAulaCapacidad;
    @Column(name = "BUEN_ESTADO")
    private Long buenEstado;
    @Column(name = "MAL_ESTADO")
    private Long malEstado;
    @Column(name = "ESPACIOS_TIPOS")
    private Character espaciosTipos;
    @JoinColumn(name = "CORRELATIVO_REGISTRO", referencedColumnName = "CORRELATIVO_REGISTRO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmerRegistroAlbergue correlativoRegistro;
    @JoinColumn(name = "ID_TIPO_AULA", referencedColumnName = "ID_TIPO_AULA")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmerTipAulas idTipoAula;

    public EmerCapAlbergue() {
    }

    public EmerCapAlbergue(Integer correlativoCapacidad) {
        this.correlativoCapacidad = correlativoCapacidad;
    }

    public Integer getCorrelativoCapacidad() {
        return correlativoCapacidad;
    }

    public void setCorrelativoCapacidad(Integer correlativoCapacidad) {
        this.correlativoCapacidad = correlativoCapacidad;
    }

    public BigInteger getNumeroPersonasAulas() {
        return numeroPersonasAulas;
    }

    public void setNumeroPersonasAulas(BigInteger numeroPersonasAulas) {
        this.numeroPersonasAulas = numeroPersonasAulas;
    }

    public BigInteger getPersonasPorAulaCapacidad() {
        return personasPorAulaCapacidad;
    }

    public void setPersonasPorAulaCapacidad(BigInteger personasPorAulaCapacidad) {
        this.personasPorAulaCapacidad = personasPorAulaCapacidad;
    }

    public Long getBuenEstado() {
        return buenEstado;
    }

    public void setBuenEstado(Long buenEstado) {
        this.buenEstado = buenEstado;
    }

    public Long getMalEstado() {
        return malEstado;
    }

    public void setMalEstado(Long malEstado) {
        this.malEstado = malEstado;
    }

    public Character getEspaciosTipos() {
        return espaciosTipos;
    }

    public void setEspaciosTipos(Character espaciosTipos) {
        this.espaciosTipos = espaciosTipos;
    }

    public EmerRegistroAlbergue getCorrelativoRegistro() {
        return correlativoRegistro;
    }

    public void setCorrelativoRegistro(EmerRegistroAlbergue correlativoRegistro) {
        this.correlativoRegistro = correlativoRegistro;
    }

    public EmerTipAulas getIdTipoAula() {
        return idTipoAula;
    }

    public void setIdTipoAula(EmerTipAulas idTipoAula) {
        this.idTipoAula = idTipoAula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (correlativoCapacidad != null ? correlativoCapacidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmerCapAlbergue)) {
            return false;
        }
        EmerCapAlbergue other = (EmerCapAlbergue) object;
        if ((this.correlativoCapacidad == null && other.correlativoCapacidad != null) || (this.correlativoCapacidad != null && !this.correlativoCapacidad.equals(other.correlativoCapacidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.org.mined.emergencia.model.EmerCapAlbergue[ correlativoCapacidad=" + correlativoCapacidad + " ]";
    }
    
}
