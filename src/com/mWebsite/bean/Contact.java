/**
 * 
 */
package com.mWebsite.bean;

import java.util.Calendar;

/**
 * @author lxynox
 *
 */
public class Contact {
	
	private int id;
	private String name;
	private String email;
	private String message;
	private String subject;
	private Calendar time;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//	constructors
	public Contact() {}
	public Contact(int id, String name, String email, String message,
			String subject, Calendar time) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.message = message;
		this.subject = subject;
		this.time = time;
	}
//	getter && setter
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * @return the time
	 */
	public Calendar getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(Calendar time) {
		this.time = time;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", email=" + email
				+ ", message=" + message + ", subject=" + subject + ", time="
				+ time + "]";
	}

	
	
}
