/*
 * Softstudio LTDA
 * Copyrigth .2015.
 */
package com.ssl.sipt.api.service;

import com.ssl.sipt.api.model.Contrato;
import com.ssl.sipt.api.service.exception.ServiceException;
import java.util.List;

/**
 * @author: Diego Poveda.
 * @name:
 * @descripcion:
 * @version: 1.0
 * @since: JDK_1.7
 */
public interface ContratoServiceInterface {

  List<Contrato> findAll() throws ServiceException;

  List<Contrato> findByEmpleado(Long idEmpleado) throws ServiceException;

  Contrato findById(Long id) throws ServiceException;

  Contrato create(Contrato record) throws ServiceException;

  void update(Contrato record) throws ServiceException;

  void delete(Contrato record) throws ServiceException;

  void delete(Long id) throws ServiceException;
}
