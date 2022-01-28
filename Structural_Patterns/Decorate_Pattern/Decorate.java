package Decorate_Pattern;

//interface
//----------------------------------------------------------------
abstract class Beverage {
    public String description = "Unknown Beverage";

    public String getDescription() {
        return this.description;
    }

    public abstract float cost();
}
// ----------------------------------------------------------------

class DarkRoast extends Beverage {
    public DarkRoast() {
        this.description = "DarkRoast";
    }

    public float cost() {
        return 2.99f;
    }
}

class HouseBlend extends Beverage {
    public HouseBlend() {
        this.description = "HouseBlend";
    }

    public float cost() {
        return 2.5f;
    }
}

class Espresso extends Beverage {
    public Espresso() {
        this.description = "Espresso";
    }

    public float cost() {
        return 1.9f;
    }
}

class Decaf extends Beverage {
    public Decaf() {
        this.description = "Decaf";
    }

    public float cost() {
        return 2.3f;
    }
}

// condimentDecorator
// ----------------------------------------------------------------

abstract class CondimentDecorator extends Beverage {
    public abstract String getDescription();
}

// -----------------------------------------------------------------
class Milk extends CondimentDecorator {
    private Beverage beverage;

    public Milk(Beverage b) {
        this.beverage = b;
    }

    public String getDescription() {
        return this.beverage.getDescription() + ", Milk";
    }

    public float cost() {
        return this.beverage.cost() + 0.2f;
    }
}

class Mocha extends CondimentDecorator {
    private Beverage beverage;

    public Mocha(Beverage b) {
        this.beverage = b;
    }

    public String getDescription() {
        return this.beverage.getDescription() + ", Mocha";
    }

    public float cost() {
        return this.beverage.cost() + 0.3f;
    }
}

class Soy extends CondimentDecorator {
    private Beverage beverage;

    public Soy(Beverage b) {
        this.beverage = b;
    }

    public String getDescription() {
        return this.beverage.getDescription() + ", Soy";
    }

    public float cost() {
        return this.beverage.cost() + 0.4f;
    }
}

class Whip extends CondimentDecorator {
    private Beverage beverage;

    public Whip(Beverage b) {
        this.beverage = b;
    }

    public String getDescription() {
        return this.beverage.getDescription() + ", Whip";
    }

    public float cost() {
        return this.beverage.cost() + 0.5f;
    }
}

public class Decorate {
    public static void main(String[] args) {
        Beverage firstOrder = new DarkRoast();
        firstOrder = new Milk(firstOrder);
        firstOrder = new Milk(firstOrder);
        firstOrder = new Soy(firstOrder);

        System.out.println("Order: " + firstOrder.getDescription() + " with cost: " + firstOrder.cost());
    }
}
