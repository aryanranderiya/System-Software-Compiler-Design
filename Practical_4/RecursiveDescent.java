//Recursive descent parser
/*
    S -> aAb | aBb
    A -> cx | dx
    B -> xe
 */
import java.util.Scanner;
class RecursiveDescent{
    static int i=0;
    static char[] inputArray;
    public static int S(){
        if(inputArray[i]=='a'){
            i++;
            if(A()==1){
                if(inputArray[i]=='b'){
                    return 1;
                }
            }
            else if(B()==1){
                if(inputArray[i]=='b'){
                    return 1;
                }
            }
        }
        return 0;
    }

    public static int A(){
        if(inputArray[i]=='c'){
            i++;
            if(inputArray[i]=='x'){
                i++;
                return 1;
            }
            else{
                return 0;
            }
        }
        else if(inputArray[i]=='d'){
            i++;
            if(inputArray[i]=='x'){
                i++;
                return 1;
            }
            else{
                return 0;
            }
        }
        return 0;
    }

    public static int B(){
        if(inputArray[i]=='x'){
            i++;
            if(inputArray[i]=='e'){
                i++;
                return 1;
            }
            else{
                return 0;
            }
        }
        else{
            return 0;
        }
    }

    public static void main(String args[]){
        //Take string input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String input = sc.nextLine();
        inputArray = input.toCharArray();
        if(S() == 1){
            System.out.println("Valid String");
        }
        else{
            System.out.println("Invalid String");
        }
    }
}