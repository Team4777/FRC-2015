package org.usfirst.frc.team4777.robot;

public class Button extends R{

	// LETTERS
	public static int A = 1;
	public static int B = 2;
	public static int X = 3;
	public static int Y = 4;
	
	// BACK OF CONTROLLER
	public static int LB = 5;
	public static int RB = 6;
	
	// MIDDLE OF CONTROLLER
	public static int Back = 7;
	public static int Start = 8;
	
	
	// Negative [RIGHT < 0] :: Positive [Left > 0] axis<0
	public static boolean RT() {
		double axis = R.xboxController.getRawAxis(3);
		if (axis < 0) {
			return true;
		}
		return false;
	}
	
	public static boolean LT() {
		double axis = R.xboxController.getRawAxis(3);
		if (axis > 0) {
			return true;
		}
		return false;
	}
	
}
