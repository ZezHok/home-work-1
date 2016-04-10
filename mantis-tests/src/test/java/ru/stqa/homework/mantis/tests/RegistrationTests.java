package ru.stqa.homework.mantis.tests;

import org.testng.annotations.Test;

/**
 * Created by Yulia on 10.04.2016.
 */
public class RegistrationTests extends TestBase {

  @Test
  public void testRegistration() {
    app.registration().start("user1", "user1@localhost.localdomain");
  }
}
