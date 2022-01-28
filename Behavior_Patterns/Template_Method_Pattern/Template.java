package Template_Method_Pattern;

abstract class CaffeinBeverage {
    final void prepareRecipe() {
        brew();
        addCondiments();
        boilWater();
        pourInCup();
    }

    public abstract void brew();

    public abstract void addCondiments();

    public void boilWater() {
        System.out.println("Boiling Water");
    }

    public void pourInCup() {
        System.out.println("Pouring into cup");
    }
}

class Tea extends CaffeinBeverage {
    public void brew() {
        System.out.println("Stepping a tea");
    }

    public void addCondiments() {
        System.out.println("Adding lemonade");
    }
}

class Coffee extends CaffeinBeverage {
    public void brew() {
        System.out.println("Dripping Coffee Through Filter");
    }

    public void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }
}

public class Template {
    public static void main(String[] args) {
        CaffeinBeverage coffee = new Coffee();
        CaffeinBeverage tea = new Tea();

        coffee.prepareRecipe();
        tea.prepareRecipe();
    }
}
