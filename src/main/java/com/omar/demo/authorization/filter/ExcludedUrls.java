package com.omar.demo.authorization.filter;


class ExcludedUrls {

  private ExcludedUrls() {}

  public static boolean validate(String url) {
    return url.contains("login")
            || url.contains("home")
            || url.equals("");
  }
}
