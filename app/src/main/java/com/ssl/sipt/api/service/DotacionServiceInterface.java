/*
 * Softstudio LTDA
 * Copyrigth .2015.
 */
package com.ssl.sipt.api.service;

import com.ssl.sipt.api.model.Dotacion;
import com.ssl.sipt.api.service.exception.ServiceException;
import java.util.List;

/**
 * @author: Diego Poveda.
 * @name:
 * @descripcion:
 * @version: 1.0
 * @since: JDK_1.7
 */
public interface DotacionServiceInterface {

  List<Dotacion> findAll() throws ServiceException;

  List<Dotacion> findByEmpleado(Long idEmpleado) throws ServiceException;

  Dotacion findById(Long id) throws ServiceException;

  Dotacion create(Dotacion record) throws ServiceException;

  void update(Dotacion record) throws ServiceException;

  void delete(Dotacion record) throws ServiceException;

  void delete(Long id) throws ServiceException;
}
