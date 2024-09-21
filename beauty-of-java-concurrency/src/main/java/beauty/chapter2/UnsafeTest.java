package beauty.chapter2;

import sun.misc.Unsafe;

/**
 * @author 熊乾坤
 * @since 2020-11-19 8:55
 */
public class UnsafeTest {
    public static void main(String[] args) {
        var unsafeTest = new UnsafeTest();
        unsafeTest.parkTest();
    }

    public void parkTest() {
        System.out.println("Unsafe park start");
        synchronized (this) {
            Unsafe.getUnsafe().park(false, 1000);
        }
        System.out.println("Unsafe park end");
    }
}
