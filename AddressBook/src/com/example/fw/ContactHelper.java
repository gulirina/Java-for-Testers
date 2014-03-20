package com.example.fw;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.Base;
import com.example.tests.ContactData;
import com.example.tests.GroupData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void goToHomePage() {
		click(By.linkText("home page"));
	}

	public void addNext() {
		click(By.linkText("add next"));
	}

	public void submitNewContactCreation() {
		click(By.name("submit"));
	}

	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.firstName);
		type(By.name("lastname"), contact.secondName);
	    type(By.name("address"), contact.mainAddress);
	    type(By.name("home"), contact.hPhone);
	    type(By.name("mobile"), contact.mPhone);
	    type(By.name("work"), contact.wPhone);
	    type(By.name("email"), contact.email1);
	    type(By.name("email2"),contact.email2);
	    selectByText(By.name("bday"), contact.bDay);
	    selectByText(By.name("bmonth"), contact.bMonth);
	    type(By.name("byear"), contact.bYear);
	    //selectByText(By.name("new_group"), contact.groupName);
	    type(By.name("address2"), contact.supAddress);
	    type(By.name("phone2"), contact.supPhone);
	}

	public void initNewContactCreation() {
		click(By.linkText("add new"));
	}

	public void showContactDetalis(int index) {
		int cur_row = index+1; //because the first row is the header of the table
		click(By.xpath("//tr[" + cur_row + "]//img[@title='Details']"));
	}
	
	public void editContactDetails(int index) {
		int cur_row = index+1; //because the first row is the header of the table
		click(By.xpath("//tr[" + cur_row + "]//img[@title='Edit']"));
	}

	public void submitContactModification() {
		click(By.xpath("//input[@value='Update']"));//I use xpath because buttons "Update" & "Delete" have the same names "update"		
	}

	public void pressDeleteBtn() {
		click(By.xpath("//input[@value='Delete']"));//I use xpath because buttons "Update" & "Delete" have the same names "update"
	} 
	
	public void initContactModification() {
		click(By.xpath("//input[@name='modifiy']"));
	}
	
	public void deleteContact(int index) {
		editContactDetails(index);
		pressDeleteBtn();
	}
	
	public void quickContactCreation(ContactData contact) {
		initNewContactCreation();
		fillContactForm(contact);
	    submitNewContactCreation();
	    goToHomePage();
	}

	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> lines = driver.findElements(By.xpath("//tr[@name='entry']//td[2]"));
		for (WebElement line : lines) {
			ContactData contact = new ContactData();
			String name = line.getText();
			contact.secondName = name;
			contacts.add(contact);
		}
		return contacts;
		
	}
	
	public int chooseRandomContact(List<ContactData> oldList) {
		Random  rnd = new Random();
	    int index = rnd.nextInt(oldList.size());
		return index;
	}
	
	
}
