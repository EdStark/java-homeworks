package ch7;
import java.util.Random;

/**
 * Created by ikirilov on 06/03/15.
 */
public class RollTheDice {
    static int index = 0;

    //Roll the dice!!!!!!!!!!!!!!!!!
    public static int roll(){
        Random random = new Random();
        int result = random.nextInt(6) + 1; //Generate random # between 1 and 6
        return result;
    }

    //Adds the sum to the array
    public static void add(int[] a, int sum){
          a[index] = sum;
          index++;
    }

    //Tally results' count
    public static int count(int[] a, int val){
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == val) {
                count++;
            }
        }
        return count;
  }
    //MAIN
    public static void main(String[] args) {
        int N=10;    //How many times the dice is rolled. CHANGE THIS VALUE
        int[] a = new int[N];

        //Roll the requested number of times
        for(int i=1; i<=N; i++) {
            System.out.println("Commencing round #" + i);
            int roll_1 = roll();
            System.out.println("Rolling dice #1... Result is: " + roll_1);
            int roll_2 = roll();
            System.out.println("Rolling dice #2... Result is: " + roll_2);
            int sum = roll_1 + roll_2;

            add(a, sum);
            System.out.println("++++++++++++++++++++++++++++++++++++++++");
            System.out.println("The sum of the two dices is: " + sum);
            System.out.println("=======================================");
        }

        System.out.print("Results in order: ");
        for(int i=0; i< a.length;i++){
            System.out.print(a[i] + " ");
        }

        System.out.println("");

        //Loop through all possible results and display the number of times each result occurred
        for(int i=2; i<=12; i++) {  //Range of possible sums is between 2 and 12
            System.out.printf("Result " + i + " shows " + count(a, i)+ " %s.", (count(a,i)==1)?"time":"times");
            System.out.println("");
        }
    }
}
