/*
 * Softstudio LTDA
 * Copyrigth .2015.
 */
package com.ssl.sipt.web.controller;

import com.ssl.sipt.api.model.CentroTrabajo;
import com.ssl.sipt.api.service.CentroTrabajoServiceInterface;
import com.ssl.sipt.api.service.exception.ServiceException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: Diego Poveda.
 * @name:
 * @descripcion:
 * @version: 1.0
 * @since: JDK_1.7
 */
@Named
@ViewScoped
public class CentroTrabajoController extends AbstractController {

  private static final Logger LOG = LoggerFactory.getLogger(CentroTrabajoController.class);

  private enum OptionNavEnum {

    LIST, DETAILS
  }
  @EJB
  private CentroTrabajoServiceInterface service;
  private CentroTrabajo selected;
  private List<CentroTrabajo> list;
  private boolean editable;
  private OptionNavEnum optionNavEnum;

  public CentroTrabajoController() {
    LOG.trace("method: constructor()");
  }

  @PostConstruct
  public void initialize() {
    LOG.trace("method: initialize()");
    optionNavEnum = OptionNavEnum.LIST;
    setSelected(null);
    setEditable(false);
    setSelected(null);
    loadList();
  }

  /**
   *
   */
  public void loadList() {
    LOG.trace("method: loadList()");
    try {
      setList(service.findAll());
    } catch (ServiceException ex) {
      LOG.error("Error in method: loadList()", ex);
    }
  }

  /**
   *
   */
  private void initializeEdit() {
    LOG.trace("method: initializeEdit()");
    setEditable(true);
  }

  /**
   *
   */
  public void onCreate() {
    LOG.trace("method: onCreate()");
    optionNavEnum = OptionNavEnum.DETAILS;
    setSelected(new CentroTrabajo());
    initializeEdit();
  }

  /**
   *
   * @param event
   */
  public void onRowSelect(SelectEvent event) {
    LOG.trace("method: onRowSelect()");
    setSelected((CentroTrabajo) event.getObject());
    setEditable(false);
    optionNavEnum = OptionNavEnum.DETAILS;
  }

  /**
   *
   */
  public void onEdit() {
    LOG.trace("method: onEdit()");
    initializeEdit();
  }

  /**
   *
   */
  public void onDelete() {
    LOG.trace("method: onDelete()");
    try {
      service.delete(getSelected());
      initialize();
    } catch (ServiceException ex) {
      LOG.error("Error in method: onDelete()", ex);
    }
  }

  /**
   *
   */
  public void onSave() {
    LOG.trace("method: onSave()");
    try {
      if (getSelected().getId() == null) {
        service.create(getSelected());
      } else {
        service.update(getSelected());
      }
      setEditable(false);
    } catch (ServiceException ex) {
      LOG.error("Error en <<onSave>> ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
    }
  }

  /**
   *
   */
  public void onCancel() {
    LOG.trace("method: onCancel()");
    if (getSelected() != null && getSelected().getId() != null) {
      setEditable(false);
    } else {
      optionNavEnum = OptionNavEnum.LIST;
    }
  }

  /**
   *
   */
  public void onBack() {
    LOG.trace("method: onBack()");
    initialize();
  }

  /**
   *
   * @return
   */
  public boolean isShowList() {
    boolean showList = (optionNavEnum == OptionNavEnum.LIST);
    return showList;
  }

  /**
   *
   * @return
   */
  public boolean isShowDetails() {
    boolean showDetails = (optionNavEnum == OptionNavEnum.DETAILS);
    return showDetails;
  }

  /**
   *
   * @return
   */
  public boolean isNewRecord() {
    boolean newRecord = (getSelected() != null && getSelected().getId() == null);
    return newRecord;
  }

  /**
   * @return the selected
   */
  public CentroTrabajo getSelected() {
    return selected;
  }

  /**
   * @param selected the selected to set
   */
  public void setSelected(CentroTrabajo selected) {
    this.selected = selected;
  }

  /**
   * @return the list
   */
  public List<CentroTrabajo> getList() {
    return list;
  }

  /**
   * @param list the list to set
   */
  public void setList(List<CentroTrabajo> list) {
    this.list = list;
  }

  /**
   * @return the editable
   */
  public boolean isEditable() {
    return editable;
  }

  /**
   * @param editable the editable to set
   */
  public void setEditable(boolean editable) {
    this.editable = editable;
  }
}