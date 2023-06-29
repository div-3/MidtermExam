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

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class Playground {
    public static void main(String[] args) {
        Cactus cactus = new Cactus();
//        cactus.setLastWaterDate(LocalDate.now().minusDays(new Random().nextInt(0, 365)));
        HumiditySensor humiditySensor = new HumiditySensor();
        Season season = new Season();
        Sprinkler sprinkler = new Sprinkler();

        //Получение даты последней поливки от пользователя
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите дату последнего полива кактуса в формате DD.MM.YYYY: ");
        while (true){
            String wateringDay = sc.nextLine();
            try {
                DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                LocalDate prevWaterDay = LocalDate.parse(wateringDay, dateFormat);
//                System.out.println(prevWaterDay);
                break;
            } catch (Exception e) {
                System.out.print("Неправильный формат даты! Введите дату заново в формате DD.MM.YYYY: ");
            }
        }



//        System.out.println("Дата последней поливки: " + cactus.getLastWaterDate());

//        System.out.println(season.getSeason());


    }


}
