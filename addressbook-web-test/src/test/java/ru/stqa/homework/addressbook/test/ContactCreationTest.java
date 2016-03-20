package ru.stqa.homework.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.homework.addressbook.model.ContactData;
import ru.stqa.homework.addressbook.model.Contacts;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() {
    app.goTo().HomePage();
    Contacts before = app.contact().all();
    app.goTo().AddNewContactPage();
    ContactData contact = new ContactData().withFirstName("Test").withLastName("Test").withGroup("test1");
    app.contact().create(contact, true);
    app.goTo().HomePage();
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }


}
