package ch11;
import ch7.*;

/**
 * Created by ikirilov on 27/04/15.
 */


public class ch11 {
    public static void main(String[] args) {
        int[] array = {12, 100, 100, 8, 13};

        try{
            for(int i=0;i<=array.length;++i){   //Error occurs here
               System.out.print(array[i]+ " ");
            }
        }

        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("\nOops, we went too far, better go back and check your array boundaries!");
            //e.printStackTrace();
        }

        finally{
            System.out.print("So far, the the array contains following elements: ");
            for(int i=0; i< array.length; i++){
                System.out.print(array[i] + " ");
            }
            System.out.print("\nArray length is: " + array.length + "\n");

            //method call to continue program. Call external method from another package
            Duplicate_Elimination duplicate_eliminate = new Duplicate_Elimination();
            duplicate_eliminate.Eliminate(array);

        }

    }

}

