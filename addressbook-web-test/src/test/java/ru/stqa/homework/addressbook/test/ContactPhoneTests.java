package ru.stqa.homework.addressbook.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.homework.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Yulia on 20.03.2016.
 */
public class ContactPhoneTests extends TestBase {

  @BeforeMethod
  public  void ensurePreconditions() {
    app.goTo().HomePage();
    if (app.db().contacts().size() == 0) {
      app.goTo().AddNewContactPage();
      app.contact().create(new ContactData().withFirstName("Test").withLastName("Test")
              .withMobilePhone("111").withWorkPhone("222"), true);
      app.goTo().HomePage();
    }
  }

  @Test
  public void testContactPhone() {
     ContactData contact = app.db().contacts().iterator().next(); // загружаем множество контактов
     ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact); // выбираем контакт случайным образом
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));  //contact.getAllPhones() загружаем телефоны с главной страницы
  }

  private String mergePhones(ContactData contact) {  // выбрасываем ненужные пустые строки и склеиваем строки
    return Arrays.asList(contact.getHomePhone(),contact.getMobilePhone(), contact.getWorkPhone())
            .stream().filter((s) -> !s.equals("")) //убарли пустые строки
            .map(ContactPhoneTests::cleaned) //удаляем все ненужные символы
            .collect(Collectors.joining("\n")); // между склеиваимыми частями будем вставлять энтер
  }

  public static String cleaned (String phone){  //вспомогательная функция которая приводит телефон на главной странице к очищенному виду: без тире, скобок, пробелов и тд
      return phone.replaceAll("\\s", "").replaceAll("[-()]", ""); // в скобках указаны регуляоные выражения
    }
}
