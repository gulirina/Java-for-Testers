package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class TwiceContactCreationTests extends Base {

  @Test
  public void testNewContactCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    
    
    //save old
    List<ContactData> oldList = app.getContactHelper().getContacts();
    //action    
    ContactData contact = new ContactData();
    contact.firstName ="Jane";
    contact.secondName = "Marple";
    app.getContactHelper().initNewContactCreation();
	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitNewContactCreation();
    //add first contact
    oldList.add(contact);
    
    app.getContactHelper().addNext();
    ContactData contact1 = new ContactData();
    contact1.firstName ="Hercules";
    contact1.secondName = "Poirot";
    app.getContactHelper().fillContactForm(contact1);
    app.getContactHelper().submitNewContactCreation();
    app.getContactHelper().goToHomePage();
    //save new
    List<ContactData> newList = app.getContactHelper().getContacts();
    //compare states
    oldList.add(contact1);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }

}