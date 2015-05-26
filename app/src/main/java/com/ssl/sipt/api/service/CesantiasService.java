/*
 * Softstudio LTDA
 * Copyrigth .2015.
 */
package com.ssl.sipt.api.service;

import com.ssl.sipt.api.model.Cesantias;
import com.ssl.sipt.api.sdo.SDO;
import com.ssl.sipt.api.sdo.exception.PersistenceException;
import com.ssl.sipt.api.service.exception.ServiceException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class CesantiasService implements CesantiasServiceInterface {

  private static final Logger LOG = LoggerFactory.getLogger(CesantiasService.class);
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
  public List<Cesantias> findAll() throws ServiceException {
    LOG.trace("method: findAll()");
    List<Cesantias> list;
    try {
      list = sdo.getResultList(em, Cesantias.class);
      em.clear();
    } catch (PersistenceException ex) {
      LOG.error("Error en <<findAll>> ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
      throw new ServiceException(ex);
    }
    return list;
  }

  @Override
  public List<Cesantias> findByEmpleado(Long idEmpleado) throws ServiceException {
    LOG.trace("method: findByEmpleado()");
    if (idEmpleado == null) {
      throw new IllegalArgumentException("El id del empleado es obligatorio");
    }
    List<Cesantias> list;
    try {
      Map<String, Object> params = new HashMap<>();
      params.put("idEmpleado", idEmpleado);
      list = sdo.getResultListByNamedQuery(em, Cesantias.FIND_BY_EMPLEADO, params);
      em.clear();
    } catch (PersistenceException ex) {
      LOG.error("Error en <<findByEmpleado>> ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
      throw new ServiceException(ex);
    }
    return list;
  }

  @Override
  public Cesantias findById(Long id) throws ServiceException {
    LOG.debug("method: findById(id)");
    try {
      Cesantias i = (Cesantias) sdo.find(em, id, Cesantias.class);
      em.clear();
      return i;
    } catch (PersistenceException ex) {
      LOG.error("Error en <<findById>> ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
      throw new ServiceException(ex);
    }
  }

  @Override
  public Cesantias create(Cesantias record) throws ServiceException {
    LOG.debug("method: create(entity)");
    try {
      sdo.persist(em, record);
      em.flush();
      return record;
    } catch (PersistenceException ex) {
      LOG.error("Error en <<create>> ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
      throw new ServiceException(ex);
    }
  }

  @Override
  public void update(Cesantias record) throws ServiceException {
    LOG.debug("method: edit(record)");
    try {
      sdo.merge(em, record);
      em.flush();
    } catch (PersistenceException ex) {
      LOG.error("Error en <<record>> ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
      throw new ServiceException(ex);
    }
  }

  @Override
  public void delete(Cesantias record) throws ServiceException {
    LOG.debug("method: delete(record)");
    try {
      sdo.remove(em, record);
      em.flush();
    } catch (PersistenceException ex) {
      LOG.error("Error en <<delete>> ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
      throw new ServiceException(ex);
    }
  }

  @Override
  public void delete(Long id) throws ServiceException {
    LOG.debug("method: delete(id)");
    try {
      sdo.remove(em, id, Cesantias.class);
      em.flush();
    } catch (PersistenceException ex) {
      LOG.error("Error en <<delete>> ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
      throw new ServiceException(ex);
    }
  }
}
