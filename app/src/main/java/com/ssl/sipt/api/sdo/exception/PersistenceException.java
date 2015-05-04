package com.ssl.sipt.api.sdo.exception;

/**
 * DemiurgeSoft
 *
 * @author d5a9p6s7
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
