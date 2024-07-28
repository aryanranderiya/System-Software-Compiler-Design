import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Pr1 {

    public static boolean checkIdentifier(String string) {
        for (int index = 0; index < string.length(); index++) {
            char letter = string.charAt(index);
            if (index == 0 && (Character.isLetter(letter) || Character.isDigit(letter) || letter == '_'))
                return true;
            else if (Character.isLetter(letter) || Character.isDigit(letter))
                return true;
        }
        return false;
    }

    public static boolean linearSearchKeyword(String word) {
        String[] keywords = { "int", "(", ")", ";", "\n", "\t", "{", "}", " ", "," };
        for (String keyword : keywords)
            if (keyword.equals(word))
                return true;
        return false;
    }

    public static void main(String[] args) {

        try {
            File filename = new File("program.c");
            Scanner dataReader = new Scanner(filename);
            while (dataReader.hasNextLine()) {
                String fileData = dataReader.nextLine();
                String[] words = fileData.split(" ");
                for (String word : words) {
                    if (linearSearchKeyword(word))
                        System.out.println(word + " is a keyword");
                    else if (checkIdentifier(word))
                        System.out.println(word + " is an identifier");
                    else
                        System.out.println(word + " is invalid (others)");
                }
            }
            dataReader.close();
        } catch (FileNotFoundException exception) {
            System.out.println("Unexcpected error occurred!");
            exception.printStackTrace();
        }
    }
}