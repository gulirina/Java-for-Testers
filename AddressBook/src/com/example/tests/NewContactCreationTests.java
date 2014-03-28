package com.example.tests;

import static com.example.fw.ContactHelper.CREATION;

import java.util.Collections;
import java.util.List;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class NewContactCreationTests extends Base {
	

	
  @Test(dataProvider = "randomValidContactGenerator")
  public void testNewContactCreation (ContactData contact) throws Exception {
    app.navigateTo().mainPage();
    //save old
    List<ContactData> oldList = app.getContactHelper().getContacts();
    //action   
    app.getContactHelper().initNewContactCreation();
    app.getContactHelper().fillContactForm(contact, CREATION);
    app.getContactHelper().submitNewContactCreation();
    app.getContactHelper().goToHomePage();
    //save new state
    List<ContactData> newList = app.getContactHelper().getContacts();
    //compare states
    oldList.add(contact);
    Collections.sort(oldList);
    AssertJUnit.assertEquals(newList, oldList);
  }
}
