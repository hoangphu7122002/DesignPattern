package Strategy_Pattern;
// ----------------------------------------------------------------------------

interface QuacKBehavior {
    void quack();
}

class Quack implements QuacKBehavior {
    public void quack() {
        System.out.println("Quack");
    }
}

class MuteQuack implements QuacKBehavior {
    public void quack() {
        System.out.println("Mute");
    }
}

class Squeak implements QuacKBehavior {
    public void quack() {
        System.out.println("Squeak");
    }
}

// ----------------------------------------------------------------
interface FlyBehavior {
    void fly();
}

class FlyWithWings implements FlyBehavior {
    public void fly() {
        System.out.println("I'm flying");
    }
}

class FlyNoWay implements FlyBehavior {
    public void fly() {
        System.out.println("I'm not flying");
    }
}
// ----------------------------------------------------------------

abstract class Duck {
    QuacKBehavior quackBehavior;
    FlyBehavior flyBehavior;

    public Duck() {

    };

    public void performQuack() {
        quackBehavior.quack();
    };

    public void performFly() {
        flyBehavior.fly();
    };

    public void setFlyBehavior(FlyBehavior fb) {
        flyBehavior = fb;
    }

    public void setQuackBehavior(QuacKBehavior qb) {
        quackBehavior = qb;
    }

    public abstract void display();

    public abstract void swim();
}

class MallardDuck extends Duck {
    public MallardDuck() {
        this.flyBehavior = new FlyWithWings();
        this.quackBehavior = new Quack();
    }

    public void display() {
        System.out.println("I'm Mallard Duck");
        this.flyBehavior.fly();
        this.quackBehavior.quack();
    }

    public void swim() {
        System.out.println("I can swim");
    }
}

class RobotDuck extends Duck {
    public RobotDuck() {
        this.flyBehavior = new FlyNoWay();
        this.quackBehavior = new MuteQuack();
    }

    public void display() {
        System.out.println("I'm RobotDuck");
        this.quackBehavior.quack();
        this.flyBehavior.fly();
    }

    public void swim() {
        System.out.println("I can't swim");
    }
}

public class Strategy {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        Duck robot = new RobotDuck();
        mallard.display();
        System.out.println("\n");
        robot.display();
    }
}