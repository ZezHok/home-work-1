package ru.stqa.homework.addressbook;

import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() {
    gotoHomePage();
    editContact();
    deleteContact();
    gotoHomePage();
  }

}
