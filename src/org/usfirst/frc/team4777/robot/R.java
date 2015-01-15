package org.usfirst.frc.team4777.robot;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Victor;

public class R extends IterativeRobot{
    
    /* PWM and Channel numbers found on the RobotRIO */
    
    // Other Declarations
    public static Executor threadPool = Executors.newSingleThreadExecutor();
    
    // Logic Variables
    public int loopsPerSecond = 50; // How many the autonomousPeriodic method loops through a second
    public static int autonomousCounter = 0;
    public static boolean autonomousToggle = false;
    
    // Modifier Variables
    public double liftMotorSpeed = 1.0;
    public double robotDriveSpeed = 1.0;
    public double gyroRotationSpeed = 0.5;
    public double gyroSensitivity = -0.05;//(volts / 1000)
    public double timerDelay = 0.005;
    
    // Handles Joystick Input
    public static int JoystickPort = 1; // USB Port
    public static Joystick xboxController = new Joystick(JoystickPort);
    
    // Handles Robot Drive Motors
    public int leftMotorChannel = 0; // PWM Port
    public int rightMotorChannel = 0; // PWN Port
    public RobotDrive theRobot = new RobotDrive(leftMotorChannel, rightMotorChannel);
    
    // Gyro - Handles Trajectory Paths
    public int GyroChannel = 0;
    Gyro gyro = new Gyro(GyroChannel);
    
    // Handles Pneumatics
    static int pistonRelayGrabChannel = 0;
    static int pistonRelayExtendLeftChannel = 0;
    static int pistonRelayExtendRightChannel = 0;
    static int compressorChannel = 1;
    public static Relay pistonGrab = new Relay(pistonRelayGrabChannel);
    public static Relay pistonLeftExtend = new Relay(pistonRelayExtendLeftChannel);
    public static Relay pistonRightExtend = new Relay(pistonRelayExtendRightChannel);
    public static Compressor compressor = new Compressor(compressorChannel);
    
    // Handles Lift Motors
    int liftMotorChannel = 0; // PWM Port
    public Victor liftMotor = new Victor(liftMotorChannel);
    
    // Common Methods
    public void queueThread(Runnable thread) {
    	threadPool.execute(thread);
    }
    
}
