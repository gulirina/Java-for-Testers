package com.example.tests;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class SubContactRemovalTests extends Base {
	
	@Test
	public void deleteSomeContact() {
		app.getContactHelper().checkExistance();
		SortedListOf<ContactData> oldList = new SortedListOf<ContactData>(app.getHibernateHelper().listContacts());
		int index = 1 + app.getCommonHelper().chooseRandom(oldList);
		app.getContactHelper().subDeleteContact(index);
		//save new
		SortedListOf<ContactData> newList = app.getContactHelper().getUiContacts();
		//compare states
		assertThat(newList, equalTo(oldList.without(index-1)));
	}
}
