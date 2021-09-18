package com.omar.demo.authorization.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@WebFilter(filterName = "AuthenticationFilter")
@Order(1)
public class AuthenticationFilter implements Filter {

  @Override
  public synchronized void doFilter(
      ServletRequest request, ServletResponse response, FilterChain chain)
      throws ServletException, IOException {
    if (ExcludedUrls.validateUser(
        ((HttpServletRequest) request).getRequestURL().toString()
            + "?"
            + ((HttpServletRequest) request).getQueryString())) {
      chain.doFilter(request, response);
      return;
    }

    if (CookiesValidator.validateCookie((HttpServletRequest) request, "authorized", "true")) {
      chain.doFilter(request, response);
    } else {
      request.getRequestDispatcher("/login").forward(request, response);
    }
  }
}
