package Visitor_Pattern;

import java.util.ArrayList;

interface Component {
    void accept(Visitor v);
}

interface Visitor {
    void visitComponentA(ComponentA ele);

    void visitComponentB(ComponentB ele);
}

class ComponentA implements Component {
    public void accept(Visitor v) {
        v.visitComponentA(this);
    }

    public String method() {
        return "A";
    }
}

class ComponentB implements Component {
    public void accept(Visitor v) {
        v.visitComponentB(this);
    }

    public String method() {
        return "B";
    }
}

class ConcreteVisitor1 implements Visitor {
    public void visitComponentA(ComponentA ele) {
        System.out.println(ele.method() + "---concreteVisitor1");
    }

    public void visitComponentB(ComponentB ele) {
        System.out.println(ele.method() + "---concreteVisitor1");
    }
}

public class Visitor_Pattern {
    public static void main(String[] args) {
        Component a = new ComponentA();
        Component b = new ComponentB();
        Component c = new ComponentA();

        Visitor visitor = new ConcreteVisitor1();
        ArrayList<Component> components = new ArrayList<Component>();

        components.add(a);
        components.add(b);
        components.add(c);

        client(components, visitor);
    }

    static void client(ArrayList<Component> components, Visitor v) {
        for (Component c : components) {
            c.accept(v);
        }
    }
}