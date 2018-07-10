package com.keinen.facadePattern;

import java.text.ParseException;

// Complex parts
class CPU {
    public void freeze() {System.out.println("CPU:freeze");}
    public void jump() {System.out.println("CPU:jump");}
    public void execute() {System.out.println("CPU:execute");}
}

class Memory {
    public void load() {System.out.println("Memory:load");}
}

class HardDrive {
    public void read() {System.out.println("HardDrive:read");}
}

// facade
class Computer {
    public void startComputer() {
        CPU cpu = new CPU();
        Memory memory = new Memory();
        HardDrive hardDrive = new HardDrive();
        cpu.freeze();
        memory.load();
        hardDrive.read();
        cpu.jump();
        cpu.execute();
    }
}

public class facadePattern {
    public static void main(String[] args) throws ParseException {
        Computer facade = new Computer();
        facade.startComputer();
    }
}
