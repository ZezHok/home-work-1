package ru.stqa.homework.mantis.model;

/**
 * Created by Yulia on 17.04.2016.
 */
public class Issue {

  private int id;
  private String summary;
  private String description;
  private String project;

  public int getId() {
    return id;
  }

  public Issue withId(int id) {
    this.id = id;
    return this;
  }

  public String getSummary() {
    return summary;
  }

  public Issue withSummary(String summary) {
    this.summary = summary;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public Issue withDescription(String description) {
    this.description = description;
    return this;
  }

  public String getProject() {
    return project;
  }

  public Issue withProject(String project) {
    this.project = project;
    return this;
  }
}
