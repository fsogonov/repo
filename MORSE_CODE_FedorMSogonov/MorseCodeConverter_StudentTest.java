


import static org.junit.Assert.*;

	import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
	import java.io.IOException;

import org.junit.Test;

	public class MorseCodeConverter_StudentTest {

	    private static final String TEXT_TO_ENCODE = "for our struggle is not against flesh and blood but against the rulers against the authorities against the powers of this dark world and against the spiritual forces of evil in the heavenly realms";
	    private static final String MORSE = "..-. --- .-. / --- ..- .-. / ... - .-. ..- --. --. .-.. . / .. ... / -. --- - / .- --. .- .. -. ... - / ..-. .-.. . ... .... / .- -. -.. / -... .-.. --- --- -.. / -... ..- - / .- --. .- .. -. ... - / - .... . / .-. ..- .-.. . .-. ... / .- --. .- .. -. ... - / - .... . / .- ..- - .... --- .-. .. - .. . ... / .- --. .- .. -. ... - / - .... . / .--. --- .-- . .-. ... / --- ..-. / - .... .. ... / -.. .- .-. -.- / .-- --- .-. .-.. -.. / .- -. -.. / .- --. .- .. -. ... - / - .... . / ... .--. .. .-. .. - ..- .- .-.. / ..-. --- .-. -.-. . ... / --- ..-. / . ...- .. .-.. / .. -. / - .... . / .... . .- ...- . -. .-.. -.-- / .-. . .- .-.. -- ...";
	   
	    @Test
	    public void testConvertToEnglish() {
	        String morseCode = MORSE;
	        String result = MorseCodeConverter.convertToEnglish(morseCode);

	        assertEquals(TEXT_TO_ENCODE, result);
	    }

	    @Test
	    public void testConvertToEnglishFromFile() throws IOException {
	      
	    	File file = new File("src/MY_FILE.txt"); 
			try {
				assertEquals(TEXT_TO_ENCODE, MorseCodeConverter.convertToEnglish(file));
			} catch (FileNotFoundException e) {
				assertTrue("An unwanted exception was caught", false);
			}
	    	

	        
	    }
	}
