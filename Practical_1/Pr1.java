import java.io.*;
import java.util.*;

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
        String[] keywords = { "int", "(", ")", ";", "\n", "\t", "{", "}", " ", "," };
        for (String keyword : keywords) {
            if (keyword.equals(word))
                return true;
        }
        return false;
    }

    public static boolean checkOperator(String word) {
        // List of operators
        String[] arithmetic_ops = { "+", "-", "*", "%", "/" };
        String[] logical_ops = { "&&", "!", "||"};
        String[] assignment_ops = { "=", "<=", ">=", "==", "+=", "-=", "*=", "/="};

        for (String operator : arithmetic_ops) {
            if (operator.equals(word)) {
                System.out.println(word + " is an arithmetic operator");
                return true;
            }
        }

        for (String operator : logical_ops) {
            if (operator.equals(word)) {
                System.out.println(word + " is a logical operator");
                return true;
            }
        }

        for (String operator : assignment_ops) {
            if (operator.equals(word)) {
                System.out.println(word + " is an assignment operator");
                return true;
            }
        }

        return false;
    }

    public static boolean checkIsNumber(String string) {
        for (int index = 0; index < string.length(); index++) {
            char letter = string.charAt(index);
            if (!(Character.isDigit(letter)))
                return false;
        }
        return true;
    }

    public static boolean checkIsLiteral(String string) {
        int length = string.length();

        for (int index = 0; index < string.length(); index++) {
            char letter = string.charAt(index);

            if (index == 0 || index == (length - 1))
                if (!Objects.equals(letter, '"'))
                    return false;
        }
        return true;
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

                    else if (checkIsNumber(word))
                        System.out.println(word + " is a number");

                    else if (checkIsLiteral(word))
                        System.out.println(word + " is a string literal");

                    else if (checkOperator(word))
                        break;
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