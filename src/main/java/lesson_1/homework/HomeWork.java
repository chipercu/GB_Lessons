package lesson_1.homework;

public class HomeWork {

    public static void main(String[] args) {
        printThreeWords();
        System.out.println("_____________________________");
        checkSumSign(5, 10);
        System.out.println("_____________________________");
        printColor(-10);
        System.out.println("_____________________________");
        compareNumbers(5, 5);
    }
    public static void printThreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    public static void checkSumSign(int a, int b){
        if (a + b >= 0){
            System.out.println("Сумма положительная");
        }else {
            System.out.println("Сумма отрицательная");
        }
    }
    public static void printColor(int value){
        if (value <= 0){
            System.out.println("Красный");
        }else if (value <= 100){
            System.out.println("Желтый");
        }else {
            System.out.println("Зеленый");
        }
    }
    public static void compareNumbers(int a, int b){
        if (a >= b){
            System.out.println("a >= b");
        }else {
            System.out.println("a < b");
        }
    }
}