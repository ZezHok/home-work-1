package ru.stqa.homework.addressbook.test;

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

  @Test
  public void testContactPhone() {
    app.goTo().HomePage();
    ContactData contact = app.contact().all().iterator().next(); // загружаем множество контактов
    //нужно создать проверку предусловий, если нет ни одного контакта то создать его


    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact); // выбираем контакт случайным образом
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));  //contact.getAllPhones() загружаем телефоны с главной страницы
  }

  private String mergePhones(ContactData contact) {  // выбрасываем ненужные пустые строки и склеиваем строки
    return Arrays.asList(contact.getHomePhone(),contact.getMobilePhone(), contact.getWorkPhone())
            .stream().filter((s) -> s.equals("")) //убарли пустые строки
            .map(ContactPhoneTests::cleaned) //удаляем все ненужные символы
            .collect(Collectors.joining("\n")); // между склеиваимыми частями будем вставлять энтер
  }

  public static String cleaned (String phone){  //вспомогательная функция которая приводит телефон на главной странице к очищенному виду: без тире, скобок, пробелов и тд
      return phone.replaceAll("\\s", "").replaceAll("[-()]", ""); // в скобках указаны регуляоные выражения
    }
}
