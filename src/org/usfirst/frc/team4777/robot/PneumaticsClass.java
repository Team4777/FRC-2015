package org.usfirst.frc.team4777.robot;

import edu.wpi.first.wpilibj.Relay;

public class PneumaticsClass extends R{

	public void ControlExtendPiston(Relay piston) {
		piston.set(Relay.Value.kForward);
	}
	
	public void ControlRetractPiston(Relay piston) {
		piston.set(Relay.Value.kReverse);
	}
	
	public void ExtendPiston(Relay piston){
		queueThread(new Runnable() {
			public void run() {
				piston.set(Relay.Value.kForward);
			}
		});
	}
	
	public void RetractPiston(Relay piston){
		queueThread(new Runnable() {
			public void run() {
				piston.set(Relay.Value.kReverse);
			}
		});
	}
	
}