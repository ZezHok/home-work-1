package ru.stqa.homework.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.homework.addressbook.model.ContactData;

/**
 * Created by Yulia on 02.03.2016.
 */
public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification(){
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().editContact();
    app.getContactHelper().fillContactForm(new ContactData("Test", "Test", "Test", "89030000000", "test@mail.ru"));
    app.getContactHelper().submitContactModificatio();
    app.getNavigationHelper().gotoHomePage();

  }
}
