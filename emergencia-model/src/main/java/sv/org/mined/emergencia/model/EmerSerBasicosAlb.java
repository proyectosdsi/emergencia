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
@Table(name = "EMER_SER_BASICOS_ALB")
@NamedQueries({
    @NamedQuery(name = "EmerSerBasicosAlb.findAll", query = "SELECT e FROM EmerSerBasicosAlb e")})
public class EmerSerBasicosAlb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CORRELATIVO_BASICO")
    private Integer correlativoBasico;
    @Column(name = "AGUA_BASICOS")
    private Character aguaBasicos;
    @Column(name = "SUSPENDIDAD_AGUA")
    private Character suspendidadAgua;
    @Column(name = "POTABLE_BASICOS")
    private Character potableBasicos;
    @Column(name = "CISTERNA_BASICOS")
    private Character cisternaBasicos;
    @Column(name = "POZO_BASICOS")
    private Character pozoBasicos;
    @Column(name = "OTROS_BASICOS")
    private String otrosBasicos;
    @Column(name = "ENERGIA_ELECTRICA_BASICOS")
    private Character energiaElectricaBasicos;
    @Column(name = "OTROS_ELECTRICA")
    private String otrosElectrica;
    @Column(name = "SUSPENDIDA_BASICOS")
    private Character suspendidaBasicos;
    @Column(name = "EXPLICAR_BASICOS")
    private String explicarBasicos;
    @Column(name = "SERVICIOS_SANITARIOS_BASICOS")
    private Character serviciosSanitariosBasicos;
    @Column(name = "CANTIDAD_BASICOS")
    private BigInteger cantidadBasicos;
    @Column(name = "DESCRIPCION_BASICO")
    private String descripcionBasico;
    @Column(name = "FOSA_BASICOS")
    private Long fosaBasicos;
    @Column(name = "LAVAR_BASICOS")
    private Long lavarBasicos;
    @Column(name = "LETRINA_ABONERA")
    private Long letrinaAbonera;
    @Column(name = "URINARIO")
    private Long urinario;
    @Column(name = "PORTATILES")
    private Long portatiles;
    @JoinColumn(name = "CORRELATIVO_REGISTRO", referencedColumnName = "CORRELATIVO_REGISTRO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmerRegistroAlbergue correlativoRegistro;

    public EmerSerBasicosAlb() {
    }

    public EmerSerBasicosAlb(Integer correlativoBasico) {
        this.correlativoBasico = correlativoBasico;
    }

    public Integer getCorrelativoBasico() {
        return correlativoBasico;
    }

    public void setCorrelativoBasico(Integer correlativoBasico) {
        this.correlativoBasico = correlativoBasico;
    }

    public Character getAguaBasicos() {
        return aguaBasicos;
    }

    public void setAguaBasicos(Character aguaBasicos) {
        this.aguaBasicos = aguaBasicos;
    }

    public Character getSuspendidadAgua() {
        return suspendidadAgua;
    }

    public void setSuspendidadAgua(Character suspendidadAgua) {
        this.suspendidadAgua = suspendidadAgua;
    }

    public Character getPotableBasicos() {
        return potableBasicos;
    }

    public void setPotableBasicos(Character potableBasicos) {
        this.potableBasicos = potableBasicos;
    }

    public Character getCisternaBasicos() {
        return cisternaBasicos;
    }

    public void setCisternaBasicos(Character cisternaBasicos) {
        this.cisternaBasicos = cisternaBasicos;
    }

    public Character getPozoBasicos() {
        return pozoBasicos;
    }

    public void setPozoBasicos(Character pozoBasicos) {
        this.pozoBasicos = pozoBasicos;
    }

    public String getOtrosBasicos() {
        return otrosBasicos;
    }

    public void setOtrosBasicos(String otrosBasicos) {
        this.otrosBasicos = otrosBasicos;
    }

    public Character getEnergiaElectricaBasicos() {
        return energiaElectricaBasicos;
    }

    public void setEnergiaElectricaBasicos(Character energiaElectricaBasicos) {
        this.energiaElectricaBasicos = energiaElectricaBasicos;
    }

    public String getOtrosElectrica() {
        return otrosElectrica;
    }

    public void setOtrosElectrica(String otrosElectrica) {
        this.otrosElectrica = otrosElectrica;
    }

    public Character getSuspendidaBasicos() {
        return suspendidaBasicos;
    }

    public void setSuspendidaBasicos(Character suspendidaBasicos) {
        this.suspendidaBasicos = suspendidaBasicos;
    }

    public String getExplicarBasicos() {
        return explicarBasicos;
    }

    public void setExplicarBasicos(String explicarBasicos) {
        this.explicarBasicos = explicarBasicos;
    }

    public Character getServiciosSanitariosBasicos() {
        return serviciosSanitariosBasicos;
    }

    public void setServiciosSanitariosBasicos(Character serviciosSanitariosBasicos) {
        this.serviciosSanitariosBasicos = serviciosSanitariosBasicos;
    }

    public BigInteger getCantidadBasicos() {
        return cantidadBasicos;
    }

    public void setCantidadBasicos(BigInteger cantidadBasicos) {
        this.cantidadBasicos = cantidadBasicos;
    }

    public String getDescripcionBasico() {
        return descripcionBasico;
    }

    public void setDescripcionBasico(String descripcionBasico) {
        this.descripcionBasico = descripcionBasico;
    }

    public Long getFosaBasicos() {
        return fosaBasicos;
    }

    public void setFosaBasicos(Long fosaBasicos) {
        this.fosaBasicos = fosaBasicos;
    }

    public Long getLavarBasicos() {
        return lavarBasicos;
    }

    public void setLavarBasicos(Long lavarBasicos) {
        this.lavarBasicos = lavarBasicos;
    }

    public Long getLetrinaAbonera() {
        return letrinaAbonera;
    }

    public void setLetrinaAbonera(Long letrinaAbonera) {
        this.letrinaAbonera = letrinaAbonera;
    }

    public Long getUrinario() {
        return urinario;
    }

    public void setUrinario(Long urinario) {
        this.urinario = urinario;
    }

    public Long getPortatiles() {
        return portatiles;
    }

    public void setPortatiles(Long portatiles) {
        this.portatiles = portatiles;
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
        hash += (correlativoBasico != null ? correlativoBasico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmerSerBasicosAlb)) {
            return false;
        }
        EmerSerBasicosAlb other = (EmerSerBasicosAlb) object;
        if ((this.correlativoBasico == null && other.correlativoBasico != null) || (this.correlativoBasico != null && !this.correlativoBasico.equals(other.correlativoBasico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.org.mined.emergencia.model.EmerSerBasicosAlb[ correlativoBasico=" + correlativoBasico + " ]";
    }
    
}
