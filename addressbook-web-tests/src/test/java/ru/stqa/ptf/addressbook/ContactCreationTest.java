package ru.stqa.ptf.addressbook;

import org.testng.annotations.*;

public class ContactCreationTest extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    initContactCreation();
    fillContactForm(new ContactData("Test", "User", "Employee", "Somebody", "TEST", "Somewhere LLC", "Russia, Moscow", "8-800-555-99-99", "8-800-666-00-00", "8-800-777-11-11", "8-800-888-22-22", "test@mail.ru", "user@mail.ru", "employee@mail.ru", "www.test-employee.com", "1", "January", "1904", "2", "February", "1922", "test1", "Russia, Moscow", "Home", "Nothing"));
    submitContactCreation();
    returnToHomePage();
  }

}

