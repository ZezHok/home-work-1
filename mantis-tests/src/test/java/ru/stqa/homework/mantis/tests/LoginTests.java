package ru.stqa.homework.mantis.tests;

import org.testng.annotations.Test;
import ru.stqa.homework.mantis.appmanager.HttpSession;

import java.io.IOException;
import static org.testng.Assert.assertTrue;

/**
 * Created by Yulia on 09.04.2016.
 */
public class LoginTests extends TestBase{

  @Test
  public void testLogin() throws IOException {
    HttpSession session = app.newSession();
    assertTrue(session.login("administrator", "root"));
    assertTrue(session.isLogginAs("administrator"));
  }
}
