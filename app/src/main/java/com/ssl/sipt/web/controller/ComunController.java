/*
 * Softstudio LTDA
 * Copyrigth .2015.
 */
package com.ssl.sipt.web.controller;

import com.ssl.sipt.api.conf.LPEnum;
import com.ssl.sipt.api.model.Departamento;
import com.ssl.sipt.api.model.Item;
import com.ssl.sipt.api.model.Municipio;
import com.ssl.sipt.api.service.DepartamentoServiceInterface;
import com.ssl.sipt.api.service.LPServiceInterface;
import com.ssl.sipt.api.service.MunicipioServiceInterface;
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
  @EJB
  private MunicipioServiceInterface municipioService;
  @EJB
  private LPServiceInterface lpService;

  public List<Departamento> obtenerDepartamentos() {
    LOG.trace("method: obtenerDepartamentos()");
    try {
      return departamentoService.findAll();
    } catch (ServiceException ex) {
      LOG.error("Error in method: obtenerDepartamentos()", ex);
      return null;
    }
  }

  public List<Municipio> obtenerMunicipios(Long idDepartamento) {
    LOG.trace("method: obtenerDepartamentos()");
    if (idDepartamento == null) {
      return null;
    }
    try {
      return municipioService.findByDepartamento(idDepartamento);
    } catch (ServiceException ex) {
      LOG.error("Error in method: obtenerDepartamentos()", ex);
      return null;
    }
  }

  public List<Item> obtenerARLs() {
    LOG.trace("method: obtenerARLs()");
    try {
      return lpService.findByParent(LPEnum.ARL.getId());
    } catch (ServiceException ex) {
      LOG.error("Error in method: obtenerARLs()", ex);
      return null;
    }
  }

  public List<Item> obtenerBancos() {
    LOG.trace("method: obtenerBancos()");
    try {
      return lpService.findByParent(LPEnum.BANCO.getId());
    } catch (ServiceException ex) {
      LOG.error("Error in method: obtenerBancos()", ex);
      return null;
    }
  }

  public List<Item> obtenerCajasCompensacion() {
    LOG.trace("method: obtenerCajasCompensacion()");
    try {
      return lpService.findByParent(LPEnum.CAJA_COMPENSACION.getId());
    } catch (ServiceException ex) {
      LOG.error("Error in method: obtenerCajasCompensacion()", ex);
      return null;
    }
  }

  public List<Item> obtenerCargos() {
    LOG.trace("method: obtenerCargos()");
    try {
      return lpService.findByParent(LPEnum.CARGO.getId());
    } catch (ServiceException ex) {
      LOG.error("Error in method: obtenerCargos()", ex);
      return null;
    }
  }

  public List<Item> obtenerEPSs() {
    LOG.trace("method: obtenerEPSs()");
    try {
      return lpService.findByParent(LPEnum.EPS.getId());
    } catch (ServiceException ex) {
      LOG.error("Error in method: obtenerEPSs()", ex);
      return null;
    }
  }

  public List<Item> obtenerEstadosCiviles() {
    LOG.trace("method: obtenerEstadosCiviles()");
    try {
      return lpService.findByParent(LPEnum.ESTADO_CIVIL.getId());
    } catch (ServiceException ex) {
      LOG.error("Error in method: obtenerEstadosCiviles()", ex);
      return null;
    }
  }

  public List<Item> obtenerFondosCesantias() {
    LOG.trace("method: obtenerFondosCesantias()");
    try {
      return lpService.findByParent(LPEnum.FONDO_CESANTIAS.getId());
    } catch (ServiceException ex) {
      LOG.error("Error in method: obtenerFondosCesantias()", ex);
      return null;
    }
  }

  public List<Item> obtenerFondosPensiones() {
    LOG.trace("method: obtenerFondosPensiones()");
    try {
      return lpService.findByParent(LPEnum.FONDO_PENSIONES.getId());
    } catch (ServiceException ex) {
      LOG.error("Error in method: obtenerFondosPensiones()", ex);
      return null;
    }
  }

  public List<Item> obtenerGeneros() {
    LOG.trace("method: obtenerGeneros()");
    try {
      return lpService.findByParent(LPEnum.GENERO.getId());
    } catch (ServiceException ex) {
      LOG.error("Error in method: obtenerGeneros()", ex);
      return null;
    }
  }

  public List<Item> obtenerMacroproyectos() {
    LOG.trace("method: obtenerMacroproyectos()");
    try {
      return lpService.findByParent(LPEnum.MACROPROYECTO.getId());
    } catch (ServiceException ex) {
      LOG.error("Error in method: obtenerMacroproyectos()", ex);
      return null;
    }
  }

  public List<Item> obtenerParentescos() {
    LOG.trace("method: obtenerParentescos()");
    try {
      return lpService.findByParent(LPEnum.PARENTESCO.getId());
    } catch (ServiceException ex) {
      LOG.error("Error in method: obtenerParentescos()", ex);
      return null;
    }
  }

  public List<Item> obtenerRHs() {
    LOG.trace("method: obtenerRHs()");
    try {
      return lpService.findByParent(LPEnum.RH.getId());
    } catch (ServiceException ex) {
      LOG.error("Error in method: obtenerRHs()", ex);
      return null;
    }
  }

  public List<Item> obtenerSINO() {
    LOG.trace("method: obtenerSINO()");
    try {
      return lpService.findByParent(LPEnum.SI_NO.getId());
    } catch (ServiceException ex) {
      LOG.error("Error in method: obtenerSINO()", ex);
      return null;
    }
  }

  public List<Item> obtenerTiposContratos() {
    LOG.trace("method: obtenerTiposContratos()");
    try {
      return lpService.findByParent(LPEnum.TIPO_CONTRATO.getId());
    } catch (ServiceException ex) {
      LOG.error("Error in method: obtenerTiposContratos()", ex);
      return null;
    }
  }

  public List<Item> obtenerTiposCuentas() {
    LOG.trace("method: obtenerTiposCuentas()");
    try {
      return lpService.findByParent(LPEnum.TIPO_CUENTA.getId());
    } catch (ServiceException ex) {
      LOG.error("Error in method: obtenerTiposCuentas()", ex);
      return null;
    }
  }

  public List<Item> obtenerTiposDotaciones() {
    LOG.trace("method: obtenerTiposDotaciones()");
    try {
      return lpService.findByParent(LPEnum.TIPO_DOTACION.getId());
    } catch (ServiceException ex) {
      LOG.error("Error in method: obtenerTiposDotaciones()", ex);
      return null;
    }
  }

  public List<Item> obtenerTiposEmpresas() {
    LOG.trace("method: obtenerTiposEmpresas()");
    try {
      return lpService.findByParent(LPEnum.TIPO_EMPRESA.getId());
    } catch (ServiceException ex) {
      LOG.error("Error in method: obtenerTiposEmpresas()", ex);
      return null;
    }
  }

  public List<Item> obtenerTiposFormaciones() {
    LOG.trace("method: obtenerTiposFormaciones()");
    try {
      return lpService.findByParent(LPEnum.TIPO_FORMACION.getId());
    } catch (ServiceException ex) {
      LOG.error("Error in method: obtenerTiposFormaciones()", ex);
      return null;
    }
  }

  public List<Item> obtenerTiposIdentificaciones() {
    LOG.trace("method: obtenerTiposIdentificaciones()");
    try {
      return lpService.findByParent(LPEnum.TIPO_IDENTIFICACION.getId());
    } catch (ServiceException ex) {
      LOG.error("Error in method: obtenerTiposIdentificaciones()", ex);
      return null;
    }
  }

  public List<Item> obtenerTiposSoportes() {
    LOG.trace("method: obtenerTiposSoportes()");
    try {
      return lpService.findByParent(LPEnum.TIPO_SOPORTE.getId());
    } catch (ServiceException ex) {
      LOG.error("Error in method: obtenerTiposSoportes()", ex);
      return null;
    }
  }
}