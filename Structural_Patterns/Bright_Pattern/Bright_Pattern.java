package Bright_Pattern;

interface implementation {
    public void method();
}

abstract class entity {
    implementation imp;

    public abstract void method1();

    public abstract void method2();
}

class imp1 implements implementation {
    public imp1() {
        System.out.println("Create imp1");
    }

    public void method() {
        System.out.println("imp1");
    }
}

class imp2 implements implementation {
    public imp2() {
        System.out.println("Create imp2");
    }

    public void method() {
        System.out.println("imp2");
    }
}

class entity1 extends entity {
    public entity1(implementation imp) {
        this.imp = imp;
    }

    public void method1() {
        System.out.println("method1");
    }

    public void method2() {
        System.out.println("method2");
    }
}

class entity2 extends entity {
    public entity2(implementation imp) {
        this.imp = imp;
    }

    public void method1() {
        System.out.println("method1");
    }

    public void method2() {
        System.out.println("method2");
    }
}

public class Bright_Pattern {
    public static void main(String[] args) {
        entity ent1 = new entity1(new imp1());
        entity ent2 = new entity1(new imp2());

        ent1.method1();
        ent2.method2();
    }
}
