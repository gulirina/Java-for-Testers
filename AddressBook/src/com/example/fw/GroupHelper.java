package com.example.fw;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class GroupHelper extends WebDriverHelperBase{

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}
	
	
	public SortedListOf<GroupData> getUiGroups() {
		SortedListOf<GroupData> groups =  new SortedListOf<GroupData>();
		manager.navigateTo().groupsPage();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");
			String groupname = title.substring("Select (".length(),title.length()-")".length());
			groups.add(new GroupData().withGroupname(groupname));
		}
		return groups;
	}
	
	public void checkExistance() {
		SortedListOf<GroupData> list =  getUiGroups();
		 if(list.size()==0){
			GroupData group = new GroupData();
			createGroup(group);
		 }	
	}


	public GroupHelper createGroup(GroupData group) {
		manager.navigateTo().groupsPage();
		initNewGroupCreation();
		fillGroupForm(group);
		submitGroupCreation();
		returnToGroupsPage();
		//update model
		manager.getModel().addGroup(group);
		return this;
		
	}	
	
	public GroupHelper modifyGroup(int index, GroupData group) {
		manager.navigateTo().groupsPage();
		initGroupModification(index);
		fillGroupForm(group);
		submitGroupModification();
		returnToGroupsPage();
		manager.getModel().remouveGroup(index).addGroup(group);
		return this;
	}

	public GroupHelper deleteGroup(int index) {
		manager.navigateTo().groupsPage();
		selectGroupByIndex(index);
		submitGroupDeletion();
		returnToGroupsPage();
		manager.getModel().remouveGroup(index);
		return this;
	}


//===========================================================================================
	public GroupHelper fillGroupForm(GroupData group) {
		type(By.name("group_name"), group.getGroupname());
		type(By.name("group_header"), group.getHeader());
		type(By.name("group_footer"), group.getFooter());	    
		return this;
	}

	public GroupHelper initNewGroupCreation() {
		manager.navigateTo().groupsPage();
		click(By.xpath("//input[@name='new']"));
		return this;
		
	}
	
	public GroupHelper initGroupModification(int index) {
		manager.navigateTo().groupsPage();
		selectGroupByIndex(index);
		click(By.name("edit"));
		return this;
	}


	public GroupHelper submitGroupCreation() {
		click(By.name("submit"));
		return this;
	}
	
	public GroupHelper submitGroupModification() {
		click(By.name("update"));
		return this;
	}
	
	private GroupHelper submitGroupDeletion() {
		click(By.name("delete"));
		return this;
	}
	

	public GroupHelper returnToGroupsPage() {
		click(By.linkText("group page"));
		return this;
	}

	private void selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + (index+1) + "]"));
	}









	


	

}
