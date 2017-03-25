package com.sun.coolmaster.device;

import com.google.android.things.pio.PeripheralManagerService;

import java.io.IOException;

/**
 * Created by liyang on 2017/3/25.
 */

public interface Device {
    public void init(PeripheralManagerService service,String name) throws IOException;
    public void disconnect();
}
