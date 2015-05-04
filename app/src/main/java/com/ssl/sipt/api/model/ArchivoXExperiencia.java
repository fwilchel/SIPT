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

/**
 *
 * @author d5a9p6s7
 */
@Entity
@Table(name = "archivo_x_experiencia", catalog = "sipt", schema = "public")
@NamedQueries({
  @NamedQuery(name = "ArchivoXExperiencia.findAll", query = "SELECT a FROM ArchivoXExperiencia a")})
public class ArchivoXExperiencia implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(nullable = false)
  private Long id;
  @JoinColumn(name = "archivo", referencedColumnName = "id", nullable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Experiencia archivo;
  @JoinColumn(name = "experiencia", referencedColumnName = "id", nullable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Archivo experiencia;

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

  public Experiencia getArchivo() {
    return archivo;
  }

  public void setArchivo(Experiencia archivo) {
    this.archivo = archivo;
  }

  public Archivo getExperiencia() {
    return experiencia;
  }

  public void setExperiencia(Archivo experiencia) {
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
    return "com.ssl.sipt.api.model.ArchivoXExperiencia[ id=" + id + " ]";
  }

}
