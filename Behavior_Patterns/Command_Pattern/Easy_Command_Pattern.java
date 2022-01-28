package Command_Pattern;

interface Command {
    void execute();
}

class Light_1 {
    public Light_1() {

    }

    public void on() {
        System.out.println("Light is On!!!");
    }

    public void off() {
        System.out.println("Light is Off!!!");
    }
}

class LightOnCommand_1 implements Command {
    Light_1 light;

    public LightOnCommand_1(Light_1 light) {
        this.light = light;
    }

    public void execute() {
        this.light.on();
    }
}

class SimpleRemoteControl {
    Command slot;

    public SimpleRemoteControl() {

    }

    public void setCommand(Command cmd) {
        this.slot = cmd;
    }

    public void buttonWasPressed() {
        this.slot.execute();
    }
}

class GarageDoor {
    public GarageDoor() {

    }

    public void up() {
        System.out.println("GarageUp!!!");
    }

    public void down() {
        System.out.println("GarageDown!!!");
    }

    public void stop() {
        System.out.println("GarageStop!!!");
    }

    public void lightOn() {
        System.out.println("LightOn!!!");
    }

    public void lightOff() {
        System.out.println("LightOff!!!");
    }
}

class GarageDoorOpenCommand implements Command {
    GarageDoor garageDoor;

    public GarageDoorOpenCommand(GarageDoor Garage) {
        this.garageDoor = Garage;
    }

    public void execute() {
        this.garageDoor.up();
    }
}

public class Easy_Command_Pattern {
    public static void main(String[] args) {
        SimpleRemoteControl remoteControl = new SimpleRemoteControl();

        Light_1 light = new Light_1();
        LightOnCommand_1 lightCmd = new LightOnCommand_1(light);

        GarageDoor garageDoor = new GarageDoor();
        GarageDoorOpenCommand garageDoorCMD = new GarageDoorOpenCommand(garageDoor);

        remoteControl.setCommand(lightCmd);
        remoteControl.buttonWasPressed();

        remoteControl.setCommand(garageDoorCMD);
        remoteControl.buttonWasPressed();
    }
}
