package junit;

import org.junit.Test;

import banksystem.PasswordManager;
import junit.framework.Assert;

public class PasswordLengthTest {

	@Test
	public void checkLessMinLength() {
		String password = "A";
		Assert.assertEquals("Password minimum " + PasswordManager.PASSWORD_MIN_CHARS + " characters", PasswordManager.validate(password));
	}
	
	@Test
	public void checkZeroLength() {
		String password = "";
		Assert.assertEquals("Password minimum " + PasswordManager.PASSWORD_MIN_CHARS + " characters", PasswordManager.validate(password));
	}
	
	@Test
	public void checkMinLength() {
		String password = "A$1jesgt";
		Assert.assertEquals("valid", PasswordManager.validate(password));
	}
	
	@Test
	public void checkGreaterMaxLength() {
		String password = "123456789123456789123";
		Assert.assertEquals("Password maximum " + PasswordManager.PASSWORD_MAX_CHARS + " characters", PasswordManager.validate(password));
	}
	@Test
	public void checkMaxLength() {
		String password = "12345$78912345678c1A";
		Assert.assertEquals("valid", PasswordManager.validate(password));
	}
	@Test
	public void checkValidLength() {
		String password = "s123$aFtashklkjgdsfg";
		Assert.assertEquals("valid", PasswordManager.validate(password));
	}
	
	@Test
	public void checkOneSpace() {
		String password = " $4sfgfs";
		Assert.assertEquals("Password cannot contain space(s)", PasswordManager.validate(password));
	}
	
	@Test
	public void checkSpaceInPassword() {
		String password = "1 $dfs45";
		Assert.assertEquals("Password cannot contain space(s)", PasswordManager.validate(password));
	}

}
