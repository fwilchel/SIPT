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
 * @author: Diego Poveda.
 * @name:
 * @descripcion:
 * @version: 1.0
 * @since: JDK_1.7
 */
public interface LPServiceInterface {

    List<Lista> findAll() throws ServiceException;

    List<Item> findByParent(Long parent) throws ServiceException;

    Item findById(Long id) throws ServiceException;

    Item create(Item record) throws ServiceException;

    void update(Item record) throws ServiceException;

    void delete(Item record) throws ServiceException;

    void delete(Long id) throws ServiceException;

}
