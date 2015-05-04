package com.ssl.sipt.api.sdo;

import com.ssl.sipt.api.sdo.exception.PersistenceException;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;

/**
 * DemiurgeSoft
 *
 * Interface que expone los metodos necesarios para manejar la informacion con el motor de persistencia
 *
 * @author d5a9p6s7
 * @param <T>
 * @param <K>
 */
public interface SDO<T, K> {

  T find(EntityManager em, K id, Class<T> entityClass) throws PersistenceException;

  T findByNamedQuery(EntityManager em, String queryName, Map<String, Object> params) throws PersistenceException;

  T findByNamedQuery(EntityManager em, String queryName, Map<String, Object> params, Class<T> entityClass) throws PersistenceException;

  T findByJPQLQuery(EntityManager em, String jpqlQuery, Map<String, Object> params) throws PersistenceException;

  T findByJPQLQuery(EntityManager em, String jpqlQuery, Map<String, Object> params, Class<T> entityClass) throws PersistenceException;

  T findByNativeQuery(EntityManager em, String nquery, Map<String, Object> params) throws PersistenceException;

  T findByNativeQuery(EntityManager em, String nquery, Map<String, Object> params, Class<T> entityClass) throws PersistenceException;

  List<T> getResultList(EntityManager em, Class<T> entityClass) throws PersistenceException;

  List<T> getResultListByNamedQuery(EntityManager em, String queryName, Map<String, Object> params) throws PersistenceException;

  List<T> getResultListByNamedQuery(EntityManager em, String queryName, Map<String, Object> params, Class<T> entityClass) throws PersistenceException;

  List<T> getResultListByJPQLQuery(EntityManager em, String jpqlQuery, Map<String, Object> params) throws PersistenceException;

  List<T> getResultListByJPQLQuery(EntityManager em, String jpqlQuery, Map<String, Object> params, Class<T> entityClass) throws PersistenceException;

  List<T> getResultListByNativeQuery(EntityManager em, String nquery, Map<String, Object> params) throws PersistenceException;

  List<T> getResultListByNativeQuery(EntityManager em, String nquery, Map<String, Object> params, Class<T> entityClass) throws PersistenceException;

  List<T> getResultListByRange(EntityManager em, Class<T> entityClass, int[] range) throws PersistenceException;

  void persist(EntityManager em, T entity) throws PersistenceException;

  void merge(EntityManager em, T entity) throws PersistenceException;

  void remove(EntityManager em, T entity) throws PersistenceException;

  void remove(EntityManager em, K id, Class<T> entityClass) throws PersistenceException;

  int executeNamedQuery(EntityManager em, String namedQuery, Map<String, Object> params) throws PersistenceException;

  int executeJPQLQuery(EntityManager em, String jpqlQuery, Map<String, Object> params) throws PersistenceException;

  int executeNativeQuery(EntityManager em, String nativeQuery, Map<String, Object> params) throws PersistenceException;

  int count(EntityManager em, Class<T> entityClass) throws PersistenceException;
}
