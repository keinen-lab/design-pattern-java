package com.keinen.commandPattern;

// the command interface
interface Command {
    void execute();
}

// Receiver class
class Light {
    public Light() { }
    public void turnOn() {
        System.out.println("The light is on");
    }
    public void turnOff() {
        System.out.println("The light is off");
    }
}

// the command for turning on the light
class TurnOnLightCommand implements Command {
    private Light theLight;
    public TurnOnLightCommand(Light light) {
        this.theLight = light;
    }

    public void execute() {
        theLight.turnOn();
    }
}

// the command for turning off the light
class TurnOffLightCommand implements Command {
    private Light theLight;
    public TurnOffLightCommand(Light light) {
        this.theLight = light;
    }

    public void execute() {
        theLight.turnOff();
    }
}

//the invoke class
class Switch {
    private Command flipUpCommand;
    private Command flipDownCommand;

    public Switch(Command flipUpCommand, Command flipDownCommand) {
        this.flipUpCommand = flipUpCommand;
        this.flipDownCommand = flipDownCommand;
    }

    public void flipUp() {
        flipUpCommand.execute();
    }

    public void flipDown() {
        flipDownCommand.execute();
    }
}


public class commandPattern {
    public static void main(String[] args) {
        Light light = new Light();
        Command switchUp = new TurnOnLightCommand(light);
        Command switchDown = new TurnOffLightCommand(light);

        Switch s = new Switch(switchUp, switchDown);

        s.flipUp();
        s.flipDown();
    }
}
