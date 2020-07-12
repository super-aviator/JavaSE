import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

/**
 * @author 熊乾坤
 * @date 2020-04-16 17:14
 */
public class DecimalFormatTest {
    @Test
    public void testDecimalFormat() {
        double dol = 2.12343;
        DecimalFormat df = new DecimalFormat();
        df.setMaximumIntegerDigits(0);
        df.setMaximumFractionDigits(2);
        System.out.println(df.format(dol));
    }
}
