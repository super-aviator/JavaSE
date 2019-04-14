// package Exception;

/**
 * RethrowException
 */
public class RethrowException {
    public void f() throws OneException{
        System.out.print("throw a OneException form f");
        throw new OneException();
    }

    /**
     * 重抛异常会丢失前面异常的异常信息。
     * 抛出已捕获的旧异常之前，调用fillStackTrace()，会将栈帧重新填充为当前方法开始调用
     * @throws OneException
     */
    public void g()throws Exception{
       try{
           f();
       }catch(OneException e){
        System.out.print("throw a TowException form g");
        throw new Exception(e);
        
        // throw new TwoException();

        // throw (Exception)e.fillInStackTrace();

        // throw e;
       }
    }
        
    public static void main(String[] args) {
        RethrowException re=new RethrowException();
        try{
            re.g();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

class OneException extends Exception{
    private static final long serialVersionUID = -5064781474279236620L;

    public OneException() {
        super();
    }
    public OneException(String msg){super(msg);}
}

class TwoException extends Exception{
    private static final long serialVersionUID = 7433642976827457571L;

    public TwoException() {
        super();
    }
    public TwoException(String msg){super(msg);}
}