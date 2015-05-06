package ch3;
//Silly assumptions for three types of vehicles
//Regular (gas, color, top_speed, electric)
//Hybrid (gas, electric, color, top_speed)
//Electric (electric, range, color, top_speed)
class Specs{
	private boolean gas;
	private boolean electric;
	private String color;
	private double top_speed;
	private int range;
	
	//GETTERS & SETTERS
	public boolean isGas() {return gas;}
	public void setGas(boolean gas) {this.gas = gas;}
		 
	public boolean isElectric() {return electric;}
	public void setElectric(boolean electric) {this.electric = electric;}
	
	public String getColor(){return color;}
	public void setColor(String color){this.color=color;}
	
	public double getSpeed(){return top_speed;}
	public void setSpeed(double speed){this.top_speed = speed;}
	
	public int getRange(){return range;}
	public void setRange(int range){this.range = range;}
	
	//CONSTRUCTOR OVERLOAD
	//Conventional (Regular) vehicle
	Specs(boolean gas, String color, double top_speed, boolean electric){
		setGas(gas);
		setElectric(electric);
		setColor(color);
		setSpeed(top_speed);
	}
	
	//Hybrid
	Specs(boolean gas, boolean electric, String color, double top_speed){
		setGas(gas);
		setElectric(electric);
		setColor(color);
		setSpeed(top_speed);
	}
	
	//Electric
	Specs(boolean gas, boolean electric, int range, String color, double top_speed){
		setGas(gas);
		setElectric(electric);
		setRange(range);
		setColor(color);
		setSpeed(top_speed);
	}
}

public class Car {
	public static void main(String[] args){
		//REGULAR 
		Specs regular = new Specs(true, "Red", 204, false); //THOSE ARGUMENTS COULD BE MODIFIED
	    System.out.println("Calling Class Constructor for Regular Type of Car");
	    System.out.println("=================================================");
		System.out.printf("The car %s run on gas%n",regular.isGas() ? "can" : "cannot" ); //USE TERNARY LOGICAL OPERATOR TO DISPLAY TEXT BASED ON RESULT FROM THE BOOLEAN
	    System.out.printf("The car %s run on electricity%n",regular.isElectric() ? "can" : "cannot" ); 
	    if(regular.isGas() && !regular.isElectric()){
			System.out.println("The car is of REGULAR type.");
			System.out.println("Car's color is " + regular.getColor());
			System.out.println("Car's top speed is " + regular.getSpeed());
			
		}
	    System.out.println();
	    
	    //HYBRID
	    Specs hybrid = new Specs(true, true, "Yellow", 100); //THOSE ARGUMENTS COULD BE MODIFIED
	    System.out.println("Calling Class Constructor for Hybrid Type of Car");
	    System.out.println("=================================================");
		System.out.printf("The car %s run on gas%n",hybrid.isGas()?"can" : "cannot" );
	    System.out.printf("The car %s run on electricity%n",hybrid.isElectric() ? "can" : "cannot" );
	    if(hybrid.isGas() && hybrid.isElectric()){
			System.out.println("The car is of HYBRID type.");
			System.out.println("Car's color is " + hybrid.getColor());
			System.out.println("Car's top speed is " + hybrid.getSpeed());
		}
	    System.out.println();
	    
	    //ELECTRIC 
	    Specs electic = new Specs(false, true, 80, "White", 103); //THOSE ARGUMENTS COULD BE MODIFIED
	    System.out.println("Calling Class Constructor for Electric Type of Car");
	    System.out.println("=================================================");
		System.out.printf("The car %s run on gas%n",electic.isGas()?"can" : "cannot" );
	    System.out.printf("The car %s run on electricity%n",electic.isElectric() ? "can" : "cannot" );
	    if(!electic.isGas() && electic.isElectric()){
			System.out.println("The car is of ELECTRIC type.");
			System.out.println("Car's color is " + electic.getColor());
			System.out.println("Car's top speed is " + electic.getSpeed());
		}	
	}
}


