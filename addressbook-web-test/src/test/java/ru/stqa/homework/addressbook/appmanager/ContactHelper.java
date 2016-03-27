package ru.stqa.homework.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.homework.addressbook.model.ContactData;
import ru.stqa.homework.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yulia on 01.03.2016.
 */
public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("middlename"), contactData.getMiddleName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("email"), contactData.getEmail());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("work"), contactData.getWorkPhone());
    attach(By.name("photo"), contactData.getPhoto());


    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/input[2]"));

  }


  public void editContact(int index) {
    wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img")).get(index).click();
  }

  public void editContactById(int id) {
    wd.findElement(By.cssSelector("a[href='edit.php?id="+id+"']")).click();
  }

  public void submitContactModificatio() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }


  public void create(ContactData contactData, boolean b) {

    fillContactForm(new ContactData().withFirstName("Test").withLastName("Test").withGroup("test1"), true);
    submitContactCreation();
    contactCashe = null;
  }

  public void modify(ContactData contact) {
    editContactById(contact.getId());
    fillContactForm(contact, false);
    submitContactModificatio();
    contactCashe = null;
  }

  public boolean isThisAContact() {
    return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public int count() {
    return wd.findElements(By.name("entry")).size();
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      String name = element.findElement(By.xpath("./td[3]")).getText();
      String lastname = element.findElement(By.xpath("./td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
      ContactData contact = new ContactData().withId(id).withFirstName(name).withLastName(lastname);
      contacts.add(contact);
    }
    return contacts;
  }

   public void delete(ContactData contact) {
    editContactById(contact.getId());
    deleteContact();
     contactCashe = null;
  }

   private Contacts contactCashe = null;

  public Contacts all() {
    if (contactCashe != null) {
      return new Contacts(contactCashe);
    }
    contactCashe = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      String name = element.findElement(By.xpath("./td[3]")).getText();
      String lastName = element.findElement(By.xpath("./td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
      String allPhones = element.findElement(By.xpath("./td[6]")).getText(); //берем инфу из ячейки телефон
      String address = element.findElement(By.xpath("./td[4]")).getText();
      String email = element.findElement(By.xpath("./td[5]")).getText();
      contactCashe.add(new ContactData().withId(id).withFirstName(name).withLastName(lastName)
              .withAllPhones(allPhones).withAddress(address).withEmail(email));
              }
    return new Contacts(contactCashe);
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String middleName = wd.findElement(By.name("middlename")).getAttribute("value");
    String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
    String nickname = wd.findElement(By.name("nickname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String emailTwo = wd.findElement(By.name("email2")).getAttribute("value");
    String emailThree = wd.findElement(By.name("email3")).getAttribute("value");

    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstName(firstname).withMiddleName(middleName).withLastName(lastName)
            .withNickname(nickname).withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work).withAddress(address).withEmail(email)
            .withEmailTwo(emailTwo).withEmailThree(emailThree);
  }

  private void initContactModificationById(int id){ //кликаем на карандашек для редактирвоания
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();
  }

  public void clickInfoContactById(int id) {
            click(By.cssSelector(String.format("a[href='view.php?id=%s']", id)));
       }

  public WebElement infoFromDetailsForm(ContactData contact) {
            clickInfoContactById(contact.getId());
            WebElement element = wd.findElement(By.xpath(".//*[@id='content']"));
           return element;
       }

}

