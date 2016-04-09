package ru.stqa.homework.addressbook.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stqa.homework.addressbook.model.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Yulia on 09.04.2016.
 */
public class ContactAddGroup extends TestBase{
  @BeforeClass
  public void ensurePreconditions(){
    if (app.db().groups().size() == 0)
    {   app.goTo().GroupPage();
      app.group().create(new GroupData().withName("test1").withHeader("test2").withFooter("test3"));
    }

    if (app.db().contacts().size() == 0){
      app.goTo().HomePage();
      Groups groups = app.db().groups();
      ContactData contact = new ContactData().withFirstName("Test").withLastName("Test1").inGroup(groups.iterator().next());
      app.contact().create(contact, true);
    }

  }

  @Test
  public void testContactAddGroup()  {
    Contacts contacts =  app.db().contacts();
    Groups groups =  app.db().groups();
    ContactsAndGroups before =  app.db().contactsGroups();
    ContactData contact = contacts.iterator().next();
    int  contactId = contact.getId();
    GroupData group = groups.iterator().next();
    int groupId = group.getId();
    String groupName =  group.getName();
    ContactsGroupsData contactsGroup = new ContactsGroupsData().withContactId(contactId).withGroupId(groupId);
    app.contact().selectContactById(contactId);
    app.contact().addToGroup(groupName);
    ContactsAndGroups after =  app.db().contactsGroups();
    assertThat(after, equalTo(before.withAdded(contactsGroup)));
  }

}
