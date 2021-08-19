package com.omar.demo.objects;

public class NullAnime implements AnimeInterface {

  @Override
  public int getCreatorId() {
    return 0;
  }

  @Override
  public String getName() {
    return "";
  }

  @Override
  public long getId() {
    return 0;
  }

  public int getYearOfProduction() {
    return 0;
  }

  public int getRating() {
    return 0;
  }

  public int getWatchCount() {
    return 0;
  }
}
