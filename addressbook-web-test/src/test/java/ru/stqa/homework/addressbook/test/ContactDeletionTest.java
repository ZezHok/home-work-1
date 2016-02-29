package ru.stqa.homework.addressbook.test;

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
