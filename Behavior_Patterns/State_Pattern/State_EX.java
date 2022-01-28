package State_Pattern;

interface State {
    void handle();
}

class StateA implements State {
    Context context;

    public StateA(Context context) {
        this.context = context;
    }

    public void handle() {
        System.out.println("A");
        context.setState(new StateB(context));
    }
}

class StateB implements State {
    Context context;

    public StateB(Context context) {
        this.context = context;
    }

    public void handle() {
        System.out.println("B");
        context.setState(new StateA(context));
    }
}

class Context {
    StateA A;
    StateB B;
    State currentState;

    public Context() {
        this.A = new StateA(this);
        this.B = new StateB(this);
        this.currentState = A;
    }

    void setState(State state) {
        this.currentState = state;
    }

    public void handle() {
        this.currentState.handle();
    }
}

public class State_EX {
    public static void main(String[] args) {
        Context context = new Context();
        for (int i = 0; i < 5; ++i) {
            context.handle();
            // System.out.println(context);
        }
    }
}
