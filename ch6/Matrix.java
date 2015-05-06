package ch6;

/**
 * Created by ikirilov on 27/02/15.
 */
public class Matrix {
   static int[] id = {0, 1, 2, 3, 4, 5};
   static int i=0;
   static int q = 1;

    public static int MoveRight(int q){
        id[q] = id[i] ;
        System.out.println("4 MoveRight - id[q] is now " + id[q]);
        q = q+1;
        System.out.println("Q is " + q);
        return q;
    }

    public static void main(String[] args) {
        System.out.println("1 id[q] is " + id[q]);
        int increment = 0;
        increment += MoveRight(q);

        System.out.println("2 increment is now " + increment);




    }

}
