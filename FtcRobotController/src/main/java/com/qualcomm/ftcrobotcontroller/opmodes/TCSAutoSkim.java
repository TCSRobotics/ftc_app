package com.qualcomm.ftcrobotcontroller.opmodes;


/**
 * Created by mpclayton on 10/29/15.
 */
public class TCSAutoSkim extends TCSAutoBase {

    @Override
    public void runOpMode() throws InterruptedException {

        //Set up the Hardware done in the base clase
        super.runOpMode();

        // wait for the start button to be pressed
        //moveStraight(double speed, double seconds, double wait) throws InterruptedException{
        waitForStart();

        pauseRobot(8);
        moveStraight(.30, .25, .25);
        turn(Direction.RIGHT, .30, .75, .25);
        moveStraight(.30, 4, 0);
        pauseRobot(0);

    }
    }

