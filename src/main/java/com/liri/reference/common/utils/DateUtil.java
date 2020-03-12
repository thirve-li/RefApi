package com.liri.reference.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期工具类
 *
 * @author William
 * @date 2019/8/19
 */
public final class DateUtil {
    
    public static final String FORMAT_DATE = "yyyyMMdd";
    public static final String FORMAT_DATETIME = "yyyyMMddHHmmss";
    public static final String FORMAT_DATETIME_DASH_HHMMSS = "yyyy-MM-dd HH:mm:ss";
    
    public DateUtil() {
    }

    public static  final Logger logger = LoggerFactory.getLogger(DateUtil.class);

    /**
     * 年
     */
    public static final String FORMAT_YEAR = "yyyy";

    /**
     * 月
     */
    public static final String FORMAT_MONTH = "MM";

    /**
     * 日
     */
    public static final String FORMAT_DAY = "dd";

    /**
     * 时
     */
    public static final String FORMAT_HOUR = "HH";

    /**
     * 分
     */
    public static final String FORMAT_MINUTE = "mm";

    /**
     * 日期格式 yyyy-MM-dd HH:mm:ss
     */
    public static final String FORMAT_DATE_DEFAULT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期格式 yyyy-MM-dd
     */
    public static final String FORMAT_YYYY_MM_DD = "yyyy-MM-dd";


    /**
     * 日期格式 yyyyMMdd
     */
    public static final String FORMAT_YYYYMMDD = "yyyyMMdd";
    
    public static String getDate(String format){
        return getCurrentDate(format);
    }
    
    public static Date getDate(){
        return getCurrentDate();
    }

    /**
     * 获取当前日期
     *
     * @return 当前日期
     */
    public static Date getCurrentDate() {
        Date nowDate = new Date();
        return nowDate;
    }

    /**
     * 获取当前日期
     *
     * @param format 日期格式
     * @return 当前日期取得
     */
    public static String getCurrentDate(String format) {
        Date nowDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(nowDate);
    }

    /**
     * 日期转换成字符口串
     *
     * @param date   日期
     * @param format 格式
     * @return 日期文字列
     */
    public static String dateToString(Date date, String format) {
        if (date == null) {
            return null;
        }

        DateFormat df = new SimpleDateFormat(format);

        return df.format(date);
    }

    /**
     * 日期格式化
     *
     * @param dateStr     日期文字列
     * @param preFormat   格式化前
     * @param afterFormat 格式化后
     * @return String
     */
    public static String formatDate(String dateStr, String preFormat, String afterFormat) {

        if (StringUtil.isBlank(dateStr)) {
            return "";
        }

        String value;
        try {
            SimpleDateFormat psdf = new SimpleDateFormat(preFormat);
            SimpleDateFormat asdf = new SimpleDateFormat(afterFormat);
            Date date = psdf.parse(dateStr);
            value = asdf.format(date);
        } catch (Exception e) {
            logger.error(">>>>>> formatDate error:", e);
            return "";
        }
        return value;
    }

    /**
     * 日期的加减秒数
     *
     * @param date    日期
     * @param seconds 秒数，正数时加相应的秒数；负数时减去相应的秒数
     * @return 计算后日期
     */
    public static Date calculateDateBySecond(Date date, int seconds) {
        if (date == null) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.SECOND, c.get(Calendar.SECOND) + seconds);
        return c.getTime();
    }


    /**
     * 日期的加减分钟
     *
     * @param date    日期
     * @param minutes 分钟，正数时加相应的分钟；负数时减去相应的分钟
     * @return 计算后日期
     */
    public static Date calculateDateByMinute(Date date, int minutes) {
        if (date == null) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.MINUTE, c.get(Calendar.MINUTE) + minutes);
        return c.getTime();
    }

    /**
     * 日期的加减小时
     *
     * @param date  日期
     * @param hours 小时，正数时加相应的小时；负数时减去相应的小时
     * @return 计算后日期
     */
    public static Date calculateDateByHour(Date date, int hours) {
        if (date == null) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR, c.get(Calendar.HOUR) + hours);
        return c.getTime();
    }

    /**
     * 日期的加减天数
     *
     * @param date 日期
     * @param days 天数，正数时加相应的天数；负数时减去相应的天数
     * @return 计算后日期
     */
    public static Date calculateDateByDay(Date date, int days) {
        if (date == null) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + days);
        return c.getTime();
    }

    /**
     * 日期的加减月数
     *
     * @param date   日期
     * @param months 月数，正数时加相应的月数；负数时减去相应的月数
     * @return 计算后日期
     */
    public static Date calculateDateByMonth(Date date, int months) {
        if (date == null) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.MONTH, c.get(Calendar.MONTH) + months);
        return c.getTime();
    }

    /**
     * 日期的加减年数
     *
     * @param date  日期
     * @param years 年数，正数时加相应的年数；负数时减去相应的年数
     * @return 计算后日期
     */
    public static Date calculateDateByYear(Date date, int years) {
        if (date == null) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.YEAR, c.get(Calendar.YEAR) + years);
        return c.getTime();
    }

    /**
     * 日期比较
     *
     * <p>
     * {@code 1} sourceDate > targetDate
     * {@code 0} sourceDate = targetDate
     * {@code -1} sourceDate < targetDate
     *
     * @param sourceDate 源日期
     * @param targetDate 目标日期
     * @return int 小于：-1， 相等：0， 大于：1
     */
    public static int dateCompare(Date sourceDate, Date targetDate) {
        Calendar myCal = Calendar.getInstance();
        Calendar compareCal = Calendar.getInstance();
        myCal.setTime(sourceDate);
        compareCal.setTime(targetDate);
        return myCal.compareTo(compareCal);
    }

    /**
     * 获取两个时间中最小的一个日期
     *
     * @param sourceDate 源日期
     * @param targetDate 目标日期
     * @return Date
     */
    public static Date dateMin(Date sourceDate, Date targetDate) {
        if (sourceDate == null) {
            return targetDate;
        }

        if (targetDate == null) {
            return sourceDate;
        }

        if (1 == dateCompare(sourceDate, targetDate)) {
            return targetDate;
        } else if (-1 == dateCompare(sourceDate, targetDate)) {
            return sourceDate;
        }

        return sourceDate;
    }

    /**
     * 获取两个时间中最大的一个日期
     *
     * @param sourceDate 源日期
     * @param targetDate 目标日期
     * @return Date
     */
    public static Date dateMax(Date sourceDate, Date targetDate) {
        if (sourceDate == null) {
            return targetDate;
        }

        if (targetDate == null) {
            return sourceDate;
        }

        if (1 == dateCompare(sourceDate, targetDate)) {
            return sourceDate;
        } else if (-1 == dateCompare(sourceDate, targetDate)) {
            return targetDate;
        }

        return sourceDate;
    }

    /**
     * 获取当前时间所在周的开始日期
     *
     * @param date   日期
     * @param format 格式
     * @return 格式化后目标日期
     */
    public static String getFirstDayOfWeek(Date date, String format) {
        Calendar c = Calendar.getInstance();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
        return DateUtil.dateToString(c.getTime(), format);
    }

    /**
     * 获取当前时间所在周的结束日期
     *
     * @param date   日期
     * @param format 格式
     * @return 格式化后目标日期
     */
    public static String getLastDayOfWeek(Date date, String format) {
        Calendar c = Calendar.getInstance();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
        return DateUtil.dateToString(c.getTime(), format);
    }

    /**
     * 获取当前时间所在月的开始日期
     *
     * @param date   日期
     * @param format 格式
     * @return 格式化后目标日期
     */
    public static String getFirstDayOfMonth(Date date, String format) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);
        return DateUtil.dateToString(c.getTime(), format);
    }

    /**
     * 获取当前时间所在月的结束日期
     *
     * @param date   日期
     * @param format 格式
     * @return 格式化后目标日期
     */
    public static String getLastDayOfMonth(Date date, String format) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        return DateUtil.dateToString(c.getTime(), format);
    }

    /**
     * 获取当前时间所在季度的开始日期
     *
     * @param date   日期
     * @param format 格式
     * @return 格式化后目标日期
     */
    public static String getFirstDayOfQuarter(Date date, String format) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        int month = c.get(Calendar.MONTH) + 1;

        if (month > 0 && month < 4) {
            c.set(Calendar.MONTH, 0);
        } else if (month > 3 && month < 7) {
            c.set(Calendar.MONTH, 3);
        } else if (month > 6 && month < 10) {
            c.set(Calendar.MONTH, 6);
        } else if (month > 9 && month < 13) {
            c.set(Calendar.MONTH, 9);
        }

        c.getTime();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);

        return DateUtil.dateToString(c.getTime(), format);
    }

    /**
     * 获取当前时间所在季度的结束日期
     *
     * @param date   日期
     * @param format 格式
     * @return 格式化后目标日期
     */
    public static String getLastDayOfQuarter(Date date, String format) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        int month = c.get(Calendar.MONTH) + 1;

        if (month > 0 && month < 4) {
            c.set(Calendar.MONTH, 2);
        } else if (month > 3 && month < 7) {
            c.set(Calendar.MONTH, 5);
        } else if (month > 6 && month < 10) {
            c.set(Calendar.MONTH, 8);
        } else if (month > 9 && month < 13) {
            c.set(Calendar.MONTH, 11);
        }

        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        return DateUtil.dateToString(c.getTime(), format);
    }

    /**
     * 获取当前时间所在半年的开始日期
     *
     * @param date   日期
     * @param format 格式
     * @return 格式化后目标日期
     */
    public static String getFirstDayOfHalfYear(Date date, String format) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        int month = c.get(Calendar.MONTH) + 1;

        if (month > 0 && month < 7) {
            c.set(Calendar.MONTH, 0);
        } else if (month > 6 && month < 13) {
            c.set(Calendar.MONTH, 6);
        }

        c.getTime();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);

        return DateUtil.dateToString(c.getTime(), format);
    }

    /**
     * 获取当前时间所在半年的结束日期
     *
     * @param date   日期
     * @param format 格式
     * @return 格式化后目标日期
     */
    public static String getLastDayOfHalfYear(Date date, String format) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        int month = c.get(Calendar.MONTH) + 1;

        if (month > 0 && month < 7) {
            c.set(Calendar.MONTH, 5);
        } else if (month > 6 && month < 13) {
            c.set(Calendar.MONTH, 11);
        }

        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        return DateUtil.dateToString(c.getTime(), format);
    }

    /**
     * 获取当前时间所在年的开始日期
     *
     * @param date   日期
     * @param format 格式
     * @return 格式化后目标日期
     */
    public static String getFirstDayOfYear(Date date, String format) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.MONTH, 0);
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);
        return DateUtil.dateToString(c.getTime(), format);
    }

    /**
     * 获取当前时间所在年的结束日期
     *
     * @param date   日期
     * @param format 格式
     * @return 格式化后目标日期
     */
    public static String getLastDayOfYear(Date date, String format) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.MONTH, 11);

        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        return DateUtil.dateToString(c.getTime(), format);
    }
    
    // 获取当前时间所在周的开始日期
    public static String getFirstDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
        return DateUtil.dateToString(c.getTime(), DateUtil.FORMAT_DATE);
    }
    
    // 获取当前时间所在周的开始日期
    public static String getFirstDayOfWeek2(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DATE, c.get(Calendar.DATE) - 6); //
        return DateUtil.dateToString(c.getTime(), DateUtil.FORMAT_DATE);
    }
    
    // 获取当前时间所在周的结束日期
    public static String getLastDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
        return DateUtil.dateToString(c.getTime(), DateUtil.FORMAT_DATE);
    }
    
    // 获取当前时间所在月的开始日期
    public static String getFirstDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);
        return DateUtil.dateToString(c.getTime(), DateUtil.FORMAT_DATE);
    }
    
    public static String getFirstDayOfMonth2(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DATE, c.get(Calendar.DATE) - 29); //
        return DateUtil.dateToString(c.getTime(), DateUtil.FORMAT_DATE);
    }
    
    // 获取当前时间所在月的结束日期
    public static String getLastDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        return DateUtil.dateToString(c.getTime(), DateUtil.FORMAT_DATE);
    }
    
    // 获取当前时间所在季度的开始日期
    public static String getFirstDayOfQuarter(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        
        int month = c.get(Calendar.MONTH) + 1;
        
        if (month > 0 && month < 4) {
            c.set(Calendar.MONTH, 0);
        } else if (month > 3 && month < 7) {
            c.set(Calendar.MONTH, 3);
        } else if (month > 6 && month < 10) {
            c.set(Calendar.MONTH, 6);
        } else if (month > 9 && month < 13) {
            c.set(Calendar.MONTH, 9);
        }
        
        c.getTime();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);
        
        return DateUtil.dateToString(c.getTime(), DateUtil.FORMAT_DATE);
    }
    
    public static String getFirstDayOfQuarter2(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DATE, c.get(Calendar.DATE) - 89); //
        return DateUtil.dateToString(c.getTime(), DateUtil.FORMAT_DATE);
    }
    
    // 获取当前时间所在季度的结束日期
    public static String getLastDayOfQuarter(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        
        int month = c.get(Calendar.MONTH) + 1;
        
        if (month > 0 && month < 4) {
            c.set(Calendar.MONTH, 2);
        } else if (month > 3 && month < 7) {
            c.set(Calendar.MONTH, 5);
        } else if (month > 6 && month < 10) {
            c.set(Calendar.MONTH, 8);
        } else if (month > 9 && month < 13) {
            c.set(Calendar.MONTH, 11);
        }
        
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        return DateUtil.dateToString(c.getTime(), DateUtil.FORMAT_DATE);
    }
    
    // 获取当前时间所在半年的开始日期
    public static String getFirstDayOfHalfYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        
        int month = c.get(Calendar.MONTH) + 1;
        
        if (month > 0 && month < 7) {
            c.set(Calendar.MONTH, 0);
        } else if (month > 6 && month < 13) {
            c.set(Calendar.MONTH, 6);
        }
        
        c.getTime();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);
        
        return DateUtil.dateToString(c.getTime(), DateUtil.FORMAT_DATE);
    }
    
    public static String getFirstDayOfHalfYear2(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DATE, c.get(Calendar.DATE) - 179); //
        return DateUtil.dateToString(c.getTime(), DateUtil.FORMAT_DATE);
    }
    
    // 获取当前时间所在半年的结束日期
    public static String getLastDayOfHalfYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        
        int month = c.get(Calendar.MONTH) + 1;
        
        if (month > 0 && month < 7) {
            c.set(Calendar.MONTH, 5);
        } else if (month > 6 && month < 13) {
            c.set(Calendar.MONTH, 11);
        }
        
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        return DateUtil.dateToString(c.getTime(), DateUtil.FORMAT_DATE);
    }
    
    // 获取当前时间所在年的开始日期
    public static String getFirstDayOfYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.MONTH, 0);
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);
        
        return DateUtil.dateToString(c.getTime(), DateUtil.FORMAT_DATE);
    }
    
    public static String getFirstDayOfYear2(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DATE, c.get(Calendar.DATE) - 364); //
        return DateUtil.dateToString(c.getTime(), DateUtil.FORMAT_DATE);
    }
    
    // 获取当前时间所在年的结束日期
    public static String getLastDayOfYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.MONTH, 11);
        
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        return DateUtil.dateToString(c.getTime(), DateUtil.FORMAT_DATE);
    }
    
 
}
