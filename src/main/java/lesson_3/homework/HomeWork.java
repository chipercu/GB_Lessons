package lesson_3.homework;

import java.util.Arrays;

public class HomeWork {
    public static void main(String[] args) {
        int[] arr1 = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        int[] arr2 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[] arr3 = {-50, 2, -100, 25, 75, 30, 55};
        int square_size = 8;
        //1 задача
        System.out.println("1 задание --------------------------------------");
        reversArray(arr1);
        //2 задача
        System.out.println("2 задание --------------------------------------");
        System.out.println(Arrays.toString(increasedArray(100)));
        //3 задача
        System.out.println("3 задание --------------------------------------");
        System.out.println("переданый масив " + Arrays.toString(arr2));
        System.out.println("измененый масив " + Arrays.toString(ifMore6MultipleBy2(arr2)));
        //4 задача
        System.out.println("4 задание --------------------------------------");
        drawSquareAndDiagonals(square_size);
        //5 задача
        System.out.println("5 задание --------------------------------------");
        System.out.println(Arrays.toString(initialArray(6, 32)));
        //6 задача
        System.out.println("6 задание --------------------------------------");
        minimumAndMaximumValue(arr3);
    }

    /**
     * первая задание, метод принимает на вход масив из нулей и единиц, и меняет значения на противоположные
     * @param arr
     */
    public static void reversArray(int [] arr){
        int [] arr_return = new int [arr.length];
        System.out.println("переданый масив " + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            arr_return[i] = arr[i] == 0 ? 1: 0;
        }
        System.out.println("измененый масив " + Arrays.toString(arr_return));
    }

    /**
     * второе задание, метод возврощяет масив длиной count
     * со значениеми от 1 до count в порядке возростания
     * @param count
     * @return
     */
    public static int[] increasedArray(int count){
        int[] array = new int[count];
        for (int i = 1; i <= count; i++) {
            array[i - 1] = i;
        }
        return array;
    }

    /**
     * третье задание, метод походится по масиву array и удваевает его значения если они меньще 6     * @param array
     * @return
     */
    public static int[] ifMore6MultipleBy2(int [] array){
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6)
                array[i] = array[i] * 2;
        }
        return array;
    }

    /**
     * четвертая задача, метод создоет квадратный двумерный целочисленный массив,
     * и с помощью циклов заполняет его диагональные элементы единицами
     * @param n
     */
    public static void drawSquareAndDiagonals(int n){
        int [][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || j == (n - 1) - i) {
                    array[i][j] = 1;
                }
                System.out.print(" " + array[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * пятая задача, метод возвращает одномерный массив типа int длиной len, каждая ячейка которого равна initialValue
     * @param len
     * @param initialValue
     * @return
     */
    public static int[] initialArray(int len, int initialValue){
        int [] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }

    /**
     * шестая задача, метод находит в задоном масиве минимальное и максимальное значение
     * @param array
     */
    public static void minimumAndMaximumValue(int[] array){
        int min = array[0];
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min >= array[i])
                min = array[i];
            if (max <= array[i])
                max = array[i];
        }
        System.out.println("Минимальное значение в масиве : " + min);
        System.out.println("Максимальное значение в масиве : " + max);

    }
}