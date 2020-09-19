package ru.stqa.ptf.addressbook.model;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String firstName;
  private String lastName;
  private String address;
  private String homePhoneNumber;
  private String mobilePhoneNumber;
  private String email;
  private String group;

  public ContactData(int id, String firstName, String lastName, String address, String homePhoneNumber, String mobilePhoneNumber, String email, String group) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.homePhoneNumber = homePhoneNumber;
    this.mobilePhoneNumber = mobilePhoneNumber;
    this.email = email;
    this.group = group;
  }

  public ContactData(String firstName, String lastName, String address, String homePhoneNumber, String mobilePhoneNumber, String email, String group) {
    this.id = Integer.MAX_VALUE;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.homePhoneNumber = homePhoneNumber;
    this.mobilePhoneNumber = mobilePhoneNumber;
    this.email = email;
    this.group = group;
  }

  public int getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getAddress() {
    return address;
  }

  public String getHomePhoneNumber() {
    return homePhoneNumber;
  }

  public String getMobilePhoneNumber() {
    return mobilePhoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public String getGroup() {
    return group;
  }

}