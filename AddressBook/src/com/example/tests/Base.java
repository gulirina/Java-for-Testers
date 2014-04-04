package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

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
	public Iterator<Object[]>randomValidGroupGenerator() {
	  List<Object[]> list = new ArrayList<Object[]>();
	  for(int i=0;i<5;i++) {
		  GroupData group = new GroupData()
		  	.withGroupname(generateRandomString())
		  	.withHeader(generateRandomString())
		  	.withFooter(generateRandomString());
		  list.add(new Object[]{group});
	  }
	  return list.iterator();
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
		  return "test"+rnd.nextInt();
	  }
  }	 
  
  public String generateRandomNumber(int limit){
	  Random rnd = new Random();
	  int number = 1+rnd.nextInt(limit);
	  String num = ""+number+"";
	  return num;
  }  	
}
