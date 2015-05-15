/*
 * Softstudio LTDA
 * Copyrigth .2015.
 */
package com.ssl.sipt.api.sdo.exception;

/**
 * @author: Diego Poveda.
 * @name:
 * @descripcion:
 * @version: 1.0
 * @since: JDK_1.7
 */
public class PersistenceException extends Exception {

  public PersistenceException() {
  }

  public PersistenceException(String message) {
    super(message);
  }

  public PersistenceException(Throwable cause) {
    super(cause);
  }

  public PersistenceException(String message, Throwable cause) {
    super(message, cause);
  }
}
