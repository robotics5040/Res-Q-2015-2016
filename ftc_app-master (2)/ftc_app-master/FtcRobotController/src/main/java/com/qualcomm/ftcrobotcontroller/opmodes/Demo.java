/* Copyright (c) 2014 Qualcomm Technologies Inc

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Qualcomm Technologies Inc nor the names of its contributors
may be used to endorse or promote products derived from this software without
specific prior written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. */

package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


/**
 * TeleOp Mode
 * <p>
 * Enables control of the robot via the gamepad
 */
public class Demo extends OpMode {
    DcMotor leftMotorb;
    DcMotor rightMotorb;
    DcMotor leftMotor;
    DcMotor rightMotor;
    DcMotor rotateleft;
    DcMotor rotateright;
    DcMotor liftL;
    DcMotor liftR;
    int x = 0;
    @Override
    public void init() {
        leftMotor = hardwareMap.dcMotor.get("leftdrive");
        leftMotorb = hardwareMap.dcMotor.get("leftdriveb");
        rightMotor = hardwareMap.dcMotor.get("rightdrive");
        rightMotorb = hardwareMap.dcMotor.get("rightdriveb");/*
        rotateleft = hardwareMap.dcMotor.get("rotateleft");
        rotateright = hardwareMap.dcMotor.get("rotateright");
        */
        liftL = hardwareMap.dcMotor.get("liftL");
        liftR = hardwareMap.dcMotor.get("liftR");

        //motors and sensors setup complete
        leftMotor.setDirection(DcMotor.Direction.REVERSE);
        leftMotorb.setDirection(DcMotor.Direction.REVERSE);
        //rotateright.setDirection(DcMotor.Direction.REVERSE);
        //right motor now reversed
    }

    @Override
    public void loop() {
        double right1 = gamepad1.right_stick_y;
        double left1 = gamepad1.left_stick_y;
        double right2 = gamepad2.right_stick_y;
        double left2 = gamepad2.left_stick_y;

        leftMotor.setPower(left1);
        leftMotorb.setPower(left1);
        rightMotor.setPower(right1);
        rightMotorb.setPower(right1);
        telemetry.addData("liftL", liftL.getCurrentPosition());
        telemetry.addData("liftR", liftR.getCurrentPosition());
        telemetry.addData("leftMotorb", leftMotorb.getCurrentPosition());
        telemetry.addData("rightMotorb", rightMotorb.getCurrentPosition());
        telemetry.addData("leftMotor", leftMotor.getCurrentPosition());
        telemetry.addData("rightMotor", rightMotor.getCurrentPosition());
        /*
        rotateleft.setPower(right2);
        rotateright.setPower(right2);*/

            if(left2 != 0.0) {
                if (liftL.getCurrentPosition() > liftR.getCurrentPosition()) {
                    liftL.setPower((left2 * .75) - .2);
                    liftR.setPower(left2 * .75);
                    x = 1;
                } else if (liftL.getCurrentPosition() < liftR.getCurrentPosition()) {
                    liftL.setPower(left2 * .75);
                    liftR.setPower(left2 * .75 - .2);
                    x = 1;
                } else {
                    liftL.setPower(left2 * .75);
                    liftR.setPower(left2 * .75);
                    x = 1;
                }

            }
        else {
                if (liftL.getCurrentPosition() > liftR.getCurrentPosition() && (x == 1 || x == 2)) {
                    telemetry.addData("im here", leftMotorb.getCurrentPosition());
                    liftL.setPower(-.2);
                    liftR.setPower(0.0);
                    x = 2;
                } else if (liftL.getCurrentPosition() < liftR.getCurrentPosition() && (x == 1 || x == 3)) {
                    liftL.setPower(0.0);
                    liftR.setPower(-.2);
                    x = 3;
                }
                else {
                    liftL.setPower(0);
                    liftR.setPower(0);
                }
            }

    }
}

