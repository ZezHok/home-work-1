package ru.stqa.homework.addressbook.test;

import org.apache.bcel.classfile.Method;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.homework.addressbook.appmanager.ApplicationManager;

import java.util.Arrays;

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

  @AfterSuite ()
  public void tearDown() {
    app.stop();
  }

  @BeforeMethod
  public void logTestStart() {
    logger.info("Start test");
  }

  @AfterMethod(alwaysRun= true)
  public void logTestStop() {
    logger.info("Stop test");
  }

}
