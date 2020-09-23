package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletingTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondtion() {
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData("User", "Employee", "SaintP", "8-800-555-99-99", "sp@mail.ru", "test1"), true);
      app.goTo().homePage();
    }
  }

  @Test
  public void testContactDeleting() {
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().delete(index);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
    Assert.assertEquals(before, after);
  }
}


