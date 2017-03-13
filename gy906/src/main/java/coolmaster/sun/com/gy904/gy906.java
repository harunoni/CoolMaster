package coolmaster.sun.com.gy904;

import com.google.android.things.pio.I2cDevice;
import com.google.android.things.pio.PeripheralManagerService;

import java.io.IOException;
import java.util.List;

/**
 * Created by liyang on 2017/3/13.
 */

public class gy906 {
    private String address ;

    public gy906(String address) {
        this.address = address;
        PeripheralManagerService manager = new PeripheralManagerService();
        List<String> lists = manager.getI2cBusList();
        try {
            I2cDevice i2cDevice = manager.openI2cDevice(lists.get(0), 0x5A);
            byte[] result = new byte[3];
            result[0] = 1;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
