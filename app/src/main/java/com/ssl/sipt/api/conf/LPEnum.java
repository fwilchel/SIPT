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

  ARL(1L, "title.arl"),
  BANCO(2L, "title.banco"),
  CAJA_COMPENSACION(3L, "title.cajacompensacion"),
  CARGO(4L, "title.cargo"),
  CENTRO_MEDICO(5L, "title.centromedico"),
  CENTRO_TRABAJO(6L, "title.centrotrabajo"),
  DEPARTAMENTO(7L, "title.departamento"),
  EPS(8L, "title.eps"),
  ESTADO_CIVIL(9L, "title.estadovivil"),
  FONDO_CESANTIAS(10L, "title.fondocesantias"),
  FONDO_PENSIONES(11L, "title.fondopensiones"),
  GENERO(12L, "title.genero"),
  MACROPROYECTO(13L, "title.macroproyecto"),
  MUNICIPIO(14L, "title.municipio"),
  PARENTESCO(15L, "title.parentesco"),
  RH(16L, "title.rh"),
  SI_NO(17L, "title.sino"),
  TIPO_CONTRATO(18L, "title.tipocontrato"),
  TIPO_CUENTA(19L, "title.tipocuenta"),
  TIPO_DOTACION(20L, "title.tipodotacion"),
  TIPO_EMPRESA(21L, "title.tipoempresa"),
  TIPO_FORMACION(22L, "title.tipoformacion"),
  TIPO_IDENTIFICACION(23L, "title.tipoidentificacion"),
  TIPO_SOPORTE(24L, "title.tiposoporte");

  private final Long id;
  private final String key;

  private LPEnum(Long id, String nombre) {
    this.id = id;
    this.key = nombre;
  }

  /**
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * @return the key
   */
  public String getKey() {
    return key;
  }

  /**
   * 
   * @param id
   * @return 
   */
  public static LPEnum findById(Long id) {
    for (LPEnum c : LPEnum.values()) {
      if (c.getId().equals(id)) {
        return c;
      }
    }
    return null;
  }
}
