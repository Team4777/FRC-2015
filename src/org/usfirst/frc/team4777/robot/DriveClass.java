package org.usfirst.frc.team4777.robot;

import edu.wpi.first.wpilibj.Timer;

public class DriveClass extends R implements Runnable{
    
    static int seconds = 0;
    boolean forward = false;
    
    public void DriveControl() { // For Tele-Op
        
        double xValue = -xboxController.getRawAxis(4);
        double yValue = xboxController.getRawAxis(2);
        theRobot.arcadeDrive(yValue, xValue);
        
    }
    
    public void DriveForwardSimple() { // testing drive without use of threads
    	theRobot.drive(-0.5, 0.0);
    }
    
    public void DriveForward(int seconds) {
        queueThread(new Runnable(){
        	public void run() {
        		gyro.reset(); // Recalibrating Header
                DriveClass.seconds = seconds;
        		forward = true;
        	}
        });
        queueThread(this);
    }
    
    public void DriveBackward(int seconds) {
        queueThread(new Runnable(){
        	public void run() {
        		gyro.reset(); // Recalibrating Header
                DriveClass.seconds = seconds;
        		forward = false;
        	}
        });
        queueThread(this);
    }
    
    public void DriveRotate(int rotateAngle) {
    	queueThread(new Runnable() {
    		public void run() {
    			gyro.reset();
    			double angleHeader = gyro.getAngle(); // Initial Angle
    			while (Math.abs(angleHeader - gyro.getAngle()) <= Math.abs(rotateAngle)) { // Rotating
    				theRobot.drive(0.0, rotateAngle * gyroRotationSpeed);
    				Timer.delay(timerDelay);
    			}
    		}
    	});
    }
    
    public void run() { // This method is executed only for DriveForward and DriveBackward
        R.autonomousCounter = 0;
        while ((Math.floor(R.autonomousCounter / loopsPerSecond)) <= DriveClass.seconds) {
            if (forward) {
                theRobot.drive(-robotDriveSpeed, gyro.getAngle() * gyroModifierSpeed);
            }else if (!forward) {
                theRobot.drive(robotDriveSpeed, gyro.getAngle() * gyroModifierSpeed);
            }
            Timer.delay(timerDelay);	
        }
        theRobot.drive(0.0, 0.0);
    }
    
}
