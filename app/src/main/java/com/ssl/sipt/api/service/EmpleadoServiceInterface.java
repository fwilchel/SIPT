/*
 * Softstudio LTDA
 * Copyrigth .2015.
 */
package com.ssl.sipt.api.service;

import com.ssl.sipt.api.model.Empleado;
import com.ssl.sipt.api.service.exception.ServiceException;
import java.util.List;

/**
 * @author: Diego Poveda.
 * @name:
 * @descripcion:
 * @version: 1.0
 * @since: JDK_1.7
 */
public interface EmpleadoServiceInterface {

    List<Empleado> findAll() throws ServiceException;

    List<Empleado> findByFilter(Empleado filter) throws ServiceException;

    Empleado findById(Long id) throws ServiceException;

    void create(Empleado empleado) throws ServiceException;

    void update(Empleado empleado) throws ServiceException;

    void delete(Empleado empleado) throws ServiceException;

    void delete(Long id) throws ServiceException;

}
