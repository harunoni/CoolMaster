package com.sun.coolmaster.device;

import com.sun.coolmaster.device.imp.AIDA64;
import com.sun.coolmaster.device.imp.Pca9685;

/**
 * Created by liyang on 2017/3/24.
 */

public class DeviceManage {
    //control pwm fan
    public Pca9685 pca9685;
    //aida64 like data sensor.
    public AIDA64 aida64;
}
