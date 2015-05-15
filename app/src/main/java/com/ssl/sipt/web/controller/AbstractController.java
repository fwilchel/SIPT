/*
 * Softstudio LTDA
 * Copyrigth .2015.
 */
package com.ssl.sipt.web.controller;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.MethodExpressionActionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: Diego Poveda.
 * @name:
 * @descripcion:
 * @version: 1.0
 * @since: JDK_1.7
 */
public abstract class AbstractController implements Serializable {

  private static final Logger LOG = LoggerFactory.getLogger(AbstractController.class);

  /**
   *
   * @return
   */
  protected FacesContext getFacesContextCurrentInstance() {
    LOG.debug("method: getFacesContextCurrentInstance()");
    return FacesContext.getCurrentInstance();
  }

  /**
   *
   * @param severity
   * @param summary
   * @param detail
   */
  private void addMessage(Severity severity, String summary, String detail) {
    LOG.debug("method: addMensaje()");
    FacesMessage mensaje = new FacesMessage(severity, summary, detail);
    getFacesContextCurrentInstance().addMessage(null, mensaje);
  }

  /**
   *
   * @param severity
   * @param summary
   * @param detail
   * @param clientId
   */
  private void addMessage(Severity severity, String summary, String detail, String clientId) {
    LOG.debug("method: addMensaje()");
    FacesMessage mensaje = new FacesMessage(severity, summary, detail);
    getFacesContextCurrentInstance().addMessage(null, mensaje);
  }

  /**
   *
   * @param summary
   * @param detail
   */
  public void addInfoMesage(String summary, String detail) {
    LOG.debug("method: addInfoMesage()");
    addMessage(FacesMessage.SEVERITY_INFO, summary, detail);
  }

  /**
   *
   * @param summary
   * @param detail
   * @param clientId
   */
  public void addInfoMesage(String summary, String detail, String clientId) {
    LOG.debug("method: addInfoMesage()");
    addMessage(FacesMessage.SEVERITY_INFO, summary, detail, clientId);
  }

  /**
   *
   * @param summary
   * @param detail
   */
  public void addErrorMessage(String summary, String detail) {
    LOG.debug("method: addErrorMessage()");
    addMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
  }

  /**
   *
   * @param summary
   * @param detail
   * @param clientId
   */
  public void addErrorMessage(String summary, String detail, String clientId) {
    LOG.debug("method: addErrorMessage()");
    addMessage(FacesMessage.SEVERITY_ERROR, summary, detail, clientId);
  }

  /**
   *
   * @param summary
   * @param detail
   */
  public void addFatalMessage(String summary, String detail) {
    LOG.debug("method: addFatalMessage()");
    addMessage(FacesMessage.SEVERITY_FATAL, summary, detail);
  }

  /**
   *
   * @param summary
   * @param detail
   * @param clientId
   */
  public void addFatalMessage(String summary, String detail, String clientId) {
    LOG.debug("method: addFatalMessage()");
    addMessage(FacesMessage.SEVERITY_FATAL, summary, detail, clientId);
  }

  /**
   *
   * @param summary
   * @param detail
   */
  public void addWarnMessage(String summary, String detail) {
    LOG.debug("method: addWarnMessage()");
    addMessage(FacesMessage.SEVERITY_WARN, summary, detail);
  }

  /**
   *
   * @param summary
   * @param detail
   * @param clientId
   */
  public void addWarnMessage(String summary, String detail, String clientId) {
    LOG.debug("method: addWarnMessage()");
    addMessage(FacesMessage.SEVERITY_WARN, summary, detail, clientId);
  }

  /**
   *
   * @param key
   * @return
   */
  public Object getValueFromSessionMap(String key) {
    LOG.debug("method: getValueFromSessionMap()");
    return getFacesContextCurrentInstance().getExternalContext().getSessionMap().get(key);
  }

  /**
   *
   * @param key
   * @param value
   */
  public void setValueIntoSessionMap(String key, Object value) {
    LOG.debug("method: setValueIntoSessionMap()");
    getFacesContextCurrentInstance().getExternalContext().getSessionMap().put(key, value);
  }

  /**
   *
   * @param key
   * @return
   */
  public Object removeValueFromSessionMap(String key) {
    LOG.debug("method: removeValueFromSessionMap()");
    return getFacesContextCurrentInstance().getExternalContext().getSessionMap().remove(key);
  }

  /**
   *
   * @param key
   * @return
   */
  public Object getValueFromRequestMap(String key) {
    LOG.debug("method: getValueFromRequestMap()");
    return getFacesContextCurrentInstance().getExternalContext().getRequestMap().get(key);
  }

  /**
   *
   * @param key
   * @param value
   */
  public void setValueIntoRequestMap(String key, Object value) {
    LOG.debug("method: setValueIntoRequestMap()");
    getFacesContextCurrentInstance().getExternalContext().getRequestMap().put(key, value);
  }

  /**
   *
   * @param key
   * @return
   */
  public Object getValueFromRequestParameterMap(String key) {
    LOG.debug("method: getValueFromRequestParameterMap()");
    return getFacesContextCurrentInstance().getExternalContext().getRequestParameterMap().get(key);
  }

  /**
   *
   * @param <T> Tipo de retorno
   * @param beanName nombre del ManagedBean a buscar
   * @return la instancia del ManagedBean buscado o null si esta no existe
   */
  public <T> T findManagedBean(String beanName) {
    LOG.debug("method: findManagedBean()");
    return (T) getFacesContextCurrentInstance().getApplication().evaluateExpressionGet(getFacesContextCurrentInstance(), "#{" + beanName + "}", Object.class);
  }

  /**
   * Encuentra un UIComponent por id dentro del ViewRoot
   *
   * @param id
   * @return
   */
  public static UIComponent findComponent(String id) {
    LOG.debug("method: findComponent()");
    return findComponent(FacesContext.getCurrentInstance().getViewRoot(), id);
  }

  /**
   * Encuentra un UIComponent por id dentro del UIComponet pasado por parametro
   *
   * @param component UICOmponet
   * @param id id del UIComponet buscado
   * @return
   */
  public static UIComponent findComponent(UIComponent component, String id) {
    LOG.debug("method: findComponent()");
    if (component == null) {
      return null;
    }
    LOG.debug("Component id: " + component.getId());
    List<UIComponent> items = component.getChildren();
    Iterator<UIComponent> facets = component.getFacetsAndChildren();
    if (items.size() > 0) {
      for (UIComponent item : items) {
        UIComponent found = findComponent(item, id);
        if (found != null) {
          return found;
        }
        if (item.getId().equalsIgnoreCase(id)) {
          return item;
        }
      }
    } else if (facets.hasNext()) {
      while (facets.hasNext()) {
        UIComponent facet = facets.next();
        UIComponent found = findComponent(facet, id);
        if (found != null) {
          return found;
        }
        if (facet.getId().equalsIgnoreCase(id)) {
          return facet;
        }
      }
    }
    return null;
  }

  /**
   *
   * @param valueExpression
   * @param expectedReturnType
   * @param expectedParamTypes
   * @return
   */
  public static MethodExpression createMethodExpression(String valueExpression, Class<?> expectedReturnType, Class<?>[] expectedParamTypes) {
    LOG.debug("method: createMethodExpression()");
    FacesContext fc = FacesContext.getCurrentInstance();
    ExpressionFactory factory = fc.getApplication().getExpressionFactory();
    return factory.createMethodExpression(fc.getELContext(), valueExpression, expectedReturnType, expectedParamTypes);
  }

  /**
   *
   * @param valueExpression
   * @param expectedReturnType
   * @param expectedParamTypes
   * @return
   */
  public static MethodExpressionActionListener createMethodActionListener(String valueExpression, Class<?> expectedReturnType, Class<?>[] expectedParamTypes) {
    LOG.debug("method: createMethodActionListener()");
    return new MethodExpressionActionListener(createMethodExpression(valueExpression, expectedReturnType, expectedParamTypes));
  }

  /**
   *
   * @param expression
   * @return
   */
  public Object getExpression(String expression) {
    LOG.debug("method: findComponent()");
    FacesContext ctx = getFacesContextCurrentInstance();
    ExpressionFactory factory = ctx.getApplication().getExpressionFactory();
    ValueExpression ex = factory.createValueExpression(ctx.getELContext(), "#{" + expression + "}", Object.class);
    return ex.getValue(ctx.getELContext());
  }

  /**
   * 
   * @param key
   * @return 
   */
  public String getPropertyFromBundle(String key) {
    Locale es = new Locale("ES");
    ResourceBundle bundle = ResourceBundle.getBundle("bundle", es);
    return bundle.getString(key);
  }

  /**
   * 
   * @param key
   * @param locale
   * @return 
   */
  public String getPropertyFromBundle(String key, String locale) {
    Locale es = new Locale(locale);
    ResourceBundle bundle = ResourceBundle.getBundle("bundle", es);
    return bundle.getString(key);
  }
}
