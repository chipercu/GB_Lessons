package lesson_2.homework;

import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) {
        int value1 = Rnd.getInt(1, 30);
        int value2 = Rnd.getInt(1, 30);
        int value3 = Rnd.getInt(-100, 100);
        int value4 = Rnd.getInt(-100, 100);
        int yaer = 1993;
        //1 задача
        System.out.println("---------------1 задача ----------------");
        System.out.println("Сумма переменых value1 и value2 = " + (value1 + value2) + " и " + (ifInRange(value1, value2) ?
                "лежит в пределах от 10 до 20 включительно" : "не лежит в пределах от 10 до 20 включительно"));
        //2 задача
        System.out.println("---------------2 задача-----------------");
        System.out.print("value3 = " + value3 + ", ");
        positiveOrNegative(value3);

        //3 задача
        System.out.println("---------------3 задача ----------------");
        System.out.println("value3 = " + value4 + ", value3 - "
                + (valueIsPositiveOrNegative(value4) ? "отрицательное" : "положительное"));
        //4 задача
        System.out.println("---------------4 задача ----------------");
        printStringNTimes("Я буду Java прогромистом!", 5);

        //5 задача
        System.out.println("---------------5 задача -----------------");
        System.out.println(yaer + " год - " + (checkIfYearIsLeap(yaer) ? "високосный":"не високосный"));



    }

    /**
     * первое задание, проверяет если сумма двух значений входит в заданый интервал
     *
     * @param value1
     * @param value2
     * @return
     */
    public static boolean ifInRange(int value1, int value2) {
        return value1 + value2 > 10 && value1 + value2 <= 20;
    }

    /**
     * вторая задача, проверяет если значение положительное или отрицательное.
     *
     * @param value
     */
    public static void positiveOrNegative(int value) {
        System.out.println(value >= 0 ? "value - положительное " : "value - отрицательное");
    }

    /**
     * третья задача, возврощает true если value отрицательное или false если value положительное.
     *
     * @param value
     * @return
     */
    public static boolean valueIsPositiveOrNegative(int value) {
        return value < 0;
    }

    /**
     * четвертая задача, печатает в консоль строку str  count раз.
     *
     * @param str
     * @param count
     */
    public static void printStringNTimes(String str, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }

    /**
     * 5 задача, проверяет является ли год (year) високосным и возврощат true если правда или false если нет;
     * @param year - год.
     * @return
     */
    public static boolean checkIfYearIsLeap(int year) {
        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
    }


    /**
     * доп класс для получения рандомных значении для переменых
     */
    static class Rnd{

        public static int getInt(int v){
            return (int) (Math.random() * v);
        }
        public static int getInt(int v1, int v2){
            double rnd = Math.random();
            return (int) ((rnd * (v2 - v1)) + v1);
        }


    }
}
