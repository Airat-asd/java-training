class Lesson5 {

    public static void main(String[] args) {
        Cat cat = new Cat("Murzik", "white", 3);
        System.out.println("print: "+ cat.name + " " + cat.color + " " + cat.age);
        cat.voice();
    }
}

    class Cat {
        int age;
        String color;
        String name;

        Cat(String name, String color, int age) {
            this.name = name;
            this.color = color;
            this.age = 3;
        }
        void voice() {
            System.out.println("meow!");
    }

}