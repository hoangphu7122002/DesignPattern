package Composite_Pattern;

import java.util.ArrayList;
// import java.util.Collection;
import java.util.Iterator;

abstract class MenuComponent {
    public void add(MenuComponent component) {
        throw new UnsupportedOperationException();
    }

    public void remove(MenuComponent component) {
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public String getDescription() {
        throw new UnsupportedOperationException();
    }

    public double getPrice() {
        throw new UnsupportedOperationException();
    }

    public boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }

    public void print() {
        throw new UnsupportedOperationException();
    }
}

class MenuItem extends MenuComponent {
    String name;
    String description;
    boolean vegetarian;
    double price;

    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isVegetarian() {
        return this.vegetarian;
    }

    public double getPrice() {
        return this.price;
    }

    public void print() {
        System.out.print(" " + getName());
        if (isVegetarian()) {
            System.out.print("(v)");
        }
        System.out.print(" " + getPrice());
        System.out.print(" " + getDescription());
    }
}

class Menu extends MenuComponent {
    String name;
    String description;
    ArrayList<MenuComponent> menuComponent = new ArrayList<MenuComponent>();

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void add(MenuComponent component) {
        this.menuComponent.add(component);
    }

    public void remove(MenuComponent component) {
        this.menuComponent.remove(component);
    }

    public MenuComponent getChild(int i) {
        MenuComponent child = menuComponent.get(i);
        return child;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public void print() {
        System.out.print(" Name: " + getName());
        System.out.println(" Description: " + getDescription());
        System.out.println("=================================");

        Iterator iterator = menuComponent.iterator();
        while (iterator.hasNext()) {
            MenuComponent menu = (MenuComponent) iterator.next();
            menu.print();
        }
    }
}

class Waitress {
    MenuComponent allMenus;

    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    public void printMenu() {
        this.allMenus.print();
    }
}

public class Composite_Pattern {
    public static void main(String[] args) {
        MenuComponent pancakeHouseMenu = new Menu("PANCAKE_HOUSE_MENU", "Breakfast");
        MenuComponent dinnerMenu = new Menu("DINNER_MENU", "Lunch");
        MenuComponent cafeMenu = new Menu("CAFE_MENU", "dinner");
        MenuComponent dessertMenu = new Menu("DESSERT_MENU", "Desert of course!");

        MenuComponent allMenus = new Menu("ALL_MENUS", "All menus combined");

        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinnerMenu);
        allMenus.add(cafeMenu);
        // allMenus.add(dessertMenu);

        dinnerMenu.add(new MenuItem("Pasta", "Spaghetti Italy", true, 3.89));
        dinnerMenu.add(dessertMenu);

        dessertMenu.add(new MenuItem("Apple Pie", "Topping push", true, 1.59));

        Waitress waitress = new Waitress(allMenus);
        waitress.printMenu();
    }
}
