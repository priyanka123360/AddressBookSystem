package com.bridgelabz;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Map.Entry;

public class AddressBook {
	private static final String String = null;
	String firstName;
	String lastName;
	String address;
	String city;
	String state;
	String zip;
	long phoneNumber;
	String email;

	public AddressBook() {
		contactList = new ArrayList<>();
	}

	MultipleAddressBook mbooks = new MultipleAddressBook();

	public static List<Contacts> contactList = new ArrayList<>();

	public List<Contacts> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contacts> contactList) {
		AddressBook.contactList = contactList;
	}

	Scanner sc = new Scanner(System.in);

	public List<Contacts> addContact() {

		Contacts contacts = new Contacts();
		System.out.println("Enter your First Name");
		firstName = sc.next();
		if (checkDuplicate(firstName) == false) {
			contacts.setFirstName(firstName);
			System.out.println("Enter your Last Name");
			lastName = sc.next();
			contacts.setLastName(lastName);
			System.out.println("Enter your Address");
			address = sc.next();
			contacts.setAddress(address);
			System.out.println("Enter your City");
			city = sc.next();
			contacts.setCity(city);
			System.out.println("Enter your State");
			state = sc.next();
			contacts.setState(state);
			System.out.println("Enter your ZipCode");
			zip = sc.next();
			contacts.setZip(zip);
			System.out.println("Enter your Phone Number");
			phoneNumber = sc.nextInt();
			contacts.setPhoneNumber(phoneNumber);
			System.out.println("Enter your E-mail");
			email = sc.next();
			contacts.setEmail(email);
			contactList.add(new Contacts(firstName, lastName, address, city, state, zip, phoneNumber, email));
		} else {
			System.out.println("Duplicate value cant be add");
		}
		return contactList;
	}

	public void display() {
		contactList.stream().forEach(System.out::println);
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

	public boolean checkDuplicate(String firstName) {

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
		zip = sc.next();
		System.out.println("Enter your Phone Number");
		phoneNumber = sc.nextLong();
		System.out.println("Enter your E-mail");
		email = sc.next();

		contactList.set(i, (new Contacts(firstName, lastName, address, city, state, zip, phoneNumber, email)));

	}

	public void removeContact(int index) {
		contactList.remove(index);

	}

	public void searchByCity_or_State_Name() {

		System.out.println("Enter City Name  or State Name ");
		String searchText = sc.next();
		Long countContacts = contactList.stream()
				.filter(c -> (c.getCity().equals(searchText) || c.getState().equals(searchText)))
				.peek(System.out::println).count();
		System.out.println("The number of Contacts in City or State :" + searchText + " = " + countContacts);

	}

	public void view_By_City_or_State_Name() {

		System.out.println("Enter City Name  or State Name ");
		String searchText = sc.next();
		contactList.stream().filter(c -> (c.getCity().equals(searchText) || c.getState().equals(searchText))).forEach(
				p -> System.out.println("First Name : " + p.getFirstName() + "  Last Name : " + p.getLastName()));

	}

	public static void sortedContactByFirstName() {

		List<Contacts> sortedContact = contactList.stream().sorted(new compareFirstName()).collect(Collectors.toList());
		System.out.println(sortedContact);
	}

	public static void sortedContactByCity() {
		contactList.stream().sorted(new compareCity()).forEach(System.out::println);

	}

	public static void sortedContactByState() {
		contactList.stream().sorted(new compareState()).forEach(System.out::println);

	}

	public static void sortedContactByZip() {
		contactList.stream().sorted(new compareZip()).forEach(System.out::println);

	}

}

class compareFirstName implements Comparator<Contacts> {

	@Override
	public int compare(Contacts o1, Contacts o2) {

		return o1.getFirstName().compareTo(o2.getFirstName());
	}

}

class compareCity implements Comparator<Contacts> {

	@Override
	public int compare(Contacts o1, Contacts o2) {
		return o1.getCity().compareTo(o2.getCity());
	}

}

class compareState implements Comparator<Contacts> {

	@Override
	public int compare(Contacts o1, Contacts o2) {
		return o1.getState().compareTo(o2.getState());
	}

}

class compareZip implements Comparator<Contacts> {

	@Override
	public int compare(Contacts o1, Contacts o2) {
		return o1.getZip().compareTo(o2.getZip());
	}
}
