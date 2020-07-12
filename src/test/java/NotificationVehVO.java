import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * package: com.kedacom.kstp.disposition.vo
 * date : 2018/8/27
 *
 * @author Administrator
 */
@Data
public class NotificationVehVO {
    private String id;
    private String dispositionId;
    private Integer priorityLevel;
    private String title;
    private String reason;
    private String reasonName;
    private String plateNo;
    private Integer plateColor;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date passTime;
    private String tollgateId;
    private String deviceId;
    private String tollgateCat;
    private String tollgateName;
    private String processingStatus;
    private String policeStatus;
    private String infoType;
    private Double longitude;
    private Double latitude;
    private String jobId;
    private String roadType;
}
