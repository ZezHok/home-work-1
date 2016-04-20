package ru.stqa.homework.mantis.tests;



import org.testng.annotations.Test;
import ru.stqa.homework.mantis.model.Issue;
import ru.stqa.homework.mantis.model.Project;


import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by Yulia on 17.04.2016.
 */
public class SoapTests extends TestBase {

  @Test
  public void testGetProject() throws MalformedURLException, ServiceException, RemoteException {
    Set<Project> projects = app.soap().getProjects();
    System.out.println(projects.size());
    for (Project project : projects) {
      System.out.println(project.getName());
    }
  }

  @Test
  public void testCreateIssue() throws MalformedURLException, ServiceException, RemoteException {
    Set<Project> projects = app.soap().getProjects();
    Issue issue = new Issue().withSummary("Test issue").
            withDescription("Test issue descroption").withProject(projects.iterator().next());
    Issue created = app.soap().addIssue(issue);
    assertEquals(issue.getSummary(), created.getSummary());
  }

  @Test
  public void testIsIssueOpen() throws Exception {
    skipIfNotFixed(0000001);
    Set<Project> projects = app.soap().getProjects();
    Issue issue = new Issue().withSummary("Test issue").
            withDescription("Test issue description").withProject(projects.iterator().next());
    Issue created = app.soap().addIssue(issue);
    assertEquals(issue.getSummary(), created.getSummary());

  }
}