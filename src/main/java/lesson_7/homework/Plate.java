package lesson_7.homework;

public class Plate {


    public void setFood(int food) {
        this.food = food;
    }

    private int food;

    public Plate(int food) {
        this.food = food;
    }
    public int getFood() {
        return food;
    }
    public void decreaseFood(int n) {
            food -= n;
    }
    public void info() {
        System.out.println("plate: " + food);
    }



}
