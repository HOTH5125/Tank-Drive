package org.usfirst.frc.team5125.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Robot extends IterativeRobot {
	//The Sparks are each the four motor controllers connected to the wheels and PWM on RoboRio so make sure to change those positions if needed
	Spark blMotor = new Spark (0);
	Spark tlMotor = new Spark (1);
	Spark trMotor = new Spark (2);
	Spark brMotor = new Spark (3);
	SpeedControllerGroup leftSide = new SpeedControllerGroup (tlMotor,blMotor); // This is making the two left motors one variable called leftSide calling only the two left motors
	SpeedControllerGroup rightSide = new SpeedControllerGroup (trMotor,brMotor); // This is making the two right motors one variable called rightSide calling only the two right motors
	DifferentialDrive robot = new DifferentialDrive(leftSide,rightSide);	// Lets the drive what motors it needs to call when it's being used 
	Joystick leftStick, rightStick; // This is creating two joystick names 

	@Override
	public void robotInit() {		
		leftStick = new Joystick(0); // This is setting the left joystick to the 0 position in Driverstation 
    	rightStick = new Joystick(1); // This is setting the right joystick to the 1 position in Driverstation
	}
	
	@Override
	public void teleopPeriodic() {
			robot.tankDrive(leftStick.getY(), rightStick.getY()); //This is the command that allows the robot to run just by moving the joystick since the values are being called by another code in the tankDrive command
		Timer.delay(.001); //The code needs to update every so often so this is needed
		
	}
	
	@Override
	public void autonomousInit() {
			
	}
}