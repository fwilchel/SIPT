/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssl.sipt.api.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author d5a9p6s7
 */
@Entity
@Table(catalog = "sipt", schema = "public")
@NamedQueries({
  @NamedQuery(name = "Beneficiario.findAll", query = "SELECT b FROM Beneficiario b")})
public class Beneficiario implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(nullable = false)
  private Long id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(nullable = false, length = 100)
  private String identificacion;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(nullable = false, length = 100)
  private String nombres;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(nullable = false, length = 100)
  private String apellidos;
  @Basic(optional = false)
  @NotNull
  @Column(name = "fecha_nacimiento", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaNacimiento;
  @JoinColumn(name = "parentesco", referencedColumnName = "id", nullable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Item parentesco;
  @JoinColumn(name = "tipo_identificacion", referencedColumnName = "id", nullable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Item tipoIdentificacion;
  @JoinColumn(name = "genero", referencedColumnName = "id", nullable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Item genero;
  @JoinColumn(name = "empleado", referencedColumnName = "id", nullable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Empleado empleado;

  public Beneficiario() {
  }

  public Beneficiario(Long id) {
    this.id = id;
  }

  public Beneficiario(Long id, String identificacion, String nombres, String apellidos, Date fechaNacimiento) {
    this.id = id;
    this.identificacion = identificacion;
    this.nombres = nombres;
    this.apellidos = apellidos;
    this.fechaNacimiento = fechaNacimiento;
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

  public Date getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setFechaNacimiento(Date fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public Item getParentesco() {
    return parentesco;
  }

  public void setParentesco(Item parentesco) {
    this.parentesco = parentesco;
  }

  public Item getTipoIdentificacion() {
    return tipoIdentificacion;
  }

  public void setTipoIdentificacion(Item tipoIdentificacion) {
    this.tipoIdentificacion = tipoIdentificacion;
  }

  public Item getGenero() {
    return genero;
  }

  public void setGenero(Item genero) {
    this.genero = genero;
  }

  public Empleado getEmpleado() {
    return empleado;
  }

  public void setEmpleado(Empleado empleado) {
    this.empleado = empleado;
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
    if (!(object instanceof Beneficiario)) {
      return false;
    }
    Beneficiario other = (Beneficiario) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.ssl.sipt.api.model.Beneficiario[ id=" + id + " ]";
  }

}
