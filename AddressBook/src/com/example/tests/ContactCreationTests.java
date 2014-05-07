package com.example.tests;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;
import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;
import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;


public class ContactCreationTests extends Base {
	

	@DataProvider
	public Iterator<Object[]> contactsFromFile() throws IOException {
		//return wrapContactForDataProvider(loadContactsFromXmlFile(new File("contacts.xml"))).iterator();
		return wrapContactForDataProvider(loadContactsFromCsvFile(new File("contacts.txt"))).iterator();
	}
	
	@Test(dataProvider = "contactsFromFile")
	public void testNewContactCreation(ContactData contact) throws Exception {
	    //save old
		SortedListOf<ContactData> oldList = new SortedListOf<ContactData>(app.getHibernateHelper().listContacts());//getModel().getContacts()
	    //action  
	    app.getContactHelper().createContact(contact);
	    //save new state
	    SortedListOf<ContactData> newList = app.getContactHelper().getUiContacts();
	    //compare states
	    assertThat(newList, equalTo(oldList.withAdded(contact))); //
	}
}
