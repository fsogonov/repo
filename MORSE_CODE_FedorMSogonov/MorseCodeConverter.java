import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * MorseCodeConverter is a utility class for converting Morse code to English and printing the Morse Code tree.
 * It uses a MorseCodeTree instance to perform the conversions.
 */
public class MorseCodeConverter {
    static MorseCodeTree mct = new MorseCodeTree();

    /**
     * Prints the Morse Code tree in LNR order with spaces in between them.
     *
     * @return a string with all the data in the tree in LNR order separated by a space
     */
    public static String printTree() {
        ArrayList<String> a = mct.toArrayList();
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < a.size(); i++) {
            s.append(a.get(i)).append(" ");
        }
        return s.toString().trim();
    }

    /**
     * Converts Morse code into English. Each letter is delimited by a space (' ').
     * Each word is delimited by a '/'.
     *
     * @param phrase the Morse code
     * @return the English translation
     */
    public static String convertToEnglish(String phrase) {
        StringBuilder ans = new StringBuilder();
        StringBuilder let = new StringBuilder();

        for (int i = 0; i < phrase.length(); i++) {
            char currentChar = phrase.charAt(i);

            if (currentChar == '.' || currentChar == '-') {
                let.append(currentChar);
            } else if (currentChar == '/') {
                ans.append(" ");
                let = new StringBuilder();
            } else if (currentChar == ' ') {
                ans.append(mct.fetch(let.toString()));
                let = new StringBuilder();
            }
        }
        ans.append(mct.fetch(let.toString()));
        return ans.toString();
    }

    /**
     * Converts a file of Morse code into English. Each letter is delimited by a space (' ').
     * Each word is delimited by a '/'.
     *
     * @param codeFile the File that contains Morse Code
     * @return the English translation of the file
     * @throws FileNotFoundException if the file is not found
     */
    public static String convertToEnglish(File codeFile) throws FileNotFoundException {
        try (Scanner myReader = new Scanner(codeFile)) {
            StringBuilder data = new StringBuilder();

            while (myReader.hasNextLine()) {
                data.append(myReader.nextLine());
            }

            return convertToEnglish(data.toString());
        } catch (FileNotFoundException e) {
            throw e;
        }
    }
}


