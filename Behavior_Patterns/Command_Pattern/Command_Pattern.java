package Command_Pattern;

interface Command {
    void execute();
}

class NoCommand implements Command {
    public void execute() {
        System.out.println("I'm not work!!");
    }
}

class Light {
    String description;

    public Light(String description) {
        this.description = description;
    }

    public void on() {
        System.out.println(this.description + " LightOn");
    }

    public void off() {
        System.out.println(this.description + " LightOff");
    }
}

class CellingFan {
    String description;

    public CellingFan(String description) {
        this.description = description;
    }

    public void on() {
        System.out.println(this.description + " CellingFanOn");
    }

    public void off() {
        System.out.println(this.description + " CellingFanOff");
    }
}

class Stereo {
    public Stereo() {

    }

    public void on() {
        System.out.println("Stereo on!!!");
    }

    public void off() {
        System.out.println("Stereo off!!");
    }

    public void settingVolume(int volume) {
        System.out.println("Stereo has volume: " + volume);
    }
}

class StereoOnCommand implements Command {
    Stereo stereo;

    public StereoOnCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    public void execute() {
        stereo.on();
        stereo.settingVolume(11);
    }
}

class StereoOffCommand implements Command {
    Stereo stereo;

    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    public void execute() {
        stereo.off();
        stereo.settingVolume(0);
    }
}

class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        this.light.on();
    }
}

class LightOffCommand implements Command {
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        this.light.off();
    }
}

class CellingFanOnCommand implements Command {
    CellingFan cellingFan;

    public CellingFanOnCommand(CellingFan cellingFan) {
        this.cellingFan = cellingFan;
    }

    public void execute() {
        this.cellingFan.on();
    }
}

class CellingFanOffCommand implements Command {
    CellingFan cellingFan;

    public CellingFanOffCommand(CellingFan cellingFan) {
        this.cellingFan = cellingFan;
    }

    public void execute() {
        this.cellingFan.off();
    }
}

class RemoteControl {
    Command[] onCommands;
    Command[] offCommands;

    public RemoteControl(int size) {
        onCommands = new Command[size];
        offCommands = new Command[size];

        Command noCommand = new NoCommand();
        for (int i = 0; i < size; ++i) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        this.onCommands[slot] = onCommand;
        this.offCommands[slot] = offCommand;
    }

    public void onButtonPush(int slot) {
        this.onCommands[slot].execute();
    }

    public void offButtonPush(int slot) {
        this.offCommands[slot].execute();
    }

    // public String toString() {
    // StringBuilder sb = new StringBuilder();
    // sb.append("\n-------- Remote Control ---------\n");
    // for (int i = 0; i < onCommands.length; ++i) {

    // }
    // return sb.toString();
    // }
}

public class Command_Pattern {
    public static void main(String[] args) {
        Light LivingRoomLight = new Light("LivingRoom");
        Light KitchenLight = new Light("Kitchen");
        CellingFan cellingFanBedroom = new CellingFan("Bedroom");
        CellingFan cellingFanBathRoom = new CellingFan("Bathroom");
        Stereo stereo = new Stereo();

        LightOnCommand livingRoomLightOnCommand = new LightOnCommand(LivingRoomLight);
        LightOffCommand livingRoomLightOffCommand = new LightOffCommand(LivingRoomLight);

        LightOnCommand kitchenLightOnCommand = new LightOnCommand(KitchenLight);
        LightOffCommand kitchenLightOffCommand = new LightOffCommand(KitchenLight);

        CellingFanOnCommand BathroomCellingFanOnCommand = new CellingFanOnCommand(cellingFanBathRoom);
        CellingFanOffCommand BathroomCellingFanOffCommand = new CellingFanOffCommand(cellingFanBathRoom);

        CellingFanOnCommand BedroomCellingFanOnCommand = new CellingFanOnCommand(cellingFanBedroom);
        CellingFanOffCommand BedroomCellingFanOffCommand = new CellingFanOffCommand(cellingFanBedroom);

        StereoOnCommand stereoOnCommand = new StereoOnCommand(stereo);
        StereoOffCommand stereoOffCommand = new StereoOffCommand(stereo);

        RemoteControl remoteControl = new RemoteControl(7);
        remoteControl.setCommand(0, livingRoomLightOnCommand,
                livingRoomLightOffCommand);

        remoteControl.setCommand(1, kitchenLightOnCommand, kitchenLightOffCommand);

        remoteControl.setCommand(2, BedroomCellingFanOnCommand,
                BedroomCellingFanOffCommand);

        remoteControl.setCommand(3, BathroomCellingFanOnCommand,
                BathroomCellingFanOffCommand);

        remoteControl.setCommand(4, stereoOnCommand, stereoOffCommand);

        remoteControl.onButtonPush(0);
        remoteControl.onButtonPush(1);
        remoteControl.onButtonPush(2);
        remoteControl.onButtonPush(3);
        remoteControl.onButtonPush(4);

        System.out.println("==============================");

        remoteControl.offButtonPush(0);
        remoteControl.offButtonPush(1);
        remoteControl.offButtonPush(2);
        remoteControl.offButtonPush(3);
        remoteControl.offButtonPush(4);
    }
}
