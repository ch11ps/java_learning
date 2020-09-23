package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;
import ru.stqa.ptf.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletingTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondtion() {
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstName("User").withLastName("Employee").withAddress("SaintP").withMobile("8-800-555-99-99")
              .withEmail("sp@mail.ru").withGroup("test1"), true);
      app.goTo().homePage();
    }
  }

  @Test
  public void testContactDeleting() {
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Contacts after = app.contact().all();
    if (before.size()!=0) {
      assertThat(after.size(),equalTo(before.size() - 1));
    } else {
      assertThat(after.size(),equalTo(before.size()));
    }
    assertThat(after, equalTo(before.without(deletedContact)));
  }
}


