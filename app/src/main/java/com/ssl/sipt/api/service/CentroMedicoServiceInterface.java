/*
 * Softstudio LTDA
 * Copyrigth .2015.
 */
package com.ssl.sipt.api.service;

import com.ssl.sipt.api.model.CentroMedico;
import com.ssl.sipt.api.service.exception.ServiceException;
import java.util.List;

/**
 * @author: Diego Poveda.
 * @name:
 * @descripcion:
 * @version: 1.0
 * @since: JDK_1.7
 */
public interface CentroMedicoServiceInterface {

  List<CentroMedico> findAll() throws ServiceException;

  CentroMedico findById(Long id) throws ServiceException;

  CentroMedico create(CentroMedico record) throws ServiceException;

  void update(CentroMedico record) throws ServiceException;

  void delete(CentroMedico record) throws ServiceException;

  void delete(Long id) throws ServiceException;
}
