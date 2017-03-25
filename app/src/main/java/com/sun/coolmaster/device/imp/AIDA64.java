package com.sun.coolmaster.device.imp;

import com.google.android.things.pio.PeripheralManagerService;
import com.sun.coolmaster.device.Device;

import java.io.IOException;

/**
 * Created by liyang on 2017/3/25.
 * deal aida64 as senso maybe replace real sensor or someone write window program for data collect directly
 */

public class AIDA64 implements Device {
    @Override
    public void init(PeripheralManagerService service, String name) throws IOException {

    }

    @Override
    public void disconnect() {

    }
}
