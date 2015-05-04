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
  @NamedQuery(name = "Dotacion.findAll", query = "SELECT d FROM Dotacion d")})
public class Dotacion implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(nullable = false)
  private Long id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 10)
  @Column(nullable = false, length = 10)
  private String tall;
  @Basic(optional = false)
  @NotNull
  @Column(nullable = false)
  private BigInteger cantidad;
  @Basic(optional = false)
  @NotNull
  @Column(name = "fecha_entrega", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fechaEntrega;
  @JoinColumn(name = "tipo_dotacion", referencedColumnName = "id", nullable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Item tipoDotacion;
  @JoinColumn(name = "empleado", referencedColumnName = "id", nullable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Empleado empleado;

  public Dotacion() {
  }

  public Dotacion(Long id) {
    this.id = id;
  }

  public Dotacion(Long id, String tall, BigInteger cantidad, Date fechaEntrega) {
    this.id = id;
    this.tall = tall;
    this.cantidad = cantidad;
    this.fechaEntrega = fechaEntrega;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTall() {
    return tall;
  }

  public void setTall(String tall) {
    this.tall = tall;
  }

  public BigInteger getCantidad() {
    return cantidad;
  }

  public void setCantidad(BigInteger cantidad) {
    this.cantidad = cantidad;
  }

  public Date getFechaEntrega() {
    return fechaEntrega;
  }

  public void setFechaEntrega(Date fechaEntrega) {
    this.fechaEntrega = fechaEntrega;
  }

  public Item getTipoDotacion() {
    return tipoDotacion;
  }

  public void setTipoDotacion(Item tipoDotacion) {
    this.tipoDotacion = tipoDotacion;
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
    if (!(object instanceof Dotacion)) {
      return false;
    }
    Dotacion other = (Dotacion) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.ssl.sipt.api.model.Dotacion[ id=" + id + " ]";
  }

}
