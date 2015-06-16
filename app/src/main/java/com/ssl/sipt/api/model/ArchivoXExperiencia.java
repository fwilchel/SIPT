/*
 * Softstudio LTDA
 * Copyrigth .2015.
 */
package com.ssl.sipt.api.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author: Diego Poveda.
 * @name:
 * @descripcion:
 * @version: 1.0
 * @since: JDK_1.7
 */
@Entity
@Table(name = "archivo_x_experiencia", catalog = "sipt", schema = "public")
public class ArchivoXExperiencia implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(nullable = false)
  private Long id;
  @JoinColumn(name = "archivo", referencedColumnName = "id", nullable = false)
  @ManyToOne(cascade = {CascadeType.ALL}, optional = false, fetch = FetchType.EAGER)
  private Archivo archivo;
  @JoinColumn(name = "experiencia", referencedColumnName = "id", nullable = false)
  @ManyToOne(cascade = {CascadeType.ALL}, optional = false, fetch = FetchType.EAGER)
  private Experiencia experiencia;

  public ArchivoXExperiencia() {
  }

  public ArchivoXExperiencia(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Archivo getArchivo() {
    return archivo;
  }

  public void setArchivo(Archivo archivo) {
    this.archivo = archivo;
  }

  public Experiencia getExperiencia() {
    return experiencia;
  }

  public void setExperiencia(Experiencia experiencia) {
    this.experiencia = experiencia;
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
    if (!(object instanceof ArchivoXExperiencia)) {
      return false;
    }
    ArchivoXExperiencia other = (ArchivoXExperiencia) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.mycompany.test.ArchivoXExperiencia[ id=" + id + " ]";
  }  
}