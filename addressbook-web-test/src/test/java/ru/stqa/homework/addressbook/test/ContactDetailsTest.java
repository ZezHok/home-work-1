package ru.stqa.homework.addressbook.test;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.homework.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Yulia on 23.03.2016.
 */
public class ContactDetailsTest extends TestBase {

  @BeforeMethod
  public  void ensurePreconditions() {
    app.goTo().HomePage();
    if (app.db().contacts().size() == 0) {
      app.goTo().AddNewContactPage();
      app.contact().create(new ContactData().withFirstName("Test").withLastName("Test").withAddress("Street").withEmail("test@mail.ru"), true);
      app.goTo().HomePage();
    }
  }

  @Test (enabled = false)
  public void testContactDetails(){
    ContactData contact = app.db().contacts().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    WebElement contactInfo = app.contact().infoFromDetailsForm(contact);
    String contactInf = cleaned(contactInfo);
    String contactFromEdit = mergeContactInfo(contactInfoFromEditForm);
    assertThat(contactInf, equalTo(contactFromEdit));
    verifyContactListInUI();
  }

  private String mergeContactInfo(ContactData contact) {
    return Arrays.asList(contact.getFirstName(), contact.getMiddleName(), contact.getLastName(), contact.getNickname()
            , contact.getAddress(), contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone()
            , contact.getEmail(), contact.getEmailTwo(), contact.getEmailThree())
            .stream().filter(s -> ! s.equals(""))
            .map(ContactDetailsTest::cleaned)
            .collect(Collectors.joining(""));
  }

  private String cleaned(WebElement contactInfo){
    String contact = contactInfo.getText().replaceAll("www.mail.ru|H:|M:|W:|Member of.*|\n| |\\(|\\)", "");
    return contact;
  }

  public static String cleaned(String phone){
    return  phone.replaceAll("[-()]", "").replace("\n", "");
  }


}
