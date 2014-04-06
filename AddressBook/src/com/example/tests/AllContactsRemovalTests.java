package com.example.tests;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class AllContactsRemovalTests extends Base {
	
	@Test
	public void removeAllContacts(){
		//check existance
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
		if(oldList.size()==0){
			//...		
		}
		else{
			do {
				//save old
				oldList = app.getContactHelper().getContacts();
				int index = 1 + app.getCommonHelper().chooseRandom(oldList);
				//action
				app.getContactHelper().deleteContact(index);
				//save new
				SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
				//compare states
				//assertThat(newList, equalTo(oldList.without(index-1)));
			} while(oldList.size()!=0);
		}
	}
}
