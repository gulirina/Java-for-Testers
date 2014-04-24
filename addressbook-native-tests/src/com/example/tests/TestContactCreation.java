package com.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.fw.Contact;

public class TestContactCreation extends Base {
	
	@Test
	public void shouldCreateContactWithvalidData(){
		Contact contact = new Contact()
							.setFirstname("tester")
							.setLastName("tester");
		app.getContactHelper().createContact(contact);
		Contact createdContact = app.getContactHelper().getFirstContact();
		Assert.assertEquals(contact, createdContact);
	}

}
