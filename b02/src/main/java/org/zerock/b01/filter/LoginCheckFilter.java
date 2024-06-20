//package org.zerock.b01.filter;
//
//import jakarta.servlet.*;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.IOException;
//
//@Configuration
//@Log4j2
//public class LoginCheckFilter {
//    @Bean
//    public FilterRegistrationBean<Filter> loginCheckFilterRegistration() {
//        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
//        registrationBean.setFilter(loginCheckFilter());
//        registrationBean.addUrlPatterns("/member/login"); // 적용할 URL 패턴 지정
//        registrationBean.setOrder(1); // 필터 순서 지정
//        return registrationBean;
//    }
//
//    @Bean
//    public Filter loginCheckFilter() {
//        return new LoginFilter();
//    }
//
//    public static class LoginFilter implements Filter {
//        @Override
//        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//            log.info("login check filter...");
//
//            HttpServletRequest req = (HttpServletRequest) request;
//            HttpServletResponse resp = (HttpServletResponse) response;
//            HttpSession session = req.getSession();
//
//            if (session.getAttribute("loginInfo") != null) {
//                chain.doFilter(request, response);
//                return;
//            }
//
//            resp.sendRedirect("/member/login");
//        }
//    }
//}
