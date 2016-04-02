package ru.stqa.homework.addressbook.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.homework.addressbook.model.ContactData;
import ru.stqa.homework.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Yulia on 02.03.2016.
 */
public class ContactModificationTest extends TestBase {

  @BeforeMethod
  public  void ensurePreconditions() {
    app.goTo().HomePage();
    if (app.db().contacts().size() == 0)
    {
      app.goTo().AddNewContactPage();
      app.contact().create(new ContactData().withFirstName("Test").withLastName("Test"), true);
      app.goTo().HomePage();
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.db().contacts();
    ContactData modifyContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifyContact.getId()).withFirstName("Test").withLastName("Test");
    app.contact().modify(contact);
    app.goTo().HomePage();
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(modifyContact).withAdded(contact)));
    verifyContactListInUI();
  }

}
