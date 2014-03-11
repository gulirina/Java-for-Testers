package com.example.tests;

import org.testng.annotations.Test;

public class SubContactRemovalTests extends Base {
	
	@Test
	public void deleteSomeContact() {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().showContactDetalis(2);
		app.getContactHelper().initContactModification();
		app.getContactHelper().pressDeleteBtn();
		app.getContactHelper().goToHomePage();
	}

}
