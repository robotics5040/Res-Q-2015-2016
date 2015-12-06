package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.hardware.HiTechnicNxtColorSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.UltrasonicSensor;

/**
 * Created by Jaredh on 11/11/2015.
 */
public class Auto1 extends LinearOpMode {
    DcMotor leftMotorb;
    DcMotor rightMotorb;
    DcMotor leftMotor;
    DcMotor rightMotor;
    ColorSensor color;
    UltrasonicSensor sonic;
    Servo servo1;
    Servo servo2;
    int leftM = 0;
    int leftMb = 0;
    int rightM = 0;
    int rightMb = 0;
    @Override
    public void runOpMode() throws InterruptedException {
        color = hardwareMap.colorSensor.get("c1");
        sonic = hardwareMap.ultrasonicSensor.get("sonic");
        leftMotor = hardwareMap.dcMotor.get("leftdrive");
        leftMotorb = hardwareMap.dcMotor.get("leftdriveb");
        rightMotor = hardwareMap.dcMotor.get("rightdrive");
        rightMotorb = hardwareMap.dcMotor.get("rightdriveb");
        servo1 = hardwareMap.servo.get("s1");
        servo2 = hardwareMap.servo.get("s2");
        leftMotor.setDirection(DcMotor.Direction.REVERSE);
        leftMotorb.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();
        telemetry.addData("Motor", leftMotorb.getCurrentPosition());
        leftM = leftMotor.getCurrentPosition();
        leftMb = leftMotorb.getCurrentPosition();
        rightM = rightMotor.getCurrentPosition();
        rightMb = rightMotorb.getCurrentPosition();

        while(leftMotorb.getCurrentPosition() < 1360 + leftMb)//move 1 to center of square
        {
            telemetry.addData("Motor", leftMotorb.getCurrentPosition());
            leftMotor.setPower(.2);
            leftMotorb.setPower(.2);
            rightMotor.setPower(.2);
            rightMotorb.setPower(.2);
        }
        leftMotor.setPower(0);
        leftMotorb.setPower(0);
        rightMotor.setPower(0);
        rightMotorb.setPower(0);

        telemetry.addData("Motor", leftMotorb.getCurrentPosition());//turn 1
        leftM = leftMotor.getCurrentPosition();
        leftMb = leftMotorb.getCurrentPosition();
        rightM = rightMotor.getCurrentPosition();
        rightMb = rightMotorb.getCurrentPosition();

        while(rightMotorb.getCurrentPosition() < 990 + rightMb)
        {
            telemetry.addData("Motor", rightMotorb.getCurrentPosition());
            leftMotor.setPower(-.5);
            leftMotorb.setPower(-.5);
            rightMotor.setPower(.5);
            rightMotorb.setPower(.5);
        }
        leftMotor.setPower(0);
        leftMotorb.setPower(0);
        rightMotor.setPower(0);
        rightMotorb.setPower(0);

        telemetry.addData("Motor", leftMotorb.getCurrentPosition());//forward to line
        leftM = leftMotor.getCurrentPosition();
        leftMb = leftMotorb.getCurrentPosition();
        rightM = rightMotor.getCurrentPosition();
        rightMb = rightMotorb.getCurrentPosition();

        while(rightMotorb.getCurrentPosition() < 3700 + rightMb && color.green() < 130)//forward to white line
        {
            telemetry.addData("Motor", rightMotorb.getCurrentPosition());
            telemetry.addData("1", "Color Value: " + color.blue());
            if(rightMotorb.getCurrentPosition() > 2800 + rightMb)
            {
                leftMotor.setPower(.05);
                leftMotorb.setPower(.05);
                rightMotor.setPower(.05);
                rightMotorb.setPower(.05);
            }
            else {
                leftMotor.setPower(.2);
                leftMotorb.setPower(.2);
                rightMotor.setPower(.2);
                rightMotorb.setPower(.2);
            }
        }
        while(color.blue() > 75)
        {
            leftMotor.setPower(.05);
            leftMotorb.setPower(.05);
            rightMotor.setPower(.05);
            rightMotorb.setPower(.05);
        }
       /* telemetry.addData("I made it!!!!!", rightMotorb.getCurrentPosition());
        leftMotor.setPower(0);
        leftMotorb.setPower(0);
        rightMotor.setPower(0);
        rightMotorb.setPower(0);
        telemetry.addData("Motor", leftMotorb.getCurrentPosition());//forward to line
        leftM = leftMotor.getCurrentPosition();
        leftMb = leftMotorb.getCurrentPosition();
        rightM = rightMotor.getCurrentPosition();
        rightMb = rightMotorb.getCurrentPosition();
        while(rightMotorb.getCurrentPosition() < 1350 + rightMb)
        {
            telemetry.addData("Motor", rightMotorb.getCurrentPosition());
            if(color.blue() < 75) {
                leftMotor.setPower(-.4);
                leftMotorb.setPower(-.4);
            }
            else
            {
                leftMotor.setPower(0);
                leftMotorb.setPower(0);
            }
            rightMotor.setPower(.6);
            rightMotorb.setPower(.6);
        }
        leftMotor.setPower(0);
        leftMotorb.setPower(0);
        rightMotor.setPower(0);
        rightMotorb.setPower(0);
        leftM = leftMotor.getCurrentPosition();
        leftMb = leftMotorb.getCurrentPosition();
        rightM = rightMotor.getCurrentPosition();
        rightMb = rightMotorb.getCurrentPosition();
        while(rightMotorb.getCurrentPosition() < 580 + rightMb )
        {
            telemetry.addData("Motor", rightMotorb.getCurrentPosition());
            if(sonic.getUltrasonicLevel() != 0 && sonic.getUltrasonicLevel() < 9)
            {
                break;

            }
            if(color.blue() < 75) {
                leftMotor.setPower(.15);
                leftMotorb.setPower(.15);
            }
            else
            {
                leftMotor.setPower(.2);
                leftMotorb.setPower(.2);
            }
            rightMotor.setPower(.2);
            rightMotorb.setPower(.2);
        }*/
        leftM = leftMotor.getCurrentPosition();
        leftMb = leftMotorb.getCurrentPosition();
        rightM = rightMotor.getCurrentPosition();
        rightMb = rightMotorb.getCurrentPosition();
        while(true)
        {
            telemetry.addData("Motor", rightMotorb.getCurrentPosition());
            if(sonic.getUltrasonicLevel() != 0 && sonic.getUltrasonicLevel() < 15)
            {
                leftMotor.setPower(.01);
                leftMotorb.setPower(.01);
                rightMotor.setPower(.01);
                rightMotorb.setPower(.01);
                break;
            }
            if(color.blue() < 75) {
                leftMotor.setPower(-.2);
                leftMotorb.setPower(-.2);
                rightMotor.setPower(.6);
                rightMotorb.setPower(.6);
            }
            else
            {
                leftMotor.setPower(.6);
                leftMotorb.setPower(.6);
                rightMotor.setPower(0);
                rightMotorb.setPower(.0);
            }

        }
        sleep(250);
        while(true) {
            leftMotor.setPower(0);
            leftMotorb.setPower(0);
            rightMotor.setPower(0);
            rightMotorb.setPower(0);
            servo1.setPosition(.3);
        }
    }
}