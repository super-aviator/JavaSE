package com.xqk.learn.javase.designpattern.command;

/**
 * @author 熊乾坤
 * @since 2021-05-20 18:51
 */
public class Step1Command extends Command {

    public Step1Command(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.step1();
    }
}
