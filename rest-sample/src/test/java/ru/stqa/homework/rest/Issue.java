package ru.stqa.homework.rest;

/**
 * Created by Yulia on 20.04.2016.
 */
public class Issue {

  private int id;
  private String subject;
  private String description;
  private String name;

  public int getId() {
    return id;
  }

  public String getSubject() {
    return subject;
  }

  public String getDescription() {
    return description;
  }


  public Issue whitId(int id) {
    this.id = id;
    return this;
  }

  public Issue withSubject(String subject) {
    this.subject = subject;
    return this;
  }


  public Issue withDescription(String description) {
    this.description = description;
    return this;
  }

  public String getStatus() {
    return name;
  }

  public Issue whitStatus(String name) {
    this.name = name;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Issue issue = (Issue) o;

    if (id != issue.id) return false;
    if (!subject.equals(issue.subject)) return false;
    return description.equals(issue.description);

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + subject.hashCode();
    result = 31 * result + description.hashCode();
    return result;
  }
}
