package Adapt_Pattern;

interface Duck {
    void quack();

    void fly();
}

interface Chicken {
    void hot();

    void fly();
}

class Adapt implements Duck {
    public Chicken animal;

    public Adapt(Chicken animal) {
        this.animal = animal;
    }

    public void quack() {
        animal.hot();
    }

    public void fly() {
        animal.fly();
    }
}

class Duck_Temp implements Duck {
    public Duck_Temp() {
        System.out.println("Hi, I'm Duck_temp");
    }

    public void quack() {
        System.out.println("QUACK");
    }

    public void fly() {
        System.out.println("I can fly");
    }
}

class Chicken_Temp implements Chicken {
    public Chicken_Temp() {
        System.out.println("Hi, I'm Chicken_temp");
    }

    public void hot() {
        System.out.println("O O O");
    }

    public void fly() {
        System.out.println("I can't fly");
    }
}

public class EX1 {
    public static void main(String[] args) {
        // Duck duck = new Duck_Temp();
        Chicken chicken = new Chicken_Temp();

        Duck chicken_duck = new Adapt(chicken);

        chicken_duck.quack();
        chicken_duck.fly();
    }
}