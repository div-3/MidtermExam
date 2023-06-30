package Task2;

import java.time.LocalDate;

public class Season {
    private LocalDate currentDate;

    public Seasons getCurrentSeason() {
        return getSeasonByDate(currentDate = LocalDate.now());
    }

    //Вычисление сезона по дате
    public Seasons getSeasonByDate(LocalDate localDate) {
        return switch (localDate.getMonthValue()) {
            case 1, 2, 12 -> Seasons.WINTER;
            case 3, 4, 5 -> Seasons.SPRING;
            case 6, 7, 8 -> Seasons.SUMMER;
            default -> Seasons.AUTUMN;
        };
    }
}
