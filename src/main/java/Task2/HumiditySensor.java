package Task2;

import java.util.Random;

public class HumiditySensor {
    private double currentHumidity;

    public double getCurrentHumidity() {
        this.currentHumidity = new Random().nextDouble(10, 80);
        System.out.printf("Текущая влажность почвы равна %.2f%%\n", this.currentHumidity);
        return this.currentHumidity;
    }
}
