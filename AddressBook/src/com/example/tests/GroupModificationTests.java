package com.example.tests;

import static org.testng.Assert.assertEquals;
import java.util.Collections;
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
		app.getGroupHelper().modifyGroup(index,group);
		//save new
		SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
	    //compare states
	    oldList.remove(index);
	    oldList.add(group);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
}
