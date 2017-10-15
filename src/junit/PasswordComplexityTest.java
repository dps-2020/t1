package junit;

import org.junit.Test;

import banksystem.PasswordManager;
import junit.framework.Assert;

public class PasswordComplexityTest {
	
	@Test
	public void checkMinimumUpperCaseCharacters() {
		String password = "$2f4567a";
		Assert.assertEquals("Password must contain at least " + 
		PasswordManager.PASSWORD_MIN_UPPERCASE_CHARS + " uppercase character", PasswordManager.validate(password));
	}
	
	@Test
	public void checkMinimumLowerCaseCharacters() {
		String password = "$2F4567A";
		Assert.assertEquals("Password must contain at least " + 
		PasswordManager.PASSWORD_MIN_UPPERCASE_CHARS + " lowercase character", PasswordManager.validate(password));
	}
	
	@Test
	public void checkMinimumSpecialCharacters() {
		String password = "gAF4567A";
		Assert.assertEquals("Password must contain at least " + 
		PasswordManager.PASSWORD_MIN_SPECIAL_CHARS + " special character", PasswordManager.validate(password));
	}
	
	@Test
	public void checkMinimumAlphaNumericCharacters() {
		String password = "#@#$%^$#";
		Assert.assertEquals("Password must contain at least " + 
		PasswordManager.PASSWORD_MIN_ALPHA_NUMERIC_CHARS + " alphanumeric character", PasswordManager.validate(password));
	}

}
