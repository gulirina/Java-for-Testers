package com.example.tests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator extends BaseGenerator {

	public static void main(String[] args) throws IOException {
		if(args.length<3){
			System.out.println("Please specify parameters: <amount of test data> <file> <format>");
			return;
		}
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];		
		if(file.exists()) {
			System.out.println("File exists, please remove it manualy: "+file);
			return;
		}		
		List<ContactData> contacts = generateRandomContact(amount);
		if("csv".equals(format)){
			saveContactToCsvFile(contacts, file);
		} else if("xml".equals(format)){
			saveContactToXmlFile(contacts, file);	
		} else{
			System.out.println("Unknown format "+format);
		}
	}
	
	public static List<ContactData> generateRandomContact(int amount) {
		  List<ContactData> list = new ArrayList<ContactData>();
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
			  	.withBDay(generateRandomNumber(30))
			  	.withBMonth("August")
			  	.withBYear(generateRandomNumber(2000))
			  	//.withGroupName(generateRandomString())
			  	.withSupAddress(generateRandomString())
			  	.withSupPhone(generateRandomString());
			  list.add(contact);	  
		  }
		  return list;
	}
		
	//======================================================================================

	private static void saveContactToXmlFile(List<ContactData> contacts, File file) throws IOException{
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}
	
	//======================================================================================

	private static void saveContactToCsvFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write(contact.getFirstName()+","+
						contact.getSecondName()+","+
						contact.getMainAddress()+","+
						contact.getHPhone()+","+
						contact.getMPhone()+","+
						contact.getWPhone()+","+
						contact.getEmail1()+","+
						contact.getEmail2()+","+
						contact.getBDay()+","+
						contact.getBMonth()+","+
						contact.getBYear()+","+
						contact.getSupAddress()+","+
						contact.getSupPhone()+","+
						",!"+"\n");
		}
		writer.close();		
	}
}
