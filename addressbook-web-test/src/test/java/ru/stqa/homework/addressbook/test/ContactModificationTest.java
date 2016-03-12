package ru.stqa.homework.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.homework.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by Yulia on 02.03.2016.
 */
public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification(){
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThisAContact()){
      app.getNavigationHelper().gotoAddNewContactPage();
      app.getContactHelper().createContact(new ContactData("Test", null, null, null, null, "test1"),true);
      app.getNavigationHelper().gotoHomePage();
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().editContact(0);
    app.getContactHelper().fillContactForm(new ContactData("Test", null, null, "89030000000", null, null), false);
    app.getContactHelper().submitContactModificatio();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
  }
}
