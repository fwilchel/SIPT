/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssl.sipt.api.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author d5a9p6s7
 */
@Entity
@Table(name = "centro_trabajo", catalog = "sipt", schema = "public")
@NamedQueries({
  @NamedQuery(name = "CentroTrabajo.findAll", query = "SELECT c FROM CentroTrabajo c")})
public class CentroTrabajo implements Serializable {

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
  private String nombre;
  @Size(max = 500)
  @Column(length = 500)
  private String descripcion;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(nullable = false, length = 100)
  private String direccion;
  @Basic(optional = false)
  @NotNull
  @Column(nullable = false)
  private boolean estado;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "centroTrabajo", fetch = FetchType.LAZY)
  private List<Empleado> empleadoList;

  public CentroTrabajo() {
  }

  public CentroTrabajo(Long id) {
    this.id = id;
  }

  public CentroTrabajo(Long id, String nombre, String direccion, boolean estado) {
    this.id = id;
    this.nombre = nombre;
    this.direccion = direccion;
    this.estado = estado;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public boolean getEstado() {
    return estado;
  }

  public void setEstado(boolean estado) {
    this.estado = estado;
  }

  public List<Empleado> getEmpleadoList() {
    return empleadoList;
  }

  public void setEmpleadoList(List<Empleado> empleadoList) {
    this.empleadoList = empleadoList;
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
    if (!(object instanceof CentroTrabajo)) {
      return false;
    }
    CentroTrabajo other = (CentroTrabajo) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.ssl.sipt.api.model.CentroTrabajo[ id=" + id + " ]";
  }

}
