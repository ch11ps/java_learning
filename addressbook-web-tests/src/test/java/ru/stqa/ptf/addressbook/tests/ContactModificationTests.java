package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.Set;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstName("Test").withLastName("User").withAddress("Moscow").withMobile("88528009080")
              .withEmail("java@mail.ru").withGroup("test1"), true);
      app.goTo().homePage();
    }
  }

  @Test
  public void testContactModification() {
    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstName("Test").withLastName("User").withAddress("City")
            .withMobile("88009001020").withEmail("ya@mail.ru").withGroup("test1");
    app.contact().modify(contact);
    app.goTo().homePage();
    Set<ContactData> after = app.contact().all();
    if (before.size() != 0) {
      Assert.assertEquals(after.size(), before.size());
    } else {
      Assert.assertEquals(after.size(), before.size() + 1);
    }
    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}
