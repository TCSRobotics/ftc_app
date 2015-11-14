package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;



/**
 * Created by mpclayton on 10/29/15.
 */
        public class TCSAutoRed extends TCSAutoBase {

            @Override
            public void runOpMode() throws InterruptedException {

                //Set up the Hardware done in the base clase
                super.runOpMode();

                // wait for the start button to be pressed
                waitForStart();

                pauseRobot(8);
                moveStraight(.30, 8, .25);
                turn(Direction.LEFT,.30,1.5,.25);
                moveStraight(.30,6.5,0);
                pauseRobot(0);
            }
        }




