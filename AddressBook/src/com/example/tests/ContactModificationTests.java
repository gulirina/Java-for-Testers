package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactModificationTests extends Base {
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactData contact){
		app.getNavigationHelper().openMainPage();
		//check existance
		List<ContactData> oldList = app.getContactHelper().getContacts();
		if(oldList.size()==0){
			app.getContactHelper().quickContactCreation(contact);			
		 }
		 else{
			 //...
		 }
		//save old
		oldList = app.getContactHelper().getContacts();
		int index = 1 + app.getContactHelper().chooseRandomContact(oldList);
		//action
		app.getContactHelper().editContactDetails(index);
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().goToHomePage();	
		//save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    //compare states
	    oldList.remove(index-1);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
}
