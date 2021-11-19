package com.bridgelabz;

public class AddressBook {
	public static void main(String[] args, String name) {
		System.out.println("Welcome to Address Book System. ");
		Contacts contacts = new Contacts();
		contacts.addContact(contacts);
		contacts.editContacts(name, contacts);
	}

}
