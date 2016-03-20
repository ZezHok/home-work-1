package ru.stqa.homework.addressbook.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.homework.addressbook.model.GroupData;
import ru.stqa.homework.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;

/**
 * Created by Yulia on 02.03.2016.
 */
public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public  void ensurePreconditions() {
    app.goTo().GroupPage();
    if (app.group().list().size() == 0) {
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testGroupModification() {
    Groups before = app.group().all();
    GroupData modifyGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifyGroup.getId()).withName("test1").withHeader("test2").withFooter("test3");
    app.group().modify(group);
    Groups after = app.group().all();
    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.without(modifyGroup).withAdded(group)));
  }


}
