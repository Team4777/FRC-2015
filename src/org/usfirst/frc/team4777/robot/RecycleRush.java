package org.usfirst.frc.team4777.robot;
import edu.wpi.first.wpilibj.IterativeRobot;

public class RecycleRush extends IterativeRobot {
    
    DriveClass driveClass = new DriveClass();
    
    public void robotInit() {
        
    }

    public void autonomousInit() {
        
    }
    
    public void autonomousPeriodic() { // loops 50 times per second
    	
        R.autonomousCounter++;
        if (!R.autonomousToggle) {
        	
        	// autonomous code here
        	
        	if (R.autonomousCounter <= 100) {
        		driveClass.DriveForwardSimple();
        	}
        	
        	R.autonomousToggle = true;
        }
        
    }

    public void teleopInit() {
        
    }
    
    public void teleopPeriodic() {
        
        driveClass.DriveControl();
        
    }
    
    public void testPeriodic() {
        
    }
    
}
