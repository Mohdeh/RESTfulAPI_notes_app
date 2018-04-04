import java.util.Date;
import java.util.*;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.text.*;
import java.io.File;
//import javax.validation.constraints.*;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

class Note extends User {

	public Note(String userEmail, String userPass, Date createTime, Date lastUpdate) {
		super(userEmail, userPass, createTime, lastUpdate);
		// TODO Auto-generated constructor stub
	}
	
//	@NotNull
//  @Pattern(regexp = Constants.LOGIN_REGEX)
//  @Size(min = 1, max = 50)
	private String Title;
	
//	@Size(max = 50)
	private String Note;
	
}

