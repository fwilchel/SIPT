/*
 * Softstudio LTDA
 * Copyrigth .2015.
 */
package com.ssl.sipt.api.service;

import com.ssl.sipt.api.model.Beneficiario;
import com.ssl.sipt.api.service.exception.ServiceException;
import java.util.List;

/**
 * @author: Diego Poveda.
 * @name:
 * @descripcion:
 * @version: 1.0
 * @since: JDK_1.7
 */
public interface BeneficiarioServiceInterface {

  List<Beneficiario> findAll() throws ServiceException;

  Beneficiario findById(Long id) throws ServiceException;

  Beneficiario create(Beneficiario record) throws ServiceException;

  void update(Beneficiario record) throws ServiceException;

  void delete(Beneficiario record) throws ServiceException;

  void delete(Long id) throws ServiceException;
}
