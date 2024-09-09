// E -> TE'
//     E' -> +TE' | -TE' | NULL
//     T -> FT'
//     T' -> *FT' | /FT' | NULL
//     F -> PF'
//     F' -> eF | NULL (e-exponent)
//     P -> (E) | i
//     String - i+i*i
import java.util.Scanner;

class Grammar2 {
    static int i = 0;
    static char[] inputArray;

    public static int E() {
        if (T() == 1) {
            if (X() == 1) {
                return 1;
            }
        }
        return 0;
    }

    public static int X() {
        if (i < inputArray.length && (inputArray[i] == '+' || inputArray[i] == '-')) {
            i++;
            if (T() == 1) {
                if (X() == 1) {
                    return 1;
                }
            }
            return 0;
        }
        // epsilon production
        return 1;
    }

    public static int T() {
        if (F() == 1) {
            if (Y() == 1) {
                return 1;
            }
        }
        return 0;
    }

    public static int Y() {
        if (i < inputArray.length && (inputArray[i] == '*' || inputArray[i] == '/')) {
            i++;
            if (F() == 1) {
                if (Y() == 1) {
                    return 1;
                }
            }
            return 0;
        }
        // epsilon production
        return 1;
    }

    public static int F() {
        if (P() == 1) {
            if (Z() == 1) {
                return 1;
            }
        }
        return 0;
    }

    public static int Z() {
        if (i < inputArray.length && inputArray[i] == '^') {
            i++;
            if (F() == 1) {
                return 1;
            }
            return 0;
        }
        // epsilon production
        return 1;
    }

    public static int P() {
        if (i < inputArray.length) {
            if (inputArray[i] == '(') {
                i++;
                if (E() == 1 && i < inputArray.length && inputArray[i] == ')') {
                    i++;
                    return 1;
                }
                return 0;
            } else if (inputArray[i] == 'i') {
                i++;
                return 1;
            }
        }
        return 0;
    }

    public static void main(String args[]) {
        // Take string input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string to parse: ");
        String input = sc.nextLine();
        inputArray = input.toCharArray();

        if (E() == 1 && i == inputArray.length) {
            System.out.println(input + " is accepted.");
        } else {
            System.out.println(input + " is rejected.");
        }
    }
}