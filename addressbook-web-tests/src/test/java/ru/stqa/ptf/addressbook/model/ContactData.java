package ru.stqa.ptf.addressbook.model;

public class ContactData {
  private final String firstName;
  private final String lastName;
  private final String middleName;
  private final String nickName;
  private final String title;
  private final String company;
  private final String address;
  private final String homePhoneNumber;
  private final String mobilePhoneNumber;
  private final String workPhoneNumber;
  private final String faxPhoneNumber;
  private final String email_1;
  private final String email_2;
  private final String email_3;
  private final String homePage;
  private final String birthDay;
  private final String birthMonth;
  private final String birthYear;
  private final String anniversaryDay;
  private final String anniversaryMonth;
  private final String anniversaryYear;
  private final String groupName;
  private final String address2;
  private final String phone2;
  private final String notes;

  public ContactData(String firstName, String lastName, String middleName, String nickName, String title, String company, String address, String homePhoneNumber, String mobilePhoneNumber, String workPhoneNumber, String faxPhoneNumber, String email_1, String email_2, String email_3, String homePage, String birthDay, String birthMonth, String birthYear, String anniversaryDay, String anniversaryMonth, String anniversaryYear, String groupName, String address2, String phone2, String notes) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.middleName = middleName;
    this.nickName = nickName;
    this.title = title;
    this.company = company;
    this.address = address;
    this.homePhoneNumber = homePhoneNumber;
    this.mobilePhoneNumber = mobilePhoneNumber;
    this.workPhoneNumber = workPhoneNumber;
    this.faxPhoneNumber = faxPhoneNumber;
    this.email_1 = email_1;
    this.email_2 = email_2;
    this.email_3 = email_3;
    this.homePage = homePage;
    this.birthDay = birthDay;
    this.birthMonth = birthMonth;
    this.birthYear = birthYear;
    this.anniversaryDay = anniversaryDay;
    this.anniversaryMonth = anniversaryMonth;
    this.anniversaryYear = anniversaryYear;
    this.groupName = groupName;
    this.address2 = address2;
    this.phone2 = phone2;
    this.notes = notes;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getNickName() {
    return nickName;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
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

  public String getWorkPhoneNumber() {
    return workPhoneNumber;
  }

  public String getFaxPhoneNumber() {
    return faxPhoneNumber;
  }

  public String getEmail_1() {
    return email_1;
  }

  public String getEmail_2() {
    return email_2;
  }

  public String getEmail_3() {
    return email_3;
  }

  public String getHomePage() {
    return homePage;
  }

  public String getBirthDay() {
    return birthDay;
  }

  public String getBirthMonth() {
    return birthMonth;
  }

  public String getBirthYear() {
    return birthYear;
  }

  public String getAnniversaryDay() {
    return anniversaryDay;
  }

  public String getAnniversaryMonth() {
    return anniversaryMonth;
  }

  public String getAnniversaryYear() {
    return anniversaryYear;
  }

  public String getGroupName() {
    return groupName;
  }

  public String getAddress2() {
    return address2;
  }

  public String getPhone2() {
    return phone2;
  }

  public String getNotes() {
    return notes;
  }
}