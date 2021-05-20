package com.xqk.learn.javase.designpattern.command;

/**
 * @author 熊乾坤
 * @since 2021-05-20 18:50
 */
public abstract class Command {
    protected final Receiver receiver;

    public Command(Receiver receiver) {
        this.receiver = receiver;
    }

    public abstract void execute();
}
