package ru.stqa.ptf.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.ptf.addressbook.model.ContactData;

public class ContactHelper extends HelperBase{

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void initContactCreation() {
    wd.findElement(By.linkText("add new")).click();
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("middlename"), contactData.getMiddleName());
    type(By.name("nickname"), contactData.getNickName());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    click(By.name("theform"));
    type(By.name("home"), contactData.getHomePhoneNumber());
    type(By.name("mobile"), contactData.getMobilePhoneNumber());
    type(By.name("work"), contactData.getWorkPhoneNumber());
    type(By.name("fax"), contactData.getFaxPhoneNumber());
    type(By.name("email"), contactData.getEmail_1());
    type(By.name("email2"), contactData.getEmail_2());
    type(By.name("email3"), contactData.getEmail_3());
    type(By.name("homepage"), contactData.getHomePage());
    click(By.name("bday"));
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getBirthDay());
    click(By.name("bmonth"));
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getBirthMonth());
    type(By.name("byear"), contactData.getBirthYear());
    click(By.name("aday"));
    new Select(wd.findElement(By.name("aday"))).selectByVisibleText(contactData.getAnniversaryDay());
    click(By.name("amonth"));
    new Select(wd.findElement(By.name("amonth"))).selectByVisibleText(contactData.getAnniversaryMonth());
    type(By.name("ayear"), contactData.getAnniversaryYear());
    click(By.name("new_group"));
    new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroupName());
    click(By.name("theform"));
    type(By.name("address2"), contactData.getAddress2());
    click(By.name("theform"));
    type(By.name("phone2"), contactData.getPhone2());
    type(By.name("notes"), contactData.getNotes());
  }

  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

}
