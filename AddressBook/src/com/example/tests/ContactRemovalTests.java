package com.example.tests;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class ContactRemovalTests extends Base {	
	@Test
	public void deleteSomeContact(){
		app.getContactHelper().checkExistance();		
		//save old
		SortedListOf<ContactData> oldList= app.getContactHelper().getContacts();
		int index = 1 + app.getCommonHelper().chooseRandom(oldList);
		//action
		app.getContactHelper().deleteContact(index);		
		//save new
		SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
		//compare states
		assertThat(newList, equalTo(oldList.without(index-1)));
	}	
}
