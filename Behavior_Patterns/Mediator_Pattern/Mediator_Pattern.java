package Mediator_Pattern;

interface Mediator {
    void notify(Component sender, String event);
}

abstract class Component {
    public Mediator mediator;

    void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    Mediator getMediator() {
        return this.mediator;
    }
}

class Component1 extends Component {
    public Component1() {
    }

    public void doA() {
        System.out.println("Component1 do A");
        this.mediator.notify(this, "A");
    }

    public void doB() {
        System.out.println("Component1 do B");
        this.mediator.notify(this, "B");
    }
}

class Component2 extends Component {
    public Component2() {
    }

    public void doC() {
        System.out.println("Component2 do C");
        this.mediator.notify(this, "C");
    }

    public void doD() {
        System.out.println("Component1 do D");
        this.mediator.notify(this, "D");
    }
}

class ConcreteMediator implements Mediator {
    public Component1 component1;
    public Component2 component2;

    public ConcreteMediator(Component component1, Component component2) {
        this.component1 = (Component1) component1;
        this.component2 = (Component2) component2;
        this.component1.setMediator(this);
        this.component2.setMediator(this);
    }

    public void notify(Component component, String event) {
        if (event == "A") {
            System.out.println("Mediator react on A and triggers following:");
            this.component2.doC();
        } else if (event == "D") {
            System.out.println("Mediator reacts on D and triggers following operations:");
            this.component1.doB();
            this.component2.doC();
        }
    }
}

public class Mediator_Pattern {
    public static void main(String[] args) {
        Component c1 = new Component1();
        Component c2 = new Component2();

        ConcreteMediator concreteMediator = new ConcreteMediator(c1, c2);
        concreteMediator.component1.doA();
        concreteMediator.component2.doD();
    }
}