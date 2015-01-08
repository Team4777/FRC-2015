package org.usfirst.frc.team4777.robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;

public class MotorClass extends R{

	boolean toggleMotor = false;
	
	public void ControlToggleRunMotor(Victor vMotor, int speed) {
		if (!toggleMotor) {
			vMotor.set(speed);
			toggleMotor = true;
		}else if (toggleMotor) {
			vMotor.set(0.0);
			toggleMotor = false;
		}
	}
	
	public void ControlHoldRunMotor(Victor vMotor, int speed, boolean holdingButton) {
		if (holdingButton) {
			vMotor.set(speed);
		}else{
			vMotor.set(0.0);
		}
	}
	
	
	public void AutoRunMotor(Victor vMotor, int speed, int seconds) {
		queueThread(new Runnable() {
			public void run() {
				R.autonomousCounter = 0;
		        while ((Math.floor(R.autonomousCounter / loopsPerSecond)) <= seconds) {
		            vMotor.set(speed);
		            Timer.delay(timerDelay);	
		        }
		        vMotor.set(0.0);
			}
		});
	}
	
	
	
	
	
}
