package com.example.tests;

import com.example.fw.ApplicationManager;

public class ContactData implements Comparable<ContactData> {
	public String firstName;
	public String secondName;
	public String mainAddress;
	public String hPhone;
	public String mPhone;
	public String wPhone;
	public String email1;
	public String email2;
	public String bDay;
	public String bMonth;
	public String bYear;
	public String groupName;
	public String supAddress;
	public String supPhone;
	

	
	public ContactData() {
	}
	
	
	
	@Override
	public String toString() {
		return "ContactData [secondName=" + secondName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result	+ ((fullName == null) ? 0 : fullName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (secondName == null) {
			if (other.secondName != null)
				return false;
		} else if (!secondName.equals(other.secondName))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(ContactData other) {
		return this.secondName.toLowerCase().compareTo(other.secondName.toLowerCase());
	}
	
	
}