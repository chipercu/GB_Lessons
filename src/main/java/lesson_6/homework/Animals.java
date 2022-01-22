package lesson_6.homework;

public class Animals {

    protected String name;
    protected int maxRunDistance;
    protected int maxSwimDistance;
    public static int counts;

    public Animals(){
        counts++;
    }


    public void run(int distance){
        System.out.println(name == null ? "Животное не умеет бежать" : name + " не умеет бежать");
    }


    public void swim(int distance){
        System.out.println(name == null ? "Животное не умеет плыть" : name + " не умеет плыть");
    }

    public static void printCounts(){
        System.out.println("Количество создоных животных = " + counts);
    }

}
