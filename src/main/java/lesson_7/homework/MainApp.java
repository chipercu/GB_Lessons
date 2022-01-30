package lesson_7.homework;

public class MainApp {
    public static Cat[] cats = new Cat[6];
    public static Plate plate = new Plate(105);
    public static void main(String[] args) {

        for (int i = 0; i < 6; i++) {
            cats[i] = new Cat("Proglot" + i , 20);
            cats[i].setSatiety(false);
        }
        plate.info();
        for (int i = 0; i < 6; i++) {
            cats[i].eat(plate);
            plate.info();
        }
    }

}
