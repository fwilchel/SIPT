/*
 * Softstudio LTDA
 * Copyrigth .2015.
 */
package com.ssl.sipt.api.service;

import com.ssl.sipt.api.model.Departamento;
import com.ssl.sipt.api.service.exception.ServiceException;
import java.util.List;

/**
 * @author: Diego Poveda.
 * @name:
 * @descripcion:
 * @version: 1.0
 * @since: JDK_1.7
 */
public interface DepartamentoServiceInterface {

    List<Departamento> findAll() throws ServiceException;

    Departamento findById(Long id) throws ServiceException;

    Departamento create(Departamento record) throws ServiceException;

    void update(Departamento record) throws ServiceException;

    void delete(Departamento record) throws ServiceException;

    void delete(Long id) throws ServiceException;
}
