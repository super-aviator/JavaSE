/**
 * Return
 * 
 * Lambda表达式中，如果函数体只有一行，则这一行默认为返回的结果，不能加return，否则会编译错误。
 */
public class Return {

    public static void perform(Strategy strategy){
        System.out.println(strategy.strategy());
    }
    public static void main(String[] args) {
        perform(()->"Hello");
        perform(()->"Hello World");
        // perform(()-> return "Hello World");
    }
}

interface Strategy{
    String strategy();
}

/* 
output:
Hello
Hello World 
*/