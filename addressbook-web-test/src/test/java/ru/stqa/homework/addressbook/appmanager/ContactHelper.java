package ru.stqa.homework.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.homework.addressbook.model.ContactData;

/**
 * Created by Yulia on 01.03.2016.
 */
public class ContactHelper {
  FirefoxDriver wd;

  public ContactHelper(FirefoxDriver wd) {
    this.wd =wd;
  }

  public void submitContactCreation() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void fillContactForm(ContactData contactData) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstName());
    wd.findElement(By.name("middlename")).click();
    wd.findElement(By.name("middlename")).clear();
    wd.findElement(By.name("middlename")).sendKeys(contactData.getMiddleName());
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(contactData.getLastName());
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys(contactData.getMobileNumber());
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
   wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
  }

  public void deleteContact() {
      wd.findElement(By.xpath("//div[@id='content']/form[2]/input[2]")).click();
  }

  public void editContact() {
      wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img")).click();
  }
}
