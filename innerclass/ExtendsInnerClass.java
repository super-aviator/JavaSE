/**
 * ExtendsInnserClass
 * 
 * 继承内部类的方法
 */
public class ExtendsInnerClass extends WithInner.Inner{
    public ExtendsInnerClass(WithInner wi){
        wi.super();
    }

    public static void main(String[] args) {
        WithInner wi=new WithInner();
        ExtendsInnerClass extendsInnerClass=new ExtendsInnerClass(wi);
        extendsInnerClass.f();
    }
}

class WithInnerClass{
    class InnerClass{
        public void f(){
            System.out.println("Inner class f()");
        }
    }
}