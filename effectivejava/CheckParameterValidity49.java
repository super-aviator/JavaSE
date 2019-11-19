import java.util.ArrayList;
import java.util.Objects;
import java.util.Arrays;

/**
 * CheckParameterValidity 检查参数的有效性
 * 
 * 检查方法中未使用但存储以供以后使用的参数的有效性尤为重要。
 * 私有方法可以使用assert来检查参数有效性（需要在java命令后面加上-ea参数）
 */
public class CheckParameterValidity49 {
    // 存储起来，可能在对象创建很久以后才会调用consume方法
    private ArrayList<String> strList;

    public CheckParameterValidity49(ArrayList<String> arrList) {
        this.strList=arrList;
        // this.strList = Objects.requireNonNull(arrList, "ArrList不能为空");
    }

    public void consume() {
        privateConsume();
        strList.forEach(t -> {
            System.out.println("consume " + t);
        });
    }

    /** 
     * 私有方法中的assert
    */
    private void privateConsume() {
        assert this.strList!=null; //满足条件代码才会通过，否则抛出AssertionError异常
        strList.forEach(t -> {
            System.out.println("privateConsume " + t);
        });
    }

    public static void main(String[] args) {
        CheckParameterValidity49 checkParameterValidity = new CheckParameterValidity49(
                new ArrayList<>(Arrays.asList("xkq", "is", "big", "sb")));
        CheckParameterValidity49 checkParameterValidityWithNull = new CheckParameterValidity49(null); // 如果检查参数有效性，在创建对象时就会快速失败
        checkParameterValidity.consume();
        checkParameterValidityWithNull.consume();// 如果不检查参数有效性，在使用到参数时才会抛出异常
    }
}