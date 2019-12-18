/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.emergencia.model.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MISanchez
 */
@Entity
@XmlRootElement
@SqlResultSetMapping(name = "defaultVwCatalogoEntidad",
        entities = @EntityResult(entityClass = VwCatalogoEntidad.class))
public class VwCatalogoEntidad implements Serializable {

    @Id
    private BigDecimal idRow;
    private String codigoEntidad;
    private String nombre;
    private String direccion;
    private String codigoDepartamento;
    private String codigoMunicipio;
    private String nombreDepartamento;
    private String nombreMunicipio;
    private String codigoModalidadAdmin;
    private String inicialesModalidad;
    private String codigoTipoEntidad;
    private String entNombre;
    private String telefono1;
    private String codigoZona;
    private String zonaNombre;

    public BigDecimal getIdRow() {
        return idRow;
    }

    public void setIdRow(BigDecimal idRow) {
        this.idRow = idRow;
    }

    public String getCodigoEntidad() {
        return codigoEntidad;
    }

    public void setCodigoEntidad(String codigoEntidad) {
        this.codigoEntidad = codigoEntidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(String codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public String getNombreMunicipio() {
        return nombreMunicipio;
    }

    public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigoModalidadAdmin() {
        return codigoModalidadAdmin;
    }

    public void setCodigoModalidadAdmin(String codigoModalidadAdmin) {
        this.codigoModalidadAdmin = codigoModalidadAdmin;
    }

    public String getInicialesModalidad() {
        return inicialesModalidad;
    }

    public void setInicialesModalidad(String inicialesModalidad) {
        this.inicialesModalidad = inicialesModalidad;
    }

    public String getCodigoTipoEntidad() {
        return codigoTipoEntidad;
    }

    public void setCodigoTipoEntidad(String codigoTipoEntidad) {
        this.codigoTipoEntidad = codigoTipoEntidad;
    }

    public String getEntNombre() {
        return entNombre;
    }

    public void setEntNombre(String entNombre) {
        this.entNombre = entNombre;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getCodigoZona() {
        return codigoZona;
    }

    public void setCodigoZona(String codigoZona) {
        this.codigoZona = codigoZona;
    }

    public String getZonaNombre() {
        return zonaNombre;
    }

    public void setZonaNombre(String zonaNombre) {
        this.zonaNombre = zonaNombre;
    }

    @Override
    public String toString() {
        return "VwCatalogoEntidad{" + "codigoEntidad=" + codigoEntidad + ", nombre=" + nombre + '}';
    }

}
