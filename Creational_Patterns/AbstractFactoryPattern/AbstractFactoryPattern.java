package AbstractFactoryPattern;

import javafx.scene.control.Tab;

interface Chair {
    void create();
}

interface Sofa {
    void create();
}

interface Table {
    void create();
}

interface FurnitureAbstractFactory {
    Chair createChair();

    Sofa createSofa();

    Table createTable();
}

enum StyleType {
    ARTDECO,
    VICTORIAN,
    MODERN;
}

class FurnitureFactory {
    private FurnitureFactory() {

    }

    public static final FurnitureAbstractFactory getFactory(StyleType type) {
        switch (type) {
            case ARTDECO:
                return new ArtDecoFactory();
            case VICTORIAN:
                return new VictorianFactory();
            case MODERN:
                return new ModernFactory();
            default:
                throw new UnsupportedOperationException("don't have type");
        }
    }
}

class ArtDecoFactory implements FurnitureAbstractFactory {
    public Chair createChair() {
        return new ArtDecoChair();
    };

    public Sofa createSofa() {
        return new ArtDecoSofa();
    };

    public Table createTable() {
        return new ArtDecoTable();
    };
}

class ArtDecoChair implements Chair {
    public void create() {
        System.out.println("ArtDecoChair created!!");
    }
}

class ArtDecoSofa implements Sofa {
    public void create() {
        System.out.println("ArtDecoSofa created!!");
    }
}

class ArtDecoTable implements Table {
    public void create() {
        System.out.println("ArtDecoTable created!!");
    }
}

class VictorianFactory implements FurnitureAbstractFactory {
    public Chair createChair() {
        return new VictorianChair();
    };

    public Sofa createSofa() {
        return new VictorianSofa();
    };

    public Table createTable() {
        return new VictorianTable();
    };
}

class VictorianChair implements Chair {
    public void create() {
        System.out.println("VictorianChair created!!");
    }
}

class VictorianSofa implements Sofa {
    public void create() {
        System.out.println("VictorianSofa created!!");
    }
}

class VictorianTable implements Table {
    public void create() {
        System.out.println("VictorianTable created!!");
    }
}

class ModernFactory implements FurnitureAbstractFactory {
    public Chair createChair() {
        return new ModernChair();
    };

    public Sofa createSofa() {
        return new ModernSofa();
    };

    public Table createTable() {
        return new ModernTable();
    };
}

class ModernChair implements Chair {
    public void create() {
        System.out.println("ModernChair created!!");
    }
}

class ModernSofa implements Sofa {
    public void create() {
        System.out.println("ModernSofa created!!");
    }
}

class ModernTable implements Table {
    public void create() {
        System.out.println("ModernTable created!!");
    }
}

public class AbstractFactoryPattern {
    public static void main(String[] args) throws Exception {
        FurnitureAbstractFactory factory = FurnitureFactory.getFactory(StyleType.ARTDECO);
        Chair chair = factory.createChair();
        chair.create();
    }
}
