package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupModificationTests extends Base{
	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void modifySomeGroup(GroupData group) {
		
		//check existence
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
		 if(oldList.size()==0){
			 app.getGroupHelper().createGroup(group);
		 }
		 else{
			 //...
		 }
		//save old
	    oldList = app.getGroupHelper().getGroups();
	    int index = app.getCommonHelper().chooseRandom(oldList);
		//action	    
		app.getGroupHelper().modifyGroup(index, group);
			
		//save new
		SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
	    //compare states
		assertThat(newList, equalTo(oldList.without(index).withAdded(group)));
	}
}
