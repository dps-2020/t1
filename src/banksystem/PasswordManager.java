package banksystem;

import database.Database;

public class PasswordManager {
	
	Database database = Database.getInstance();
	
	public static final int PASSWORD_MIN_CHARS = 8;
	public static final int PASSWORD_MAX_CHARS = 20;
	public static final int PASSWORD_MIN_UPPERCASE_CHARS = 1;
	public static final int PASSWORD_MIN_LOWERCASE_CHARS = 1;
	public static final int PASSWORD_MIN_SPECIAL_CHARS = 1;
	public static final int PASSWORD_MIN_ALPHA_NUMERIC_CHARS = 1;

	public static String authenticate(String password, String expectedPassword) {
		if (password.equals(expectedPassword)) {
			return ("valid");
		} else {
			return ("Invalid Password");
		}
	}
	
	public static String validate(String password) {
		
		int numberSpecialCharacters = 0;
		int numberAlphaNumerics = 0;
		int numberUpperCaseCharacters = 0;
		int numberLowerCaseCharacters = 0;
		
		if (password.length() < PASSWORD_MIN_CHARS) {
			return ("Password minimum " + PASSWORD_MIN_CHARS + " characters");
		}
		if (password.length() > 20) {
			return ("Password maximum " + PASSWORD_MAX_CHARS + " characters");
		}
		if (password.contains(" ")) {
			return ("Password cannot contain space(s)");
		}				
		
		for (Character ch : password.toCharArray()) {
			if (!Character.isLetterOrDigit(ch)) {
				numberSpecialCharacters++;
			}
			if (Character.isLetterOrDigit(ch)) {
				numberAlphaNumerics++;
				if (Character.isUpperCase(ch)) {
					numberUpperCaseCharacters++;
				} else if (Character.isLowerCase(ch)) {
					numberLowerCaseCharacters++;
				}
			}
		}
		if (numberSpecialCharacters < PASSWORD_MIN_SPECIAL_CHARS) {
			
			return ("Password must contain at least " + PASSWORD_MIN_SPECIAL_CHARS + " special character");
		} else if (numberAlphaNumerics < PASSWORD_MIN_ALPHA_NUMERIC_CHARS) {
			
			return ("Password must contain at least " + PASSWORD_MIN_ALPHA_NUMERIC_CHARS + " alphanumeric character");
		} else if (numberUpperCaseCharacters < PASSWORD_MIN_UPPERCASE_CHARS) {
			
			return ("Password must contain at least " + PASSWORD_MIN_UPPERCASE_CHARS + " uppercase character");
		} else if (numberLowerCaseCharacters < PASSWORD_MIN_LOWERCASE_CHARS) {
			
			return ("Password must contain at least " + PASSWORD_MIN_LOWERCASE_CHARS + " lowercase character");
		} else {
			return ("valid");
		}
	}
}
