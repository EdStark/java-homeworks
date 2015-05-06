package ch4;
import java.util.*;
import static java.lang.System.exit;
/**
 * Created by ikirilov on 05/02/15.
 */
public class Factorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter factorial value:");

        //Validate if the input is a true Integer. If not, keep printing the prompt to enter valid input!
        while (!input.hasNextInt()) {
             System.out.println("Please enter valid integer!");
             input.nextLine();
        }

        //Validate if input is positive integer
        int number = input.nextInt();
        while (number < 0){
            System.out.println("Please enter non negative integer!");
            number = input.nextInt();
        }

        //If all is good, proceed with the next method
        SwitchFactorial(number);


        /*Example of achieving same result by using Recursion
        * We simply overload CalculateFactorial method, using a parameter of type long, instead
        * of the initial int
        */
        long recursive_param = number; //Parameter is provided as a field
        System.out.println("USING RECURSION... Factorial is: " + CalculateFactorial(recursive_param));
    }

    /* Following method just splits the flow of control based on the value of the parameter
    * If 0 or 1, factorial is 1, so we print this and exit
    * For all other legal values, we continue with the actual calculation -
    * CalculateFactorial method called with parameter of type int
    */
    private static void SwitchFactorial(int a){
        switch (a) {
          case 0: // case fallback here, as we know that factorial for 0 and 1 is 1
          case 1:
              System.out.println("Factorial is 1");
              exit(1);    //Exits here, so the recursion will never happen

          default:
              CalculateFactorial(a);
              break;
      }
    }

    //*******************************************************************************************
    //Using for-loop
    private static long CalculateFactorial(int a){  //use long as factorial results are huge
        long factorial_result = a; //our int is implicitly cast to long

        //Following loop will build the required multipliers and will add them to the sum
        for(int i=a-1; i > 0;i--){
            factorial_result *= i; // calculate the sum here
        }
        System.out.println("USING FOR LOOP... Factorial is: " + factorial_result);
        return factorial_result; /*
        left for functionality (i. e. if the method is called from another method that will need
        to manipulate factorial_result
        */
    }

    //Using recursion - our CalculateFactorial method is overloaded
     public static long CalculateFactorial(long b){
         if(b==1){
            return (b);
         }
         else {
            return (b * CalculateFactorial(b - 1));
         }
    }


}
