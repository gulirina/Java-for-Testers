package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactModificationTests extends Base {
	

	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactData contact){
		//check existance
		List<ContactData> oldList = app.getContactHelper().getContacts();
		if(oldList.size()==0){
			app.getContactHelper().createContact(contact);			
		 }
		 else{
			 //...
		 }
		//save old
		oldList = app.getContactHelper().getContacts();
		int index = 1 + app.getCommonHelper().chooseRandom(oldList);
		//action
		app.getContactHelper().modifyContact(index,contact);	
		//save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    //compare states
	    oldList.remove(index-1);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
}
