package com.sun.coolmaster.device.imp;

import android.support.annotation.CheckResult;
import android.support.annotation.IntRange;

import com.google.android.things.pio.I2cDevice;
import com.google.android.things.pio.PeripheralManagerService;
import com.sun.coolmaster.device.Device;

import java.io.IOException;

/**
 * Created by liyang on 2017/3/25.
 */

public class Pca9685 implements Device {

    public static final short SALVE_ADDRESS = 0x40;
    public static final short ALL_LED_ON_L = 0xFA;
    public static final short ALL_LED_ON_H = 0xFB;
    public static final short ALL_LED_OFF_L = 0xFC;
    public static final short ALL_LED_OFF_H = 0xFD;
    public static final short RANGE = 0x0FFF-1;
    private I2cDevice i2cDevice;


    @Override
    public void init(PeripheralManagerService service, String name) throws IOException {
        i2cDevice = service.openI2cDevice(name, SALVE_ADDRESS);
        i2cDevice.writeRegByte(0x00, (byte) 1);
    }

    @Override
    public void disconnect() {
        if (i2cDevice != null) {
            try {
                i2cDevice.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //return false can`t control pwm otherwise true;
    //every range High now and control off time for pwm
    @CheckResult
    public boolean setPercent(@IntRange(from = 0,to = 100)int percent){
        if (i2cDevice !=null){
            try {
                i2cDevice.writeRegByte(ALL_LED_ON_H, (byte) 0x00);
                i2cDevice.writeRegByte(ALL_LED_ON_L, (byte) 0x00);
                short value = (short) (RANGE*percent/100);
                i2cDevice.writeRegByte(ALL_LED_OFF_H, (byte) (value>>8));
                i2cDevice.writeRegByte(ALL_LED_OFF_L, (byte) (value & 0xff));
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }else {
            return false;
        }
    }
}
