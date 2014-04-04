package com.example.tests;

import static org.testng.Assert.assertEquals;
import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;

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
