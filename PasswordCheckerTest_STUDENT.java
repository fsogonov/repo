
/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Fedor Sogonov
 *
 */
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PasswordCheckerTest_STUDENT {

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort() {
        try {
            PasswordCheckerUtility.isValidLength("abc"); 
            fail("Expected LengthException");
        } catch (LengthException e) {}

        
        try {
            PasswordCheckerUtility.isValidLength("abcdef"); 
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
            PasswordCheckerUtility.hasUpperAlpha("abcdef"); 
            fail("Expected NoUpperAlphaException");
        } catch (NoUpperAlphaException e) {}

        
        try {
            PasswordCheckerUtility.hasUpperAlpha("abcdeF"); 
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
            PasswordCheckerUtility.hasLowerAlpha("ABCDEF"); 
            fail("Expected NoLowerAlphaException");
        } catch (NoLowerAlphaException e) {}

        
        try {
            PasswordCheckerUtility.hasLowerAlpha("abcdeF"); 
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 * @throws InvalidSequenceException 
	 * @throws NoSpecialCharacterException 
	 * @throws NoDigitException 
	 * @throws NoLowerAlphaException 
	 * @throws NoUpperAlphaException 
	 * @throws LengthException 
	 */
	@Test
	public void testIsWeakPassword() throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException
	{
		try {
            PasswordCheckerUtility.isWeakPassword("a_b1De"); 
            fail("Expected WeakPasswordException");
        } catch (WeakPasswordException e) {}

        
        try {
            PasswordCheckerUtility.isWeakPassword("a_bcD1fghG"); 
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
            PasswordCheckerUtility.NoSameCharInSequence("aaa_bcDe"); 
            fail("Expected InvalidSequenceException");
        } catch (InvalidSequenceException e) {}

        
        try {
            PasswordCheckerUtility.NoSameCharInSequence("a_bcDefghG"); 
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
        }
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
            PasswordCheckerUtility.hasDigit("aaa_bcDe"); 
            fail("Expected NoDigitException");
        } catch (NoDigitException e) {}

        
        try {
            PasswordCheckerUtility.hasDigit("a1bcDefghG"); 
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful() {
	    try {
	        // Provide a valid password, it should not throw an exception
	        assertTrue(PasswordCheckerUtility.isValidPassword("Valid_Password123"));
	    } catch (Exception e) {
	        fail("Unexpected exception: " + e.getMessage());
	    }
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		try {
            // Create an ArrayList of passwords with both valid and invalid passwords
            ArrayList<String> passwords = new ArrayList<>(Arrays.asList("abc", "abcdef", "a12_3456", "Abcdefg"));

            // Call the PasswordChecker method to get invalid passwords
            ArrayList<String> invalidPasswords = PasswordCheckerUtility.getInvalidPasswords(passwords);

            // Check if the invalidPasswords ArrayList contains the expected invalid passwords
            assertTrue(invalidPasswords.contains("abc The password must be at least 6 characters long"));
            assertTrue(invalidPasswords.contains("a12_3456 The password must have at least one uppercase alphabetic character"));
            assertFalse(invalidPasswords.contains("abcdef The password must contain at least one lowercase alphabetic character"));
            assertFalse(invalidPasswords.contains("Abcdefg The password must have at least one digit "));
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
	}
	
}
