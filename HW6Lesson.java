/**
 * Java level 1. Lesson 6. Home work
 * @author Zagretdinov Airat
 * @version 1.0 date 17.02.2020
 */

public class HW6Lesson {

    public static void main(String[] args) {
        Dog dog = new Dog("Barsik");
        Cat cat = new Cat("Murzik");
        System.out.println(dog.run(600));
        System.out.println(cat.run(150));
        System.out.println(dog.swim(9));
        System.out.println(cat.swim(10));
        System.out.println(dog.jump(2));
        System.out.println(cat.jump(1));
    }
}