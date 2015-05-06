package ch10;

/**
 * Created by ikirilov on 20/04/15.
 */
public class ChildClass extends AbsClass {
    @Override
    public int MultiplyTwoNumbers(int num1, int num2) {
        return num1 * num2;
    }

    public static void main(String[] args) {
        ChildClass cc = new ChildClass();
        cc.addTwoNumbers(5,6);
        cc.MultiplyTwoNumbers(6,7);
    }
}

