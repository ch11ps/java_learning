package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletingTests extends TestBase {

  @Test
  public void testContactDeleting() {
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("User", "Employee", "SaintP", "555555", "8-800-555-99-99", "sp@mail.ru", "test1"));
      app.getNavigationHelper().returnToHomePage();
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().delteSelectedContact();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);
  }

}
