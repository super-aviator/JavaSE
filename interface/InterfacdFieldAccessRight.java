/**
 * 接口中的域默认是public static final修饰的(只能是pubic static final修饰)
 * 接口中的方法默认是public修饰的（只能是public，friendly，private，protected都不被允许）
 *
 * @author Aviator
 */
public interface InterfacdFieldAccessRight {
    public static final int DEFAULT_FIELD=10;

    public void f();

}
