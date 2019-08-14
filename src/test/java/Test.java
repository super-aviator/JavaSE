import java.util.HashMap;
import java.util.Map;

/**
 * Test
 */
public class Test {

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("HELO", "sdfdf");
        for (Map.Entry<String, String> entity : hashMap.entrySet())
            System.out.println(entity);
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