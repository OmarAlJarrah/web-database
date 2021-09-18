package com.omar.demo.authorization.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@WebFilter(filterName = "AuthorizationFilter")
@Order(2)
public class AuthorizationFilter implements Filter {

  @Override
  public synchronized void doFilter(ServletRequest request,
                                    ServletResponse response,
                                    FilterChain chain)
      throws ServletException, IOException {

    if (ExcludedUrls.validateAdmin(
        ((HttpServletRequest) request).getRequestURL().toString()
            + "?"
            + ((HttpServletRequest) request).getQueryString())) {
      chain.doFilter(request, response);
      return;
    }

    if (CookiesValidator.validateCookie((HttpServletRequest) request, "isAdmin", "true")) {
      chain.doFilter(request, response);
    } else {
      request.getRequestDispatcher("/login").forward(request, response);
    }
  }
}
