package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemovalTests extends Base {
	
	@Test
	public void deleteSomeContact(){
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().deleteContact(1);
		app.getContactHelper().goToHomePage();
		
	}

	
}
