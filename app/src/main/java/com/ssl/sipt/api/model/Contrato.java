/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssl.sipt.api.model;

import java.io.Serializable;
import java.math.BigInteger;
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
  @NamedQuery(name = "Contrato.findAll", query = "SELECT c FROM Contrato c")})
public class Contrato implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(nullable = false)
  private Long id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 500)
  @Column(nullable = false, length = 500)
  private String descripcion;
  @Basic(optional = false)
  @NotNull
  @Column(name = "fecha_inicio", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaInicio;
  @Basic(optional = false)
  @NotNull
  @Column(name = "fecha_fin", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaFin;
  @Basic(optional = false)
  @NotNull
  @Column(nullable = false)
  private BigInteger sueldo;
  @JoinColumn(name = "tipo_soporte", referencedColumnName = "id", nullable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Item tipoSoporte;
  @JoinColumn(name = "empleado", referencedColumnName = "id", nullable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Empleado empleado;
  @JoinColumn(name = "soporte", referencedColumnName = "id", nullable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Archivo soporte;

  public Contrato() {
  }

  public Contrato(Long id) {
    this.id = id;
  }

  public Contrato(Long id, String descripcion, Date fechaInicio, Date fechaFin, BigInteger sueldo) {
    this.id = id;
    this.descripcion = descripcion;
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
    this.sueldo = sueldo;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public Date getFechaInicio() {
    return fechaInicio;
  }

  public void setFechaInicio(Date fechaInicio) {
    this.fechaInicio = fechaInicio;
  }

  public Date getFechaFin() {
    return fechaFin;
  }

  public void setFechaFin(Date fechaFin) {
    this.fechaFin = fechaFin;
  }

  public BigInteger getSueldo() {
    return sueldo;
  }

  public void setSueldo(BigInteger sueldo) {
    this.sueldo = sueldo;
  }

  public Item getTipoSoporte() {
    return tipoSoporte;
  }

  public void setTipoSoporte(Item tipoSoporte) {
    this.tipoSoporte = tipoSoporte;
  }

  public Empleado getEmpleado() {
    return empleado;
  }

  public void setEmpleado(Empleado empleado) {
    this.empleado = empleado;
  }

  public Archivo getSoporte() {
    return soporte;
  }

  public void setSoporte(Archivo soporte) {
    this.soporte = soporte;
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
    if (!(object instanceof Contrato)) {
      return false;
    }
    Contrato other = (Contrato) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.ssl.sipt.api.model.Contrato[ id=" + id + " ]";
  }

}
