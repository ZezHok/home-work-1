package ru.stqa.homework.addressbook;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() {
    gotoGroupPage();
    selectedGroup();
    deleteSelectedGroup();
    returnToGroupPage();
  }


}
