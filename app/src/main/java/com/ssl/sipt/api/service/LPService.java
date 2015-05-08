/*
 * Softstudio LTDA
 * Copyrigth .2015.
 */
package com.ssl.sipt.api.service;

import com.ssl.sipt.api.model.Item;
import com.ssl.sipt.api.model.Lista;
import com.ssl.sipt.api.sdo.SDO;
import com.ssl.sipt.api.sdo.exception.PersistenceException;
import com.ssl.sipt.api.service.exception.ServiceException;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: Diego Poveda.
 * @name:
 * @descripcion:
 * @version: 1.0
 * @since: JDK_1.7
 */
@Stateless
public class LPService implements LPServiceInterface {

    private static final Logger LOG = LoggerFactory.getLogger(LPService.class);
    @PersistenceContext(unitName = "sipt-pu")
    private EntityManager em;
    @Inject
    private SDO sdo;

    protected EntityManager getEntityManager() {
        LOG.trace("method: getEntityManager()");
        if (em == null) {
            try {
                em = (EntityManager) (new InitialContext()).lookup("java:comp/ejb/EntityManager");
            } catch (NamingException ex) {
                LOG.error("Error en <<getEntityManager>> ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
            }
        }
        return em;
    }

    @Override
    public List<Lista> findAll() throws ServiceException {
        LOG.trace("method: findAll()");
        List<Lista> list;
        try {
            list = sdo.getResultList(em, Lista.class);
            em.clear();
        } catch (PersistenceException ex) {
            LOG.error("Error en <<findAll>> ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
            throw new ServiceException(ex);
        }
        return list;
    }

    @Override
    public List<Item> findByParent(Long parent) throws ServiceException {
        LOG.trace("method: findByParent()");
        List<Item> list;
        try {
            list = sdo.getResultList(em, Item.class);
            em.clear();
        } catch (PersistenceException ex) {
            LOG.error("Error en <<findByParent>> ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
            throw new ServiceException(ex);
        }
        return list;
    }

    @Override
    public Item findById(Long id) throws ServiceException {
        LOG.debug("method: findById(id)");
        try {
            Item i = (Item) sdo.find(em, id, Item.class);
            em.clear();
            return i;
        } catch (PersistenceException ex) {
            LOG.error("Error en <<findById>> ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
            throw new ServiceException(ex);
        }
    }

    @Override
    public Item create(Item record) throws ServiceException {
        LOG.debug("method: create(entity)");
        try {
            sdo.persist(em, record);
            return record;
        } catch (PersistenceException ex) {
            LOG.error("Error en <<create>> ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
            throw new ServiceException(ex);
        }
    }

    @Override
    public void update(Item record) throws ServiceException {
        LOG.debug("method: edit(record)");
        try {
            sdo.merge(em, record);
        } catch (PersistenceException ex) {
            LOG.error("Error en <<record>> ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
            throw new ServiceException(ex);
        }
    }

    @Override
    public void delete(Item record) throws ServiceException {
        LOG.debug("method: delete(record)");
        try {
            sdo.remove(em, record);
        } catch (PersistenceException ex) {
            LOG.error("Error en <<delete>> ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
            throw new ServiceException(ex);
        }
    }

    @Override
    public void delete(Long id) throws ServiceException {
        LOG.debug("method: delete(id)");
        try {
            sdo.remove(em, id, Item.class);
        } catch (PersistenceException ex) {
            LOG.error("Error en <<delete>> ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
            throw new ServiceException(ex);
        }
    }
}
