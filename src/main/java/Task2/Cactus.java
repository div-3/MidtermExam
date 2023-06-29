package Task2;

import java.time.LocalDate;

public class Cactus {
    private LocalDate lastWaterDate;

    public Cactus(LocalDate lastWaterDate) {
        this.lastWaterDate = lastWaterDate;
    }

    public void setLastWaterDate(LocalDate lastWaterDate) {
        this.lastWaterDate = lastWaterDate;
    }

    public LocalDate getLastWaterDate() {
        return lastWaterDate;
    }

}
