package com.ssl.sipt.api.service;

import com.ssl.sipt.api.model.Empleado;
import com.ssl.sipt.api.service.exception.ServiceException;
import java.util.List;

/**
 *
 * @author d5a9p6s7
 */
public interface EmpleadoEJB {

  List<Empleado> findAll() throws ServiceException;

  List<Empleado> findByFilter(Empleado filter) throws ServiceException;

  Empleado findById(Long id) throws ServiceException;

  void create(Empleado empleado) throws ServiceException;

  void update(Empleado empleado) throws ServiceException;

  void delete(Empleado empleado) throws ServiceException;

  void delete(Long id) throws ServiceException;

}
