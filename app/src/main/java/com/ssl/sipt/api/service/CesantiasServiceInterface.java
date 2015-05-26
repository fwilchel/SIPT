/*
 * Softstudio LTDA
 * Copyrigth .2015.
 */
package com.ssl.sipt.api.service;

import com.ssl.sipt.api.model.Cesantias;
import com.ssl.sipt.api.service.exception.ServiceException;
import java.util.List;

/**
 * @author: Diego Poveda.
 * @name:
 * @descripcion:
 * @version: 1.0
 * @since: JDK_1.7
 */
public interface CesantiasServiceInterface {

  List<Cesantias> findAll() throws ServiceException;

  List<Cesantias> findByEmpleado(Long idEmpleado) throws ServiceException;

  Cesantias findById(Long id) throws ServiceException;

  Cesantias create(Cesantias record) throws ServiceException;

  void update(Cesantias record) throws ServiceException;

  void delete(Cesantias record) throws ServiceException;

  void delete(Long id) throws ServiceException;
}
