package utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liuzhicheng      2017年8月2日       TODO
 * </pre>
 */
public class TimeUtil {

    public static String getFormattedDate(Date date) {
        if (date == null) {
            return null;
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(date);
        }
    }

    public static String getFormattedTime(Date date) {
        if (date == null) {
            return "";
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.format(date);
        }
    }

    /**
     * 格式：yyyyMMddHHmmss
     *
     * @param date
     * @return
     */
    public static String getFormattedTime2(Date date) {
        if (date == null) {
            return "";
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            return sdf.format(date);
        }
    }

    public static String getFormattedDate(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * <p>
     * 返回系统时间组成的字符串。例如：20050828143158
     * <p>
     *
     * @return String
     */
    public static String getTimeStamp() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(date);
    }

    /**
     * 返回系统时间组成的字符串。例如：143158 HHmmss
     */
    public static String getTimeStamp2() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
        return sdf.format(date);
    }

    /**
     * <p>
     * 返回系统时间组成的字符串。例如：20050828
     * <p>
     *
     * @return String
     */
    public static String getDateStamp() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(date);
    }

    /**
     * <p>
     * 返回多少天前系统时间组成的字符串。例如：20050828
     * <p>
     *
     * @return String
     */
    public static String getDateStamp(int time) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 0 - time);
        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(date);
    }

    /**
     * <p>
     * 返回系统时间组成的字符串。例如：2005-08-28
     * <p>
     *
     * @return String
     */
    public static String getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    /**
     * <p>
     * 返回系统时间组成的字符串。例如：2005-08-28 14:20:36
     * <p>
     *
     * @return String
     */
    public static String getCurrentTime() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    /**
     * 返回某年某月的天数
     *
     * @param year  int
     * @param month int
     * @return int
     */
    public static int getDays(int year, int month) {
        int days = 30;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    days = 29;
                } else {
                    days = 28;
                }
                break;
        }
        return days;
    }

    /**
     * Returns true if the specified date string represents a valid date in the
     * specified format.
     *
     * @param dateString        a String representing a date/time.
     * @param dateFormatPattern a String specifying the format to be used when parsing the
     *                          dateString. The pattern is expressed with the pattern letters
     *                          defined for the java.text.SimpleDateFormat class.
     * @return boolean - return true if valid, false otherwise.
     */
    public static boolean isValidDate(String dateString, String dateFormatPattern) {

        // 长度校验追加 窦彬 2015/3/17 begin
        if (StringUtil.isEmpty(dateString) || StringUtil.isEmpty(dateFormatPattern)) {
            return false;
        }

        if (dateString.length() != dateFormatPattern.length()) {
            return false;
        }
        // 长度校验追加 窦彬 2015/3/17 end

        Date validDate = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(dateFormatPattern);
            sdf.setLenient(false);
            validDate = sdf.parse(dateString);
        } catch (ParseException e) {
            // Ignore and return null
        }
        return validDate != null;
    }

    public static Date string2Date(String date, String format) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            throw e;
        }

    }

    public static String date2String(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * @return 当前时间
     */
    public static Date getNowTime() {
        return Calendar.getInstance().getTime();
    }

    /**
     * @return 当前时间
     */
    public static long getNowTimeInMillis() {
        return Calendar.getInstance().getTimeInMillis();
    }

    /**
     * <p>
     * 返回系统时间组成的字符串。例如：20050828143158333
     * <p>
     *
     * @return String
     */
    public static String getTimeMillisecondStamp() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(date);
    }

    public static String transformTime(String date, String sourceFormat, String destFormat) throws Exception {
        SimpleDateFormat sdfSource = new SimpleDateFormat(sourceFormat);
        Date dateSource = sdfSource.parse(date);
        SimpleDateFormat sdfDest = new SimpleDateFormat(destFormat);
        return sdfDest.format(dateSource);
    }

    public static Timestamp stringToTimestamp(String datetime) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Timestamp ts = new Timestamp(formatter.parse(datetime).getTime());
        return ts;
    }

    public static String addDays(int days) {
        String fromTime = "";
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DAY_OF_MONTH, days);

        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        fromTime = sdf.format(date);
        return fromTime;
    }

    public static Date addDays(java.util.Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }

    public static String addDays(String dateStr, int days) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        sdf.setLenient(false);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sdf.parse(dateStr));
        calendar.add(Calendar.DATE, days);
        return sdf.format(calendar.getTime());
    }

}
