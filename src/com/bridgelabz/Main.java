package com.bridgelabz;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		MultipleAddressBook mbooks = new MultipleAddressBook();
		System.out.println("Add new AddressBook \n(Yes/No)");
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		while (str.equals("yes")) {
			mbooks.newAddressBook();
			System.out.println("Add new AddressBook \n(Yes/No)");
			str = sc.next();
		
		}
	mbooks.displayBook();
	
	}
}
