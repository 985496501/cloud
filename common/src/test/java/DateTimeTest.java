import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author jinyun liu
 * @date 2020/5/9
 */
public class DateTimeTest {

    @Test
    public void test1() {
        LocalDateTime now = LocalDateTime.now();
        // LocalDateTime toString() return date.toString() + 'T' + time.toString();
        // private final LocalDate, private final LocalTime.
        System.out.println(now);

        String basicIsoDate = now.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("basic ios date: " + basicIsoDate);

        String isoDate = now.format(DateTimeFormatter.ISO_DATE);
        System.out.println("iso date: " + isoDate);

        String iosDateTime = now.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println("iso date time: " + iosDateTime);

        String regular = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        System.out.println(regular);
    }
}
