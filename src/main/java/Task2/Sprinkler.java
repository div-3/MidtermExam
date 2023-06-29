package Task2;

import java.time.LocalDate;

public class Sprinkler {
    private LocalDate nextWaterDay;
    private LocalDate prevWaterDay;

    public LocalDate getPrevWaterDay() {
        return prevWaterDay;
    }

    public void setPrevWaterDay(LocalDate prevWaterDay) {
        this.prevWaterDay = prevWaterDay;
        Season season = new Season();
        switch (season.getCurrentSeason()){
            case AUTUMN, SPRING -> nextWaterDay = prevWaterDay.plusDays(7);     //Осенью и весной поливать раз в неделю
            case WINTER -> nextWaterDay = prevWaterDay.plusMonths(1);     //Осенью и весной поливать раз в месяц
            case SUMMER -> nextWaterDay = prevWaterDay.plusDays(2);     //Летом поливается в зависимости от влажности воздуха, но не чаще одного раза в два дня.
        }
    }

    public LocalDate getNextWaterDay() {
        return nextWaterDay;
    }

    public void setNextWaterDay(LocalDate nextWaterDay) {
        this.nextWaterDay = nextWaterDay;
    }

}
