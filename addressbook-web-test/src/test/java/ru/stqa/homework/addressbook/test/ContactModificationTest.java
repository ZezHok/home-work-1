package ru.stqa.homework.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.homework.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Yulia on 02.03.2016.
 */
public class ContactModificationTest extends TestBase {

  @BeforeMethod
  public  void ensurePreconditions() {
    app.goTo().HomePage();
    if (app.contact().list().size() == 0) {
      app.goTo().AddNewContactPage();
      app.contact().create(new ContactData("Test", null, "Test", null, null, null), true);
      app.goTo().HomePage();
    }
  }

  @Test
  public void testContactModification() {
    List<ContactData> before = app.contact().list();
    int index = 0;
    ContactData contact = new ContactData(before.get(index).getId(), "Test", null, "Test", null, null, null);

    app.contact().modify(index, contact);
    app.goTo().HomePage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
