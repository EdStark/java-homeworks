package ch9;

/**
 * Created by ikirilov on 23/03/15.
 */
public class Quadrilateral {
    protected double side_A;
    protected double side_B;
    protected double side_C;
    protected double side_D;

    protected double angle_alpha;
    protected double angle_beta;
    protected double angle_gamma;
    protected double angle_delta;

    //            A
    //   ---------------------
    //   |alpha          beta|
    //   |                   |
    //   |                   |
    // D |                   | B
    //   |                   |
    //   |                   |
    //   |gamma         delta|
    //   ---------------------
    //             C

    /*Conventions ( See above for side and angle naming):
     - Quadrilateral has
     - Sum of all angles is 360
     -  Rectangle will have sides A=C and B=D and all angles 90 degrees
     */

    public Quadrilateral(double A, double B, double C, double D, double alpha, double beta, double gamma, double delta){
        side_A=A;
        side_B=B;
        side_C=C;
        side_D=D;
        angle_alpha=alpha;
        angle_beta=beta;
        angle_gamma=gamma;
        angle_delta=delta;
    }

    protected boolean sideValidityCheck(double A, double B, double C, double D){
         return (A!=B || B!=C || C!=D);
    }

    //Checks that the sum of all angles is 360
    protected boolean angleValidityCheck(double alpha, double beta, double gamma, double delta){
        if(alpha+beta+gamma+delta!=360)
            throw new IllegalArgumentException("Total of all angles should always be 360");
        return true;
    }

    //Checks if all angles are equal (90)
    protected boolean areAllAnglesRight(double alpha, double beta, double gamma, double delta){
       return (alpha==beta && beta==gamma && gamma==delta && delta==alpha);
    }

    //Checks if only 2 angles are equal . This can be used to check if two angles are equal for Trapezoid
    protected boolean areTwoAnglesEqual(double angle_a, double angle_b){
        return (angle_a==angle_b);
    }

    //No side checks. This method will be overriden by derived classes
    protected void BuildShape() {
        if(angleValidityCheck(angle_alpha, angle_beta, angle_gamma, angle_delta))
            System.out.println("Building a quadrilateral shape with " + side_A + " ," + side_B + " ," + side_C + " ," + side_D);
    }
}

class Rectangle extends Quadrilateral{
    public Rectangle(double A, double B, double C, double D, double alpha, double beta, double gamma, double delta) {
        super(A, B, C, D, alpha, beta, gamma, delta);
    }

    @Override
    //Override this one to check sides for rectangle
    protected boolean sideValidityCheck(double A, double B, double C, double D){
        return (A==C && B==D);
    }

    @Override
    //Additional checks for side and angle equality implemented
    protected void BuildShape(){
        assert angleValidityCheck(angle_alpha,angle_beta,angle_gamma,angle_delta);
        if(sideValidityCheck(side_A, side_B, side_C, side_D)  && areAllAnglesRight(angle_alpha,angle_beta,angle_gamma,angle_delta)){
            System.out.println("Building a rectangle shape with " + side_A +"," + side_B +"," + side_C +"," + side_D );
        }
    }

    public static void main(String[] args) {
        Quadrilateral quad = new Quadrilateral(2,3,4,5,80,100,60,120);
        quad.BuildShape();
        Rectangle rect = new Rectangle(2,3,2,3,90,90,90,90);
        rect.BuildShape();
    }
}
