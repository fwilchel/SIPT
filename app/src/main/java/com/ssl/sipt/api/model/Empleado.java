/*
 * Softstudio LTDA
 * Copyrigth .2015.
 */
package com.ssl.sipt.api.model;

import java.io.Serializable;
import java.math.BigInteger;
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
  @NamedQuery(name = Empleado.FIND_ALL, query = "SELECT e FROM Empleado e"),
  @NamedQuery(name = Empleado.FIND_BY_ID, query = "SELECT e FROM Empleado e WHERE e.id = :id")
})
public class Empleado implements Serializable {

  private static final long serialVersionUID = 1L;
  public static final String FIND_ALL = "Empleado.findAll";
  public static final String FIND_BY_ID = "Empleado.findById";
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  private Long id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 25)
  private String identificacion;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  private String nombres;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  private String apellidos;
  @Basic(optional = false)
  @NotNull
  private boolean estado;
  // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
  @Size(max = 100)
  private String email;
  private BigInteger sueldo;
  @Column(name = "fecha_inicio")
  @Temporal(TemporalType.DATE)
  private Date fechaInicio;
  @Column(name = "fecha_fin")
  @Temporal(TemporalType.DATE)
  private Date fechaFin;
  @Size(max = 100)
  private String lugar;
  @Size(max = 2147483647)
  private String direccion;
  @Column(name = "arl_fecha_afiliacion")
  @Temporal(TemporalType.DATE)
  private Date arlFechaAfiliacion;
  @Column(name = "caja_compensacion_fecha_afiliacion")
  @Temporal(TemporalType.DATE)
  private Date cajaCompensacionFechaAfiliacion;
  @Column(name = "eps_fecha_afiliacion")
  @Temporal(TemporalType.DATE)
  private Date epsFechaAfiliacion;
  @Column(name = "pension_fecha_afiliacion")
  @Temporal(TemporalType.DATE)
  private Date pensionFechaAfiliacion;
  @Column(name = "cesantias_fecha_afiliacion")
  @Temporal(TemporalType.DATE)
  private Date cesantiasFechaAfiliacion;
  @Size(max = 20)
  @Column(name = "numero_cuenta")
  private String numeroCuenta;
  @Column(name = "centro_medico_fecha_examen_ingreso")
  @Temporal(TemporalType.DATE)
  private Date centroMedicoFechaExamenIngreso;
  @Column(name = "centro_medico_fecha_examen_egreso")
  @Temporal(TemporalType.DATE)
  private Date centroMedicoFechaExamenEgreso;
  @Size(max = 2147483647)
  @Column(name = "fecha_etapa_electiva_inicio")
  private String fechaEtapaElectivaInicio;
  @Column(name = "fecha_etapa_electiva_fin")
  @Temporal(TemporalType.DATE)
  private Date fechaEtapaElectivaFin;
  @Column(name = "fecha_etapa_productiva_inicio")
  @Temporal(TemporalType.DATE)
  private Date fechaEtapaProductivaInicio;
  @Column(name = "fecha_etapa_productiva_fin")
  @Temporal(TemporalType.DATE)
  private Date fechaEtapaProductivaFin;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.LAZY)
  private List<Cesantias> cesantiasList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.LAZY)
  private List<Contacto> contactoList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.LAZY)
  private List<Contrato> contratoList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.LAZY)
  private List<Beneficiario> beneficiarioList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.LAZY)
  private List<Formacion> formacionList;
  @JoinColumn(name = "curriculum", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Archivo curriculum;
  @JoinColumn(name = "imagen", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Archivo imagen;
  @JoinColumn(name = "centro_medico", referencedColumnName = "id")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private CentroMedico centroMedico;
  @JoinColumn(name = "eps", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Item eps;
  @JoinColumn(name = "centro_trabajo", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private CentroTrabajo centroTrabajo;
  @JoinColumn(name = "tipo_cuenta", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Item tipoCuenta;
  @JoinColumn(name = "municipio", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Municipio municipio;
  @JoinColumn(name = "identificacion_tipo", referencedColumnName = "id")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Item identificacionTipo;
  @JoinColumn(name = "tipo_contrato", referencedColumnName = "id")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Item tipoContrato;
  @JoinColumn(name = "rh", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Item rh;
  @JoinColumn(name = "pension", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Item pension;
  @JoinColumn(name = "estado_civil", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Item estadoCivil;
  @JoinColumn(name = "banco", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Item banco;
  @JoinColumn(name = "cesantias", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Item cesantias;
  @JoinColumn(name = "identificacion_lugar_expedicion", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Municipio identificacionLugarExpedicion;
  @JoinColumn(name = "genero", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Item genero;
  @JoinColumn(name = "cargo", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Item cargo;
  @JoinColumn(name = "macro_proyecto", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Item macroProyecto;
  @JoinColumn(name = "arl", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Item arl;
  @JoinColumn(name = "caja_compensacion", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Item cajaCompensacion;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.LAZY)
  private List<Experiencia> experienciaList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.LAZY)
  private List<Dotacion> dotacionList;

  public Empleado() {
  }

  public Empleado(Long id) {
    this.id = id;
  }

  public Empleado(Long id, String identificacion, String nombres, String apellidos, boolean estado) {
    this.id = id;
    this.identificacion = identificacion;
    this.nombres = nombres;
    this.apellidos = apellidos;
    this.estado = estado;
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

  public boolean getEstado() {
    return estado;
  }

  public void setEstado(boolean estado) {
    this.estado = estado;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public BigInteger getSueldo() {
    return sueldo;
  }

  public void setSueldo(BigInteger sueldo) {
    this.sueldo = sueldo;
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

  public String getLugar() {
    return lugar;
  }

  public void setLugar(String lugar) {
    this.lugar = lugar;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public Date getArlFechaAfiliacion() {
    return arlFechaAfiliacion;
  }

  public void setArlFechaAfiliacion(Date arlFechaAfiliacion) {
    this.arlFechaAfiliacion = arlFechaAfiliacion;
  }

  public Date getCajaCompensacionFechaAfiliacion() {
    return cajaCompensacionFechaAfiliacion;
  }

  public void setCajaCompensacionFechaAfiliacion(Date cajaCompensacionFechaAfiliacion) {
    this.cajaCompensacionFechaAfiliacion = cajaCompensacionFechaAfiliacion;
  }

  public Date getEpsFechaAfiliacion() {
    return epsFechaAfiliacion;
  }

  public void setEpsFechaAfiliacion(Date epsFechaAfiliacion) {
    this.epsFechaAfiliacion = epsFechaAfiliacion;
  }

  public Date getPensionFechaAfiliacion() {
    return pensionFechaAfiliacion;
  }

  public void setPensionFechaAfiliacion(Date pensionFechaAfiliacion) {
    this.pensionFechaAfiliacion = pensionFechaAfiliacion;
  }

  public Date getCesantiasFechaAfiliacion() {
    return cesantiasFechaAfiliacion;
  }

  public void setCesantiasFechaAfiliacion(Date cesantiasFechaAfiliacion) {
    this.cesantiasFechaAfiliacion = cesantiasFechaAfiliacion;
  }

  public String getNumeroCuenta() {
    return numeroCuenta;
  }

  public void setNumeroCuenta(String numeroCuenta) {
    this.numeroCuenta = numeroCuenta;
  }

  public Date getCentroMedicoFechaExamenIngreso() {
    return centroMedicoFechaExamenIngreso;
  }

  public void setCentroMedicoFechaExamenIngreso(Date centroMedicoFechaExamenIngreso) {
    this.centroMedicoFechaExamenIngreso = centroMedicoFechaExamenIngreso;
  }

  public Date getCentroMedicoFechaExamenEgreso() {
    return centroMedicoFechaExamenEgreso;
  }

  public void setCentroMedicoFechaExamenEgreso(Date centroMedicoFechaExamenEgreso) {
    this.centroMedicoFechaExamenEgreso = centroMedicoFechaExamenEgreso;
  }

  public String getFechaEtapaElectivaInicio() {
    return fechaEtapaElectivaInicio;
  }

  public void setFechaEtapaElectivaInicio(String fechaEtapaElectivaInicio) {
    this.fechaEtapaElectivaInicio = fechaEtapaElectivaInicio;
  }

  public Date getFechaEtapaElectivaFin() {
    return fechaEtapaElectivaFin;
  }

  public void setFechaEtapaElectivaFin(Date fechaEtapaElectivaFin) {
    this.fechaEtapaElectivaFin = fechaEtapaElectivaFin;
  }

  public Date getFechaEtapaProductivaInicio() {
    return fechaEtapaProductivaInicio;
  }

  public void setFechaEtapaProductivaInicio(Date fechaEtapaProductivaInicio) {
    this.fechaEtapaProductivaInicio = fechaEtapaProductivaInicio;
  }

  public Date getFechaEtapaProductivaFin() {
    return fechaEtapaProductivaFin;
  }

  public void setFechaEtapaProductivaFin(Date fechaEtapaProductivaFin) {
    this.fechaEtapaProductivaFin = fechaEtapaProductivaFin;
  }

  public List<Cesantias> getCesantiasList() {
    return cesantiasList;
  }

  public void setCesantiasList(List<Cesantias> cesantiasList) {
    this.cesantiasList = cesantiasList;
  }

  public List<Contacto> getContactoList() {
    return contactoList;
  }

  public void setContactoList(List<Contacto> contactoList) {
    this.contactoList = contactoList;
  }

  public List<Contrato> getContratoList() {
    return contratoList;
  }

  public void setContratoList(List<Contrato> contratoList) {
    this.contratoList = contratoList;
  }

  public List<Beneficiario> getBeneficiarioList() {
    return beneficiarioList;
  }

  public void setBeneficiarioList(List<Beneficiario> beneficiarioList) {
    this.beneficiarioList = beneficiarioList;
  }

  public List<Formacion> getFormacionList() {
    return formacionList;
  }

  public void setFormacionList(List<Formacion> formacionList) {
    this.formacionList = formacionList;
  }

  public Archivo getCurriculum() {
    return curriculum;
  }

  public void setCurriculum(Archivo curriculum) {
    this.curriculum = curriculum;
  }

  public Archivo getImagen() {
    return imagen;
  }

  public void setImagen(Archivo imagen) {
    this.imagen = imagen;
  }

  public CentroMedico getCentroMedico() {
    return centroMedico;
  }

  public void setCentroMedico(CentroMedico centroMedico) {
    this.centroMedico = centroMedico;
  }

  public Item getEps() {
    return eps;
  }

  public void setEps(Item eps) {
    this.eps = eps;
  }

  public CentroTrabajo getCentroTrabajo() {
    return centroTrabajo;
  }

  public void setCentroTrabajo(CentroTrabajo centroTrabajo) {
    this.centroTrabajo = centroTrabajo;
  }

  public Item getTipoCuenta() {
    return tipoCuenta;
  }

  public void setTipoCuenta(Item tipoCuenta) {
    this.tipoCuenta = tipoCuenta;
  }

  public Municipio getMunicipio() {
    return municipio;
  }

  public void setMunicipio(Municipio municipio) {
    this.municipio = municipio;
  }

  public Item getIdentificacionTipo() {
    return identificacionTipo;
  }

  public void setIdentificacionTipo(Item identificacionTipo) {
    this.identificacionTipo = identificacionTipo;
  }

  public Item getTipoContrato() {
    return tipoContrato;
  }

  public void setTipoContrato(Item tipoContrato) {
    this.tipoContrato = tipoContrato;
  }

  public Item getRh() {
    return rh;
  }

  public void setRh(Item rh) {
    this.rh = rh;
  }

  public Item getPension() {
    return pension;
  }

  public void setPension(Item pension) {
    this.pension = pension;
  }

  public Item getEstadoCivil() {
    return estadoCivil;
  }

  public void setEstadoCivil(Item estadoCivil) {
    this.estadoCivil = estadoCivil;
  }

  public Item getBanco() {
    return banco;
  }

  public void setBanco(Item banco) {
    this.banco = banco;
  }

  public Item getCesantias() {
    return cesantias;
  }

  public void setCesantias(Item cesantias) {
    this.cesantias = cesantias;
  }

  public Municipio getIdentificacionLugarExpedicion() {
    return identificacionLugarExpedicion;
  }

  public void setIdentificacionLugarExpedicion(Municipio identificacionLugarExpedicion) {
    this.identificacionLugarExpedicion = identificacionLugarExpedicion;
  }

  public Item getGenero() {
    return genero;
  }

  public void setGenero(Item genero) {
    this.genero = genero;
  }

  public Item getCargo() {
    return cargo;
  }

  public void setCargo(Item cargo) {
    this.cargo = cargo;
  }

  public Item getMacroProyecto() {
    return macroProyecto;
  }

  public void setMacroProyecto(Item macroProyecto) {
    this.macroProyecto = macroProyecto;
  }

  public Item getArl() {
    return arl;
  }

  public void setArl(Item arl) {
    this.arl = arl;
  }

  public Item getCajaCompensacion() {
    return cajaCompensacion;
  }

  public void setCajaCompensacion(Item cajaCompensacion) {
    this.cajaCompensacion = cajaCompensacion;
  }

  public List<Experiencia> getExperienciaList() {
    return experienciaList;
  }

  public void setExperienciaList(List<Experiencia> experienciaList) {
    this.experienciaList = experienciaList;
  }

  public List<Dotacion> getDotacionList() {
    return dotacionList;
  }

  public void setDotacionList(List<Dotacion> dotacionList) {
    this.dotacionList = dotacionList;
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
    if (!(object instanceof Empleado)) {
      return false;
    }
    Empleado other = (Empleado) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.mycompany.test.Empleado[ id=" + id + " ]";
  }

}
