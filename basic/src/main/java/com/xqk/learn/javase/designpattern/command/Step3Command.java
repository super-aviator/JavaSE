package com.xqk.learn.javase.designpattern.command;

/**
 * @author 熊乾坤
 * @since 2021-05-20 18:51
 */
public class Step3Command extends Command {

    public Step3Command(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.step3();
    }
}
