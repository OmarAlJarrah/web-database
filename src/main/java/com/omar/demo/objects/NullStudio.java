package com.omar.demo.objects;

import java.util.ArrayList;
import java.util.List;

public class NullStudio implements StudioInterface {
  @Override
  public long getId() {
    return 0L;
  }

  @Override
  public String getName() {
    return "";
  }

  @Override
  public String getLocation() {
    return "";
  }


  public long getStartYear() {
    return 0L;
  }
}
