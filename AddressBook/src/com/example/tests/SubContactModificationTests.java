package com.example.tests;

import org.testng.annotations.Test;

public class SubContactModificationTests extends Base {
	
	@Test
	public void ModifySomeContact() {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().showContactDetalis(1);
		app.getContactHelper().initContactModification();
		ContactData contact = new ContactData();
		contact.firstName = "Julia";
		contact.email1 = "Julia@Roberts.com";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().goToHomePage();
	}

}
