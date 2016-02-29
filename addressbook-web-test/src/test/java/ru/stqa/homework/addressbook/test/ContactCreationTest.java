package ru.stqa.homework.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.homework.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() {
    gotoAddNewContactPage();
    fillContactForm(new ContactData("Test", "Test", "Test", "89030000000", "test@mail.ru"));
    submitContactCreation();
    gotoHomePage();
  }


}
