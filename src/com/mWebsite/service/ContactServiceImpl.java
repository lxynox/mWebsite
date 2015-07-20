/**
 * 
 */
package com.mWebsite.service;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mWebsite.bean.Contact;
import com.mWebsite.dao.ContactDao;
import com.mWebsite.dao.DaoFactory;
import com.mWebsite.dao.DaoFactoryImpl;

/**
 * @author lxynox
 *
 */
public class ContactServiceImpl extends HttpServlet implements ContactService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	DaoFactory daoFactory = new DaoFactoryImpl();
	ContactDao contactDao = daoFactory.createContactDao();
//	request type dispatcher
	public static final String REQUEST_ADD = "add";
	public static final String REQUEST_DISPLAY = "display";
	
	/* (non-Javadoc)
	 * @see com.mWebsite.service.ContactService#addContact(com.mWebsite.bean.Contact)
	 */
	@Override
	public boolean addContact(Contact contact) {
		return contactDao.addContact(contact);
	}

	/* (non-Javadoc)
	 * @see com.mWebsite.service.ContactService#displayContacts()
	 */
	@Override
	public List<Contact> displayContacts() {
		return contactDao.getContacts();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws IOException, ServletException {
		doGet(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws IOException, ServletException {
//		PrintWriter out = new PrintWriter(new File("test.text"));

		RequestDispatcher rd = null;
		
		if (request.getParameter("requestType").equals(REQUEST_ADD)) { 
			/* respond to add contact request */
//			 pass parameter here
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String message = request.getParameter("message");
			String subject = request.getParameter("subject");
			Contact contact = new Contact();
			
			contact.setName(name);
			contact.setEmail(email);
			contact.setMessage(message);
			contact.setSubject(subject);
			
			addContact(contact);
			request.setAttribute("contact", contact);
// TODO: delete contactList from this if block after the test
			List<Contact> contactList = displayContacts();
			request.getSession().getServletContext().setAttribute("contactList", contactList);

			rd = request.getRequestDispatcher("blog.jsp");

		} else if (request.getParameter("requestType").equals(REQUEST_DISPLAY)) {
			/* respond to display contacts request */
			List<Contact> contactList = displayContacts();
			request.setAttribute("contactList", contactList);
			rd = request.getRequestDispatcher("display.jsp");
		} else {
			// handle some other cases
		}
		//
		rd.forward(request, response);
	}
}
