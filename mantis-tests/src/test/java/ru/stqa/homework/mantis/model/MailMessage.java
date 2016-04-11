package ru.stqa.homework.mantis.model;

/**
 * Created by Yulia on 11.04.2016.
 */
public class MailMessage {
  public String to;
  public String text;

  public MailMessage(String to, String text) {
    this.to = to;
    this.text = text;
  }
}
