/*
 * Softstudio LTDA
 * Copyrigth .2015.
 */
package com.ssl.sipt.web.converter;

import com.ssl.sipt.api.model.CentroTrabajo;
import javax.faces.convert.FacesConverter;

/**
 * @author: Diego Poveda.
 * @name:
 * @descripcion:
 * @version: 1.0
 * @since: JDK_1.7
 */
@FacesConverter("centroTrabajoConverter")
public class CentroTrabajoConverter extends AbstractGSONConverter {

  @Override
  public Class getClazz() {
    return CentroTrabajo.class;
  }
}
