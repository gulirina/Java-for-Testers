package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
		  for(int i=0;i<amount;i++){
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
	
	public static List<ContactData> loadContactsFromXmlFile(File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		return (List<ContactData>) xstream.fromXML(file);
	}

	//======================================================================================

	private static void saveContactToCsvFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write(contact.getFirstName()+","+
						contact.getSecondName()+","+
						contact.getMainAddress()+","+
						contact.gethPhone()+","+
						contact.getmPhone()+","+
						contact.getwPhone()+","+
						contact.getEmail1()+","+
						contact.getEmail2()+","+
						contact.getbDay()+","+
						contact.getbMonth()+","+
						contact.getbYear()+","+
						contact.getGroupName()+","+
						contact.getSupAddress()+","+
						contact.getSupPhone()+
						",!"+"\n");
		}
		writer.close();		
	}
	
	public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException{
		List<ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line!=null) {
			String[] part = line.split(",");
			ContactData contact = new ContactData()
				.withFirstName(part[0])
				.withSecondName(part[1])
				.withMainAddress(part[2])
				.withHPhone(part[3])
				.withMPhone(part[4])
				.withWPhone(part[5])
				.withEmail1(part[6])
				.withEmail2(part[7])
				.withBDay(part[8])
				.withBMonth(part[9])
				.withBYear(part[10])
				.withGroupName(part[11])
				.withSupAddress(part[12])
				.withSupPhone(part[13]);
			list.add(contact);
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
		return list;		
	}
}
