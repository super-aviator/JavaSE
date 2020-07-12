import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @author 熊乾坤
 * @since 2019-11-26 10:25
 */
@Data
public class DispositionNotificationVO extends NotificationVehVO {
    private String id;
    private String plateNo;
    private Byte validDispositionLevel;
    private Boolean ignoreOptFlag;
    @JSONField(format = "yyyy-MM-dd HH:mm:dd")
    private Date triggerTime;

    public static void main(String[] args) {
        DispositionNotificationVO vo = new DispositionNotificationVO();
        vo.setId("hahah");
        vo.setPlateColor(12);
        vo.setProcessingStatus("ysdfas");
        vo.setDeviceId("sfasfsf0");
        vo.setTriggerTime(new Date());
        System.out.println(JSON.toJSONString(vo));
    }
}


