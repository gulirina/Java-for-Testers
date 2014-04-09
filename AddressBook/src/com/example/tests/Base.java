package com.example.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import static com.example.tests.GroupDataGenerator.generateRandomGroups;
import com.example.fw.ApplicationManager;

public class Base {
	
	protected static ApplicationManager app;

	@BeforeTest 
	public void setUp() throws Exception {
		app = new ApplicationManager();
	}
		
	@AfterTest 
	public void tearDown() throws Exception {
		app.stop();
	}
	
	@DataProvider
	public Iterator<Object[]>randomValidGroupGenerator()  {
		return wrapGroupForDataProvider(generateRandomGroups(5)).iterator();
	}
	
	public static List<Object[]> wrapGroupForDataProvider(List<GroupData> groups) {
		List<Object[]> list = new ArrayList<Object[]>();
		for(GroupData group : groups){
			list.add(new Object[] {group});
		}
		return list;
	}

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
	  List<Object[]> list = new ArrayList<Object[]>();
	  Random rnd = new Random();
	  for(int i=0;i<5;i++){
		  ContactData contact = new ContactData()
		  	.withFirstName(generateRandomString())
		  	.withSecondName(generateRandomString())
		  	.withMainAddress(generateRandomString())
		  	.withHPhone(generateRandomString())
		  	.withMPhone(generateRandomString())
		  	.withWPhone(generateRandomString())
		  	.withEmail1(generateRandomString())
		  	.withEmail2(generateRandomString())
		  	.withBDay("1")
		  	.withBMonth("August")
		  	.withBYear("1970")
		  	//.withGroupName(generateRandomString())
		  	.withSupAddress(generateRandomString())
		  	.withSupPhone(generateRandomString());
		  list.add(new Object[]{contact});	  
	  }
	  //..
	  return list.iterator();
	  
  }	
	  


public String generateRandomString() {
	  Random rnd = new Random();
	  if(rnd.nextInt(3)==0) {
		  return "";
	  }
	  else {
		  return "test"+rnd.nextInt(2);
	  }
  }	 
  
  public String generateRandomNumber(int limit){
	  Random rnd = new Random();
	  int number = 1+rnd.nextInt(limit);
	  String num = ""+number+"";
	  return num;
  }  	
}
