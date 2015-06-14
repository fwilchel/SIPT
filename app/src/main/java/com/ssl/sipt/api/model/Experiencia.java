/*
 * Softstudio LTDA
 * Copyrigth .2015.
 */
package com.ssl.sipt.api.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
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
  @NamedQuery(name = Experiencia.FIND_ALL, query = "SELECT e FROM Experiencia e"),
  @NamedQuery(name = Experiencia.FIND_BY_EMPLEADO, query = "SELECT e FROM Experiencia e WHERE e.empleado.id = :idEmpleado")
})
public class Experiencia implements Serializable {

  private static final long serialVersionUID = 1L;
  public static final String FIND_ALL = "Experiencia.findAll";
  public static final String FIND_BY_EMPLEADO = "Experiencia.findByEmpleado";
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(nullable = false)
  private Long id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(nullable = false, length = 100)
  private String cargo;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 500)
  @Column(nullable = false, length = 500)
  private String observaciones;
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
  private boolean confirmado;
  @Basic(optional = true)
  @Column(name = "fecha_confirmacion", nullable = true)
  @Temporal(TemporalType.DATE)
  private Date fechaConfirmacion;
  @JoinColumn(name = "tipo_empresa", referencedColumnName = "id", nullable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Item tipoEmpresa;
  @JoinColumn(name = "empleado", referencedColumnName = "id", nullable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Empleado empleado;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "experiencia", fetch = FetchType.LAZY)
  private List<ArchivoXExperiencia> archivoXExperienciaList;

  public Experiencia() {
  }

  public Experiencia(Long id) {
    this.id = id;
  }

  public Experiencia(Long id, String cargo, String observaciones, Date fechaInicio, Date fechaFin, boolean confirmado, Date fechaConfirmacion) {
    this.id = id;
    this.cargo = cargo;
    this.observaciones = observaciones;
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
    this.confirmado = confirmado;
    this.fechaConfirmacion = fechaConfirmacion;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCargo() {
    return cargo;
  }

  public void setCargo(String cargo) {
    this.cargo = cargo;
  }

  public String getObservaciones() {
    return observaciones;
  }

  public void setObservaciones(String observaciones) {
    this.observaciones = observaciones;
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

  public boolean getConfirmado() {
    return confirmado;
  }

  public void setConfirmado(boolean confirmado) {
    this.confirmado = confirmado;
  }

  public Date getFechaConfirmacion() {
    return fechaConfirmacion;
  }

  public void setFechaConfirmacion(Date fechaConfirmacion) {
    this.fechaConfirmacion = fechaConfirmacion;
  }

  public List<ArchivoXExperiencia> getArchivoXExperienciaList() {
    return archivoXExperienciaList;
  }

  public void setArchivoXExperienciaList(List<ArchivoXExperiencia> archivoXExperienciaList) {
    this.archivoXExperienciaList = archivoXExperienciaList;
  }

  public Item getTipoEmpresa() {
    return tipoEmpresa;
  }

  public void setTipoEmpresa(Item tipoEmpresa) {
    this.tipoEmpresa = tipoEmpresa;
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
    if (!(object instanceof Experiencia)) {
      return false;
    }
    Experiencia other = (Experiencia) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.ssl.sipt.api.model.Experiencia[ id=" + id + " ]";
  }

}
