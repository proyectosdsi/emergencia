/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.emergencia.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author MISanchez
 */
@Entity
@Table(name = "EMER_REGISTRO_ALBERGUE")
@NamedQueries({
    @NamedQuery(name = "EmerRegistroAlbergue.findAll", query = "SELECT e FROM EmerRegistroAlbergue e")})
public class EmerRegistroAlbergue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CORRELATIVO_REGISTRO")
    private Integer correlativoRegistro;
    @Basic(optional = false)
    @Column(name = "CODIGO_ENTIDAD")
    private String codigoEntidad;
    @Column(name = "FECREG_EMERGENCIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecregEmergencia;
    @Column(name = "FECINI_ALBERGUE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date feciniAlbergue;
    @Column(name = "FECVITA_ALBERGUE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecvitaAlbergue;
    @Column(name = "HORA_VISITA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaVisita;
    @Column(name = "CANTON")
    private String canton;
    @Column(name = "CASERIO")
    private String caserio;
    @Column(name = "MATRICULA")
    private BigInteger matricula;
    @Column(name = "RESPONSABLE_VISITA")
    private String responsableVisita;
    @Column(name = "RESPONSABLE_ALBERGUE")
    private String responsableAlbergue;
    @Column(name = "TEL_RESPOS_ALBERGUE")
    private String telResposAlbergue;
    @Column(name = "NUMERO_AULAS_CAPACIDAD")
    private BigInteger numeroAulasCapacidad;
    @Column(name = "AULAS_EN_BUEN_ESTADO")
    private BigInteger aulasEnBuenEstado;
    @Column(name = "AULAS_MAL_ESTADO")
    private BigInteger aulasMalEstado;
    @Column(name = "POSEE_INTERNA")
    private Character poseeInterna;
    @Column(name = "HALLAZGOS_IMPORTANTES")
    private String hallazgosImportantes;
    @Column(name = "RUTA_REALIZADA")
    private Character rutaRealizada;
    @Column(name = "TEL_REPORTADO")
    private String telReportado;
    @Column(name = "CE_ACTO_PARA_ALBERGUE")
    private Character ceActoParaAlbergue;
    @Column(name = "CE_NO_ACTO_PARA_ALBERGUE")
    private Character ceNoActoParaAlbergue;
    @Column(name = "CE_DANADO_POR_EMERGENCIA")
    private Character ceDanadoPorEmergencia;
    @Column(name = "CE_ENRIESGO")
    private Character ceEnriesgo;
    @Column(name = "USUARIO_CREA")
    private String usuarioCrea;
    @Column(name = "FECHA_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCrea;
    @Column(name = "USUARIO_MODI")
    private String usuarioModi;
    @Column(name = "FECHA_MODI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModi;
    @Column(name = "ESTADO_ALBERGUE")
    private Character estadoAlbergue;
    @Column(name = "NUMERO_FAMILIAS")
    private Short numeroFamilias;
    @Column(name = "RECIBIO_AYUDA")
    private Character recibioAyuda;
    @Column(name = "INFORMACION")
    private Character informacion;
    @Column(name = "FECHA_CIERRE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCierre;
    @OneToMany(mappedBy = "correlativoRegistro", fetch = FetchType.LAZY)
    private List<EmerObservaciones> emerObservacionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "correlativoRegistro", fetch = FetchType.LAZY)
    private List<EmerSerAlbergue> emerSerAlbergueList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "correlativoRegistro", fetch = FetchType.LAZY)
    private List<EmerIntervencion> emerIntervencionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "correlativoRegistro", fetch = FetchType.LAZY)
    private List<EmerEscCercanas> emerEscCercanasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "correlativoRegistro", fetch = FetchType.LAZY)
    private List<EmerOtrasEmergencias> emerOtrasEmergenciasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "correlativoRegistro", fetch = FetchType.LAZY)
    private List<EmerRuta> emerRutaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "correlativoRegistro", fetch = FetchType.LAZY)
    private List<EmerDonacion> emerDonacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "correlativoRegistro", fetch = FetchType.LAZY)
    private List<EmerOrgInternaAlb> emerOrgInternaAlbList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "correlativoRegistro", fetch = FetchType.LAZY)
    private List<EmerPartePreventiva> emerPartePreventivaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "correlativoRegistro", fetch = FetchType.LAZY)
    private List<EmerPerFirma> emerPerFirmaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "correlativoRegistro", fetch = FetchType.LAZY)
    private List<EmerSerBasicosAlb> emerSerBasicosAlbList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "correlativoRegistro", fetch = FetchType.LAZY)
    private List<EmerInventario> emerInventarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "correlativoRegistro", fetch = FetchType.LAZY)
    private List<EmerPerRangoEdad> emerPerRangoEdadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "correlativoRegistro", fetch = FetchType.LAZY)
    private List<EmerRegDanio> emerRegDanioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "correlativoRegistro", fetch = FetchType.LAZY)
    private List<EmerLugProcedencia> emerLugProcedenciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "correlativoRegistro", fetch = FetchType.LAZY)
    private List<EmerComitePlan> emerComitePlanList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "correlativoRegistro", fetch = FetchType.LAZY)
    private List<EmerOrgApoyo> emerOrgApoyoList;
    @JoinColumn(name = "CODIGO_ESTADO", referencedColumnName = "CODIGO_ESTADO")
    @ManyToOne(fetch = FetchType.LAZY)
    private EmerEstadoAlbergue codigoEstado;
    @JoinColumn(name = "CODIGO_PELIGRO", referencedColumnName = "CODIGO_PELIGRO")
    @ManyToOne(fetch = FetchType.LAZY)
    private EmerPeligroAlb codigoPeligro;
    @JoinColumn(name = "CODIGO_EMERGENCIA", referencedColumnName = "CODIGO_EMERGENCIA")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmerTipoEmergencia codigoEmergencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "correlativoRegistro", fetch = FetchType.LAZY)
    private List<EmerBitacora> emerBitacoraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "correlativoRegistro", fetch = FetchType.LAZY)
    private List<EmerResMined> emerResMinedList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "correlativoRegistro", fetch = FetchType.LAZY)
    private List<EmerCapAlbergue> emerCapAlbergueList;

    public EmerRegistroAlbergue() {
    }

    public EmerRegistroAlbergue(Integer correlativoRegistro) {
        this.correlativoRegistro = correlativoRegistro;
    }

    public EmerRegistroAlbergue(Integer correlativoRegistro, String codigoEntidad) {
        this.correlativoRegistro = correlativoRegistro;
        this.codigoEntidad = codigoEntidad;
    }

    public Integer getCorrelativoRegistro() {
        return correlativoRegistro;
    }

    public void setCorrelativoRegistro(Integer correlativoRegistro) {
        this.correlativoRegistro = correlativoRegistro;
    }

    public String getCodigoEntidad() {
        return codigoEntidad;
    }

    public void setCodigoEntidad(String codigoEntidad) {
        this.codigoEntidad = codigoEntidad;
    }

    public Date getFecregEmergencia() {
        return fecregEmergencia;
    }

    public void setFecregEmergencia(Date fecregEmergencia) {
        this.fecregEmergencia = fecregEmergencia;
    }

    public Date getFeciniAlbergue() {
        return feciniAlbergue;
    }

    public void setFeciniAlbergue(Date feciniAlbergue) {
        this.feciniAlbergue = feciniAlbergue;
    }

    public Date getFecvitaAlbergue() {
        return fecvitaAlbergue;
    }

    public void setFecvitaAlbergue(Date fecvitaAlbergue) {
        this.fecvitaAlbergue = fecvitaAlbergue;
    }

    public Date getHoraVisita() {
        return horaVisita;
    }

    public void setHoraVisita(Date horaVisita) {
        this.horaVisita = horaVisita;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getCaserio() {
        return caserio;
    }

    public void setCaserio(String caserio) {
        this.caserio = caserio;
    }

    public BigInteger getMatricula() {
        return matricula;
    }

    public void setMatricula(BigInteger matricula) {
        this.matricula = matricula;
    }

    public String getResponsableVisita() {
        return responsableVisita;
    }

    public void setResponsableVisita(String responsableVisita) {
        this.responsableVisita = responsableVisita;
    }

    public String getResponsableAlbergue() {
        return responsableAlbergue;
    }

    public void setResponsableAlbergue(String responsableAlbergue) {
        this.responsableAlbergue = responsableAlbergue;
    }

    public String getTelResposAlbergue() {
        return telResposAlbergue;
    }

    public void setTelResposAlbergue(String telResposAlbergue) {
        this.telResposAlbergue = telResposAlbergue;
    }

    public BigInteger getNumeroAulasCapacidad() {
        return numeroAulasCapacidad;
    }

    public void setNumeroAulasCapacidad(BigInteger numeroAulasCapacidad) {
        this.numeroAulasCapacidad = numeroAulasCapacidad;
    }

    public BigInteger getAulasEnBuenEstado() {
        return aulasEnBuenEstado;
    }

    public void setAulasEnBuenEstado(BigInteger aulasEnBuenEstado) {
        this.aulasEnBuenEstado = aulasEnBuenEstado;
    }

    public BigInteger getAulasMalEstado() {
        return aulasMalEstado;
    }

    public void setAulasMalEstado(BigInteger aulasMalEstado) {
        this.aulasMalEstado = aulasMalEstado;
    }

    public Character getPoseeInterna() {
        return poseeInterna;
    }

    public void setPoseeInterna(Character poseeInterna) {
        this.poseeInterna = poseeInterna;
    }

    public String getHallazgosImportantes() {
        return hallazgosImportantes;
    }

    public void setHallazgosImportantes(String hallazgosImportantes) {
        this.hallazgosImportantes = hallazgosImportantes;
    }

    public Character getRutaRealizada() {
        return rutaRealizada;
    }

    public void setRutaRealizada(Character rutaRealizada) {
        this.rutaRealizada = rutaRealizada;
    }

    public String getTelReportado() {
        return telReportado;
    }

    public void setTelReportado(String telReportado) {
        this.telReportado = telReportado;
    }

    public Character getCeActoParaAlbergue() {
        return ceActoParaAlbergue;
    }

    public void setCeActoParaAlbergue(Character ceActoParaAlbergue) {
        this.ceActoParaAlbergue = ceActoParaAlbergue;
    }

    public Character getCeNoActoParaAlbergue() {
        return ceNoActoParaAlbergue;
    }

    public void setCeNoActoParaAlbergue(Character ceNoActoParaAlbergue) {
        this.ceNoActoParaAlbergue = ceNoActoParaAlbergue;
    }

    public Character getCeDanadoPorEmergencia() {
        return ceDanadoPorEmergencia;
    }

    public void setCeDanadoPorEmergencia(Character ceDanadoPorEmergencia) {
        this.ceDanadoPorEmergencia = ceDanadoPorEmergencia;
    }

    public Character getCeEnriesgo() {
        return ceEnriesgo;
    }

    public void setCeEnriesgo(Character ceEnriesgo) {
        this.ceEnriesgo = ceEnriesgo;
    }

    public String getUsuarioCrea() {
        return usuarioCrea;
    }

    public void setUsuarioCrea(String usuarioCrea) {
        this.usuarioCrea = usuarioCrea;
    }

    public Date getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(Date fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    public String getUsuarioModi() {
        return usuarioModi;
    }

    public void setUsuarioModi(String usuarioModi) {
        this.usuarioModi = usuarioModi;
    }

    public Date getFechaModi() {
        return fechaModi;
    }

    public void setFechaModi(Date fechaModi) {
        this.fechaModi = fechaModi;
    }

    public Character getEstadoAlbergue() {
        return estadoAlbergue;
    }

    public void setEstadoAlbergue(Character estadoAlbergue) {
        this.estadoAlbergue = estadoAlbergue;
    }

    public Short getNumeroFamilias() {
        return numeroFamilias;
    }

    public void setNumeroFamilias(Short numeroFamilias) {
        this.numeroFamilias = numeroFamilias;
    }

    public Character getRecibioAyuda() {
        return recibioAyuda;
    }

    public void setRecibioAyuda(Character recibioAyuda) {
        this.recibioAyuda = recibioAyuda;
    }

    public Character getInformacion() {
        return informacion;
    }

    public void setInformacion(Character informacion) {
        this.informacion = informacion;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public List<EmerObservaciones> getEmerObservacionesList() {
        return emerObservacionesList;
    }

    public void setEmerObservacionesList(List<EmerObservaciones> emerObservacionesList) {
        this.emerObservacionesList = emerObservacionesList;
    }

    public List<EmerSerAlbergue> getEmerSerAlbergueList() {
        return emerSerAlbergueList;
    }

    public void setEmerSerAlbergueList(List<EmerSerAlbergue> emerSerAlbergueList) {
        this.emerSerAlbergueList = emerSerAlbergueList;
    }

    public List<EmerIntervencion> getEmerIntervencionList() {
        return emerIntervencionList;
    }

    public void setEmerIntervencionList(List<EmerIntervencion> emerIntervencionList) {
        this.emerIntervencionList = emerIntervencionList;
    }

    public List<EmerEscCercanas> getEmerEscCercanasList() {
        return emerEscCercanasList;
    }

    public void setEmerEscCercanasList(List<EmerEscCercanas> emerEscCercanasList) {
        this.emerEscCercanasList = emerEscCercanasList;
    }

    public List<EmerOtrasEmergencias> getEmerOtrasEmergenciasList() {
        return emerOtrasEmergenciasList;
    }

    public void setEmerOtrasEmergenciasList(List<EmerOtrasEmergencias> emerOtrasEmergenciasList) {
        this.emerOtrasEmergenciasList = emerOtrasEmergenciasList;
    }

    public List<EmerRuta> getEmerRutaList() {
        return emerRutaList;
    }

    public void setEmerRutaList(List<EmerRuta> emerRutaList) {
        this.emerRutaList = emerRutaList;
    }

    public List<EmerDonacion> getEmerDonacionList() {
        return emerDonacionList;
    }

    public void setEmerDonacionList(List<EmerDonacion> emerDonacionList) {
        this.emerDonacionList = emerDonacionList;
    }

    public List<EmerOrgInternaAlb> getEmerOrgInternaAlbList() {
        return emerOrgInternaAlbList;
    }

    public void setEmerOrgInternaAlbList(List<EmerOrgInternaAlb> emerOrgInternaAlbList) {
        this.emerOrgInternaAlbList = emerOrgInternaAlbList;
    }

    public List<EmerPartePreventiva> getEmerPartePreventivaList() {
        return emerPartePreventivaList;
    }

    public void setEmerPartePreventivaList(List<EmerPartePreventiva> emerPartePreventivaList) {
        this.emerPartePreventivaList = emerPartePreventivaList;
    }

    public List<EmerPerFirma> getEmerPerFirmaList() {
        return emerPerFirmaList;
    }

    public void setEmerPerFirmaList(List<EmerPerFirma> emerPerFirmaList) {
        this.emerPerFirmaList = emerPerFirmaList;
    }

    public List<EmerSerBasicosAlb> getEmerSerBasicosAlbList() {
        return emerSerBasicosAlbList;
    }

    public void setEmerSerBasicosAlbList(List<EmerSerBasicosAlb> emerSerBasicosAlbList) {
        this.emerSerBasicosAlbList = emerSerBasicosAlbList;
    }

    public List<EmerInventario> getEmerInventarioList() {
        return emerInventarioList;
    }

    public void setEmerInventarioList(List<EmerInventario> emerInventarioList) {
        this.emerInventarioList = emerInventarioList;
    }

    public List<EmerPerRangoEdad> getEmerPerRangoEdadList() {
        return emerPerRangoEdadList;
    }

    public void setEmerPerRangoEdadList(List<EmerPerRangoEdad> emerPerRangoEdadList) {
        this.emerPerRangoEdadList = emerPerRangoEdadList;
    }

    public List<EmerRegDanio> getEmerRegDanioList() {
        return emerRegDanioList;
    }

    public void setEmerRegDanioList(List<EmerRegDanio> emerRegDanioList) {
        this.emerRegDanioList = emerRegDanioList;
    }

    public List<EmerLugProcedencia> getEmerLugProcedenciaList() {
        return emerLugProcedenciaList;
    }

    public void setEmerLugProcedenciaList(List<EmerLugProcedencia> emerLugProcedenciaList) {
        this.emerLugProcedenciaList = emerLugProcedenciaList;
    }

    public List<EmerComitePlan> getEmerComitePlanList() {
        return emerComitePlanList;
    }

    public void setEmerComitePlanList(List<EmerComitePlan> emerComitePlanList) {
        this.emerComitePlanList = emerComitePlanList;
    }

    public List<EmerOrgApoyo> getEmerOrgApoyoList() {
        return emerOrgApoyoList;
    }

    public void setEmerOrgApoyoList(List<EmerOrgApoyo> emerOrgApoyoList) {
        this.emerOrgApoyoList = emerOrgApoyoList;
    }

    public EmerEstadoAlbergue getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(EmerEstadoAlbergue codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public EmerPeligroAlb getCodigoPeligro() {
        return codigoPeligro;
    }

    public void setCodigoPeligro(EmerPeligroAlb codigoPeligro) {
        this.codigoPeligro = codigoPeligro;
    }

    public EmerTipoEmergencia getCodigoEmergencia() {
        return codigoEmergencia;
    }

    public void setCodigoEmergencia(EmerTipoEmergencia codigoEmergencia) {
        this.codigoEmergencia = codigoEmergencia;
    }

    public List<EmerBitacora> getEmerBitacoraList() {
        return emerBitacoraList;
    }

    public void setEmerBitacoraList(List<EmerBitacora> emerBitacoraList) {
        this.emerBitacoraList = emerBitacoraList;
    }

    public List<EmerResMined> getEmerResMinedList() {
        return emerResMinedList;
    }

    public void setEmerResMinedList(List<EmerResMined> emerResMinedList) {
        this.emerResMinedList = emerResMinedList;
    }

    public List<EmerCapAlbergue> getEmerCapAlbergueList() {
        return emerCapAlbergueList;
    }

    public void setEmerCapAlbergueList(List<EmerCapAlbergue> emerCapAlbergueList) {
        this.emerCapAlbergueList = emerCapAlbergueList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (correlativoRegistro != null ? correlativoRegistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmerRegistroAlbergue)) {
            return false;
        }
        EmerRegistroAlbergue other = (EmerRegistroAlbergue) object;
        if ((this.correlativoRegistro == null && other.correlativoRegistro != null) || (this.correlativoRegistro != null && !this.correlativoRegistro.equals(other.correlativoRegistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.org.mined.emergencia.model.EmerRegistroAlbergue[ correlativoRegistro=" + correlativoRegistro + " ]";
    }
    
}
