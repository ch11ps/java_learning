package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletingTests extends TestBase {

  @Test
  public void testContactDeleting() {
    app.getContactHelper().selectContact();
    app.getContactHelper().delteSelectedContact();
  }

}
