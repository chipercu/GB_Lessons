package lesson_7.homework;

public class Cat {

    private String name;
    private int appetite;
    private boolean isSatiety;

    public void setSatiety(boolean satiety) {
        isSatiety = satiety;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate p) {
        if (appetite <= p.getFood() ){
            p.decreaseFood(appetite);
            System.out.println(name + " пожрал");
            isSatiety = true;
        }else {
            System.out.println(name + " ушёл обиженым");
        }
    }
}
