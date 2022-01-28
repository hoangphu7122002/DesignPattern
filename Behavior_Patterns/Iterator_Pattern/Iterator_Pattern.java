package Iterator_Pattern;

import java.util.ArrayList;

class MenuItem {
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
}

interface Iterator {
    boolean hasNext();

    Object next();
}

class DinnerMenuIterator implements Iterator {
    public MenuItem[] items;
    public int position = 0;

    public DinnerMenuIterator(MenuItem[] items) {
        this.items = items;
    }

    public boolean hasNext() {
        if (position >= items.length || items[position] == null) {
            return false;
        }
        return true;
    }

    public Object next() {
        MenuItem menuItem = items[position];
        position++;
        return menuItem;
    }
}

class PancakeHouseMenuIterator implements Iterator {
    ArrayList<MenuItem> items;
    int position = 0;

    public PancakeHouseMenuIterator(ArrayList<MenuItem> items) {
        this.items = items;
    }

    public boolean hasNext() {
        if (position >= items.size()) {
            return false;
        }
        return true;
    }

    public Object next() {
        MenuItem menuItem = (MenuItem) items.get(position);
        position++;
        return menuItem;
    }
}

class DinnerMenu {
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    MenuItem[] menuItem;

    public DinnerMenu() {
        menuItem = new MenuItem[MAX_ITEMS];

        addItem("potato", "red and sour", true, 2.9f);
        addItem("pumpkin", "scary and sweet", true, 2.9f);
        addItem("beef", "fresh and delicious", false, 5f);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);

        if (numberOfItems >= MAX_ITEMS) {
            System.out.println("I't is maximum of items, not add here");
        } else {
            this.menuItem[numberOfItems] = menuItem;
            numberOfItems++;
        }
    }

    public Iterator getIterator() {
        return new DinnerMenuIterator(this.menuItem);
    }
}

class PancakeHouseMenu {
    ArrayList<MenuItem> items;

    public PancakeHouseMenu() {
        items = new ArrayList<MenuItem>();

        addItem("potato", "red and sour", true, 2.9f);
        addItem("pumpkin", "scary and sweet", true, 2.9f);
        addItem("beef", "fresh and delicious", false, 5f);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        items.add(menuItem);
    }

    public Iterator getIterator() {
        return new PancakeHouseMenuIterator(items);
    }
}

class Waitress {
    PancakeHouseMenu pancakeHouseMenu;
    DinnerMenu dinnerMenu;

    public Waitress(PancakeHouseMenu pancakeHouseMenu, DinnerMenu dinnerMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinnerMenu = dinnerMenu;
    }

    public Waitress(DinnerMenu dinnerMenu, PancakeHouseMenu pancakeHouseMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinnerMenu = dinnerMenu;
    }

    public void printMenu() {
        Iterator dinnerMenuIter = dinnerMenu.getIterator();
        Iterator pancakeHouseMenuIter = pancakeHouseMenu.getIterator();
        System.out.println("Dinner Menu have:");
        printMenu(dinnerMenuIter);
        System.out.println("==================");
        System.out.println("Pancake house Menu have:");
        printMenu(pancakeHouseMenuIter);
    }

    public void printMenu(Iterator it) {
        while (it.hasNext()) {
            MenuItem menuItem = (MenuItem) it.next();
            System.out.println(menuItem.name + " " + menuItem.description + " " + menuItem.price);
        }
    }
}

public class Iterator_Pattern {
    public static void main(String[] args) {
        DinnerMenu dinnerMenu = new DinnerMenu();
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();

        Waitress waitress = new Waitress(pancakeHouseMenu, dinnerMenu);

        waitress.printMenu();
    }
}
