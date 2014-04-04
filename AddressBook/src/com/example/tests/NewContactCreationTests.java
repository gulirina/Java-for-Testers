package com.example.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.example.fw.ContactHelper.CREATION;

import static org.testng.Assert.assertEquals;

public class NewContactCreationTests extends Base {
	

@Test(dataProvider = "randomValidContactGenerator")
  public void testNewContactCreation(ContactData contact) throws Exception {
    //save old
    List<ContactData> oldList = app.getContactHelper().getContacts();
    //action   
    app.getContactHelper().createContact(contact);
    //save new state
    List<ContactData> newList = app.getContactHelper().getContacts();
    //compare states
    oldList.add(contact);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }
}
