package ru.stqa.ptf.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;
import ru.stqa.ptf.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstName("Test").withLastName("User").withAddress("Moscow").withMobilePhone("88528009080")
              .withEmail("java@mail.ru").withGroup("test1"), true);
      app.goTo().homePage();
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstName("Test").withLastName("User").withAddress("City")
            .withMobilePhone("88009001020").withEmail("ya@mail.ru").withGroup("test1");
    app.contact().initContactModificationById(113);
    app.contact().modify(contact);
    app.goTo().homePage();
    if (before.size() != 0) {
      assertThat(app.contact().count(), equalTo(before.size()));
    } else {
      assertThat(app.contact().count(), equalTo(before.size() + 1));
    }
    Contacts after = app.contact().all();
    MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.without(modifiedContact).withAdded(contact)));
  }
}
