package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contacts {
	Scanner sc = new Scanner(System.in);
	private String first_Name;
	private String last_Name;
	private String address;
	private String city_Name;
	private String state_Name;
	private String zip;
	private String phone_Number;
	private String email;
	List<Contacts> contactList = new ArrayList<Contacts>();

	/*
	 * public Contacts(String first_Name, String last_Name, String address, String
	 * city_Name, String state_Name, String zip, String phone_Number, String email)
	 * { super(); this.first_Name = first_Name; this.last_Name = last_Name;
	 * this.address = address; this.city_Name = city_Name; this.state_Name =
	 * state_Name; this.zip = zip; this.phone_Number = phone_Number; this.email =
	 * email; }
	 */

	public Contacts() {
		super();
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		this.address = address;
		this.city_Name = city_Name;
		this.state_Name = state_Name;
		this.zip = zip;
		this.phone_Number = phone_Number;
		this.email = email;
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public String getAddress() {
		return address;
	}

	public String getCity_Name() {
		return city_Name;
	}

	public String getState_Name() {
		return state_Name;
	}

	public String getZip() {
		return zip;
	}

	public String getPhone_Number() {
		return phone_Number;
	}

	public String getEmail() {
		return email;
	}

	public void addContact() {
		System.out.println("Enter your First Name");
		first_Name = sc.next();
		System.out.println("Enter your Last Name");
		last_Name = sc.next();
		System.out.println("Enter your Address");
		address = sc.next();
		System.out.println("Enter your City");
		city_Name = sc.next();
		System.out.println("Enter your State");
		state_Name = sc.next();
		System.out.println("Enter your ZipCode");
		zip = sc.next();
		System.out.println("Enter your Phone Number");
		phone_Number = sc.next();
		System.out.println("Enter your E-mail");
		email = sc.next();
		contactList.add(new Contacts());
	}

}
