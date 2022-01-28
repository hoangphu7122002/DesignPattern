package Builder_Pattern;

class Product1 {
    public double height;
    public double width;
    public String name;

    public Product1(double height, double width, String name) {
        this.height = height;
        this.width = width;
        this.name = name;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getInfo() {
        System.out.println(name + ',' + width + ',' + height);
    }
}

class Product2 {
    public int size;
    public int check;
    public String name;

    public Product2(int size, int check, String name) {
        this.size = size;
        this.check = check;
        this.name = name;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setCheck(int check) {
        this.check = check;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getInfo() {
        System.out.println(name + ',' + check + ',' + size);
    }
}

interface Builder {
    void setName(String name);

    void setSize(int size);

    void setHeight(double height);

    void setWidth(double width);

    void setCheck(int check);
}

class ConcreteBuilder1 implements Builder {
    private String name;
    private int size;
    private int check;
    private double height;
    private double width;

    public ConcreteBuilder1() {

    }

    public void setName(String name) {
        this.name = name;
    };

    public void setSize(int size) {
        this.size = size;
    };

    public void setHeight(double height) {
        this.height = height;
    };

    public void setWidth(double width) {
        this.width = width;
    };

    public void setCheck(int check) {
        this.check = check;
    };

    public Product1 getResult() {
        return new Product1(height, width, name);
    }
}

class ConcreteBuilder2 implements Builder {
    private String name;
    private int size;
    private int check;
    private double height;
    private double width;

    public ConcreteBuilder2() {

    }

    public void setName(String name) {
        this.name = name;
    };

    public void setSize(int size) {
        this.size = size;
    };

    public void setHeight(double height) {
        this.height = height;
    };

    public void setWidth(double width) {
        this.width = width;
    };

    public void setCheck(int check) {
        this.check = check;
    };

    public Product2 getResult() {
        return new Product2(size, check, name);
    }
}

class Director {
    public void buildProduct1(Builder builder) {
        System.out.println("Setting build product 1!");
        builder.setName("Product1");
        builder.setWidth(1.2f);
        builder.setHeight(1.3f);
        System.out.println("Complete product 1!");
    }

    public void buildProduct2(Builder builder) {
        System.out.println("Setting build product 2!");
        builder.setName("Product2");
        builder.setCheck(1);
        builder.setSize(5);
        System.out.println("Complete product 2!");
    }
}

public class Builder_Pattern {
    public static void main(String[] args) {
        Director director = new Director();

        ConcreteBuilder2 builder2 = new ConcreteBuilder2();
        ConcreteBuilder1 builder1 = new ConcreteBuilder1();

        director.buildProduct1(builder1);
        director.buildProduct2(builder2);

        Product1 product1 = (Product1) builder1.getResult();
        Product2 product2 = (Product2) builder2.getResult();
        product1.getInfo();
        product2.getInfo();
    }
}
