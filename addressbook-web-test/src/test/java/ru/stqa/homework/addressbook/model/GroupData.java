package ru.stqa.homework.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@XStreamAlias("group") // анотация того что сохраним в файл формата xml
@Entity // анатация для того чтобы сделать привязку к БД
@Table(name ="group_list") // делаем привязку к конкретной таблице в БД
public class GroupData {

  @XStreamOmitField // анотация того что сохраним в файл формата xml
  @Id // подсказка что это айдишник
  @Column(name = "group_id") // тк имена атрибутов не совпадают мы должны расставить подсказки для hibernate
  private int id = Integer.MAX_VALUE;
  @Expose
  @Column(name = "group_name") // перобразование типов происходит автоматически
  private  String name;
  @Expose
  @Column(name = "group_header")
  @Type(type = "text") // иногда нужно подсказать в какой тип нужно преобразовать
  private  String header;
  @Expose
  @Column(name = "group_footer")
  @Type(type = "text")
  private  String footer;

  public GroupData withHeader(String header) {
    this.header = header;
    return this;
  }

  public GroupData withFooter(String footer) {
    this.footer = footer;
    return this;
  }

  public GroupData withName(String name) {
    this.name = name;
    return this;
  }

  public GroupData withId(int id) {
    this.id = id;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

    if (id != groupData.id) return false;
    return name != null ? name.equals(groupData.name) : groupData.name == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
  }

}
