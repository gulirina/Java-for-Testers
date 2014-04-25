package com.example.tests;

import org.testng.annotations.Test;

import com.example.fw.Contact;

public class TestContactDeletion extends Base{
	
	@Test
	public void deleteSomeContact(){
		if(!app.getContactHelper().checkExistance()){
			Contact contact = new Contact()
				.setFirstname("irene")
				.setLastName("guliaeva");
			app.getContactHelper().createContact(contact);
		}		
		app.getContactHelper().deleteFirstContact();
	}

}
