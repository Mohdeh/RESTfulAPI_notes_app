import java.util.ArrayList;
import java.util.List;

import java.util.Date;

import javax.net.ssl.SSLSession;
import javax.swing.text.Document;
import javax.swing.text.View;
import javax.xml.crypto.Data;

import java.util.*;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.text.*;
import java.io.File;

//@Component
public class UserDAO {

	// Dummy database initialized with some dummy values.
	private static List user;
	{
		user = new ArrayList();
		user.add(new User("djohn@gmail.com", "JohnDoe", "12-07-2017", "04-04-2018"));
		user.add(new User("sruss@gmail.com", "RussSmith", "12-22-2017", "04-03-2018"));
		user.add(new User("kwilliams@gmail.com", "KateWilliams", "01-11-2018", "03-03-2018"));
	}

	/**
	 * Returns list of user from dummy database.
	 * 
	 * @return list of users
	 */
	public List list() {
		return user;
	}

	/**
	 * Return user object for given email from dummy database. If user is
	 * not found with the email, returns null.
	 * 
	 * @param email
	 *            user email
	 * @return user object for given email
	 */
	public User get(String email) {

		for (User u : user) {
			if (u.getEmail().equals(email)) {
				return u;
			}
		}
		return null;
	}

	/**
	 * Create new user in dummy database. Updates the email and insert new
	 * user in list.
	 * 
	 * @param user
	 *            User object
	 * @return user object with updated email
	 */
	public User create(User user) {
		user.setEmail(System.currentTimeMillis());
		((List) user).add(user);
		return user;
	}

	/**
	 * Delete the user object from dummy database. If user not found for
	 * given email, returns null.
	 * 
	 * @param user
	 *            the user email
	 * @return email of deleted User object
	 */
	public String delete(String email) {

		for (User u : user) {
			if (u.getEmail().equals(email)) {
				user.remove(u);
				return email;
			}
		}

		return null;
	}

	/**
	 * Update the User object for given email in dummy database. If user
	 * not exists, returns null
	 * 
	 * @param email
	 * @param user
	 * @return user object with email
	 */
	public User update(String email, User user) {

		for (User u : user) {
			if (u.getEmail().equals(email)) {
				user.setEmail(u.getEmail());
				((List) user).remove(u);
				((List) user).add(user);
				return user;
			}
		}

		return null;
	}

}
