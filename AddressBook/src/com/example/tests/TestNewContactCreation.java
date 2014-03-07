package com.example.tests;

import org.testng.annotations.Test;



public class TestNewContactCreation extends Base {

  @Test
  public void testNewContactCreation() throws Exception {
    openMainPage();
    initNewContactCreation();
    ContactData contact = new ContactData();
    contact.firstName ="Jane";
    contact.secondName = "Doe";
    contact.mainAddress = "10, Downing St";
    contact.hPhone = "+9876543210";
    contact.mPhone = "+9876543210";
    contact.wPhone = "+9876543210";
    contact.email1 = "jane@doe.com";
    contact.email2 = "jane.doe@home.com";
    contact.bDay = "18";
    contact.bMonth = "August";
    contact.bYear = "1987";
    contact.groupName = "Sparkle_Group";
    contact.supAddress = "221b, Baker St";
    contact.supPhone = "+9876543210";
	fillContactForm(contact);
    submitNewContactCreation();
    goToHomePage();
  }
  

}
