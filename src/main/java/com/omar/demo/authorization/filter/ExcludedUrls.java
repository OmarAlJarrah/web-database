package com.omar.demo.authorization.filter;


class ExcludedUrls {

  private ExcludedUrls() {}

  public static boolean validateUser(String url) {
    return url.contains("login")
            || url.contains("home")
            || url.equals("")
            || url.contains("async");
  }

  public static boolean validateAdmin(String url) {
    return !url.contains("admin");
  }
}
