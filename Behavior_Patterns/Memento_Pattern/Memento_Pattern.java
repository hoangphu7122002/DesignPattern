package Memento_Pattern;

import java.util.Stack;

interface Memento {
    String getName();

    String state();
}

class ConcreteMemento implements Memento {
    private String state;
    public static int number = 1;

    public ConcreteMemento(String state) {
        this.state = state;
        number++;
    }

    public String getName() {
        return this.state + "---" + String.valueOf(number);
    }

    public String state() {
        return this.state;
    }
}

class Originator {
    private String state;
    private Memento memento;

    public Originator() {
    }

    public String getState() {
        return this.state;
    }

    public Memento save() {
        return new ConcreteMemento(this.state);
    }

    public void Restore(Memento memento) {
        this.state = memento.state();
    }

    public void doSomething(String message) {
        this.state = message;
    }
}

class Caretaker {
    private Stack<Memento> stk = new Stack<Memento>();
    private Originator originator;

    public Caretaker(Originator originator) {
        this.originator = originator;
    }

    public void backUp() {
        System.out.println("=======Save=======");
        stk.push(this.originator.save());
        System.out.println("=======Done=======");
    }

    public void Undo() {
        if (this.stk.size() == 0) {
            return;
        }
        Memento memento = this.stk.pop();
        System.out.println("=======Restore" + memento.getName() + "=======");
        this.originator.Restore(memento);
        System.out.println("=======Done=======");
    }

    public void History() {
        System.out.println("=============History===========");
        for (Memento memento : stk) {
            System.out.println(memento.getName());
        }
    }
}

public class Memento_Pattern {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker(originator);

        originator.doSomething("Analysis");
        caretaker.backUp();

        originator.doSomething("Big Data");
        caretaker.backUp();

        originator.doSomething("ML");
        caretaker.backUp();

        caretaker.History();

        originator.doSomething("DL");
        caretaker.Undo();
        System.out.println(originator.getState());
    }

}
