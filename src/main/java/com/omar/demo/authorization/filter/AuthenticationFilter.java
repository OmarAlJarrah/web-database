package com.omar.demo.authorization.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


@Component
@WebFilter(filterName = "AuthenticationFilter")
@Order(1)
public class AuthenticationFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
    if (ExcludedUrls.validateUser(((HttpServletRequest)request)
            .getRequestURL()
            .toString()
            + "?"
            + ((HttpServletRequest)request).getQueryString())) {
      chain.doFilter(request, response);
      return;
    }

    Cookie[] cookiesArray = ((HttpServletRequest)request).getCookies();
    if (cookiesArray == null || cookiesArray.length == 0) {
      ((HttpServletRequest)request).getRequestDispatcher("/login").forward(request, response);
      return;
    }

    List<Cookie> cookies = Arrays.asList(cookiesArray);

    for (Cookie cookie : cookies) {
      String name = cookie.getName();
      String value = cookie.getValue();

      if (name.equalsIgnoreCase("authorized")
              && Boolean.parseBoolean(value)) {
        chain.doFilter(request, response);
        return;
      }
    }
    ((HttpServletRequest)request).getRequestDispatcher("/login").forward(request, response);
  }
}
