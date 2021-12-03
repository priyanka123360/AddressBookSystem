package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {
	String firstName;
	String lastName;
	String address;
	String city;
	String state;
	int zip;
	long phoneNumber;
	String email;
	private static List<Contacts> contactList = new ArrayList<>();;

	public static List<Contacts> getContactList() {
		return contactList;
	}
	public static void setContactList(List<Contacts> contactList) {
		AddressBook.contactList = contactList;
	}


	Scanner sc = new Scanner(System.in);

	public void addContact() {

		Contacts person = new Contacts();
		System.out.println("Enter your First Name");
		firstName = sc.next();
		if (getIndex(firstName) == -1) {
		person.setFirstName(firstName);
		System.out.println("Enter your Last Name");
		lastName = sc.next();
		person.setLastName(lastName);
		System.out.println("Enter your Address");
		address = sc.next();
		person.setAddress(address);
		System.out.println("Enter your City");
		city = sc.next();
		person.setCity(city);
		System.out.println("Enter your State");
		state = sc.next();
		person.setState(state);
		System.out.println("Enter your ZipCode");
		zip = sc.nextInt();
		person.setZip(zip);
		System.out.println("Enter your Phone Number");
		phoneNumber = sc.nextLong();
		person.setPhoneNumber(phoneNumber);
		System.out.println("Enter your E-mail");
		email = sc.next();
		person.setEmail(email);
		contactList.add( new Contacts(firstName, lastName, address, city, state, zip, phoneNumber, email));
		}
	else {
			System.out.println("Enter name again");
		}
	}
	
	public void display() {
		int i = 1;
		for (Contacts s : contactList) {
			System.out.println(
					"Contact." + " [ FirstName=" + s.getFirstName() + ", FastName=" + s.getLastName() + ", Address="
							+ s.getAddress() + ", city=" + s.getCity() + ", state=" + s.getState() + ", zip-code="
							+ s.getZip() + ", Phone Number=" + s.getPhoneNumber() + ", email=" + s.getEmail() + "]");
		}
	}

	public int getIndex(String firstName) {
		int index = -1;
		for (int i = 0; i < contactList.size(); i++) {
			if (firstName.equals(contactList.get(i).getFirstName())) {
				return i;
			}
		}
		return index;
	}
	
	public boolean getDuplicate(String firstName) {
		
		for (int i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getFirstName().contains(firstName)) {
				return true;
			}
		}
		return false;
	}

	public void updateContact(int i) {

		System.out.println("Enter your First Name");
		firstName = sc.next();
		System.out.println("Enter your Last Name");
		lastName = sc.next();
		System.out.println("Enter your Address");
		address = sc.next();
		System.out.println("Enter your City");
		city = sc.next();
		System.out.println("Enter your State");
		state = sc.next();
		System.out.println("Enter your ZipCode");
		zip = sc.nextInt();
		System.out.println("Enter your Phone Number");
		phoneNumber = sc.nextLong();
		System.out.println("Enter your E-mail");
		email = sc.next();

		contactList.set(i,(new Contacts(firstName, lastName, address, city, state, zip, phoneNumber, email)));

	}

	
	public void removeContact(int index) {
		contactList.remove(index);

	}
	
}