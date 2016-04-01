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
public class ContactsEmailTests extends TestBase {

  @BeforeMethod
  public  void ensurePreconditions() {
    app.goTo().HomePage();
    if (app.db().contacts().size() == 0) {
      app.goTo().AddNewContactPage();
      app.contact().create(new ContactData().withFirstName("Test").withLastName("Test").withEmail("test@mail.ru"), true);
      app.goTo().HomePage();
    }
  }

  @Test
  public void testContactEmail() {
    ContactData contact = app.db().contacts().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getEmail(), equalTo(mergeEmail(contactInfoFromEditForm)));
  }

  private String mergeEmail(ContactData contact) {  // выбрасываем ненужные пустые строки и склеиваем строки
    return Arrays.asList(contact.getEmail())
            .stream().filter((s) -> !s.equals("")) //убарли пустые строки
            .map(ContactsEmailTests::cleaned) //удаляем все ненужные символы
            .collect(Collectors.joining("\n")); // между склеиваимыми частями будем вставлять энтер
  }

  public static String cleaned (String email){  //вспомогательная функция которая приводит телефон на главной странице к очищенному виду: без тире, скобок, пробелов и тд
    return email.replaceAll("\\s", ""); // в скобках указаны регулярные выражения
  }
}
