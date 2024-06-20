package org.zerock.w2.listener;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
@Log4j2
public class LoginListener implements HttpSessionAttributeListener {
  @Override
  //session.setAttribute() 가 실행될때
  public void attributeAdded(HttpSessionBindingEvent event) {
    String name = event.getName();
    Object obj = event.getValue();
    if(name.equals("loginInfo")){
      log.info("A user logined");
      log.info(obj);
    }
  }

  @Override
  public void attributeRemoved(HttpSessionBindingEvent event) {
    String name = event.getName();
    Object obj = event.getValue();
    if(name.equals("loginInfo")){
      log.info("A user logout");
      log.info(obj);
    }
  }
}
