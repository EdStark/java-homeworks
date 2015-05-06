package ch6;
/**
 * Created by ikirilov on 26/02/15.
 * ASSUMPTIONS:
 * ===============================================
 * Prime number: has only 2 factors - 1 and itself
 * There are NO factors greater than the number's Square Root, therefore
 * We can set the limit to check if the factor is less than the number's square root
 */
public class PrimeNumbers {
    /**
     * @param N - This is the number that will be checked if it's a prime or not
     * @return - return false if 3rd factor is discovered, true otherwise
     */
    public static boolean IsPrime(int N){
        if (N < 2) return false; // 1 is NOT prime
        for(int factor=2; factor < Math.sqrt(N); factor++)
            if (N % factor == 0) return false; //Remainder is 0 => there is a third factor (N is not prime)
        return true;
    }

    /**
    * Calculates the count of prime numbers for a given range
    * @param count - number to set the range
    * @return - the count of prime numbers for the range
    */
    public static int PrimeCount(int count){
        int sum=0;
        System.out.print("Prime numbers: ");
        for(int i=2; i<count; i++){
           if(IsPrime(i)){
               sum +=1;
               System.out.print(i + " ");
          }
        }
        System.out.println();  //Start a new line
        return sum;
    }

    /**
     * Provide real argument to test both methods
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Count of prime numbers is: " + PrimeCount(90));//Count is 1254 for 9999
    }
}
