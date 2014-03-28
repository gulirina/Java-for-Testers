package com.example.fw;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.Base;
import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class GroupHelper extends HelperBase{

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}
	
	public GroupHelper createGroup(GroupData group) {
		manager.navigateTo().groupsPage();
		initNewGroupCreation();
		fillGroupForm(group);
		submitNewGroupCreation();
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

	private SortedListOf<GroupData> cachedGroups;
		
	public SortedListOf<GroupData> getGroups() {
		if(cachedGroups == null){
			rebildCache();
		}
		return cachedGroups;
	}
	
	private void rebildCache() {
		cachedGroups = new SortedListOf<GroupData>();		
		manager.navigateTo().groupsPage();		
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");
			String name = title.substring("Select (".length(),title.length()-")".length());
			cachedGroups.add(new GroupData().withName(name));
		}
	}

//---------------------------------------------------------------------------------------------
	
	public GroupHelper fillGroupForm(GroupData group) {
		type(By.name("group_name"), group.getGroupname());
		type(By.name("group_header"), group.getHeader());
		type(By.name("group_footer"), group.getFooter());	
		return this;
	}


	
	public GroupHelper returnToGroupsPage() {
		click(By.linkText("group page"));
		return this;
	}

	private void selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + (index+1) + "]"));
	}
	

//--------INIT-----------------------------------------
	public GroupHelper initNewGroupCreation() {
		click(By.xpath("//input[@name='new']"));
		return this;
	}

	public GroupHelper initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
		return this;
	}	
//-----------------------------------------------------	

//-----SUBMIT------------
	public GroupHelper submitGroupModification() {
		click(By.name("update"));
		return this;
	}
	private void submitGroupDeletion() {
		click(By.name("delete"));
		cachedGroups = null;
	}
	public GroupHelper submitNewGroupCreation() {
		click(By.name("submit"));
		cachedGroups = null;
		return this;
	}	
//------------------------	
	

}
