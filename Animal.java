class Animal {
    String name;
    float distance;

    Animal(String name) {
        this.name = name;
    }

    public String run(float distance) {
        String run = name + " ran " + distance + " m.";
    return run;
    }

    public String swim(float distance) {
        String swim = name + " swam " + distance + " m.";
    return swim;
    }

    public String jump(float distance) {
        String run = name + " jumped " + distance + " m.";
    return run;
    }

    @Override
    public String toString () {
        return name;
    }
}

class Dog extends Animal {
    private String name;
    private float distance;

    Dog(String name) {
        super(name);
    }

    public String run(float distance) {
    if (distance < 500)
        return ("Dog " + super.name + " ran " + distance + " m.");
    else return ("Dog " + super.name + " can not run " + distance + " m.");
    }

    public String jump(float distance) {
    if (distance < 0.5)
        return ("Dog " + super.name + " jumped " + distance + " m.");
    else return ("Dog " + super.name + " can not jump " + distance + " m.");
    }

    public String swim(float distance) {
    if (distance < 10)
        return ("Dog " + super.name + " swam " + distance + " m.");
    else return ("Dog " + super.name + " cannot swim " + distance + " m.");
    }

}

class Cat extends Animal {
    private String name;
    private float distance;

    Cat(String name) {
        super(name);
    }

    public String run(float distance) {
    if (distance < 200)
        return ("Cat " + super.name + " ran " + distance + " m.");
    else return ("Cat " + super.name + " can not run " + distance + " m.");
    }

    public String jump(float distance) {
    if (distance < 2)
        return ("Cat " + super.name + " jumped " + distance + " m.");
    else return ("Cat " + super.name + " can not jump " + distance + " m.");
    }

    public String swim(float distance) {
    return ("Cat " + super.name + " can`t swim.");
    }

}