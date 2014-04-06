package com.example.fw;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class GroupHelper extends HelperBase{

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}
	
	private SortedListOf<GroupData> cachedGroups;
	
	public SortedListOf<GroupData> getGroups() {
		if (cachedGroups==null){
			cachedGroups = rebildCache();
		}
		return cachedGroups;
	}
	
	private SortedListOf<GroupData> rebildCache() {
		cachedGroups =  new SortedListOf<GroupData>();
		manager.navigateTo().groupsPage();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");
			String groupname = title.substring("Select (".length(),title.length()-")".length());
			cachedGroups.add(new GroupData().withGroupname(groupname));
		}
		return cachedGroups;
	}
	
	public void checkExistance() {
		SortedListOf<GroupData> list =  getGroups();
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
		rebildCache();
		return this;
		
	}	
	
	public GroupHelper modifyGroup(int index, GroupData group) {
		manager.navigateTo().groupsPage();
		initGroupModification(index);
		fillGroupForm(group);
		submitGroupModification();
		returnToGroupsPage();
		rebildCache();
		return this;
	}

	public GroupHelper deleteGroup(int index) {
		manager.navigateTo().groupsPage();
		selectGroupByIndex(index);
		submitGroupDeletion();
		returnToGroupsPage();
		rebildCache();
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
		cachedGroups=null;
		return this;
	}
	
	public GroupHelper submitGroupModification() {
		click(By.name("update"));
		cachedGroups=null;
		return this;
	}
	
	private GroupHelper submitGroupDeletion() {
		click(By.name("delete"));
		cachedGroups=null;
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
