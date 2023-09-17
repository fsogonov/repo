/**
 * @author Fedor Sogonov
 * The PasswordCheckerUtility class provides methods for validating and checking the strength of passwords.
 */
import java.lang.String;
import java.util.ArrayList; 

public class PasswordCheckerUtility extends Object
{
	/**
    * Compares two passwords and throws an UnmatchedException if they do not match.
    *
    * @param p1 The first password to compare.
    * @param p2 The second password to compare.
    * @throws UnmatchedException If the passwords do not match.
    */
	public static void comparePasswords(String p1, String p2) throws UnmatchedException {
	    if (!p1.equals(p2)) {
	        throw new UnmatchedException("Passwords do not match");
	    }
	}
	/**
     * Compares two passwords and returns true if they match, false otherwise.
     *
     * @param p1 The first password to compare.
     * @param p2 The second password to compare.
     * @return True if the passwords match, false otherwise.
     */
	public static boolean comparePasswordsWithReturn(String p1, String p2) {
		return p1.equals(p2);
	}
	/**
     * Checks if a password has a valid length (at least 6 characters).
     *
     * @param password The password to check.
     * @return True if the password has a valid length, false otherwise.
     * @throws LengthException If the password length is less than 6 characters.
     */
	public static boolean isValidLength(String password) throws LengthException {
	    boolean b;
		if (password.length() >= 6) {
	        b = true;
	    } else {
	    	b = false;
	        throw new LengthException("The password must be at least 6 characters long");
	    }return b;
	}
	/**
     * Checks if a password contains at least one uppercase alphabetic character.
     *
     * @param password The password to check.
     * @return True if the password contains at least one uppercase alphabetic character, false otherwise.
     * @throws NoUpperAlphaException If the password lacks an uppercase alphabetic character.
     */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
	    boolean b = false;
	    for (int i = 0; i < password.length(); i++) {
	        if (Character.isUpperCase(password.charAt(i))) {
	            b = true;
	            break; 
	        }
	    }

	    if (!b) {
	        throw new NoUpperAlphaException("The password must have at least one uppercase alphabetic character");
	    }

	    return b;
	}
	  /**
     * Checks if a password contains at least one lowercase alphabetic character.
     *
     * @param password The password to check.
     * @return True if the password contains at least one lowercase alphabetic character, false otherwise.
     * @throws NoLowerAlphaException If the password lacks a lowercase alphabetic character.
     */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
		boolean b = false;
	    for (int i = 0; i < password.length(); i++) {
	        if (Character.isLowerCase(password.charAt(i))) {
	            b = true;
	            break; 
	        }
	    }

	    if (!b) {
	        throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character");
	    }

	    return b;
	}
	 /**
     * Checks if a password contains at least one digit.
     *
     * @param password The password to check.
     * @return True if the password contains at least one digit, false otherwise.
     * @throws NoDigitException If the password lacks a digit.
     */
	public static boolean hasDigit(String password) throws NoDigitException{
		boolean b = false;
	    for (int i = 0; i < password.length(); i++) {
	        if (Character.isDigit(password.charAt(i))) {
	            b = true;
	            break; 
	        }
	    }

	    if (!b) {
	        throw new NoDigitException("The password must have at least one digit");
	    }

	    return b;
	}
	 /**
     * Checks if a password contains at least one special character.
     *
     * @param password The password to check.
     * @return True if the password contains at least one special character, false otherwise.
     * @throws NoSpecialCharacterException If the password lacks a special character.
     */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
	    boolean b = false;
	    for (int i = 0; i < password.length(); i++) {
	        char c = password.charAt(i);
	        if (!Character.isDigit(c) && !Character.isLetter(c) && !Character.isWhitespace(c)) {
	            b = true;
	            break;
	        }
	    }

	    if (!b) {
	        throw new NoSpecialCharacterException("The password must contain at least one special character");
	    }

	    return b;
	}
	 /**
     * Checks if a password contains more than two consecutive identical characters.
     *
     * @param password The password to check.
     * @return True if the password does not contain more than two consecutive identical characters, false otherwise.
     * @throws InvalidSequenceException If the password contains more than two consecutive identical characters.
     */
	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException {
	    boolean b = true;
	    int count = 0;
	    for (int i = 0; i < password.length() - 1; i++) {
	        if (password.charAt(i) == password.charAt(i + 1)) {
	            count++;
	        } else {
	            count = 0; 
	        }

	        if (count > 1) {
	            b = false;
	            break;
	        }
	    }

	    if (!b) {
	        throw new InvalidSequenceException("The password should not contain more than 2 of the same character in sequence");
	    }

	    return b;
	}
	 /**
     * Checks if a password is valid based on various criteria.
     *
     * @param x The password to check.
     * @return True if the password is valid, false otherwise.
     * @throws LengthException           If the password length is less than 6 characters.
     * @throws NoUpperAlphaException     If the password lacks an uppercase alphabetic character.
     * @throws NoLowerAlphaException     If the password lacks a lowercase alphabetic character.
     * @throws NoDigitException          If the password lacks a digit.
     * @throws NoSpecialCharacterException If the password lacks a special character.
     * @throws InvalidSequenceException  If the password contains more than two consecutive identical characters.
     */
	public static boolean isValidPassword(String x) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
	    boolean isValid = true;

	    try {
	        // Check for password length
	        if (!isValidLength(x)) {
	            throw new LengthException("The password must be at least 6 characters long");
	        }

	        // Check for uppercase alphabetic character
	        if (!hasUpperAlpha(x)) {
	            throw new NoUpperAlphaException("The password must have at least one uppercase alphabetic character");
	        }

	        // Check for lowercase alphabetic character
	        if (!hasLowerAlpha(x)) {
	            throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character");
	        }

	        // Check for numeric character
	        if (!hasDigit(x)) {
	            throw new NoDigitException("The password must have at least one digit");
	        }

	        // Check for special character
	        if (!hasSpecialChar(x)) {
	            throw new NoSpecialCharacterException("The password must have at least one special character");
	        }

	        // Check for consecutive identical characters
	        if (!NoSameCharInSequence(x)) {
	            throw new InvalidSequenceException("The password should not have more than 2 of the same character in sequence");
	        }
	    } catch (LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException | NoSpecialCharacterException | InvalidSequenceException e) {
	        isValid = false;
	        throw e; 
	    }

	    return isValid;
	}
	  /**
     * Checks if a password has a length between 6 and 9 characters.
     *
     * @param password The password to check.
     * @return True if the password length is between 6 and 9 characters, false otherwise.
     */
	public static boolean hasBetweenSixAndNineChars(String password) {
		return (password.length() > 5 && password.length() < 10);		
	}
	 /**
     * Checks if a password is weak based on specific criteria.
     *
     * @param x The password to check.
     * @return True if the password is weak, false otherwise.
     * @throws WeakPasswordException    If the password is weak.
     * @throws LengthException           If the password length is less than 6 characters.
     * @throws NoUpperAlphaException     If the password lacks an uppercase alphabetic character.
     * @throws NoLowerAlphaException     If the password lacks a lowercase alphabetic character.
     * @throws NoDigitException          If the password lacks a digit.
     * @throws NoSpecialCharacterException If the password lacks a special character.
     * @throws InvalidSequenceException  If the password contains more than two consecutive identical characters.
     */
	 public static boolean isWeakPassword(String x) throws WeakPasswordException, LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
	        boolean b = false;

	        if (isValidPassword(x) && hasBetweenSixAndNineChars(x)) {
	            b = true;
	            throw new WeakPasswordException("Weak password");
	        }

	        return b;
	    }
	 /**
	     * Checks a list of passwords and returns a list of invalid passwords along with corresponding exception messages.
	     *
	     * @param ps The list of passwords to check.
	     * @return ArrayList containing invalid passwords and exception messages in the correct format.
	     */
	 public static ArrayList<String> getInvalidPasswords(ArrayList<String> ps) {
		    ArrayList<String> ips = new ArrayList<String>();
		    
		    for (int i = 0; i < ps.size(); i++) {
		        try {
		            if (!isValidPassword(ps.get(i))) {
		                ips.add(ps.get(i));
		            }
		        } catch (LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException
		                | NoSpecialCharacterException | InvalidSequenceException e) {
		            // Log the exception instead of throwing it
		        	ips.add(ps.get(i) + " " + e.getMessage());
		          // System.err.println("Exception for password: " + ps.get(i));
		           // e.printStackTrace();
		        }
		    }

		    return ips;
		}
	 }
