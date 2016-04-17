package ru.stqa.homework.mantis.appmanager;

import org.openqa.selenium.By;

/**
 * Created by Yulia on 17.04.2016.
 */
public class ChangePassword extends HelperBase {

  public ChangePassword(ApplicationManager app) throws Exception {
    super(app);
  }


  public void login(String username, String password){
    wd.get(app.getProperty("web.baseUrl"));
    type(By.name("username"),username);
    type(By.name("password"),password);
    click(By.cssSelector("input[value='Login']"));
  }
}
