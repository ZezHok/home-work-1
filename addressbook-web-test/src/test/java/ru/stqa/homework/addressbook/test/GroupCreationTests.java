package ru.stqa.homework.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.homework.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
    public void testsGroupCreation() {
    app.gotoGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("test1", "test2", "test3"));
    app.submitGroupCreation();
    app.returnToGroupPage();
    }

}
