package ru.stqa.homework.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.homework.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().gotoHomePage();
    if (!app.getContactHelper().isThisAContact()) {
      app.getNavigationHelper().gotoAddNewContactPage();
      app.getContactHelper().createContact(new ContactData("Test", null, "Test", null, null, "test1"), true);
      app.getNavigationHelper().gotoHomePage();
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().editContact(0);
    app.getContactHelper().deleteContact();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);
    ;

    before.remove(0);
    Assert.assertEquals(before, after);

  }

}
