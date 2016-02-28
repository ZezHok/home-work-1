package ru.stqa.homework.addressbook;

public class ContactData {
  private final String firstName;
  private final String middleName;
  private final String lastName;
  private final String mobileNumber;
  private final String email;

  public ContactData(String firstName, String middleName, String lastName, String mobileNumber, String email) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.mobileNumber = mobileNumber;
    this.email = email;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public String getEmail() {
    return email;
  }
}
