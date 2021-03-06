package com.example.tests;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class AllContactsRemovalTests extends Base {
	
	@Test
	public void removeAllContacts(){
		//check existance
		SortedListOf<ContactData> oldList = new SortedListOf<ContactData>(app.getHibernateHelper().listContacts());
		if(oldList.size()==0){
			//...		
		}
		else{
			do {
				int index = 1 + app.getCommonHelper().chooseRandom(oldList);
				//action
				app.getContactHelper().deleteContact(index);
				//save new
				SortedListOf<ContactData> newList = app.getContactHelper().getUiContacts();
				//compare states
				assertThat(newList, equalTo(oldList.without(index-1)));
				oldList = new SortedListOf<ContactData>(app.getHibernateHelper().listContacts());
			} while(oldList.size()!=0);
		}
	}
}
