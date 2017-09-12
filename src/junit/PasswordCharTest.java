package junit;

import junit.framework.Assert;
import org.junit.Test;
import banksystem.PasswordManager;


public class PasswordCharTest {
	
	
	@Test
	//test to check for non-alphanumeric characters in password
	public void checkAtLeastOneNonANumeric() {
		String password = "J12345";
		Assert.assertEquals("Password must contain at least 1 non-alphanumeric character", PasswordManager.validate(password));
	}
	
	@Test
	public void checkValidPassword() {
		String password = "J12*";
		Assert.assertEquals("valid", PasswordManager.validate(password));
	}
	
	@Test
	public void checkAtLeastOneANumeric() {
		String password = "$#$";
		Assert.assertEquals("Password must contain at least 1 alphanumeric character", PasswordManager.validate(password));
	}
	
	@Test
	public void checkOneSpace() {
		String password = " $";
		Assert.assertEquals("Password cannot contain space(s)", PasswordManager.validate(password));
	}
	
	@Test
	public void checkSpaceInPassword() {
		String password = "1 $";
		Assert.assertEquals("Password cannot contain space(s)", PasswordManager.validate(password));
	}

}
