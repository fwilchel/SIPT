package com.ssl.sipt.api.model;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author d5a9p6s7
 */
@Entity
@Table(catalog = "sipt", schema = "public")
@NamedQueries({
  @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")})
public class Empleado implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(nullable = false)
  private Long id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 25)
  @Column(nullable = false, length = 25)
  private String identificacion;
  @Column(name = "lugar_expedicion_identificacion")
  private BigInteger lugarExpedicionIdentificacion;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(nullable = false, length = 50)
  private String nombres;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(nullable = false, length = 50)
  private String apellidos;
  @Basic(optional = false)
  @NotNull
  @Column(nullable = false)
  private boolean estado;
  // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
  @Size(max = 100)
  @Column(length = 100)
  private String email;
  @Size(max = 100)
  @Column(length = 100)
  private String lugar;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2147483647)
  @Column(nullable = false, length = 2147483647)
  private String direccion;
  @JoinColumn(name = "municipio", referencedColumnName = "id", nullable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Municipio municipio;
  @JoinColumn(name = "macro_proyecto", referencedColumnName = "id", nullable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Item macroProyecto;
  @JoinColumn(name = "cargo", referencedColumnName = "id", nullable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Item cargo;
  @JoinColumn(name = "genero", referencedColumnName = "id", nullable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Item genero;
  @JoinColumn(name = "estado_civil", referencedColumnName = "id", nullable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Item estadoCivil;
  @JoinColumn(name = "rh", referencedColumnName = "id", nullable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Item rh;
  @JoinColumn(name = "tipo_contrato", referencedColumnName = "id", nullable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Item tipoContrato;
  @JoinColumn(name = "tipo_identificacion", referencedColumnName = "id", nullable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Item tipoIdentificacion;
  @JoinColumn(name = "centro_trabajo", referencedColumnName = "id", nullable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private CentroTrabajo centroTrabajo;
  @JoinColumn(name = "centro_medico", referencedColumnName = "id", nullable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private CentroMedico centroMedico;
  @JoinColumn(name = "curriculum", referencedColumnName = "id", nullable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Archivo curriculum;

  public Empleado() {
  }

  public Empleado(Long id) {
    this.id = id;
  }

  public Empleado(Long id, String identificacion, String nombres, String apellidos, boolean estado, String direccion) {
    this.id = id;
    this.identificacion = identificacion;
    this.nombres = nombres;
    this.apellidos = apellidos;
    this.estado = estado;
    this.direccion = direccion;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getIdentificacion() {
    return identificacion;
  }

  public void setIdentificacion(String identificacion) {
    this.identificacion = identificacion;
  }

  public BigInteger getLugarExpedicionIdentificacion() {
    return lugarExpedicionIdentificacion;
  }

  public void setLugarExpedicionIdentificacion(BigInteger lugarExpedicionIdentificacion) {
    this.lugarExpedicionIdentificacion = lugarExpedicionIdentificacion;
  }

  public String getNombres() {
    return nombres;
  }

  public void setNombres(String nombres) {
    this.nombres = nombres;
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public boolean getEstado() {
    return estado;
  }

  public void setEstado(boolean estado) {
    this.estado = estado;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getLugar() {
    return lugar;
  }

  public void setLugar(String lugar) {
    this.lugar = lugar;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public Municipio getMunicipio() {
    return municipio;
  }

  public void setMunicipio(Municipio municipio) {
    this.municipio = municipio;
  }

  public Item getMacroProyecto() {
    return macroProyecto;
  }

  public void setMacroProyecto(Item macroProyecto) {
    this.macroProyecto = macroProyecto;
  }

  public Item getCargo() {
    return cargo;
  }

  public void setCargo(Item cargo) {
    this.cargo = cargo;
  }

  public Item getGenero() {
    return genero;
  }

  public void setGenero(Item genero) {
    this.genero = genero;
  }

  public Item getEstadoCivil() {
    return estadoCivil;
  }

  public void setEstadoCivil(Item estadoCivil) {
    this.estadoCivil = estadoCivil;
  }

  public Item getRh() {
    return rh;
  }

  public void setRh(Item rh) {
    this.rh = rh;
  }

  public Item getTipoContrato() {
    return tipoContrato;
  }

  public void setTipoContrato(Item tipoContrato) {
    this.tipoContrato = tipoContrato;
  }

  public Item getTipoIdentificacion() {
    return tipoIdentificacion;
  }

  public void setTipoIdentificacion(Item tipoIdentificacion) {
    this.tipoIdentificacion = tipoIdentificacion;
  }

  public CentroTrabajo getCentroTrabajo() {
    return centroTrabajo;
  }

  public void setCentroTrabajo(CentroTrabajo centroTrabajo) {
    this.centroTrabajo = centroTrabajo;
  }

  public CentroMedico getCentroMedico() {
    return centroMedico;
  }

  public void setCentroMedico(CentroMedico centroMedico) {
    this.centroMedico = centroMedico;
  }

  public Archivo getCurriculum() {
    return curriculum;
  }

  public void setCurriculum(Archivo curriculum) {
    this.curriculum = curriculum;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Empleado)) {
      return false;
    }
    Empleado other = (Empleado) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.ssl.sipt.api.model.Empleado[ id=" + id + " ]";
  }

}
