package com.example.tests;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class GroupRemovalTests extends Base {
	
	@Test
	public void deleteSomeGroup() {
		app.getGroupHelper().checkExistance();
		//save old
		SortedListOf<GroupData> oldList = new SortedListOf<GroupData>(app.getHibernateHelper().listGroups());
		int index = app.getCommonHelper().chooseRandom(oldList);
		//actions
		app.getGroupHelper().deleteGroup(index);			
		//save new
		SortedListOf<GroupData> newList = new SortedListOf<GroupData>(app.getHibernateHelper().listGroups());
		//compare states
		assertThat(newList, equalTo(oldList.without(index)));		//
	}
}
