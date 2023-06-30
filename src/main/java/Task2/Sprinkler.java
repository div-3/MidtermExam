package Task2;

import java.time.LocalDate;

public class Sprinkler {
    private LocalDate nextWaterDay;
    private LocalDate prevWaterDay;
    private final double CACTUS_CRITICAL_HUMIDITY = 30;

    public LocalDate getPrevWaterDay() {
        return prevWaterDay;
    }

    public void setPrevWaterDay(LocalDate prevWaterDay) {
        this.prevWaterDay = prevWaterDay;
        nextWaterDayCalc(prevWaterDay);
    }

    //Вычисление дня следующего полива
    private void nextWaterDayCalc(LocalDate prevWaterDay) {
        LocalDate now = LocalDate.now();
        Seasons currentSeason = new Season().getSeasonByDate(now);
        System.out.println("Текущий сезон: " + currentSeason.getInRussian());
        switch (currentSeason) {
            case AUTUMN, SPRING -> waterDayCalc(prevWaterDay, now, 7);     //Осенью и весной поливать раз в неделю
            case WINTER -> waterDayCalc(prevWaterDay, now, 30);     //Зимой поливать раз в месяц
            case SUMMER -> {
                //Летом поливается в зависимости от влажности воздуха, но не чаще одного раза в два дня.
                if (isCactusHumidityLow()) {
                    waterDayCalc(prevWaterDay, now, 2);
                }
            }
        }
    }

    //Сдвиг дня полива по дням
    private void waterDayCalc(LocalDate prevWaterDay, LocalDate now, int days) {
        if ((now.toEpochDay() - prevWaterDay.toEpochDay() > days)) {
            nextWaterDay = now;
        } else {
            nextWaterDay = prevWaterDay.plusDays(days);
        }
    }

    //Проверка влажности почвы
    private boolean isCactusHumidityLow() {
        //Если влажность меньше 30%, кактус нужно полить.
        HumiditySensor humiditySensor = new HumiditySensor();
        return humiditySensor.getCurrentHumidity() < CACTUS_CRITICAL_HUMIDITY;
    }

    public LocalDate getNextWaterDay() {
        return nextWaterDay;
    }
}
