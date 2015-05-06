package ch4;
import java.util.*;
import java.text.DecimalFormat;
/* Simple Tax Calculator
 * Task: Design Simplified Tax Calculator and use the table below for THREE defined brackets
 * Bracket  Single filers          Married, filing jointly
 * 10%	    Up to $9,225	        Up to $18,450
 * 15%	    $9,226 to $37,450	    $18,451 to $74,900
 * 28%	    $90,751 to $189,300	    $MyComparator151,201 to $230,450
 * 33%	    $189,301 to $41Jz1,500	$230,451 to $411,500
 * ************************************************************
 *  <tt>TaxCalculator</tt> is designed as a reusable library of static methods and provides following APIs:
 *  public static char ValidateInput(String status, double income) - Validates user input
 *  public static double CalculateTax(char status, double income) - Calculates Tax based on user input
 *  @author Ivan Kirilov
 */
public class TaxCalculator {
    //RATE CONSTANTS
    private static final double RATE_10 = 0.10;
    public static final double RATE_15 = 0.15;
    public static final double RATE_28 = 0.28;
    public static final double RATE_33 = 0.33;
    // Tax brackets for single (see table above)
    public static final double S1 = 9225.0;
    public static final double S2 = 37450.0;
    public static final double S3 = 189300.0;
    // Tax brackets for married (see table above)
    public static final double M1 = 18450.0;
    public static final double M2 = 74900.0;
    public static final double M3 = 230450.0;

    /**
     * Validates input for correct boundaries
     * @param status denotes filing status
     * @param income yearly income
     * @return character of filing status, 'm' for married and 's' for single
     */
    public static char ValidateInput(String status, double income){
      String low_status = status.toLowerCase();  //To lowercase
      char[] stat = low_status.toCharArray(); //lowercase to char array
      //Check if entered status is correct
      if(income <=0){
          System.out.println("Income must be larger than 0. Please correct and try again!");
          System.exit(-1);
      }

      if(stat[0]=='m' || stat[0] =='s'){
          System.out.println("Valid status entered");

      } else {
          System.out.println("Unrecognized status. Please enter 'S' for Single or 'M' for Married");
          System.exit(-1);
      }
      return stat[0];
    }

    /**
     * Calculates tax amount based on filing status and income
     * @param status character that could take 's' for single or 'm' for married. Other values are not supported
     * @param income yearly income
     * @return result of the tax calculation
     */
    public static double CalculateTax(char status, double income){
        double result = 0;
        System.out.println("Calculating tax ");
        System.out.println("Status: " + status);
        System.out.println("Income: " + income);
        System.out.println("*****************************");
        /*FORMULA
        * bracket(1) -> INCOME * PERCENT_RATE_FOR_BRACKET
        * bracket(n) = bracket(1) + (RATE * (bracket(n-1) - bracket(n-2))) + (RATE * (income - bracket(n-1))
        */
        switch (status){
            //SINGLE FILER
            case 's':
                if (income <= S1){
                    result = income * RATE_10;
                } else if (income <= S2){
                    result = (RATE_10 * S1) + (RATE_15 * (income - S1));
                } else if(income < S3) {
                    result = (RATE_10 * S1) + (RATE_15 * (S2 - S1)) + (RATE_28 * (income - S2));
                } else {
                    result = (RATE_10 * S1) + (RATE_15 * (S2 - S1)) + (RATE_28 * (S3 - S2)) + (RATE_33 * (income - S3));
                }
               break;

            //MARRIED, FILING JOINTLY
            case 'm':
                if (income <= M1){
                    result = income * RATE_10;
                } else if (income <= M2){
                    result = RATE_10 * M1 + RATE_15 * (income - M1);
                } else if(income < M2) {
                    result = RATE_10 * M1 + RATE_15 * (M2 - M1) + RATE_28 * (income - M2);
                } else {
                    result = RATE_10 * M1 + RATE_15 * (M2 - M1) + RATE_28 * (M3 - M2) + RATE_33 * (income - M3);
                }
                break;
        }
        return result;
    }

    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       System.out.println("Please enter marital status[S/M]");
       String status = scan.next();
       System.out.println("Please enter your income");
       double yearly_income = scan.nextDouble();
       char result = ValidateInput(status, yearly_income); //Call ValidateInput method
       double tax = CalculateTax(result,yearly_income);
       DecimalFormat df = new DecimalFormat("###.##");    //Format the computed result to show as currency
       String output = df.format(tax);
       System.out.println("Tax amount owed: " + output + " USD.");
    }
}
