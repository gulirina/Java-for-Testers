package com.example.tests;

import org.testng.annotations.Test;


public class ContactModificationTests extends Base {
	
	@Test
	public void modifySomeContact(){
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().editContactDetails(1);
		ContactData contact = new ContactData();
		contact.firstName = "Irene";
		contact.email1 = "irene@gulyaeva.ig";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().goToHomePage();		
	}
	

}
