package ru.stqa.homework.addressbook.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.homework.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Yulia on 21.03.2016.
 */
public class ContactAddressTests extends TestBase {

  @BeforeMethod
  public  void ensurePreconditions() {
    app.goTo().HomePage();
    if (app.contact().list().size() == 0) {
      app.goTo().AddNewContactPage();
      app.contact().create(new ContactData().withFirstName("Test").withLastName("Test").withAddress("Street"), true);
      app.goTo().HomePage();
    }
  }

  @Test
  public void testContactAddress() {
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAddress(), equalTo(mergeAddress(contactInfoFromEditForm)));
  }

  private String mergeAddress(ContactData contact) {  // выбрасываем ненужные пустые строки и склеиваем строки
    return Arrays.asList(contact.getAddress())
            .stream().filter((s) -> !s.equals("")) //убарли пустые строки
            .collect(Collectors.joining("\n")); // между склеиваимыми частями будем вставлять энтер
  }


  }

