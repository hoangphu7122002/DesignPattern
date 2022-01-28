package Observer_Pattern;

import java.util.ArrayList;

interface Button {
    void registerListener(Listener l);

    void removeListener(Listener l);

    void notifyListener();
}

interface Listener {
    void display();
}

class FancyButton implements Button {
    private ArrayList<Listener> listener;

    public FancyButton() {
        this.listener = new ArrayList<Listener>();
    }

    public void registerListener(Listener l) {
        this.listener.add(l);
    }

    public void removeListener(Listener l) {
        int index = listener.indexOf(l);

        if (index >= 0) {
            listener.remove(index);
        }
    }

    public void notifyListener() {
        for (int i = 0; i < listener.size(); i++) {
            Listener l = (Listener) listener.get(i);
            l.display();
        }
    }

    public void pressButton() {
        this.notifyListener();
    }
}

class Devil implements Listener {
    private Button button;

    public Devil(Button b) {
        this.button = b;
        this.button.registerListener(this);
    }

    public void display() {
        System.out.println("Hi I'm Devil");
        System.out.println("Don't do it, you might regret it");
    }
}

class Angle implements Listener {
    private Button button;

    public Angle(Button b) {
        this.button = b;
        this.button.registerListener(this);
    }

    public void display() {
        System.out.println("Hi I'm Angle");
        System.out.println("Come on, do it!");
    }
}

public class SwingObserver {
    public static void main(String[] args) {
        FancyButton button = new FancyButton();

        Angle angle = new Angle(button);
        Devil devil = new Devil(button);

        button.pressButton();

        button.removeListener(angle);
        button.pressButton();
    }
}
