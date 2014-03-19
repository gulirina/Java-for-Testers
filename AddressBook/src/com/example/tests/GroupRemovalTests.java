package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupRemovalTests extends Base {
	
	@Test
	public void deleteSomeGroup() {
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().goToGroupsPage();
		//check existence
		 List<GroupData> oldList = app.getGroupHelper().getGroups();
		 if(oldList.size()==0){
			GroupData group = new GroupData();
			app.getGroupHelper().quickGroupCreation(group);
		 }
		 else{
			 //...
		 }
		//save old
		oldList = app.getGroupHelper().getGroups();
		int index = app.getGroupHelper().chooseRandomGroup(oldList);
		//actions
		app.getGroupHelper().deleteGroup(index);
		app.getGroupHelper().returnToGroupsPage();
		//save new
		List<GroupData> newList = app.getGroupHelper().getGroups();
		//compare states
		oldList.remove(index);
		Collections.sort(oldList);
		assertEquals(newList, oldList);		
	}
}
