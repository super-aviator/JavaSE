interface Operations{
    void execute();

    static void runOps(Operations...operations){
        for(Operations opt:operations){
            opt.execute();
        }
    }

    /**
     * static方法可以作为工具方法，在接口的任何地方都可以使用到。
     * @param str 想要打印的字符串
     */
    static void show(String str){
        System.out.println(str);
    }
}
 
class People implements Operations{

    @Override
    public void execute() {
        //直接调用接口中的工具方法
        Operations.show("People");
    }

}

/**
 * InterfaceStaticMethod
 */
public class InterfaceStaticMethod {

    /**
     * 方法引用的常规使用方式；
     * 引用静态方法-->类名称::static 方法名称；
     * 引用某个对象的实例的普通方法-->示例化对象::普通方法；
     * 引用某个类型的任意对象的实例的普通方法-->特定类::普通方法；
     * 引用构造方法-->类名称::new
     * @param args
     */
    public static void main(String[] args) {
        Operations.runOps(
            new People(),
            new Operations(){
            
                @Override
                public void execute() {
                    Operations.show("Men");
                }
            },
            ()->Operations.show("Women")
            // Operations::show("hello")
        );
    }
}