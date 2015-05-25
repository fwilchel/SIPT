/*
 * Softstudio LTDA
 * Copyrigth .2015.
 */
package com.ssl.sipt.api.service;

import com.ssl.sipt.api.model.Experiencia;
import com.ssl.sipt.api.service.exception.ServiceException;
import java.util.List;

/**
 * @author: Diego Poveda.
 * @name:
 * @descripcion:
 * @version: 1.0
 * @since: JDK_1.7
 */
public interface ExperienciaServiceInterface {

  List<Experiencia> findAll() throws ServiceException;

  List<Experiencia> findByEmpleado(Long idEmpleado) throws ServiceException;

  Experiencia findById(Long id) throws ServiceException;

  Experiencia create(Experiencia record) throws ServiceException;

  void update(Experiencia record) throws ServiceException;

  void delete(Experiencia record) throws ServiceException;

  void delete(Long id) throws ServiceException;
}