import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Pr1 {

    // Method to check if a string is a valid identifier
    public static boolean checkIdentifier(String string) {
        // If string is empty, it's not a valid identifier
        if (string.isEmpty())
            return false;

        // First character of identifier should be a letter or underscore
        char firstChar = string.charAt(0);
        if (!(Character.isLetter(firstChar) || firstChar == '_'))
            return false;

        // Remaining characters should be a letter, digit or underscore
        for (int index = 1; index < string.length(); index++) {
            char letter = string.charAt(index);
            if (!(Character.isLetter(letter) || Character.isDigit(letter) || letter == '_'))
                return false;
        }
        return true;
    }

    // Method to check if a word is a keyword
    public static boolean linearSearchKeyword(String word) {
        // List of keywords
        String[] keywords = { "int", "(", ")", ";", "\n", "\t", "{", "}", " ", ","};
        for (String keyword : keywords) {
            if (keyword.equals(word))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

        try {
            // Open the file
            File filename = new File("program.c");
            Scanner dataReader = new Scanner(filename);
            // Read the file line by line
            while (dataReader.hasNextLine()) {
                String fileData = dataReader.nextLine().trim();

                // Split the line into words
                String[] words = fileData.split(" ");
                for (String word : words) {

                    // Check if the word is a keyword
                    if (linearSearchKeyword(word))
                        System.out.println(word + " is a keyword");

                    // Check if the word is an identifier
                    else if (checkIdentifier(word))
                        System.out.println(word + " is an identifier");

                    // If the word is neither a keyword nor an identifier, it's invalid
                    else
                        System.out.println(word + " is invalid (others)");
                }
            }
            // Close the file reader
            dataReader.close();
        } catch (FileNotFoundException exception) {
            // Handle file not found exception
            System.out.println("Unexpected error occurred!");
            exception.printStackTrace();
        }
    }
}