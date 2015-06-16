/*
 * Softstudio LTDA
 * Copyrigth .2015.
 */
package com.ssl.sipt.api.model;

import java.io.Serializable;
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
 * @author: Diego Poveda.
 * @name:
 * @descripcion:
 * @version: 1.0
 * @since: JDK_1.7
 */
@Entity
@Table(catalog = "sipt", schema = "public")
@NamedQueries({
  @NamedQuery(name = Contacto.FIND_ALL, query = "SELECT c FROM Contacto c"),
  @NamedQuery(name = Contacto.FIND_BY_EMPLEADO, query = "SELECT c FROM Contacto c WHERE c.empleado.id = :idEmpleado")
})
public class Contacto implements Serializable {

  private static final long serialVersionUID = 1L;
  public static final String FIND_ALL = "Contacto.findAll";
  public static final String FIND_BY_EMPLEADO = "Contacto.findByEmpleado";
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(nullable = false)
  private Long id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(nullable = false, length = 50)
  private String numero;
  @Basic(optional = false)
  @NotNull
  @Column(nullable = false)
  private long municipio;
  @JoinColumn(name = "tipo_contacto", referencedColumnName = "id", nullable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Item tipoContacto;
  @JoinColumn(name = "empleado", referencedColumnName = "id", nullable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Empleado empleado;

  public Contacto() {
  }

  public Contacto(Long id) {
    this.id = id;
  }

  public Contacto(Long id, String numero, long municipio) {
    this.id = id;
    this.numero = numero;
    this.municipio = municipio;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public long getMunicipio() {
    return municipio;
  }

  public void setMunicipio(long municipio) {
    this.municipio = municipio;
  }

  public Item getTipoContacto() {
    return tipoContacto;
  }

  public void setTipoContacto(Item tipoContacto) {
    this.tipoContacto = tipoContacto;
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
    if (!(object instanceof Contacto)) {
      return false;
    }
    Contacto other = (Contacto) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.ssl.sipt.api.model.Contacto[ id=" + id + " ]";
  }

}
