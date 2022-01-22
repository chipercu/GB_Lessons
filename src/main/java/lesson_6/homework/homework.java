package lesson_6.homework;


public class homework {

    public static void main(String[] args) {

        Animals tom = new Cat("Tom");
        Animals murka = new Cat("Murka");
        Animals rex = new Dog("Rex");
        tom.run(150);
        tom.swim(20);
        rex.run(600);
        rex.swim(10);
        murka.run(300);
        murka.swim(20);

        Animals.printCounts();
        Dog.printCounts();
        Cat.printCounts();


    }



}
