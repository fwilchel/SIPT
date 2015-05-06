/*
 * Softstudio LTDA
 * Copyrigth .2015.
 */
package com.ssl.sipt.api.conf;

/**
 * @author: Diego Poveda.
 * @name:
 * @descripcion:
 * @version: 1.0
 * @since: JDK_1.7
 */
public enum LPEnum {

  ARL(1L, "ARL's", ""),
  BANCO(1L, "Bancos", ""),
  CAJA_COMPENSACION(1L, "Cajas de compensación", ""),
  CARGO(1L, "Cargos", ""),
  CENTRO_MEDICO(1L, "Centros médicos", ""),
  CENTRO_TRABAJO(1L, "Centros de trabajo", ""),
  DEPARTAMENTO(1L, "Departamentos", ""),
  EPS(1L, "EPS's", ""),
  ESTADO_CIVIL(1L, "Estados civiles", ""),
  FONDO_CESANTIAS(1L, "Fondos de cesantias", ""),
  FONDO_PENSIONES(1L, "Fondos de pensiones", ""),
  GENERO(1L, "Géneros", ""),
  MACROPROYECTO(1L, "Macroproyectos", ""),
  MUNICIPIO(1L, "Municipios", ""),
  PARENTESCO(1L, "Parentescos", ""),
  RH(1L, "RH's", ""),
  SI_NO(1L, "SI/NO", ""),
  TIPO_CONTRATO(1L, "Tipos de contratos", ""),
  TIPO_CUENTA(1L, "Tipos de cuentas", ""),
  TIPO_DOTACION(1L, "Tipos de dotaciones", ""),
  TIPO_EMPRESA(1L, "Tipos de empresas", ""),
  TIPO_FORMACION(1L, "Tipos de formaciones", ""),
  TIPO_IDENTIFICACION(1L, "Tipos de identificación", ""),
  TIPO_SOPORTE(1L, "Tipos de soporte", "");

  private Long id;
  private String nombre;
  private String descripcion;

  private LPEnum(Long id, String nombre, String descripcion) {
    this.id = id;
    this.nombre = nombre;
    this.descripcion = descripcion;
  }

  /**
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * @return the nombre
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * @param nombre the nombre to set
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * @return the descripcion
   */
  public String getDescripcion() {
    return descripcion;
  }

  /**
   * @param descripcion the descripcion to set
   */
  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

}
