package Creational_Pattern.Factory_Pattern;

import java.util.ArrayList;

abstract class PizzaStore {
    public Pizza OrderPizza(String type) {
        Pizza pizza;

        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    abstract Pizza createPizza(String type);
}

abstract class Pizza {
    public String name;
    public String dough;
    public String sauce;

    ArrayList<String> toppings = new ArrayList<String>();

    public void prepare() {
        System.out.println("Preparing: " + name);
        System.out.println("Toss dough...");
        System.out.println("Adding sauce...");
        System.out.println("Adding toppings...");

        for (int i = 0; i < toppings.size(); i++) {
            System.out.print(toppings.get(i) + " ");
        }
        System.out.println("");
    }

    public void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    public void box() {
        System.out.println("Place pizza into Box");
    }

    public String getName() {
        return this.name;
    }
}

class NYPizzaStore extends PizzaStore {
    public Pizza createPizza(String item) {
        if (item.equals("cheese")) {
            return new NYStyleCheesePizza();
        } else if (item.equals("veggie")) {
            return new NYStyleCVeggiePizza();
        } else if (item.equals("clam")) {
            return new NYStyleClamPizza();
        } else if (item.equals("pepperoni")) {
            return new NYStylePepperoniPizza();
        }
        return null;
    }
}

class ChicagoPizzaStore extends PizzaStore {
    public Pizza createPizza(String item) {
        if (item.equals("cheese")) {
            return new ChicagoStyleCheesePizza();
        } else if (item.equals("veggie")) {
            return new ChicagoStyleCVeggiePizza();
        } else if (item.equals("clam")) {
            return new ChicagoStyleClamPizza();
        } else if (item.equals("pepperoni")) {
            return new ChicagoStylePepperoniPizza();
        }
        return null;
    }
}

class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza() {
        this.name = "NYStyleCheesePizza";
        this.dough = "Thin Crust Dough";
        this.sauce = "Marinara Sauce";

        toppings.add("1");
    }
}

class NYStyleCVeggiePizza extends Pizza {
    public NYStyleCVeggiePizza() {
        this.name = "NYStyleCVeggiePizza";
        this.dough = "Thin Crust Dough";
        this.sauce = "Marinara Sauce";

        toppings.add("2");
    }
}

class NYStyleClamPizza extends Pizza {
    public NYStyleClamPizza() {
        this.name = "NYStyleClamPizza";
        this.dough = "Thin Crust Dough";
        this.sauce = "Marinara Sauce";

        toppings.add("3");
    }
}

class NYStylePepperoniPizza extends Pizza {
    public NYStylePepperoniPizza() {
        this.name = "NYStylePepperoniPizza";
        this.dough = "Thin Crust Dough";
        this.sauce = "Marinara Sauce";

        toppings.add("4");
    }
}

class ChicagoStyleCheesePizza extends Pizza {
    public ChicagoStyleCheesePizza() {
        this.name = "ChicagoStyleCheesePizza";
        this.dough = "Thin Crust Dough";
        this.sauce = "Marinara Sauce";

        toppings.add("5");
    }
}

class ChicagoStyleCVeggiePizza extends Pizza {
    public ChicagoStyleCVeggiePizza() {
        this.name = "ChicagoStyleCVeggiePizza";
        this.dough = "Thin Crust Dough";
        this.sauce = "Marinara Sauce";

        toppings.add("6");
    }
}

class ChicagoStyleClamPizza extends Pizza {
    public ChicagoStyleClamPizza() {
        this.name = "ChicagoStyleClamPizza";
        this.dough = "Thin Crust Dough";
        this.sauce = "Marinara Sauce";

        toppings.add("7");
    }
}

class ChicagoStylePepperoniPizza extends Pizza {
    public ChicagoStylePepperoniPizza() {
        this.name = "ChicagoStylePepperoniPizza";
        this.dough = "Thin Crust Dough";
        this.sauce = "Marinara Sauce";

        toppings.add("8");
    }
}

public class Factory {
    public static void main(String[] args) {
        PizzaStore NYStore = new NYPizzaStore();
        PizzaStore ChicagoStore = new ChicagoPizzaStore();

        Pizza JackOrder = NYStore.OrderPizza("cheese");
        Pizza JohnOrder = ChicagoStore.OrderPizza("veggie");

        // JackOrder.prepare();
        // JohnOrder.prepare();
    }
}
