package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class AllContactsRemovalTests extends Base {
	
	@Test
	public void removeAllContacts(){
		app.navigateTo().mainPage();
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
				oldList.remove(index-1);
				Collections.sort(oldList);
			    assertEquals(newList, oldList);
			} while(oldList.size()!=0);
		}
	}
}
