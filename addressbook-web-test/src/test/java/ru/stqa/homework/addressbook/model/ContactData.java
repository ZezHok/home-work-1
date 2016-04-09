package ru.stqa.homework.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactData {

  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id;
  @Column(name = "firstname")
  private  String firstName;
  @Column(name = "middlename")
  private  String middleName;
  @Column(name = "lastname")
  private  String lastName;
  @Column(name = "mobile")
  @Type(type = "text")
  private  String mobilePhone;
  @Column(name = "home")
  @Type(type = "text")
  private  String homePhone;
  @Column(name = "work")
  @Type(type = "text")
  private  String workPhone;
  @Transient // поле будет пропущенно, не извлечется из БД
  private  String allPhones;
  @Column(name = "address")
  @Type(type = "text")
  private  String address;
  @Column(name = "email")
  @Type(type = "text")
  private  String email;
  @Column(name = "nickname")
  private  String nickname;
  @Column(name = "email2")
  @Type(type = "text")
  private  String emailTwo;
  @Column(name = "email3")
  @Type(type = "text")
  private  String emailThree;
  @Column(name = "photo")
  @Type(type = "text")
  private  String photo;

  @ManyToMany
  @JoinTable(name = "address_in_groups",
          joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
  private Set<GroupData> groups = new HashSet<GroupData>();


  public ContactData withId(int id) {
    this.id = id;
    return this;
  }
  public int getId() {
    return id;
  }

  public ContactData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }
  public String getFirstName() {
    return firstName;
  }

  public ContactData withMiddleName(String middleName) {
    this.middleName = middleName;
    return this;
  }
  public String getMiddleName() {
    return middleName;
  }

  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }
  public String getLastName() {
    return lastName;
  }

  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }
  public String getMobilePhone() {
    return mobilePhone;
  }

  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }
  public String getWorkPhone() {
    return workPhone;
  }

  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }
  public String getHomePhone() {
    return homePhone;
  }

  public ContactData withAllPhones (String allPhones) {
    this.allPhones = allPhones;
    return this;
  }
  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withAddress (String address) {
    this.address = address;
    return this;
  }
  public String getAddress() {
    return address;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }
  public String getEmail() {
    return email;
  }

  public ContactData withNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }
  public String getNickname() {
    return nickname;
  }

  public ContactData withEmailTwo(String emailTwo) {
    this.emailTwo = emailTwo;
    return this;
  }
  public String getEmailTwo() {
    return emailTwo;
  }

  public ContactData withEmailThree(String emailThree) {
    this.emailThree = emailThree;
    return this;
  }
  public String getEmailThree() {
    return emailThree;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }
  public File getPhoto() {
    if(photo != null) {
                  return new File(photo);
              }
            return null;
  }

  public Groups getGroups() {
    return new Groups(groups);
  }

  public ContactData inGroup (GroupData group){
    groups.add(group);
    return this;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';

  }



}
