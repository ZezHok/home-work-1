package ru.stqa.homework.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() {
    gotoAddNewContactPage();
    fillContactForm(new ContactData("Test", "Test", "Test", "89030000000", "test@mail.ru"));
    submitContactCreation();
    gotoHomePage();
  }


}
