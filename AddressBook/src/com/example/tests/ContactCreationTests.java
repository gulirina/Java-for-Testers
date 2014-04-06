package com.example.tests;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class ContactCreationTests extends Base {
	@Test(dataProvider = "randomValidContactGenerator")
	public void testNewContactCreation(ContactData contact) throws Exception {
	    //save old
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
	    //action  
	    app.getContactHelper().createContact(contact);
	    //save new state
	    SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
	    //compare states
	    assertThat(newList, equalTo(oldList.withAdded(contact)));
	}
}
