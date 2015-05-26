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
  EPS(5L, "title.eps"),
  ESTADO_CIVIL(6L, "title.estadovivil"),
  FONDO_CESANTIAS(7L, "title.fondocesantias"),
  FONDO_PENSIONES(8L, "title.fondopensiones"),
  GENERO(9L, "title.genero"),
  MACROPROYECTO(10L, "title.macroproyecto"),
  PARENTESCO(11L, "title.parentesco"),
  RH(12L, "title.rh"),
  SI_NO(13L, "title.sino"),
  TIPO_CONTRATO(14L, "title.tipocontrato"),
  TIPO_CUENTA(15L, "title.tipocuenta"),
  TIPO_DOTACION(16L, "title.tipodotacion"),
  TIPO_EMPRESA(17L, "title.tipoempresa"),
  TIPO_FORMACION(18L, "title.tipoformacion"),
  TIPO_IDENTIFICACION(19L, "title.tipoidentificacion"),
  TIPO_SOPORTE(20L, "title.tiposoporte");

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
