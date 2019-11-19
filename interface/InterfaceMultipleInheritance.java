/**
 * 对于接口的多继承，如果非default方法的签名相同，接口的实现类中只需要重写该方法即可，如下面的box方法
 * 如果是default方法签名相同，则实现类中必须显式的重写该default方法，同时可以使用{接口}.super.{方法名}的方式调用
 * 特定接口的default方法,如下面的table方法。
 */
public class InterfaceMultipleInheritance{
    public static void main(String[] args) {
        BoxImpl boxImpl=new BoxImpl();
        boxImpl.box();
        boxImpl.table();
    }
}

interface Box1{
    void box();
    default void table(){
        System.out.println("Box1 Interface table()");        
    }
}

interface Box2{
    void box();
    default void table(){
        System.out.println("Box2 Interface table()");                
    }
}

class BoxImpl implements Box1,Box2{

    @Override
    public void box() {
        System.out.println("BoxImpl box()");
    }

    /** 
     * 由于Box1和Box2中的table方法冲突，则需要显式的重写该方法
     * 正如default方法存在的意义，如果不冲突，则不需要显式的覆盖。。。
    */
    @Override
    public void table(){
        System.out.print("BoxImpl table()");
        Box1.super.table();
        Box2.super.table();
    }

}