package com.ssl.sipt.web.listener;

import java.util.Date;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * OMNES S.A.S.
 *
 * @author: Alejandro Poveda.
 * @name:
 * @Descripcion:
 * @version: 1.0
 * @since: JDK_1.7
 */
public class SessionListener implements HttpSessionListener {

  private static final Logger LOG = LoggerFactory.getLogger(SessionListener.class);
  private Integer sessionCount;

  public SessionListener() {
    this.sessionCount = 0;
  }

  @Override
  public void sessionCreated(HttpSessionEvent se) {
    LOG.debug("method: sessionCreated()");
    HttpSession session = se.getSession();
    //session.setMaxInactiveInterval(60);
    synchronized (this) {
      sessionCount++;
    }
    String id = session.getId();
    Date now = new Date();
    StringBuilder message = new StringBuilder();
    message.append("New Session created on ");
    message.append(now.toString());
    message.append("\n");
    message.append("Value of created session ID is: ");
    message.append(id);
    message.append("\n");
    message.append("There are now: ");
    message.append(sessionCount);
    message.append(" live sessions in the application.");
    LOG.debug(message.toString());
  }

  @Override
  public void sessionDestroyed(HttpSessionEvent se) {
    LOG.debug("method: sessionDestroyed()");
    HttpSession session = se.getSession();
    // Acciones antes de invalidar la session.
    beforeInvalidateSession(session);
    synchronized (this) {
      sessionCount--;
    }
    String id = session.getId();
    Date now = new Date();
    StringBuilder message = new StringBuilder();
    message.append("Session destroyed on ");
    message.append(now.toString());
    message.append("\n");
    message.append("Value of destroyed session ID is: ");
    message.append(id);
    message.append("\n");
    message.append("There are now: ");
    message.append(sessionCount);
    message.append(" live sessions in the application.");
    LOG.debug(message.toString());
  }

  /**
   * Gets the logged in user data from Acegi SecurityContext and makes necessary logout operations.
   *
   * @param httpSession
   */
  public void beforeInvalidateSession(HttpSession httpSession) {
    LOG.debug("method: beforeInvalidateSession()");
  }
}
