package Task2;

import java.util.Random;

public class HumiditySensor {
    private double currentHumidity;

    public double getCurrentHumidity() {
        return this.currentHumidity = new Random().nextDouble(0, 100);
    }
}
