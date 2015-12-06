package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.UltrasonicSensor;

/**
 * Created by Jaredh on 11/18/2015.
 */
public class ServoTest extends LinearOpMode {
    Servo servo1, servo2;

    public void runOpMode() throws InterruptedException
    {
        waitForStart();
        servo1 = hardwareMap.servo.get("s1");
        servo2 = hardwareMap.servo.get("s2");
        servo2.setPosition(.4);
        sleep(1000);
        servo1.setPosition(.2);
        sleep(1000);
        servo2.setPosition(.8);
        sleep(1000);
        servo1.setPosition(1);
        sleep(1000);
        servo1.close();
    }
}
