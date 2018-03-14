package cn.bdqn.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 
 * @ClassName WeekUtil
 * @Description 日期转换工具类
 * @author yw
 * @Date 2018年2月3日 下午10:01:21
 * @version 1.0.0
 */
public class WeekUtil {
    // 禁止实例化
    private WeekUtil() {
    }

    private static SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");

    private static Calendar cal = new GregorianCalendar();

    /**
     * 
     * @Description (获取当前周的周一是多少号)
     * @return
     */
    public static String getMonday() {
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 设置星期一为一星期的第一天
        cal.setTime(new Date());
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
        Date first = cal.getTime();
        String format = formater.format(first);
        return format;
    }

    /**
     * 
     * @Description (获取当前周的周日是多少号)
     * @return
     */
    public static String getSunday() {
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获取这个星期的最后一天
        cal.setTime(new Date());
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek() + 6);
        Date last = cal.getTime();
        String format = formater.format(last);
        return format;
    }

    /**
     * 
     * @Description (根据日期获取周中天)
     * @param date
     * @return
     */
    public static String getWeek() {
        // 获取默认选中的日期的年月日星期的值，并赋值
        Calendar cl = Calendar.getInstance();// 日历对象
        cl.setTime(new Date());// 设置当前日期
        int week = cl.get(Calendar.WEEK_OF_YEAR);
        week += 1;
        cl.add(Calendar.DAY_OF_MONTH, -7);
        int year = cl.get(Calendar.YEAR);
        if (week < cl.get(Calendar.WEEK_OF_YEAR)) {
            year += 1;
        }
        return year + "年第" + week + "周";
    }

    public static int getWeekDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    public static String getNextday(Integer day) {
        String[] weekday = new String[7];
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 设置星期一为下一星期的第一天
        for (int i = 0; i < 7; i++) {
            cal.setTime(new Date());
            cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek() + 7 + i);
            Date first = cal.getTime();
            weekday[i] = formater.format(first);
        }

        return weekday[day];
    }

    /**
     * 获取指定日期所在星期的全部日期。<br>
     *
     * @author junwen.bao
     * @param date
     * @return
     */
    public static Date[] getAllDateOfWeek(Date date) {
        cal.setTime(date);
        Date[] result = new Date[7];
        
        for (int i = 0; i < 6; i++) {
            cal.set(Calendar.DAY_OF_WEEK, i+2);
            result[i] = cal.getTime();
        }
        result[6] = addDate(result[5], 1);
        return result;
    }

    /**
     * 获取指定日期后几天的日期 <br/>
     *
     * @author junwen.bao
     * @param date
     * @param amount
     * @return
     */
    public static Date addDate(Date date, int amount) {
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, amount);
        return cal.getTime();
    }

}
