package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getContactHelper().editContact();
    app.getContactHelper().fillContactForm(new ContactData("Edited", "User", "Employee", "Test", "EDIT_TEST", "Somewhere LLC", "Russia, Moscow", "8-800-555-99-99", "8-800-666-00-00", "8-800-777-11-11", "8-800-888-22-22", "test@mail.ru", "user@mail.ru", "employee@mail.ru", "www.test-employee.com", "1", "January", "1904", "2", "February", "1922", null, "Russia, Moscow", "Home", "Nothing"), false);
    app.getContactHelper().submitContactUpdate();
    app.getNavigationHelper().returnToHomePage();
  }
}
