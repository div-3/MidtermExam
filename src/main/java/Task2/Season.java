package Task2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

public class Season {
    private LocalDate currentDate;

    public Seasons getCurrentSeason(){
        currentDate = LocalDate.now().minusMonths(new Random().nextInt(0, 12));
        System.out.println(currentDate.getMonth());
        return getSeasonByDate(currentDate);
    }

    public Seasons getSeasonByDate(LocalDate localDate){
        return switch (localDate.getMonthValue()) {
            case 1, 2, 12 -> Seasons.WINTER;
            case 3, 4, 5 -> Seasons.SPRING;
            case 6, 7, 8 -> Seasons.SUMMER;
            default -> Seasons.AUTUMN;
        };
    }
}
