package ru.stqa.homework.addressbook.test;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.homework.addressbook.appmanager.ApplicationManager;
import ru.stqa.homework.addressbook.model.ContactData;
import ru.stqa.homework.addressbook.model.Contacts;
import ru.stqa.homework.addressbook.model.GroupData;
import ru.stqa.homework.addressbook.model.Groups;

import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Yulia on 29.02.2016.
 */
public class TestBase {

  protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

  Logger logger = LoggerFactory.getLogger(TestBase.class);

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite()
  public void tearDown() {
    app.stop();
  }

  @BeforeMethod
  public void logTestStart() {
    logger.info("Start test");
  }

  @AfterMethod(alwaysRun = true)
  public void logTestStop() {
    logger.info("Stop test");
  }

  public void verifyGroupListInUI() { // сравниваем инфу из бд и ui по айдишнику и имени
    if (Boolean.getBoolean("verifyUI")) {
      Groups dbGroups = app.db().groups();
      Groups uiGroups = app.group().all();

      assertThat(uiGroups, equalTo(dbGroups.stream()
              .map((g) -> new GroupData().withId(g.getId()).withName(g.getName()))
              .collect(Collectors.toSet())));
    }
  }

  public void verifyContactListInUI() {
    if (Boolean.getBoolean("verifyUI")) { //функция получает системное имя с данным именем и переводит его в boolean
      Contacts dbContacts = app.db().contacts();
      Contacts uiContacts = app.contact().all();

      assertThat(uiContacts, equalTo(dbContacts.stream()
              .map((c) -> new ContactData().withId(c.getId()).withFirstName(c.getFirstName()).withLastName(c.getLastName()))
              .collect(Collectors.toSet())));
    }
  }
}
