package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by mpclayton on 11/8/15.
 */
public abstract class TCSAutoBase  extends LinearOpMode  {


    protected DcMotor motorRight;
    protected DcMotor motorLeft;
    private int milli = 1000;

    public enum Direction {
        LEFT,RIGHT
    }

    private long convertSeconds(double seconds){
        return (long) seconds*milli;
    }


    public void pauseRobot(double seconds)throws InterruptedException{


        motorRight.setPower(0);
        motorLeft.setPower(0);
        sleep(convertSeconds(seconds));
    }




    public void moveStraight(double speed, double seconds, double wait) throws InterruptedException{

        motorRight.setPower(speed);
        motorLeft.setPower(speed);
        sleep(convertSeconds(seconds));

        if (wait > 0){
            pauseRobot(wait);
        }


    }

    public void turn( Direction direction, double speed, double seconds, double wait) throws InterruptedException{

        if (direction == Direction.LEFT) {
            motorRight.setPower(speed);
            motorLeft.setPower(-speed);
        } else {
            motorRight.setPower(-speed);
            motorLeft.setPower(speed);
        }
        sleep(convertSeconds(seconds));

        if (wait > 0){
            pauseRobot(wait);
        }

    }

    protected void setUpHardware(){
        // set up the hardware devices we are going to use
        motorRight = hardwareMap.dcMotor.get("motorRight");
        motorLeft = hardwareMap.dcMotor.get("motorLeft");
        motorLeft.setDirection(DcMotor.Direction.REVERSE);

    }

    @Override
    public void runOpMode() throws InterruptedException {
       setUpHardware();
    }



}
