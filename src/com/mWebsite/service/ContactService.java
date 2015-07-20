/**
 * 
 */
package com.mWebsite.service;

import java.util.List;

import com.mWebsite.bean.Contact;

/**
 * @author lxynox
 * @Date: Jul, 17, 2015
 * @description: 1. add new comment to me 2. display old comments
 */
public interface ContactService extends Service {
	/** Add new contact to the back-end
	 * return whether the add operation is done successfully
	 * @param contact
	 * @return whether the contact is added successfully 
	 */
	boolean addContact(Contact contact);
	
	/** Get all the contacts from back-end
	 * 	retrieve all the contacts 
	 * @return list of contacts
	 */
	List<Contact> displayContacts();
}
