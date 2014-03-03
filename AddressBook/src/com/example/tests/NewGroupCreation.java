package com.example.tests;

import org.testng.annotations.Test;



public class NewGroupCreation extends Base{
  @Test
  public void newGroup() throws Exception {
    openMainPage();
    goToGroupsPage();
    initNewGroupCreation();
    GroupData group = new GroupData();
    group.groupname="Sparkle_Group";
    group.header="sparkling_header";
    group.footer="sparkling_footer";
	fillGroupForm(group);
    submitNewGroupCreation();
    returnToGroupsPage();
  }
  
  @Test
  public void newEmptyGroup() throws Exception {
    openMainPage();
    goToGroupsPage();
    initNewGroupCreation();
    GroupData group = new GroupData("", "", "");
	fillGroupForm(group);
    submitNewGroupCreation();
    returnToGroupsPage();
  }
}

