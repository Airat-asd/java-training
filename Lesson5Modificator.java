class Lesson5Modificator {

    public static void main(String[] args) {
        Cat cat = new Cat("Murzik", "white", 3);
        cat.setName("Barsik");
        System.out.println("print: "+ cat.getName() + " " + cat.color + " " + cat.age);
        cat.voice();
    }
}

    class Cat {
        int age;
        String color;
        private String name;

        Cat(String name, String color, int age) {
            this.name = name;
            this.color = color;
            this.age = 3;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        void voice() {
            System.out.println("meow!");
    }

}