import java.util.Random;

/**
 * Test
 */
public class Test {
    private static final Random RAND = new Random();

    public static void main(String[] args) {
//        HashMap<String, String> hashMap = new HashMap<>();
//        hashMap.put("HELO", "sdfdf");
//        for (Map.Entry<String, String> entity : hashMap.entrySet())
//            System.out.println(entity);
//        System.out.println(createRandomNum(10));
//        System.out.println(Math.random());

        StringBuilder result = new StringBuilder();
        result.append("adfasdf-sdfad-sdf-");
        System.out.println(result.deleteCharAt(result.length() - 1).toString());
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