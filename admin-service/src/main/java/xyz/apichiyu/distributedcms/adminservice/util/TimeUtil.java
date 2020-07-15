package xyz.apichiyu.distributedcms.adminservice.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator
 */
public class TimeUtil {
    public static String nowTime(String format) {
        return stampToTime(format, System.currentTimeMillis());
    }

    public static String stampToTime(String format, long timestamp) {
        Date date = new Date(timestamp);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static long timeToStamp(String format, String time) {
        SimpleDateFormat sdf = null;
        try {
            sdf = new SimpleDateFormat(format);
            Date date = sdf.parse(time);
            return date.getTime();
        } catch (Exception e) {
            return -1;
        }
    }
}
