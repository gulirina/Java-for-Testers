package com.example.tests;

import static org.testng.Assert.assertEquals;
import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;

public class SubContactRemovalTests extends Base {
	
	@Test
	public void deleteSomeContact() {
		app.navigateTo().mainPage();
		//check existance
		List<ContactData> oldList = app.getContactHelper().getContacts();
		if(oldList.size()==0){
			ContactData contact = new ContactData();
			app.getContactHelper().createContact(contact);			
		}
		else{
			//...
		}
		//save old
		oldList = app.getContactHelper().getContacts();
		int index = 1 + app.getCommonHelper().chooseRandom(oldList);
		app.getContactHelper().subDeleteContact(index);
		//save new
		List<ContactData> newList = app.getContactHelper().getContacts();
		//compare states
		oldList.remove(index-1);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
	}
}
