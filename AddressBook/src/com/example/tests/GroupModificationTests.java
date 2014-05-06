package com.example.tests;

import org.testng.annotations.Test;
import com.example.utils.SortedListOf;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class GroupModificationTests extends Base{
	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void modifySomeGroup(GroupData group) {
		app.getGroupHelper().checkExistance();
		//save old
		SortedListOf<GroupData> oldList = new SortedListOf<GroupData>(app.getHibernateHelper().listGroups());
		int index = app.getCommonHelper().chooseRandom(oldList);
		//action	    
		app.getGroupHelper().modifyGroup(index,group);
		//save new
		SortedListOf<GroupData> newList = new SortedListOf<GroupData>(app.getHibernateHelper().listGroups());
	    //compare states
		assertThat(newList, equalTo(oldList.without(index).withAdded(group)));//
	}
}
