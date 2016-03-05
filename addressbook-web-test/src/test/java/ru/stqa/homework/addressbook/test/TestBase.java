package ru.stqa.homework.addressbook.test;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.homework.addressbook.appmanager.ApplicationManager;

/**
 * Created by Yulia on 29.02.2016.
 */
public class TestBase {

  protected final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod
    public void tearDown() {
    app.stop();
  }

}
