/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.org.mined.emergencia.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author MISanchez
 */
@Entity
@Table(name = "EMER_MINED_PER")
@NamedQueries({
    @NamedQuery(name = "EmerMinedPer.findAll", query = "SELECT e FROM EmerMinedPer e")})
public class EmerMinedPer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PERSONAL")
    private Integer idPersonal;
    @Column(name = "NOMBRE_PERSONAL")
    private String nombrePersonal;
    @Column(name = "UNIDAD_LABORAL")
    private String unidadLaboral;
    @Column(name = "TEL_PERSONAL_CASA")
    private String telPersonalCasa;
    @Column(name = "TEL_PERSONAL_OFICINA")
    private String telPersonalOficina;
    @Column(name = "EXT_PERSONAL_OFICINA1")
    private String extPersonalOficina1;
    @Column(name = "EXT_PERSONAL_OFICINA2")
    private String extPersonalOficina2;
    @Column(name = "EMAIL_PERSONAL")
    private String emailPersonal;
    @Column(name = "CARGO_PERSONAL")
    private String cargoPersonal;
    @OneToMany(mappedBy = "idPersonal", fetch = FetchType.LAZY)
    private List<EmerPerFirma> emerPerFirmaList;

    public EmerMinedPer() {
    }

    public EmerMinedPer(Integer idPersonal) {
        this.idPersonal = idPersonal;
    }

    public Integer getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Integer idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getNombrePersonal() {
        return nombrePersonal;
    }

    public void setNombrePersonal(String nombrePersonal) {
        this.nombrePersonal = nombrePersonal;
    }

    public String getUnidadLaboral() {
        return unidadLaboral;
    }

    public void setUnidadLaboral(String unidadLaboral) {
        this.unidadLaboral = unidadLaboral;
    }

    public String getTelPersonalCasa() {
        return telPersonalCasa;
    }

    public void setTelPersonalCasa(String telPersonalCasa) {
        this.telPersonalCasa = telPersonalCasa;
    }

    public String getTelPersonalOficina() {
        return telPersonalOficina;
    }

    public void setTelPersonalOficina(String telPersonalOficina) {
        this.telPersonalOficina = telPersonalOficina;
    }

    public String getExtPersonalOficina1() {
        return extPersonalOficina1;
    }

    public void setExtPersonalOficina1(String extPersonalOficina1) {
        this.extPersonalOficina1 = extPersonalOficina1;
    }

    public String getExtPersonalOficina2() {
        return extPersonalOficina2;
    }

    public void setExtPersonalOficina2(String extPersonalOficina2) {
        this.extPersonalOficina2 = extPersonalOficina2;
    }

    public String getEmailPersonal() {
        return emailPersonal;
    }

    public void setEmailPersonal(String emailPersonal) {
        this.emailPersonal = emailPersonal;
    }

    public String getCargoPersonal() {
        return cargoPersonal;
    }

    public void setCargoPersonal(String cargoPersonal) {
        this.cargoPersonal = cargoPersonal;
    }

    public List<EmerPerFirma> getEmerPerFirmaList() {
        return emerPerFirmaList;
    }

    public void setEmerPerFirmaList(List<EmerPerFirma> emerPerFirmaList) {
        this.emerPerFirmaList = emerPerFirmaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersonal != null ? idPersonal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmerMinedPer)) {
            return false;
        }
        EmerMinedPer other = (EmerMinedPer) object;
        if ((this.idPersonal == null && other.idPersonal != null) || (this.idPersonal != null && !this.idPersonal.equals(other.idPersonal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.org.mined.emergencia.model.EmerMinedPer[ idPersonal=" + idPersonal + " ]";
    }
    
}
