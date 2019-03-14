package com.phoenix.bo;


public class Student {

  private  Integer id;
  private String name;
  private String sex;
  private long birthday;
  private long specialty;


  public Integer getId() {
    return id;
  }

  public void setId( Integer id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }


  public long getBirthday() {
    return birthday;
  }

  public void setBirthday(long birthday) {
    this.birthday = birthday;
  }


  public long getSpecialty() {
    return specialty;
  }

  public void setSpecialty(long specialty) {
    this.specialty = specialty;
  }

}
