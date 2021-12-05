package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class AddressBook {
	private static final String String = null;
	String firstName;
	String lastName;
	String address;
	String city;
	String state;
	int zip;
	long phoneNumber;
	String email;

	MultipleAddressBook mbooks = new MultipleAddressBook();

	public static List<Contacts> contactList = new ArrayList<>();

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
	}

	public void display() {
		int i = 1;
		for (Contacts s : contactList) {
			System.out.println(
					"Contact." + " [ FirstName=" + s.getFirstName() + ", LastName=" + s.getLastName() + ", Address="
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

		contactList.set(i, (new Contacts(firstName, lastName, address, city, state, zip, phoneNumber, email)));

	}

	public void removeContact(int index) {
		contactList.remove(index);

	}

	public void searchByCityName() {
		Map<String, String> map = new HashMap<>();
		System.out.println("Enter City Name or State Name");
		String searchText = sc.next();

		for (int i = 0; i < contactList.size(); i++) {
//			System.out.println("city name : "+ contactList.get(i).getCity().contains(cityName));
			if (contactList.get(i).getCity().contains(searchText)
					|| contactList.get(i).getState().contains(searchText)) {
				System.out.println("Result according to city name : " + contactList.get(i));

			} else {
				System.out.println("No Match Found.");
			}
			for (Map.Entry<String, String> entry : map.entrySet()) {
				System.out.println(entry.getKey() + "-" + entry.getValue());
			}
		}
	}
}