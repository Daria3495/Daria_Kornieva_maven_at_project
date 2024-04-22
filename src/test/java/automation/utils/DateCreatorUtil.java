package automation.utils;

import java.time.LocalDate;
import java.time.ZoneId;

public class DateCreatorUtil {

    public static String calculateStartDate(int newStartDay) {
        String startTravelDate = String.valueOf(LocalDate.now(ZoneId.systemDefault()).plusDays(newStartDay));
        return startTravelDate;
    }

    public static String calculateEndDate(int newEndDay) {
        String endTravelDate = String.valueOf(LocalDate.now(ZoneId.systemDefault()).plusDays(newEndDay));
        return endTravelDate;
    }


}
