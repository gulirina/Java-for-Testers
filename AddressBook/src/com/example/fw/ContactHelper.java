package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends WebDriverHelperBase {
	
public static boolean CREATION = true;
public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}
	
	
	public SortedListOf<ContactData> getUiContacts() {
		SortedListOf<ContactData> contacts = new SortedListOf<ContactData>();
		manager.navigateTo().mainPage();
		List<WebElement> lines = driver.findElements(By.xpath("//tr[@name='entry']"));
		for (WebElement line : lines) {
			WebElement cell1 = line.findElement(By.xpath(".//td[2]"));
			WebElement cell2 = line.findElement(By.xpath(".//td[3]"));
			String fullName = ""+cell1.getText()+" "+cell2.getText()+"";			
			contacts.add(new ContactData().saveFullName(fullName));			
		}
		return contacts;
	}

	
	public void checkExistance() {
		SortedListOf<ContactData> list = new SortedListOf<ContactData>(manager.getHibernateHelper().listContacts());
		if(list.size()==0){
			ContactData contact = new ContactData();
			createContact(contact);			
		 }	
	}

	
	public ContactHelper createContact(ContactData contact) {
		initNewContactCreation();
		fillContactForm(contact, CREATION);
	    submitNewContactCreation();
	    goToHomePage();
	    manager.getModel().addContact(contact);
	    return this;
	}
	
	public ContactHelper modifyContact(int index, ContactData contact) {
		manager.navigateTo().mainPage();
		editContactDetails(index);
		fillContactForm(contact, MODIFICATION);
		submitContactModification();
		goToHomePage();
		manager.getModel().remouveContact(index).addContact(contact);
		return this;
		
	}
	
	public ContactHelper subModifyContact(int index, ContactData contact) {
		manager.navigateTo().mainPage();
		showContactDetalis(index);
		initContactModification();
		fillContactForm(contact, MODIFICATION);
		submitContactModification();	
		goToHomePage();
		manager.getModel().remouveContact(index).addContact(contact);
		return this;
	}
	
	public ContactHelper deleteContact(int index) {
		manager.navigateTo().mainPage();
		editContactDetails(index);
		submitContactDeletion();
		goToHomePage();
		manager.getModel().remouveContact(index);
		return this;
	}
	
	public ContactHelper subDeleteContact(int index) {
		manager.navigateTo().mainPage();
		showContactDetalis(index);	
		initContactModification();
		submitContactDeletion();
		goToHomePage();
		manager.getModel().remouveContact(index);
		return this;
	}
	
	public int getPhoneList() {
		SortedListOf<ContactData> userPhones = new SortedListOf<ContactData>();
		manager.navigateTo().phonePage();
		List<WebElement> cells = driver.findElements(By.xpath("//tr//td"));
		int emptyCells = 0;
		for(WebElement cell:cells){
			String data = cell.getText();
			if(data.equals("-")){
				emptyCells++;
			}
		}
		int size = cells.size()-emptyCells; 
		
		return size;
	}
	
//================================================================================	
	
	public ContactHelper fillContactForm(ContactData contact,boolean formType) {
		type(By.name("firstname"), contact.getFirstName());
		type(By.name("lastname"), contact.getSecondName());
	    type(By.name("address"), contact.getMainAddress());
	    type(By.name("home"), contact.gethPhone());
	    type(By.name("mobile"), contact.getmPhone());
	    type(By.name("work"), contact.getwPhone());
	    type(By.name("email"), contact.getEmail1());
	    type(By.name("email2"),contact.getEmail2());
	    selectByText(By.name("bday"), contact.getbDay());
	    selectByText(By.name("bmonth"), contact.getbMonth());
	    type(By.name("byear"), contact.getbYear());
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
	    contact.saveFullName(""+contact.getSecondName()+" "+contact.getFirstName()+"");
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
		return this;
	}
	
	public ContactHelper submitContactModification() {
		click(By.xpath("//input[@value='Update']"));
		return this;
	}
	
	public ContactHelper submitContactDeletion() {
		click(By.xpath("//input[@value='Delete']"));
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
