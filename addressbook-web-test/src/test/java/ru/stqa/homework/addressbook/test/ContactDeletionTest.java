package ru.stqa.homework.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.homework.addressbook.model.ContactData;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThisAContact()){
      app.getNavigationHelper().gotoAddNewContactPage();
      app.getContactHelper().createContact(new ContactData("Test", null, null, null, null, "test1"),true);
      app.getNavigationHelper().gotoHomePage();
    }
    app.getContactHelper().editContact();
    app.getContactHelper().deleteContact();
    app.getNavigationHelper().gotoHomePage();

  }

}
