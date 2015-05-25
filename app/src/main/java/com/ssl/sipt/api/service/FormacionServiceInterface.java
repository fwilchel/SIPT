/*
 * Softstudio LTDA
 * Copyrigth .2015.
 */
package com.ssl.sipt.api.service;

import com.ssl.sipt.api.model.Formacion;
import com.ssl.sipt.api.service.exception.ServiceException;
import java.util.List;

/**
 * @author: Diego Poveda.
 * @name:
 * @descripcion:
 * @version: 1.0
 * @since: JDK_1.7
 */
public interface FormacionServiceInterface {

  List<Formacion> findAll() throws ServiceException;

  List<Formacion> findByEmpleado(Long idEmpleado) throws ServiceException;

  Formacion findById(Long id) throws ServiceException;

  Formacion create(Formacion record) throws ServiceException;

  void update(Formacion record) throws ServiceException;

  void delete(Formacion record) throws ServiceException;

  void delete(Long id) throws ServiceException;
}
