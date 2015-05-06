/*
 * Softstudio LTDA
 * Copyrigth .2015.
 */
package com.ssl.sipt.web.controller;

import com.ssl.sipt.api.model.Departamento;
import com.ssl.sipt.api.service.DepartamentoServiceInterface;
import com.ssl.sipt.api.service.exception.ServiceException;
import javax.ejb.EJB;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
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
@RequestScoped
public class ComunController {

  private static final Logger LOG = LoggerFactory.getLogger(ComunController.class);
  @EJB
  private DepartamentoServiceInterface departamentoService;

  public List<Departamento> getListDepartamentos() {
    LOG.trace("method: getListDepartamentos()");
    try {
      return departamentoService.findAll();
    } catch (ServiceException ex) {
      LOG.error("Error in method: getListDepartamentos()", ex);
      return null;
    }
  }
}
