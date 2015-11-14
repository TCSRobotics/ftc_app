package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


/**
 * Created by mpclayton on 10/29/15.
 */
public class TCSAutoBlue2 extends LinearOpMode {



    DcMotor motorRight;
    DcMotor motorLeft;
    private int milli = 1000;

    public enum Direction {
        LEFT,RIGHT
    }



    public long convertSeconds(double seconds){
        return (long) seconds*milli;
    }


    public void pauseRobot(double seconds)throws InterruptedException{


        motorRight.setPower(0);
        motorLeft.setPower(0);
        sleep(convertSeconds(seconds));
    }




    public void moveStraight(double speed, double seconds, double wait) throws InterruptedException{





        speed= speed * .01;
        motorRight.setPower(speed);
        motorLeft.setPower(speed);
        //waitOneFullHardwareCycle();

        if (wait > 0){
            pauseRobot(wait);
        }


    }

    public void turn( TCSAuto.Direction direction, double speed, double seconds, double wait) throws InterruptedException{

/*
        speed = speed * .01;
        if (direction == Direction.LEFT) {
            motorRight.setPower(speed);
            motorLeft.setPower(-speed);
        } else {
            motorRight.setPower(-speed);
            motorLeft.setPower(speed);
        }
        //waitOneFullHardwareCycle();

        if (wait > 0){
            pauseRobot(wait);
        }
*/
    }


    @Override
    public void runOpMode() throws InterruptedException {


        // set up the hardware devices we are going to use
        motorRight = hardwareMap.dcMotor.get("motorRight");
        motorLeft = hardwareMap.dcMotor.get("motorLeft");
        motorLeft.setDirection(DcMotor.Direction.REVERSE);

        // wait for the start button to be pressed
        waitForStart();
        // moveStraight(30, 1.5, 0);
        sleep(8000);

        motorLeft.setPower(.30);
        motorRight.setPower(.30);
        sleep(8000);

        motorLeft.setPower(0.30);
        motorRight.setPower(-0.30);
        sleep(1700);

        motorLeft.setPower(.30);
        motorRight.setPower(.30);
        sleep(6500);


        // turn(Direction.RIGHT, 30, 1.5, 0);

        //moveStraight(30,1.5,0);

        // stop the motors
        pauseRobot(0);
    }
}
