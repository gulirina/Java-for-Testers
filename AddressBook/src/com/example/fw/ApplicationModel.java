package com.example.fw;

import java.util.List;

import com.example.utils.SortedListOf;
import com.example.tests.ContactData;
import  com.example.tests.GroupData;

public class ApplicationModel {
	
	private SortedListOf<GroupData> groups;
	private List<GroupData> listGroups;
	private SortedListOf<ContactData> contacts;
	private List<GroupData> listContacts;
	
	//==========================================================================
	
	public SortedListOf<GroupData> getGroups() {
		return groups;
	}
	
	public void setGroups(List<GroupData> groups){
		this.groups = new SortedListOf<GroupData>(groups);
	}

	public ApplicationModel addGroup(GroupData group) {
		groups.add(group);	
		return this;
	}

	public ApplicationModel remouveGroup(int index) {
		groups.remove(index);	
		return this;
	}
	
	//===============================================================================
	
	public SortedListOf<ContactData> getContacts() {
		return contacts;
	}
	
	public void setContacts(List<ContactData> contacts){
		this.contacts = new SortedListOf<ContactData>(contacts);
	}

	public ApplicationModel addContact(ContactData contact) {
		contacts.add(contact);	
		return this;
	}

	public ApplicationModel remouveContact(int index) {
		contacts.remove(index);	
		return this;
	}
}
