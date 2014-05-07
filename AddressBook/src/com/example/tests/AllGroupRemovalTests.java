package com.example.tests;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class AllGroupRemovalTests extends Base{
	
	@Test
	public void removeAllGroups() {
		//check existence
		SortedListOf<GroupData> oldList = app.getGroupHelper().getUiGroups();
		if(oldList.size()==0){
			//...
		}
		else{
			do {
				//save old
				oldList = app.getModel().getGroups();
				int index = app.getCommonHelper().chooseRandom(oldList);
				//actions
				app.getGroupHelper().deleteGroup(index);//or we can use a constant
				//save new
				SortedListOf<GroupData> newList = app.getModel().getGroups();
				//compare states
				assertThat(newList, equalTo(oldList));	
				oldList = new SortedListOf<GroupData>(app.getHibernateHelper().listGroups());
			} while(oldList.size()>0);
		}		
	}
}
