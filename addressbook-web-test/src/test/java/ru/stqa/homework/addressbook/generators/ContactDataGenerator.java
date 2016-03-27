package ru.stqa.homework.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.thoughtworks.xstream.XStream;
import ru.stqa.homework.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yulia on 28.03.2016.
 */
public class ContactDataGenerator {


   @Parameter (names = "-c", description = "Contact count")
  public  int count;

  @Parameter (names = "-f", description = "Target file")
  public String file;

  @Parameter(names = "-d", description = "Contact format")
  public String format;

  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args); // args - те опции которые переданны в командной строке
    } catch (ParameterException ex){
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContacts(count);
    if (format.equals("csv")) {
      saveAsCsv(contacts, new File(file));
    } else if (format.equals("xml")){
      saveAsXml(contacts, new File(file));
    } else {
      System.out.println("Unrecognized format" + format);
    }
  }

  private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class); // внести изменения в груп дата
    String xml = xstream.toXML(contacts);
    Writer writer = new FileWriter(file);
    writer.write(xml);
    writer.close();
  }


  private void saveAsCsv(List<ContactData> contacts, File file) throws IOException { //список который сгенерили generateGroups сохраняем в файл
    Writer writer = new FileWriter(file);                       //открываем файл на запись
    for (ContactData contact : contacts) {                           //проходимся в цикле по всем группам и каждую из них записываем
      writer.write(String.format("%s;%s;%s\n", contact.getFirstName(), contact.getLastName(), contact.getMiddleName()));
    }
    writer.close();                                             //закрыть файл
  }

  private List<ContactData> generateContacts(int count) {    //генерим тестовые данные
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData().withFirstName(String.format("test %s", i)).withLastName(String.format("LastName %s", i))
              .withMiddleName(String.format("MiddleName %s", i)));
    }
    return contacts;
  }


}
