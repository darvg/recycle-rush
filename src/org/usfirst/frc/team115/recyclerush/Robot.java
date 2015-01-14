
package org.usfirst.frc.team115.recyclerush;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author Lee Mracek
 * This class is equivalent to RobotMain in LabVIEW and runs when the robot is turned on.
 * Note: If you change the class name or package, the manifest must be updated.
 */
public class Robot extends IterativeRobot {

	private Gyro gyro;
	private AnalogInput temp; //no wrapper for temperature
    public void robotInit() {
    	// initialize gyro and gyro temperature
    	gyro = new Gyro(RobotMap.GYRO);
    	temp = new AnalogInput(RobotMap.GYRO_TEMP);
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
    	
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {

    }

    public void disabledInit(){

    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("Gyro Rate", gyro.getRate());
        SmartDashboard.putNumber("Gyro Angle", gyro.getAngle());
        SmartDashboard.putNumber("Gyro Raw Temp", temp.getVoltage());
        SmartDashboard.putNumber("Gyro Temp (?)", ((temp.getVoltage() - 2.5) / 0.009) + 25);
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}
