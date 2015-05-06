package ch7;

/**
 * Created by ikirilov on 06/03/15.
 */
public class Duplicate_Elimination {

    public static void Eliminate(int[] a){
        boolean[] duplicate = new boolean[a.length];
        for(int i=0; i<a.length;i++) {
            //duplicate[i] = false;
             for (int j = 0; j < i; j++) {
                  if (a[j] == a[i]) {
                      duplicate[i] = true; //Example: if i=2 and a[2] = a[j] then duplicate[2] is TRUE
                      // int[] a = {12, 100, 100, 8, 13};
                      // Will eliminate a[2]
                      break;
                  }
            }
        } //exit i loop

        for(int k = 0; k < a.length; k++) {
            if(!duplicate[k]) {
                System.out.print(a[k] +" ");  //Print only those whose duplicate[x] values are false
            }
        }
    }

    public static void main(String[] args) {
       int[] a = {12, 100, 100, 8, 13};
       Eliminate(a);
    }
}
