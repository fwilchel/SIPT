/*
 * Softstudio LTDA
 * Copyrigth .2015.
 */
package com.ssl.sipt.api.service;

import com.ssl.sipt.api.model.Municipio;
import com.ssl.sipt.api.service.exception.ServiceException;
import java.util.List;

/**
 * @author: Diego Poveda.
 * @name:
 * @descripcion:
 * @version: 1.0
 * @since: JDK_1.7
 */
public interface MunicipioServiceInterface {

    List<Municipio> findAll() throws ServiceException;

    List<Municipio> findByDepartamento(Long idDepartamento) throws ServiceException;

    Municipio findById(Long id) throws ServiceException;

    Municipio create(Municipio record) throws ServiceException;

    void update(Municipio record) throws ServiceException;

    void delete(Municipio record) throws ServiceException;

    void delete(Long id) throws ServiceException;

}
