/*
 * Softstudio LTDA
 * Copyrigth .2015.
 */
package com.ssl.sipt.web.converter;

import com.ssl.sipt.api.model.Item;
import javax.faces.convert.FacesConverter;

/**
 * @author: Diego Poveda.
 * @name:
 * @descripcion:
 * @version: 1.0
 * @since: JDK_1.7
 */
@FacesConverter("itemConverter")
public class ItemConverter extends AbstractGSONConverter {

  @Override
  public Class getClazz() {
    return Item.class;
  }
}
