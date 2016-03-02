package ru.stqa.homework.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.homework.addressbook.model.GroupData;

/**
 * Created by Yulia on 02.03.2016.
 */
public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectedGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();

  }
}
