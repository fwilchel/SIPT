/*
 * Softstudio LTDA
 * Copyrigth .2015.
 */
package com.ssl.sipt.web.converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: Diego Poveda.
 * @name:
 * @descripcion:
 * @version: 1.0
 * @since: JDK_1.7
 */
public abstract class AbstractGSONConverter<T> implements Converter {

  /**
   *
   */
  private static final Logger LOG = LoggerFactory.getLogger(AbstractGSONConverter.class);

  /**
   *
   * @param context
   * @param component
   * @param value
   * @return
   * @throws ConverterException
   */
  @Override
  public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
    LOG.info("Entro a: <<getAsObject>> parametros / context ->> {} / component ->> {} / value ->> {}", context, component, value);
    if (value == null || value.isEmpty() || !value.startsWith("{")) {
      return null;
    }
    return (T) unmarshal(value);
  }

  /**
   *
   * @param context
   * @param component
   * @param value
   * @return
   * @throws ConverterException
   */
  @Override
  public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
    LOG.info("Entro a: <<getAsString>> parametros / context ->> {} / component ->> {} / value ->> {}", context, component, value);
    if (value == null) {
      return null;
    }
    return marshal(value);
  }

  /**
   *
   * @param json
   * @param clazz
   * @return
   */
  private Object unmarshal(String json) {
    LOG.info("Entro a: <<unmarshal>> parametros / json ->> {} / class ->> {}", json, getClazz());
    Gson gson = new GsonBuilder().create();
    if (json == null || json.isEmpty()) {
      return null;
    } else {
      Object o = gson.fromJson(json, getClazz());
      LOG.debug(o.toString());
      return o;
    }
  }

  /**
   *
   * @param instancia
   * @return
   */
  private String marshal(Object instancia) {
    LOG.info("Entro a: <<marshal>> parametros / instancia  ->> {}", instancia);
    Gson gson = new GsonBuilder().create();
    if (instancia == null) {
      return null;
    } else {
      String json = gson.toJson(instancia);
      LOG.debug(json);
      return json;
    }

  }

  /**
   *
   * @return
   */
  public abstract Class<T> getClazz();
}
