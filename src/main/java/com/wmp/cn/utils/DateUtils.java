package com.wmp.cn.utils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName DateUtils
 * @Description: TO2DO1
 * @Author wangmp
 * @Date 2020/7/8
 * @Version V1.0
 **/
public class DateUtils {


    /**
     * Description: 判断一个时间是否在一个时间段内 </br>
     * @param nowTime 当前时间 </br>
     * @param beginTime 开始时间 </br>
     * @param endTime 结束时间 </br>
     */
    public static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        return date.after(begin) && date.before(end);
    }


    /**
     * Description: 判断一个时间是否在一个时间之前 </br>
     * @param nowTime 当前时间 </br>
     * @param beginTime 开始时间 </br>
     */
    public static boolean beforCalendar(Date nowTime, Date beginTime) {
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);
        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);
        return date.before(begin);
    }


    /**
     * Description: 判断一个时间是否在某个时间之后 </br>
     * @param nowTime 当前时间 </br>
     * @param endTime 结束时间 </br>
     */
    public static boolean afterCalendar(Date nowTime, Date endTime) {
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);
        Calendar end = Calendar.getInstance();
        end.setTime(endTime);
        return date.after(end);
    }


    /**
     * 获取过去第几天的日期
     * @param past
     * @return
     */
    public static Date getPastDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date today = calendar.getTime();
        return today;
    }

    /**
     * 获取未来 第 past 天的日期
     * @param past
     * @return
     */
    public static Date getFetureDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past);
        Date today = calendar.getTime();
        return today;
    }

    /**
     * 获取 指定日期的未来第 past 天的日期
     * @param date
     * @param past
     * @return
     */
    public static Date getFetureDate(Date date,int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past);
        Date today = calendar.getTime();
        return today;
    }



    /**
     * 获取某个日期区间的每一天日期
     * @return
     */
    public static List<String> getEveryDay(Date startDate,Date endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        List<String> dayList = new ArrayList<String>();
        long startValue = startDate.getTime();
        long endValue = endDate.getTime();
        // 计算天数差
        long result = (endValue - startValue) / 1000 / 60 / 60 / 24;
        Calendar cal = Calendar.getInstance();
//        dayList.add(sdf.format(cal.getTime()));
        cal.setTime(startDate);
        cal.add(Calendar.DATE, -1);
        // 计算期间的每一天
        for (int index = 0; index <= result; index++) {
            cal.add(Calendar.DATE, 1);
            String dateString = sdf.format(cal.getTime());
            dayList.add(dateString);
        }
        return dayList;
    }



    /**
     * 获取当前日期的周一 和周日
     * @return
     */
    public static String getAweek() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        Calendar cld = Calendar.getInstance(Locale.CHINA);
        cld.setFirstDayOfWeek(Calendar.MONDAY);//以周一为首日
        cld.setTimeInMillis(System.currentTimeMillis());//当前时间，可写可不写

        cld.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);//周一
        String monday = df.format(cld.getTime());

        cld.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);//周日
        String sunday = df.format(cld.getTime());

        return monday+"_"+sunday;
    }


    /**
     * @Description:
     * @Author: wmp
     * @Date:
     * 计算两个日期之间差
     **/
    public static String convert(Date startDate,Date endDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - startDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        if(day<0){
            day = 0;
        }
        if(hour<0){
            hour = 0;
        }
        if(min<0){
            min = 0;
        }
        return day + "天" + hour + "小时" + min + "分钟";
    }

    /**
     * @Description:判断两个日期是否在同一天
     * @Author: wmp
     * @Date:
     **/
    public static boolean isTheSameDay(Date d1,Date d2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);
        return (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR))
                && (c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH))
                && (c1.get(Calendar.DAY_OF_MONTH) == c2.get(Calendar.DAY_OF_MONTH));
    }


}
