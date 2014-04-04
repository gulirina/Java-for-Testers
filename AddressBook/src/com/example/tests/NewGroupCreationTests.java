package com.example.tests;

import static org.testng.Assert.assertEquals;
import java.util.Collections;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class NewGroupCreationTests extends Base{
  
	@Test(dataProvider = "randomValidGroupGenerator")
	public void testGroupCreationWithValidData(GroupData group) throws Exception {
	    //save old
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
	    //actions
	    app.getGroupHelper().createGroup(group);
	    //save new
	    SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
	    //compare states
	    oldList.add(group);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	   }
	}

