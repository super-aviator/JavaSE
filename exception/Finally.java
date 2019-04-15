/**
 * Finally
 */
public class Finally {

    public static void main(String[] args) {
        try{
            System.out.println("准备测试finally块");
            System.exit(1);
        }finally{
            System.out.println("finally块会执行吗");
        }
    }
}