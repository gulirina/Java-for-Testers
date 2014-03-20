package com.example.tests;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class NewContactCreationTests extends Base {

  @Test
  public void testNewContactCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    //save old
    List<ContactData> oldList = app.getContactHelper().getContacts();
    //action   
    ContactData contact = new ContactData();
    contact.firstName ="Amelie";
    contact.secondName = "Poulain";
    app.getContactHelper().quickContactCreation(contact);
    //save new state
    List<ContactData> newList = app.getContactHelper().getContacts();
    //compare states
    oldList.add(contact);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }
}
