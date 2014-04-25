package com.example.fw;

public class ContactHelper extends HelperBase{

	private ApplicationManager applicationManager;

	public ContactHelper(ApplicationManager applicationManager) {
		super(applicationManager);
		
	}

	public void createContact(Contact contact) {
		initContactCreation();
		fillContactForm(contact);
		confirmContactCreation();
			
		
	}
	private void initContactCreation() {
		manager.getAutoItHelper()
			.winWaitAndActivate("AddressBook Portable", "", 10000)
			.click("Add")
			.winWaitAndActivate("Add Contact", "", 5000);
	}	

	private void fillContactForm(Contact contact) {
		manager.getAutoItHelper()
			.send("TDBEdit12",contact.firstName)
			.send("TDBEdit11",contact.lastName);
	}

	private void confirmContactCreation() {
		manager.getAutoItHelper()
			.click("Save")
			.winWaitAndActivate("AddressBook Portable", "", 5000);
	}
	

	public Contact getFirstContact() {
		selectFirstContact();
		manager.getAutoItHelper()
			.click("Edit")
			.winWaitAndActivate("Update Contact", "", 5000);
		Contact contact = new Contact()
			.setFirstname(manager.getAutoItHelper().getText("TDBEdit12"))
			.setLastName(manager.getAutoItHelper().getText("TDBEdit11"));
		manager.getAutoItHelper().click("Cancel");
		return contact;
	}
	
	public void selectFirstContact(){
		manager.getAutoItHelper()
		.winWaitAndActivate("AddressBook Portable", "", 5000)
		.click("TListView1")
		.send("{DOWN}{SPACE}");		
	}

	public void deleteFirstContact() {
		selectFirstContact();
		manager.getAutoItHelper()
			.click("Delete")
			.winWaitAndActivate("Confirm", "", 5000)
			.click("TButton2")
			.winWaitAndActivate("AddressBook Portable", "", 5000);
			
	}

	public boolean checkExistance() {
		selectFirstContact();
		manager.getAutoItHelper()
			.click("Edit");
		if(manager.getAutoItHelper().winWaitAndActivate("Information", "", 5000) != null){
			manager.getAutoItHelper()
			.click("TButton1");
			return true;
		} else {
			return false;
		}		
	}
}
