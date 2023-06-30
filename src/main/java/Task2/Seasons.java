package Task2;

public enum Seasons {
    WINTER("Зима"),
    AUTUMN("Осень"),
    SPRING("Весна"),
    SUMMER("Лето");

    private final String inRussian;

    Seasons(String inRussian) {
        this.inRussian = inRussian;
    }

    public String getInRussian() {
        return inRussian;
    }
}
