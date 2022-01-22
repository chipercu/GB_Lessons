package lesson_6.homework;

public class Dog extends Animals{

    public static int counts;

    public Dog(String name) {
        this.name = name;
        maxRunDistance = 500;
        maxSwimDistance = 10;
        counts++;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public void run(int distance) {
        if (distance <= 0){
            super.run(distance);
        }else if (distance > maxRunDistance){
            System.out.println(getName() + " не может пробежать больше " + maxRunDistance + " м.");
        }else {
            System.out.println(getName() + " пробежал " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= 0){
            super.run(distance);
        }else if (distance > maxRunDistance){
            System.out.println(getName() + " не может проплыть больше " + maxSwimDistance + " м.");
        }else {
            System.out.println(getName() + " проплыл " + distance + " м.");
        }
    }
    public static void printCounts(){
        System.out.println("Количество создоных собак = " + counts);
    }


}
