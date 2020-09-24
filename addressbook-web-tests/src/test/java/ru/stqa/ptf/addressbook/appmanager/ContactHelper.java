package ru.stqa.ptf.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.ptf.addressbook.model.ContactData;
import ru.stqa.ptf.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Edit / add")
            && isElementPresent(By.name("Enter"))) {
      return;
    }

    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("email"), contactData.getEmail());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
    wd.findElement(By.cssSelector("div.msgbox"));
  }

  public void submitContactUpdate() {
    click(By.name("update"));
  }

  public void create(ContactData contact, boolean creation) {
    initContactCreation();
    fillContactForm(contact, true);
    submitContactCreation();
  }

  public void modify(ContactData contact) {
    fillContactForm(contact, false);
    submitContactUpdate();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }

    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.cssSelector("tr[name=\"entry\"]"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String[] phones = cells.get(5).getText().split("\n");
      ContactData contact = new ContactData()
              .withId(id).withLastName(lastname).withFirstName(firstname)
              .withHomePhone(phones[0]).withMobilePhone(phones[1]).withWorkPhone(phones[2]);
      contactCache.add(contact);
    }
    return new Contacts(contactCache);
  }

  public ContactData infoFromEditForm (ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname)
            .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
  }

  public void initContactModificationById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();
  }
}
