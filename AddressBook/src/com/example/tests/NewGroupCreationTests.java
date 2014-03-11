package com.example.tests;

import org.testng.annotations.Test;



public class NewGroupCreationTests extends Base{
  @Test
  public void testNewGroupCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().goToGroupsPage();
    app.getGroupHelper().initNewGroupCreation();
    GroupData group = new GroupData();
    group.groupname="Sparkle_Group";
    group.header="sparkling_header";
    group.footer="sparkling_footer";
	app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitNewGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
  }
  
 @Test
  public void testNewEmptyGroupCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().goToGroupsPage();
    app.getGroupHelper().initNewGroupCreation();
    GroupData group = new GroupData(" "," "," ");
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitNewGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
  }
}

