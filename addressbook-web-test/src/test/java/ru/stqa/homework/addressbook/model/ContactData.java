package ru.stqa.homework.addressbook.model;

public class ContactData {

  private int id;
  private  String firstName;
  private  String middleName;
  private  String lastName;
  private  String group;
  private  String mobilePhone;
  private  String homePhone;
  private  String workPhone;
  private  String allPhones;
  private  String address;
  private  String email;
  private  String nickname;
  private  String emailTwo;
  private  String emailThree;


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

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }
  public String getGroup() {
    return group;
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
