/*
 * Softstudio LTDA
 * Copyrigth .2015.
 */
package com.ssl.sipt.api.service;

import com.ssl.sipt.api.model.CentroTrabajo;
import com.ssl.sipt.api.service.exception.ServiceException;
import java.util.List;

/**
 * @author: Diego Poveda.
 * @name:
 * @descripcion:
 * @version: 1.0
 * @since: JDK_1.7
 */
public interface CentroTrabajoServiceInterface {

    List<CentroTrabajo> findAll() throws ServiceException;

    CentroTrabajo findById(Long id) throws ServiceException;

    CentroTrabajo create(CentroTrabajo record) throws ServiceException;

    void update(CentroTrabajo record) throws ServiceException;

    void delete(CentroTrabajo record) throws ServiceException;

    void delete(Long id) throws ServiceException;
}
