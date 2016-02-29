package ru.stqa.homework.addressbook.test;

import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().editContact();
    app.getContactHelper().deleteContact();
    app.getNavigationHelper().gotoHomePage();
  }

}
