/**
 * 
 */
package com.mWebsite.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import com.mWebsite.bean.Contact;

/**
 * @author lxynox
 *
 */
public class ContactDaoImpl implements ContactDao {

	SqlConnector connector = SqlConnector.getInstance();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// test of getContacts()
		List<Contact> contactList = new ContactDaoImpl().getContacts();
		for (Contact contact: contactList) {
			Calendar time = contact.getTime();
			int year = time.get(Calendar.YEAR);
			int month = time.get(Calendar.MONTH);
			int day = time.get(Calendar.DAY_OF_MONTH);
			
			int hour = time.get(Calendar.HOUR);
			int minute = time.get(Calendar.MINUTE);
			int second = time.get(Calendar.SECOND);
			System.out.println (hour + ":" + minute + ":" + second);
			System.out.println (year + "/" + month + "/" + day);
		}
		
		// test of addContact()
		// create some contacts as demo
		Contact contact1 = new Contact (0, "xiaoli", "xiaoli@126.com", "haha", "father greeting", null);
		System.out.println (new ContactDaoImpl().addContact(contact1));
	}

	@Override
	public Contact getContact(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> getContacts() {
		List<Map<String, ?>> contactMapList = connector.getAllContactStringContainer();
		
		List<Contact> contactList = new ArrayList<Contact>();
		for (Map<String, ?> contactMap: contactMapList) {
			String name = (String) contactMap.get("name");
			String email = (String) contactMap.get("email");
			String message = (String) contactMap.get("message");
			String subject = (String) contactMap.get("subject");
			int id = (int) contactMap.get("id");
			Timestamp timestamp = (Timestamp) contactMap.get("time");
			Calendar time = new GregorianCalendar();
			time.setTime (timestamp);
			
			Contact contact = new Contact (id, name, email, message, subject, time);
			contactList.add (contact);
		}
//		System.out.println (contactList);
		return contactList;
	}

	@Override
	public boolean removeContact(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addContact(Contact contact) {
		String responseCode = connector.insertContact(contact);
		if (responseCode.equals("")) return true;
		// TODO: else if the responseCode.length() > 0 differentiate different cases  
		return false;
	}

}
