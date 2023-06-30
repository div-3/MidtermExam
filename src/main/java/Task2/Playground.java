package Task2;
/*
 * У программиста Васи на подоконнике растёт кактус. Вася постоянно забывает его поливать, поэтому он купил датчик
 * влажности и решил составить программу для отслеживания времени полива.
 * На вход программа ждет дату последнего полива кактуса.
 * Если сейчас зима (декабрь-февраль),то кактус поливается раз в месяц.
 * Если осень или весна - раз в неделю.
 * Летом поливается в зависимости от влажности воздуха, но не чаще одного раза в два дня.
 * Значение влажности воздуха в программу попадает автоматически от датчика (реализуйте через вызов метода класса Датчик,
 * внутри которого будет генерация рандомного числа).
 * Если влажность меньше 30%, кактус нужно полить.
 * Вася ожидает от программы, что после проверки всех данных, она выведет ему сообщение с датой, когда надо поливать
 * кактус.
 * Реализуйте программу, используя принципы ООП и библиотеки для работы с датой.*/

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Playground {
    static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static void main(String[] args) {

        Sprinkler sprinkler = new Sprinkler();

        //Получение даты последней поливки от пользователя
        System.out.print("Введите дату последнего полива кактуса в формате DD.MM.YYYY: ");
        sprinkler.setPrevWaterDay(getDateFromConsole());

        //Вывод даты следующего полива
        LocalDate d = sprinkler.getNextWaterDay();
        System.out.println("Дата следующего полива кактуса: " +
                ((d != null) ? d.format(dateFormat) : "полив пока не требуется."));
    }

    //Получение даты последнего полива от пользователя
    private static LocalDate getDateFromConsole() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String wateringDay = sc.nextLine();
            try {
                LocalDate prevWaterDay = LocalDate.parse(wateringDay, dateFormat);
                //Если ввели дату в будущем
                if (LocalDate.now().toEpochDay() - prevWaterDay.toEpochDay() < 0) throw new Exception();
                sc.close();
                return prevWaterDay;
            } catch (Exception e) {
                System.out.print("Неправильный формат даты! Введите дату заново в формате DD.MM.YYYY: ");
            }
        }
    }
}
