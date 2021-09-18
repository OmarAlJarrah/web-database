package com.omar.demo.authorization.filter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

class CookiesValidator {

  private CookiesValidator() {}

  public static boolean validateCookie(HttpServletRequest request, String property, String value) {
    Cookie[] cookies = request.getCookies();
    if (cookies == null || cookies.length == 0) {
      return false;
    }
    for (Cookie cookie: cookies) {
      String cookieName = cookie.getName();
      String cookieValue = cookie.getValue();

      if (cookieName.equalsIgnoreCase(property)) {
        return cookieValue.equalsIgnoreCase(value);
      }
    }
    return false;
  }
}
