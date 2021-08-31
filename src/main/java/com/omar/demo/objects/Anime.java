package com.omar.demo.objects;


public class Anime implements DataRecord { // package-private
  private final long id;
  private String name;
  private int yearOfProduction;
  private int rating;
  private int watchCount;
  private final long creatorId;

  private Anime(Builder builder) {
    this.id = builder.id;
    this.name = builder.name;
    this.yearOfProduction = builder.yearOfProduction;
    this.rating = builder.rating;
    this.watchCount = builder.watchCount;
    this.creatorId = builder.creatorId;
  }

  @Override
  public long getId() {
    return id;
  }

  public long getCreatorId() {
    return creatorId;
  }

  public String getName() {
    return name;
  }

  public int getYearOfProduction() {
    return yearOfProduction;
  }

  public int getRating() {
    return rating;
  }

  public int getWatchCount() {
    return watchCount;
  }



  public static class Builder {
    private long id;
    private String name = "";
    private int yearOfProduction;
    private int rating;
    private int watchCount;
    private long creatorId;

    public Builder setId(long id) {
      this.id = id;
      return this;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public Builder setYearOfProduction(int yearOfProduction){
      this.yearOfProduction = yearOfProduction;
      return this;
    }

    public Builder setRating(int rating) {
      this.rating = rating;
      return this;
    }

    public Builder setWatchCount(int watchCount) {
      this.watchCount = watchCount;
      return this;
    }

    public Builder setCreatorId(long creatorId) {
      this.creatorId = creatorId;
      return this;
    }

    private boolean validateBuiltObject() {
      return this.id != 0 && !this.name.equals("") && this.creatorId != 0;
    }

    public Object create() {
      if (validateBuiltObject()) {
        return new Anime(this);
      } else {
        return new NullAnime();
      }
    }
  }

}
