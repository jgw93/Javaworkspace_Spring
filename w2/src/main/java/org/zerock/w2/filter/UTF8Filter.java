package org.zerock.w2.filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
@Log4j2
public class UTF8Filter implements Filter {
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    log.info("가나다라 UTF8 filter....");
    servletRequest.setCharacterEncoding("UTF-8");
    filterChain.doFilter(servletRequest,servletResponse);
  }
}
