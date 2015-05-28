/*
 * Softstudio LTDA
 * Copyrigth .2015.
 */
package com.ssl.sipt.web.controller;

import com.ssl.sipt.api.model.CentroMedico;
import com.ssl.sipt.api.model.Departamento;
import com.ssl.sipt.api.model.Municipio;
import com.ssl.sipt.api.service.CentroMedicoServiceInterface;
import com.ssl.sipt.api.service.exception.ServiceException;
import com.ssl.sipt.web.util.NavEnum;
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
public class CentroMedicoController extends AbstractController {

  private static final Logger LOG = LoggerFactory.getLogger(CentroMedicoController.class);

  @EJB
  private CentroMedicoServiceInterface service;
  private CentroMedico selected;
  private List<CentroMedico> list;
  private boolean editable;
  private NavEnum optionNavEnum;

  public CentroMedicoController() {
    LOG.trace("method: constructor()");
  }

  @PostConstruct
  public void initialize() {
    LOG.trace("method: initialize()");
    optionNavEnum = NavEnum.LIST;
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
    optionNavEnum = NavEnum.DETAILS;
    setSelected(new CentroMedico());
    getSelected().setMunicipio(new Municipio());
    getSelected().getMunicipio().setDepartamento(new Departamento());
    initializeEdit();
  }

  /**
   *
   * @param event
   */
  public void onRowSelect(SelectEvent event) {
    LOG.trace("method: onRowSelect()");
    setSelected((CentroMedico) event.getObject());
    setEditable(false);
    optionNavEnum = NavEnum.DETAILS;
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
      addErrorMessage(getPropertyFromBundle("commons.msg.error.save.summary"), getPropertyFromBundle("commons.msg.error.save.detail"));
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
      optionNavEnum = NavEnum.LIST;
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
    boolean showList = (optionNavEnum == NavEnum.LIST);
    return showList;
  }

  /**
   *
   * @return
   */
  public boolean isShowDetails() {
    boolean showDetails = (optionNavEnum == NavEnum.DETAILS);
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
  public CentroMedico getSelected() {
    return selected;
  }

  /**
   * @param selected the selected to set
   */
  public void setSelected(CentroMedico selected) {
    this.selected = selected;
  }

  /**
   * @return the list
   */
  public List<CentroMedico> getList() {
    return list;
  }

  /**
   * @param list the list to set
   */
  public void setList(List<CentroMedico> list) {
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
