import java.time.LocalDateTime;

/**
 * @author 熊乾坤
 * @since 2020-04-19 21:25
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {
        //查询时间范围为前5分钟
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startTime1 = now.minusMinutes(5).withSecond(0).withNano(0);
        LocalDateTime endTime1 = now.withSecond(0).withNano(0);

        //查询时间范围为前10分钟
        LocalDateTime startTime2 = startTime1.minusMinutes(5);
        LocalDateTime endTime2 = startTime1;

        //查询时间为前15分钟
        LocalDateTime startTime3 = startTime2.minusMinutes(5);
        LocalDateTime endTime3 = startTime2;


        System.out.println("now:" + now);
        System.out.println("startTime1:" + startTime1);
        System.out.println("endTime1:" + endTime1);
        System.out.println("startTime2:" + startTime2);
        System.out.println("endTime2:" + endTime2);
        System.out.println("startTime3:" + startTime3);
        System.out.println("endTime3:" + endTime3);
    }
}
