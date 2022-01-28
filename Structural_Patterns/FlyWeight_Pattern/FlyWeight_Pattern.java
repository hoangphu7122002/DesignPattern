package FlyWeight_Pattern;

import java.util.HashMap;
import java.time.Duration;
import java.util.ArrayList;

//reference: https://gpcoder.com/4626-huong-dan-java-design-pattern-flyweight/

interface IProduct {
    void promote(Context context);
}

class Context {
    private double weight;
    private double height;

    private int id;

    public Context(int id, double weight, double height) {
        this.weight = weight;
        this.height = height;
        this.id = id;
    }

    public double getWeight() {
        return this.weight;
    }

    public double getHeight() {
        return this.height;
    }

    public int getId() {
        return this.id;
    }
}

class Product implements IProduct {
    private final String name; // Intrinsic State

    public Product(String name) {
        this.name = name;
        System.out.println("Product created! - " + name);
    }

    @Override
    public void promote(Context context) {
        System.out.println(
                name + " with id : " + context.getId() + " height: " + context.getHeight() + " weight: "
                        + context.getWeight());
    }
}

class ProductFactory {
    private static final HashMap<String, IProduct> products = new HashMap<>();

    private ProductFactory() {
        throw new IllegalStateException();
    }

    public static synchronized IProduct createProduct(String name) {
        IProduct product = products.get(name);

        if (product == null) {
            waiting();
            product = new Product(name);
            products.put(name, product);
        }

        return product;
    }

    public static synchronized int getSize() {
        return products.size();
    }

    public static void waiting() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class FlyWeight_Pattern {
    private static ArrayList<IProduct> products = new ArrayList<>();

    public static void main(String[] args) {
        Long start = System.currentTimeMillis();

        createProduct("PD1", 5, 2.0, 3.0);
        createProduct("PD2", 3, 2.0, 4.0);
        createProduct("PD1", 4, 1.0, 5.0);
        createProduct("PD2", 3, 3.0, 5.0);

        Long end = System.currentTimeMillis();

        System.out.println("----------");
        System.out.println("Total Product made: " + products.size());
        System.out.println("Total time worked: " + Duration.ofMillis(end - start).getSeconds() + " second");
        System.out.println("Type of Product: " + ProductFactory.getSize());
    }

    public static void createProduct(String name, int numberOfProduct, double height, double weight) {
        for (int i = 1; i <= numberOfProduct; i++) {
            Context context = new Context((products.size() + 1), height, weight);
            IProduct product = ProductFactory.createProduct(name);
            product.promote(context);
            products.add(product);
        }
    }
}