package com.example.tests;

import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class CompareData extends Base {
	
	@Test
	public void compareContactData(){
		SortedListOf<ContactData> contactList = app.getContactHelper().getUiContacts();
		System.out.println("number of contacts: "+contactList.size());
		System.out.println("number of contacts_phones : "+app.getContactHelper().getPhoneList());
	}

}
