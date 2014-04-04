package com.example.tests;

import java.util.Collections;
import java.util.List;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class AllGroupRemovalTests extends Base{
	
	@Test
	public void removeAllGroups() {
		//check existence
		List<GroupData> oldList = app.getGroupHelper().getGroups();
		if(oldList.size()==0){
			//...
		}
		else{
			do {
				//save old
				oldList = app.getGroupHelper().getGroups();
				int index = app.getCommonHelper().chooseRandom(oldList);
				//actions
				app.getGroupHelper().deleteGroup(index);//or we can use a constant
				//save new
				List<GroupData> newList = app.getGroupHelper().getGroups();
				//compare states
				oldList.remove(index);
				Collections.sort(oldList);
				assertEquals(newList, oldList);		
			} while(oldList.size()!=0);
		}		
	}
}
