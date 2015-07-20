/**
 * 
 */
package com.mWebsite.dao;

import java.util.List;

import com.mWebsite.bean.Contact;

/**
 * @author lxynox
 * Date: Jul, 16, 2015
 * Description: java bean (encapsulate the comments information from others)
 */
public interface ContactDao {
//	select contact
	/** get the Contact from given contact id
	 * return the target Contact based on id
	 * @param id contact id
	 * @return corresponding Contact 
	 */
	Contact getContact (int id);
	List<Contact> getContacts ();
	
//	delete contact
	/** indicate whether the contact is removed from database
	 * 
	 * @param id
	 * @return whether the contact is removed from database
	 */
	boolean removeContact (int id);
	
//	insert contact
	/** indicate whether the contact is added into the database
	 * 
	 * @param contact
	 * @return whether the contact is added into the database
	 */
	boolean addContact (Contact contact);
	
}
