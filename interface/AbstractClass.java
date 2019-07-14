/**
 * 在抽象类中，private abstract与抽象类的定义相冲突，所以不能生命该类型的方法。
 * @author Aviator
 */
public abstract class AbstractClass {
    private void a(){}

    protected void b(){}

    public void c(){}

    void d(){}

    protected abstract void e();

    public abstract void f();

    abstract void g();

//    private + abstract是唯一不被允许的组合
//    private abstract void f();

}
