import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import org.junit.Test;

import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * Test1
 */
public class Test1 {
    private static final Random RAND = new Random();


    public static void main(String[] args) {
//        HashMap<String, String> hashMap = new HashMap<>();
//        hashMap.put("HELO", "sdfdf");
//        for (Map.Entry<String, String> entity : hashMap.entrySet())
//            System.out.println(entity);
//        System.out.println(createRandomNum(10));
//        System.out.println(Math.random());

//        StringBuilder result = new StringBuilder();
//        result.append("adfasdf-sdfad-sdf-");
//        System.out.println(result.deleteCharAt(result.length() - 1).toString());

        //String x = null;
        //switch (x) {
        //    case "1":
        //        System.out.println("1");
        //        break;
        //    default:
        //        break;
        //}

        for (Map.Entry entry : System.getenv().entrySet()) {
            System.out.println(entry);
        }
    }

    public static String createRandomNum(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("生成随机数的长度必须大于零");
        }

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(RAND.nextInt(10));
        }
        return sb.toString();
    }

    /**
     * 正则表达式中，\\s匹配一个非字符的字符（有点绕口）
     */
    @Test
    public void test() {
        Pattern pattern = Pattern.compile("\\s*");
        System.out.println(pattern.matcher("\r\n").matches());
        System.out.println(pattern.matcher("\r\r").matches());
        System.out.println(pattern.matcher("\n").matches());
        System.out.println(pattern.matcher("a").matches());
        System.out.println(pattern.matcher("\n\n").matches());
    }

    /**
     * 当JSONPath读取不到该路径对应的值时，返回null。
     */
    @Test
    public void testJsonPath() {
        JSONObject obj1 = new JSONObject();
        JSONObject obj2 = new JSONObject();
        obj1.put("name", "xqk");
        obj2.put("age", 20);
        obj1.put("detail", obj2);

        Integer age = (Integer) JSONPath.read(obj1.toJSONString(), "$.detail.age.name");
        System.out.println(age);
        System.out.println((Integer) null);
    }

}


/* enum ReasonEnum{
    NOT_PROCESS("交通违法未处理",),COMMIT_TRAFFIC_OFFENCE("交通肇事",),CRIMINAL_SUSPECT("违法犯罪嫌疑",),
    REPEAT_PLATE_NUM("套牌",),NOT_ANNUAL_INSPECTION("未年检",),ABANDONED_VEHICLE("报废车",)
    FALSE_PLATE_NUM("假牌",),NONE_PLATE_NUM("无牌照",);

    private String reason;
    private int code;

    ReasonEnum(String reason,int code){
        this.reason=reasom;
        this.code=code;
    }

    public String getReason(int code){
        for(ReasonEnum temp:ReasonEnum.values()){
            if(temp.code==code){
                return temp.reason;
            }
        }
        return null;
    }

    public String getReason(){
        return this.reason;
    }

    public int getCode(){
        return this.code;
    }
} */