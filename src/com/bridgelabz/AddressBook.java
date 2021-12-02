package com.bridgelabz;

import java.util.ArrayList;

import java.util.List;
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
	private List<Contacts> contactList = new ArrayList<>();;

	Scanner sc = new Scanner(System.in);

	public void addContact() {

		Contacts person = new Contacts();
		System.out.println("Enter your First Name");
		firstName = sc.next();
		if (getIndex(firstName)==-1) {
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
		contactList.add(new Contacts(firstName, lastName, address, city, state, zip, phoneNumber, email));
		}else {
			System.out.println("Enter name again");
		}
	}

	public void display() {
		int i = 1;
		for (Contacts s : contactList) {
			System.out.println(
					"Contact." + i + " [ FirstName=" + s.getFirstName() + ", FastName=" + s.getLastName() + ", Address="
							+ s.getAddress() + ", city=" + s.getCity() + ", state=" + s.getState() + ", zip-code="
							+ s.getZip() + ", Phone Number=" + s.getPhoneNumber() + ", email=" + s.getEmail() + "]");
			i++;
		}
	}

	private int getIndex(String firstName) {
		int index = -1;
		for (int i = 0; i < contactList.size(); i++) {
			if (firstName.equals(contactList.get(i).getFirstName())) {
				return i;
			}
		}
		return index;
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

		contactList.add((new Contacts(firstName, lastName, address, city, state, zip, phoneNumber, email)));

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AddressBook addressBook = new AddressBook();
		int act;
		System.out.println("Welcome to Address Book");
		do {
			System.out.println("Enter\n1.Add\n2.Update\n3.Delete\n4.Print\n5.Exit");
			act = sc.nextInt();
			int index = -1;
			String fName;
			switch (act) {
			case 1:
				addressBook.addContact();
				break;
			case 2:
				System.out.println("Enter your First name to update");
				fName = sc.next();
				index = addressBook.getIndex(fName);
				if (index < 0) {
					break;
				}
				addressBook.updateContact(index);
				break;
			case 3:
				System.out.println("Enter your First name to delete");
				fName = sc.next();
				index = addressBook.getIndex(fName);
				addressBook.removeContact(index);
				break;

			case 4:
				addressBook.display();
				break;
			case 5:
				System.out.println("Bye Bye");
				System.exit(0);
			}
		} while (act > 0 || act > 5);
		sc.close();
	}

	public void removeContact(int index) {
		contactList.remove(index);

	}
	
}