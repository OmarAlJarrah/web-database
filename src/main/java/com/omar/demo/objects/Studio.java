package com.omar.demo.objects;


public class Studio implements StudioInterface {
  private long id = 0L;
  private String name = "";
  private String location = "";
  private long startYear = 0L;

  private Studio(Builder builder) {
    this.id = builder.id;
    this.name = builder.name;
    this.location = builder.location;
    this.startYear = builder.startYear;
  }

  @Override
  public long getId() {
    return id;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getLocation() {
    return location;
  }


  public long getStartYear() {
    return startYear;
  }


  public static class Builder {
    private long id = 0;
    private String name = "";
    private String location = "";
    private long startYear = 0;


    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public Builder setId(long id) {
      this.id = id;
      return this;
    }

    public Builder setStartYear(long startYear) {
      this.startYear = startYear;
      return this;
    }

    private boolean validate() {
      return (this.id != 0) && (!this.name.equals("")) && (!this.location.equals(""));
    }

    public Object build() {
      if (validate()) {
        return new Studio(this);
      } else {
        return new NullStudio();
      }
    }
  }
}
