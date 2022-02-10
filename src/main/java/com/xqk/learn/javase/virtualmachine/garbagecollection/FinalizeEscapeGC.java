package com.xqk.learn.javase.virtualmachine.garbagecollection;

/**
 * FinalizeEscapeGC
 *
 * @author xiongqiankun
 * @since 2021/12/28 13:55
 */
public class FinalizeEscapeGC {
    private static FinalizeEscapeGC SAVE_HOOK;

    public void isAlive() {
        System.out.println("yes,i am alive :)");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Throwable {
        SAVE_HOOK = new FinalizeEscapeGC();
        SAVE_HOOK = null;
        System.gc();
        // 因为Finalizer方法优先级很低，暂停0.5秒，以等待它
        Thread.sleep(5000);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead :(");
        }
        // 下面这段代码与上面的完全相同，但是这次自救却失败了
        SAVE_HOOK = null;
        System.gc();
        // 因为Finalizer方法优先级很低，暂停0.5秒，以等待它
        Thread.sleep(5000);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead :(");
        }
    }
}
