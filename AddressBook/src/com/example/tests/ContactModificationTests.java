package com.example.tests;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class ContactModificationTests extends Base {
	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactData contact){
		app.getContactHelper().checkExistance();
		//save old
		SortedListOf<ContactData> oldList = app.getModel().getContacts();
		int index = 1 + app.getCommonHelper().chooseRandom(oldList);
		//action
		app.getContactHelper().modifyContact(index,contact);	
		//save new state
		SortedListOf<ContactData> newList = app.getModel().getContacts();
	    //compare states
		assertThat(newList, equalTo(oldList));
		check—onformityBetween("contactLists");
	}
}
