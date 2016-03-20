package ru.stqa.homework.addressbook.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.homework.addressbook.model.ContactData;
import ru.stqa.homework.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.AssertJUnit.assertEquals;

public class ContactDeletionTest extends TestBase {

  @BeforeMethod
  public  void ensurePreconditions() {
    app.goTo().HomePage();
    if (app.contact().list().size() == 0) {
      app.goTo().AddNewContactPage();
      app.contact().create(new ContactData().withFirstName("Test").withLastName("Test"), true);
      app.goTo().HomePage();
    }
  }

  @Test
  public void testContactDeletion() {
    Contacts before = app.contact().all();
    ContactData deleteContact = before.iterator().next();

    app.contact().delete(deleteContact);
    app.goTo().HomePage();
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size() -1);
    assertThat(after, equalTo(before.without(deleteContact)));



  }



}
