package ru.stqa.homework.addressbook.test;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {


  @Test
  public void GroupDeletionTests() {
    app.gotoGroupPage();
    app.selectedGroup();
    app.deleteSelectedGroup();
    app.returnToGroupPage();
  }


}
