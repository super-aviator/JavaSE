package com.xqk.learn.javase.designpattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 熊乾坤
 * @since 2021-05-20 18:59
 */
public class Invoker {
    private final List<Command> commandList;

    public Invoker() {
        this.commandList = new ArrayList<>();
    }

    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        Receiver receiver = new Receiver();
        invoker.addCommand(new Step1Command(receiver));
        invoker.addCommand(new Step2Command(receiver));
        invoker.addCommand(new Step3Command(receiver));
        invoker.executeCommand();
    }

    public void addCommand(Command command) {
        commandList.add(command);
    }

    public void clearCommand(Command command) {

    }

    public void executeCommand() {
        commandList.forEach(Command::execute);
    }
}
