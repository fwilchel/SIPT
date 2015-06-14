/*
 * Softstudio LTDA
 * Copyrigth .2015.
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
 * @author: Diego Poveda.
 * @name:
 * @descripcion:
 * @version: 1.0
 * @since: JDK_1.7
 */
@Entity
@Table(catalog = "sipt", schema = "public")
@NamedQueries({
  @NamedQuery(name = Cesantias.FIND_ALL, query = "SELECT c FROM Cesantias c"),
  @NamedQuery(name = Cesantias.FIND_BY_EMPLEADO, query = "SELECT c FROM Cesantias c WHERE c.empleado.id = :idEmpleado")
})
public class Cesantias implements Serializable {

  private static final long serialVersionUID = 1L;
  public static final String FIND_ALL = "Cesantias.findAll";
  public static final String FIND_BY_EMPLEADO = "Cesantias.findByEmpleado";
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(nullable = false)
  private Long id;
  @Basic(optional = false)
  @NotNull
  @Column(name = "fecha_solicitud", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaSolicitud;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 500)
  @Column(nullable = false, length = 500)
  private String descripcion;
  @Basic(optional = false)
  @NotNull
  @Column(nullable = false)
  private BigInteger monto;
  @Basic(optional = false)
  @NotNull
  @Column(name = "fecha_aprobacion", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaAprobacion;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 1000)
  @Column(nullable = false, length = 1000)
  private String observaciones;
  @JoinColumn(name = "empleado", referencedColumnName = "id", nullable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Empleado empleado;

  public Cesantias() {
  }

  public Cesantias(Long id) {
    this.id = id;
  }

  public Cesantias(Long id, Date fechaSolicitud, String descripcion, BigInteger monto, Date fechaAprobacion, String observaciones) {
    this.id = id;
    this.fechaSolicitud = fechaSolicitud;
    this.descripcion = descripcion;
    this.monto = monto;
    this.fechaAprobacion = fechaAprobacion;
    this.observaciones = observaciones;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getFechaSolicitud() {
    return fechaSolicitud;
  }

  public void setFechaSolicitud(Date fechaSolicitud) {
    this.fechaSolicitud = fechaSolicitud;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public BigInteger getMonto() {
    return monto;
  }

  public void setMonto(BigInteger monto) {
    this.monto = monto;
  }

  public Date getFechaAprobacion() {
    return fechaAprobacion;
  }

  public void setFechaAprobacion(Date fechaAprobacion) {
    this.fechaAprobacion = fechaAprobacion;
  }

  public String getObservaciones() {
    return observaciones;
  }

  public void setObservaciones(String observaciones) {
    this.observaciones = observaciones;
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
    if (!(object instanceof Cesantias)) {
      return false;
    }
    Cesantias other = (Cesantias) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.ssl.sipt.api.model.Cesantias[ id=" + id + " ]";
  }

}
