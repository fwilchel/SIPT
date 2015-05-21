package com.ssl.sipt.api.model;

import com.ssl.sipt.api.util.FileUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author d5a9p6s7
 */
@Entity
@Table(catalog = "sipt", schema = "public")
@NamedQueries({
  @NamedQuery(name = "Archivo.findAll", query = "SELECT a FROM Archivo a")})
public class Archivo implements Serializable {

  private static final long serialVersionUID = 1L;
  private static final Logger LOG = LoggerFactory.getLogger(Archivo.class);
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
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 10)
  @Column(nullable = false, length = 10)
  private String ext;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2147483647)
  @Column(name = "archivo_base64", nullable = false, length = 2147483647)
  private String archivoBase64;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "content_type", nullable = false, length = 50)
  private String contentType;
  @Size(max = 500)
  @Column(length = 500)
  private String url;
  @Size(max = 100)
  @Column(length = 100)
  private String titulo;
  @Size(max = 500)
  @Column(length = 500)
  private String descripcion;

  public Archivo() {
  }

  public Archivo(Long id) {
    this.id = id;
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

  public String getExt() {
    return ext;
  }

  public void setExt(String ext) {
    this.ext = ext;
  }

  public String getArchivoBase64() {
    return archivoBase64;
  }

  public void setArchivoBase64(String archivoBase64) {
    this.archivoBase64 = archivoBase64;
  }

  public String getContentType() {
    return contentType;
  }

  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  /**
   * @param documentPath the rutaDocumento to set
   */
  public void setDocumentPath(String documentPath) {
    this.setNombre(FilenameUtils.getBaseName(documentPath));
    this.setExt(FilenameUtils.getExtension(documentPath));
  }

  /**
   * nombre concatenado con la extension
   *
   * @return
   */
  public String getNameWhitExtension() {
    if (getNombre() != null && getExt() != null) {
      return getNombre().concat(".").concat(getExt());
    }
    return null;
  }

  /**
   *
   * @return @throws IOException
   */
  public InputStream getImputStream() throws IOException {
    if (getArchivoBase64() == null) {
      return null;
    } else {
      try {
        return FileUtil.base64ToInputStream(getArchivoBase64());
      } catch (IOException ex) {
        LOG.error("Error en <<getImputStream>> ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
        throw ex;
      }
    }
  }

  /**
   * @param inputStream the inputStream to set
   * @throws java.io.IOException
   */
  public void setInputStream(InputStream inputStream) throws IOException {
    if (inputStream != null) {
      try {
        setArchivoBase64(FileUtil.inputStreamToBase64(inputStream));
      } catch (IOException ex) {
        LOG.error("Error en <<setInputStream>> ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
        throw ex;
      }
    }
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
    if (!(object instanceof Archivo)) {
      return false;
    }
    Archivo other = (Archivo) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.ssl.sipt.api.model.Archivo[ id=" + id + " ]";
  }

}
