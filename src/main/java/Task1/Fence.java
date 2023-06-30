package Task1;

import java.util.Scanner;

/* Задача 1.
 * Мальчик хочет написать на заборе признание в любви девочке из пятнадцати букв и трех пробелов.
 * На каждые три буквы мальчик тратит по 62 см длины забора, а на каждый пробел - 12 см.
 * Напишите программу, которая поможет по длине забора(введенной пользователем) выяснить, поместится ли на забор такой
 * длины надпись мальчика.*/
public class Fence {
    public static void main(String[] args) {
        final int SIGNS_COUNT = 15;
        final int SPACE_COUNT = 3;
        final int TREE_SIGN_LENGTH = 62;
        final int SPACE_LENGTH = 12;
        final double MESSAGE_LENGTH = ((double) SIGNS_COUNT / 3) * TREE_SIGN_LENGTH + SPACE_COUNT * SPACE_LENGTH;
        System.out.println("Общая длина надписи в сантиметрах: " + MESSAGE_LENGTH);

        //Ввод длины забора пользователем
        System.out.print("Введите длину забора в сантиметрах: ");
        double fenceLength = getFenceLengthByConsole();

        //Вывод результата проверки
        System.out.println("Надпись " + ((MESSAGE_LENGTH > fenceLength) ? "не " : "") + "поместится на такой забор");
    }

    private static double getFenceLengthByConsole() {
        Scanner sc = new Scanner(System.in);
        double fenceLength;
        while (true) {
            try {
                //Выбросится исключение, если введено неправильное значение (строка) или число меньше 0
                if ((fenceLength = sc.nextDouble()) < 0) throw new Exception();
                break;
            } catch (Exception e) {
                System.out.print("Введена некорректная длина забора! Повторите ввод: ");
                String tmp = sc.nextLine();     //Очистка сканера
            }
        }
        sc.close();
        return fenceLength;
    }
}
