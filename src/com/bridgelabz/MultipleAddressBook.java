package com.bridgelabz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MultipleAddressBook {
	Map<String, List> mbook = new HashMap<>();
	Scanner sc = new Scanner(System.in);
	static String bookName = "";

	public void newAddressBook() throws IOException {
		AddressBook addressBook = new AddressBook();
		System.out.println("Enter new Address Book Name");
		bookName = sc.next();
		if (mbook.containsKey(bookName)) {
			System.out.println("Book Name is aleady Exist.");
		} else {
			addAddressBook();
			mbook.put(bookName, addressBook.getContactList());
		}
	}

	public void addAddressBook() throws IOException {
		AddressBook addressBook = new AddressBook();

		int act;
		System.out.println("Welcome to Address Book");
		List<Contacts> contactList = new ArrayList<Contacts>();
		do {
			System.out.println(
					"Enter\n1.Add\n2.Update\n3.Delete\n4.Print\n5.Search by City or State \n6.View by City or State"
							+ "\n7.Sort by Name \n8.Sort by City \n9.Sort by State \n10.Sort by Zip \n11.Exit");
			act = sc.nextInt();
			int index = -1;
			String fName;
			switch (act) {
			case 1:
				contactList = addressBook.addContact();
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
				addressBook.searchByCity_or_State_Name();
				break;
			case 6:
				addressBook.view_By_City_or_State_Name();
				break;
			case 7:
				addressBook.sortedContactByFirstName();
				break;
			case 8:
				addressBook.sortedContactByCity();
				break;
			case 9:
				addressBook.sortedContactByState();
				break;
			case 10:
				addressBook.sortedContactByZip();
				break;
			case 11:
				System.out.println("Exit" + bookName);
				act = 0;
				break;

			}
		} while (act > 0 || act > 12);
		AddressBookFileIO fileIO = new AddressBookFileIO();
		System.out.println(contactList);
		fileIO.writeAddressBook(contactList);
	}

	public void displayBook() {
		System.out.println("AddressBooks");
		mbook.entrySet().stream().forEach(System.out::println);

	}

}
