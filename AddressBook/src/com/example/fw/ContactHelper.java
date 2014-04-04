package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends HelperBase {
	
public static boolean CREATION = true;
public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}
	
	private SortedListOf<ContactData> cachedContacts;
	
	public SortedListOf<ContactData> getContacts() {
		if (cachedContacts==null){
			cachedContacts = rebildCache();
		}
		return cachedContacts;
	}

	private SortedListOf<ContactData> rebildCache() {
		cachedContacts = new SortedListOf<ContactData>();
		manager.navigateTo().mainPage();
		List<WebElement> lines = driver.findElements(By.xpath("//tr[@name='entry']//td[2]"));
		for (WebElement line : lines) {
			String name = line.getText();
			String secondName = name;
			cachedContacts.add(new ContactData().withSecondName(secondName));
		}
		return cachedContacts;
	}
	
	
	public ContactHelper createContact(ContactData contact) {
		initNewContactCreation();
		fillContactForm(contact, CREATION);
	    submitNewContactCreation();
	    goToHomePage();
	    rebildCache();
	    return this;
	}
	
	public ContactHelper modifyContact(int index, ContactData contact) {
		manager.navigateTo().mainPage();
		editContactDetails(index);
		fillContactForm(contact, MODIFICATION);
		submitContactModification();
		goToHomePage();
		rebildCache();
		return this;
		
	}
	
	public ContactHelper subModifyContact(int index, ContactData contact) {
		manager.navigateTo().mainPage();
		showContactDetalis(index);
		initContactModification();
		fillContactForm(contact, MODIFICATION);
		submitContactModification();	
		goToHomePage();
		rebildCache();
		return this;
	}
	
	public ContactHelper deleteContact(int index) {
		manager.navigateTo().mainPage();
		editContactDetails(index);
		submitContactDeletion();
		goToHomePage();
		rebildCache();
		return this;
	}
	
	public ContactHelper subDeleteContact(int index) {
		manager.navigateTo().mainPage();
		showContactDetalis(index);	
		initContactModification();
		submitContactDeletion();
		goToHomePage();
		rebildCache();
		return this;
	}
	
//================================================================================	
	
	public ContactHelper fillContactForm(ContactData contact,boolean formType) {
		type(By.name("firstname"), contact.getFirstName());
		type(By.name("lastname"), contact.getSecondName());
	    type(By.name("address"), contact.getMainAddress());
	    type(By.name("home"), contact.getHPhone());
	    type(By.name("mobile"), contact.getMPhone());
	    type(By.name("work"), contact.getWPhone());
	    type(By.name("email"), contact.getEmail1());
	    type(By.name("email2"),contact.getEmail2());
	    selectByText(By.name("bday"), contact.getBDay());
	    selectByText(By.name("bmonth"), contact.getBMonth());
	    type(By.name("byear"), contact.getBYear());
	    if(formType == CREATION){
	    	//selectByText(By.name("new_group"), contact.getGroupName());
	    }
	    else {
	    	if(driver.findElements(By.name("new_group")).size()!=0){
	    		throw new Error("Group selector exists in contact modification form");
	    	}
	    }
	    type(By.name("address2"), contact.getSupAddress());
	    type(By.name("phone2"), contact.getSupPhone());
	    return this;
	}
	
	public ContactHelper initNewContactCreation() {
		click(By.linkText("add new"));
		return this;
	}
	
	public ContactHelper initContactModification() {
		click(By.xpath("//input[@name='modifiy']"));
		return this;
	}
	
	public ContactHelper submitNewContactCreation() {
		click(By.name("submit"));
		cachedContacts = null;
		return this;
	}
	
	public ContactHelper submitContactModification() {
		click(By.xpath("//input[@value='Update']"));
		cachedContacts = null;
		return this;
	}
	
	public ContactHelper submitContactDeletion() {
		click(By.xpath("//input[@value='Delete']"));
		cachedContacts = null;
		return this;
	} 
	
	public ContactHelper showContactDetalis(int index) {
		int cur_row = index+1; //because the first row is the header of the table
		click(By.xpath("//tr[" + cur_row + "]//img[@title='Details']"));
		return this;
	}
	
	public ContactHelper editContactDetails(int index) {
		int cur_row = index+1; //because the first row is the header of the table
		click(By.xpath("//tr[" + cur_row + "]//img[@title='Edit']"));
		return this;
	}

	
	public ContactHelper goToHomePage() {
		click(By.linkText("home page"));
		return this;
	}

	public ContactHelper addNext() {
		click(By.linkText("add next"));
		return this;
	}






}
