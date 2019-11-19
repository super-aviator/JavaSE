/**
 * 增加默认方法的极具说服力的理由是它允许在不破坏已使用接口的代码的情况下，在接口中增加新的方法。
 * 默认方法有时也被称为守卫方法或虚拟扩展方法。
 *
 * @author Aviator
 */
public class InterfaceDefaultMethod implements HasDefaultMethodInterface {

    @Override
    public void f() {
        System.out.println(getStr());
    }

    @Override
    public void g() {
        System.out.println(getStr());
    }

    /**
     * default方法也可以被重写
     */
    @Override
    public String getStr() {
        return "this string generic from override default method";
    }


    public static void main(String[] args) {
        InterfaceDefaultMethod cla=new InterfaceDefaultMethod();
        cla.f();
        cla.g();
        cla.getStr();
    }
}

interface HasDefaultMethodInterface {
    void f();

    void g();

    /**
     * 返回一个字符创
     * @return 字符串
     */
    default String getStr() {
        return "this string generic from default method";
    }
}