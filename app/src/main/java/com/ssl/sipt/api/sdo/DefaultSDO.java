/*
 * Softstudio LTDA
 * Copyrigth .2015.
 */
package com.ssl.sipt.api.sdo;

import com.ssl.sipt.api.sdo.exception.PersistenceException;
import java.util.List;
import java.util.Map;
import javax.ejb.EJBException;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: Diego Poveda.
 * @param <T>
 * @param <K>
 * @name:
 * @descripcion:
 * @version: 1.0
 * @since: JDK_1.7
 */
public class DefaultSDO<T, K> implements SDO<T, K> {

  private static final Logger LOG = LoggerFactory.getLogger(DefaultSDO.class);

  @Override
  public T find(EntityManager em, K id, Class<T> entityClass) throws PersistenceException {
    LOG.trace("entry method: find() params -->> em -> {}, id -> {}, class -> {}", em, id, entityClass);
    try {
      return em.find(entityClass, id);
    } catch (EJBException ex) {
      LOG.error("error at find() ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
      throw new PersistenceException(ex.getCause().getMessage(), ex.getCause());
    }
  }

  @Override
  public T findByNamedQuery(EntityManager em, String queryName, Map<String, Object> params) throws PersistenceException {
    LOG.trace("entry method: findByNamedQuery() params -->> em -> {}, queryName -> {}, params -> {}", em, queryName, params);
    try {
      javax.persistence.Query q = em.createNamedQuery(queryName);
      if (params != null) {
        for (Map.Entry entry : params.entrySet()) {
          LOG.debug(entry.getKey().toString() + ": " + params.get(entry.getKey().toString()));
          q.setParameter(entry.getKey().toString(), params.get(entry.getKey().toString()));
        }
      }
      return (T) q.getSingleResult();
    } catch (EJBException ex) {
      LOG.error("error at findByNamedQuery() ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
      throw new PersistenceException(ex.getCause().getMessage(), ex.getCause());
    }
  }

  @Override
  public T findByNamedQuery(EntityManager em, String queryName, Map<String, Object> params, Class<T> entityClass) throws PersistenceException {
    LOG.trace("entry method: findByNamedQuery() params -->> em -> {}, queryName -> {}, params -> {}, class -> {}", em, queryName, params, entityClass);
    try {
      javax.persistence.Query q = em.createNamedQuery(queryName, entityClass);
      if (params != null) {
        for (Map.Entry entry : params.entrySet()) {
          LOG.debug(entry.getKey().toString() + ": " + params.get(entry.getKey().toString()));
          q.setParameter(entry.getKey().toString(), params.get(entry.getKey().toString()));
        }
      }
      return (T) q.getSingleResult();
    } catch (EJBException ex) {
      LOG.error("error at findByNamedQuery() ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
      throw new PersistenceException(ex.getCause().getMessage(), ex.getCause());
    }
  }

  @Override
  public T findByJPQLQuery(EntityManager em, String jpqlQuery, Map<String, Object> params) throws PersistenceException {
    LOG.trace("entry method: findByJPQLQuery() params -->> em -> {}, jpqlQuery -> {}, params -> {}", em, jpqlQuery, params);
    try {
      javax.persistence.Query q = em.createQuery(jpqlQuery);
      if (params != null) {
        for (Map.Entry entry : params.entrySet()) {
          LOG.debug(entry.getKey().toString() + ": " + params.get(entry.getKey().toString()));
          q.setParameter(entry.getKey().toString(), params.get(entry.getKey().toString()));
        }
      }
      return (T) q.getSingleResult();
    } catch (EJBException ex) {
      LOG.error("error at findByJPQLQuery() ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
      throw new PersistenceException(ex.getCause().getMessage(), ex.getCause());
    }
  }

  @Override
  public T findByJPQLQuery(EntityManager em, String jpqlQuery, Map<String, Object> params, Class<T> entityClass) throws PersistenceException {
    LOG.trace("entry method: findByJPQLQuery() params -->> em -> {}, jpqlQuery -> {}, params -> {}, class -> {}", em, jpqlQuery, params, entityClass);
    try {
      javax.persistence.Query q = em.createQuery(jpqlQuery, entityClass);
      if (params != null) {
        for (Map.Entry entry : params.entrySet()) {
          LOG.debug(entry.getKey().toString() + ": " + params.get(entry.getKey().toString()));
          q.setParameter(entry.getKey().toString(), params.get(entry.getKey().toString()));
        }
      }
      return (T) q.getSingleResult();
    } catch (EJBException ex) {
      LOG.error("error at findByJPQLQuery() ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
      throw new PersistenceException(ex.getCause().getMessage(), ex.getCause());
    }
  }

  @Override
  public T findByNativeQuery(EntityManager em, String nquery, Map<String, Object> params) throws PersistenceException {
    LOG.trace("entry method: findByNativeQuery() params -->> em -> {}, nquery -> {}, params -> {}", em, nquery, params);
    try {
      javax.persistence.Query q = em.createNativeQuery(nquery);
      if (params != null) {
        for (Map.Entry entry : params.entrySet()) {
          LOG.debug(entry.getKey().toString() + ": " + params.get(entry.getKey().toString()));
          q.setParameter(entry.getKey().toString(), params.get(entry.getKey().toString()));
        }
      }
      return (T) q.getSingleResult();
    } catch (EJBException ex) {
      LOG.error("error at findByNativeQuery() ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
      throw new PersistenceException(ex.getCause().getMessage(), ex.getCause());
    }
  }

  @Override
  public T findByNativeQuery(EntityManager em, String nquery, Map<String, Object> params, Class<T> entityClass) throws PersistenceException {
    LOG.trace("entry method: findByNativeQuery() params -->> em -> {}, nquery -> {}, params -> {}, class -> {}", em, nquery, params, entityClass);
    try {
      javax.persistence.Query q = em.createNativeQuery(nquery, entityClass);
      if (params != null) {
        for (Map.Entry entry : params.entrySet()) {
          LOG.debug(entry.getKey().toString() + ": " + params.get(entry.getKey().toString()));
          q.setParameter(entry.getKey().toString(), params.get(entry.getKey().toString()));
        }
      }
      return (T) q.getSingleResult();
    } catch (EJBException ex) {
      LOG.error("error at findByNativeQuery() ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
      throw new PersistenceException(ex.getCause().getMessage(), ex.getCause());
    }
  }

  @Override
  public List<T> getResultList(EntityManager em, Class<T> entityClass) throws PersistenceException {
    LOG.trace("entry method: getResultList() params -->> em -> {}, class -> {}", em, entityClass);
    try {
      javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      cq.select(cq.from(entityClass));
      return em.createQuery(cq).getResultList();
    } catch (EJBException ex) {
      LOG.error("error at getResultList() ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
      throw new PersistenceException(ex.getCause().getMessage(), ex.getCause());
    }
  }

  @Override
  public List<T> getResultListByNamedQuery(EntityManager em, String queryName, Map<String, Object> params) throws PersistenceException {
    LOG.trace("entry method: getResultListByNamedQuery() params -->> em -> {}, queryName -> {}, params -> {}", em, queryName, params);
    try {
      javax.persistence.Query q = em.createNamedQuery(queryName);
      if (params != null) {
        for (Map.Entry entry : params.entrySet()) {
          LOG.debug(entry.getKey().toString() + ": " + params.get(entry.getKey().toString()));
          q.setParameter(entry.getKey().toString(), params.get(entry.getKey().toString()));
        }
      }
      return q.getResultList();
    } catch (EJBException ex) {
      LOG.error("error at getResultListByNamedQuery() ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
      throw new PersistenceException(ex.getCause().getMessage(), ex.getCause());
    }
  }

  @Override
  public List<T> getResultListByNamedQuery(EntityManager em, String queryName, Map<String, Object> params, Class<T> entityClass) throws PersistenceException {
    LOG.trace("entry method: getResultListByNamedQuery() params -->> em -> {}, queryName -> {}, params -> {}, class -> {}", em, queryName, params, entityClass);
    try {
      javax.persistence.Query q = em.createNamedQuery(queryName, entityClass);
      if (params != null) {
        for (Map.Entry entry : params.entrySet()) {
          LOG.debug(entry.getKey().toString() + ": " + params.get(entry.getKey().toString()));
          q.setParameter(entry.getKey().toString(), params.get(entry.getKey().toString()));
        }
      }
      return q.getResultList();
    } catch (EJBException ex) {
      LOG.error("error at getResultListByNamedQuery() ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
      throw new PersistenceException(ex.getCause().getMessage(), ex.getCause());
    }
  }

  @Override
  public List<T> getResultListByJPQLQuery(EntityManager em, String jpqlQuery, Map<String, Object> params) throws PersistenceException {
    LOG.trace("entry method: getResultListByJPQLQuery() params -->> em -> {}, queryName -> {}, params -> {}", em, jpqlQuery, params);
    try {
      javax.persistence.Query q = em.createQuery(jpqlQuery);
      if (params != null) {
        for (Map.Entry entry : params.entrySet()) {
          LOG.debug(entry.getKey().toString() + ": " + params.get(entry.getKey().toString()));
          q.setParameter(entry.getKey().toString(), params.get(entry.getKey().toString()));
        }
      }
      return q.getResultList();
    } catch (EJBException ex) {
      LOG.error("error at getResultListByJPQLQuery() ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
      throw new PersistenceException(ex.getCause().getMessage(), ex.getCause());
    }
  }

  @Override
  public List<T> getResultListByJPQLQuery(EntityManager em, String jpqlQuery, Map<String, Object> params, Class<T> entityClass) throws PersistenceException {
    LOG.trace("entry method: getResultListByJPQLQuery() params -->> em -> {}, jpqlQuery -> {}, params -> {}, class -> {}", em, jpqlQuery, params, entityClass);
    try {
      javax.persistence.Query q = em.createQuery(jpqlQuery, entityClass);
      if (params != null) {
        for (Map.Entry entry : params.entrySet()) {
          LOG.debug(entry.getKey().toString() + ": " + params.get(entry.getKey().toString()));
          q.setParameter(entry.getKey().toString(), params.get(entry.getKey().toString()));
        }
      }
      return q.getResultList();
    } catch (EJBException ex) {
      LOG.error("error at getResultListByJPQLQuery() ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
      throw new PersistenceException(ex.getCause().getMessage(), ex.getCause());
    }
  }

  @Override
  public List<T> getResultListByNativeQuery(EntityManager em, String nquery, Map<String, Object> params) throws PersistenceException {
    LOG.trace("entry method: getResultListByNativeQuery() params -->> em -> {}, nquery -> {}, params -> {}", em, nquery, params);
    try {
      javax.persistence.Query q = em.createNativeQuery(nquery);
      if (params != null) {
        for (Map.Entry entry : params.entrySet()) {
          LOG.debug(entry.getKey().toString() + ": " + params.get(entry.getKey().toString()));
          q.setParameter(entry.getKey().toString(), params.get(entry.getKey().toString()));
        }
      }
      return q.getResultList();
    } catch (EJBException ex) {
      LOG.error("error at getResultListByNativeQuery() ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
      throw new PersistenceException(ex.getCause().getMessage(), ex.getCause());
    }
  }

  @Override
  public List<T> getResultListByNativeQuery(EntityManager em, String nquery, Map<String, Object> params, Class<T> entityClass) throws PersistenceException {
    LOG.trace("entry method: getResultListByNativeQuery() params -->> em -> {}, nquery -> {}, params -> {}, class -> {}", em, nquery, params, entityClass);
    try {
      javax.persistence.Query q = em.createNativeQuery(nquery, entityClass);
      if (params != null) {
        for (Map.Entry entry : params.entrySet()) {
          LOG.debug(entry.getKey().toString() + ": " + params.get(entry.getKey().toString()));
          q.setParameter(entry.getKey().toString(), params.get(entry.getKey().toString()));
        }
      }
      return q.getResultList();
    } catch (EJBException ex) {
      LOG.error("error at getResultListByNativeQuery() ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
      throw new PersistenceException(ex.getCause().getMessage(), ex.getCause());
    }
  }

  @Override
  public List<T> getResultListByRange(EntityManager em, Class<T> entityClass, int[] range) throws PersistenceException {
    LOG.trace("entry method: getResultListByRange() params -->> em -> {}, class -> {}, range[] -> {}", em, entityClass, range);
    try {
      javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      cq.select(cq.from(entityClass));
      javax.persistence.Query q = em.createQuery(cq);
      q.setMaxResults(range[1] - range[0]);
      q.setFirstResult(range[0]);
      return q.getResultList();
    } catch (EJBException ex) {
      LOG.error("error at getResultListByRange() ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
      throw new PersistenceException(ex.getCause().getMessage(), ex.getCause());
    }
  }

  @Override
  public void persist(EntityManager em, T entity) throws PersistenceException {
    LOG.trace("entry method: persist() params -->> em -> {}, entity -> {}", em, entity);
    try {
      em.persist(entity);
      em.flush();
    } catch (EJBException ex) {
      LOG.error("error at persist() ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
      throw new PersistenceException(ex.getCause().getMessage(), ex.getCause());
    }
  }

  @Override
  public void merge(EntityManager em, T entity) throws PersistenceException {
    LOG.trace("entry method: merge() params -->> em -> {}, entity -> {}", em, entity);
    try {
      em.merge(entity);
    } catch (EJBException ex) {
      LOG.error("error at merge() ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
      throw new PersistenceException(ex.getCause().getMessage(), ex.getCause());
    }
  }

  @Override
  public void remove(EntityManager em, T entity) throws PersistenceException {
    LOG.trace("entry method: remove() params -->> em -> {}, entity -> {}", em, entity);
    try {
      em.remove(em.merge(entity));
    } catch (EJBException ex) {
      LOG.error("error at remove() ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
      throw new PersistenceException(ex.getCause().getMessage(), ex.getCause());
    }
  }

  @Override
  public void remove(EntityManager em, K id, Class<T> entityClass) throws PersistenceException {
    LOG.trace("entry method: remove() params -->> em -> {}, id -> {}, class -> {}", em, id, entityClass);
    try {
      em.remove(em.find(entityClass, id));
    } catch (EJBException ex) {
      LOG.error("error at remove() ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
      throw new PersistenceException(ex.getCause().getMessage(), ex.getCause());
    }
  }

  @Override
  public int executeNamedQuery(EntityManager em, String namedQuery, Map<String, Object> params) throws PersistenceException {
    LOG.trace("entry method: <<executeNamedQuery>> params -->> em -> {}, namedQuery -> {}, params -> {}, class -> {}", em, namedQuery, params);
    try {
      Query q = em.createNamedQuery(namedQuery);
      if (params != null) {
        for (Map.Entry entry : params.entrySet()) {
          LOG.debug(entry.getKey().toString() + ": " + params.get(entry.getKey().toString()));
          q.setParameter(entry.getKey().toString(), params.get(entry.getKey().toString()));
        }
      }
      int registrosAfectados = q.executeUpdate();
      LOG.info("entry method: <<executeNamedQuery>> con resultado ->> {" + registrosAfectados + "} registro(s) afectado(s)");
      return registrosAfectados;
    } catch (EJBException ex) {
      LOG.error("error at executeNamedQuery() ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
      throw new PersistenceException(ex.getCause().getMessage(), ex.getCause());
    }
  }

  @Override
  public int executeJPQLQuery(EntityManager em, String jpqlQuery, Map<String, Object> params) throws PersistenceException {
    LOG.info("entry method: <<executeJPQLQuery>>  params -->> em -> {}, jpqlQuery -> {}, params -> {}, class -> {}", em, jpqlQuery, params);
    try {
      Query q = em.createQuery(jpqlQuery);
      if (params != null) {
        for (Map.Entry entry : params.entrySet()) {
          LOG.debug(entry.getKey().toString() + ": " + params.get(entry.getKey().toString()));
          q.setParameter(entry.getKey().toString(), params.get(entry.getKey().toString()));
        }
      }
      int registrosAfectados = q.executeUpdate();
      LOG.info("entry method: <<executeJPQLQuery>> con resultado ->> {" + registrosAfectados + "} registro(s) afectado(s)");
      return registrosAfectados;
    } catch (Exception ex) {
      LOG.error("error at executeJPQLQuery() ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
      throw new PersistenceException(ex.getCause().getMessage(), ex.getCause());
    }
  }

  @Override
  public int executeNativeQuery(EntityManager em, String nativeQuery, Map<String, Object> params) throws PersistenceException {
    LOG.info("entry method: <<executeNativeQuery>> params -->> em -> {}, nativeQuery -> {}, params -> {}, class -> {}", em, nativeQuery, params);
    try {
      Query q = em.createNativeQuery(nativeQuery);
      if (params != null) {
        for (Map.Entry entry : params.entrySet()) {
          LOG.debug(entry.getKey().toString() + ": " + params.get(entry.getKey().toString()));
          q.setParameter(entry.getKey().toString(), params.get(entry.getKey().toString()));
        }
      }
      int registrosAfectados = q.executeUpdate();
      LOG.info("left method: <<executeNativeQuery>> con resultado ->> {" + registrosAfectados + "} registro(s) afectado(s)");
      return registrosAfectados;
    } catch (Exception ex) {
      LOG.error("error at executeNativeQuery() ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
      throw new PersistenceException(ex.getCause().getMessage(), ex.getCause());
    }
  }

  @Override
  public int count(EntityManager em, Class<T> entityClass) throws PersistenceException {
    LOG.trace("entry method: count() params -->> em -> {}, class -> {}", em, entityClass);
    try {
      javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
      cq.select(em.getCriteriaBuilder().count(rt));
      javax.persistence.Query q = em.createQuery(cq);
      return ((Long) q.getSingleResult()).intValue();
    } catch (EJBException ex) {
      LOG.error("error at count() ->> mensaje ->> {} / causa ->> {} ", ex.getMessage(), ex.getCause());
      throw new PersistenceException(ex.getCause().getMessage(), ex.getCause());
    }
  }
}
