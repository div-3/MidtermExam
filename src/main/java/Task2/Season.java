package Task2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

public class Season {
    private LocalDate currentDate;

    public Seasons getSeason(){
        switch (Integer.parseInt ((currentDate = LocalDate.now()).getMonth().toString())) {
            case 1, 2, 12:
                return Seasons.WINTER;
            case 3, 4, 5:
                return Seasons.SPRING;
            case 6, 7, 8:
                return Seasons.SUMMER;
            default:
                return Seasons.AUTUMN;
        }
    }
}
