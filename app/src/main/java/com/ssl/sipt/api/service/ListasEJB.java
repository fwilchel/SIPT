/*
 * Softstudio LTDA
 * Copyrigth .2015.
 */
package com.ssl.sipt.api.service;

import com.ssl.sipt.api.model.Item;
import com.ssl.sipt.api.model.Lista;
import com.ssl.sipt.api.service.exception.ServiceException;
import java.util.List;

/**
 *
 * @author d5a9p6s7
 */
public interface ListasEJB {

  List<Lista> findAll() throws ServiceException;

  List<Item> findByParent(Long parent) throws ServiceException;

  Item findById(Long id) throws ServiceException;

  Item create(Item record) throws ServiceException;

  void update(Item record) throws ServiceException;

  void delete(Item record) throws ServiceException;

  void delete(Long id) throws ServiceException;

}
