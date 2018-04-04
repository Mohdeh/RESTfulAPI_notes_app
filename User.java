import java.util.*;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.text.*;
import java.io.File;
//import javax.validation.constraints.*;

public class User {
	
	private String email;
	
	private String password;
	
	//Date now = new Date();
	
	public User(String userEmail, String userPass, Date createTime, Date lastUpdate){
		this.email = userEmail;
        this.password = userPass;
		createTime = new Date();
		java.util.Date lastUpdate1 = new java.util.Date(User.lastModified());
}
	
//private static String lastModified() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	public static long lastModified() {
		return 0;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String userEmail) {
		this.email = userEmail;
	}
    
	

}
