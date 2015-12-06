package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.hardware.HiTechnicNxtColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.UltrasonicSensor;

/**
 * Created by User on 11/9/2015.
 */
public class SensorTest extends OpMode {
    //ColorSensor color;
    UltrasonicSensor sonic;
    public void init()
    {
        //color = hardwareMap.colorSensor.get("c1");
        sonic = hardwareMap.ultrasonicSensor.get("sonic");
    }
    public void loop()
    {
        //telemetry.addData("1", "Color Value: " + color.blue());
        telemetry.addData("2", "Distance: " + sonic.getUltrasonicLevel());
    }
}
