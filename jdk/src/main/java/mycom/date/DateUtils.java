package mycom.date;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class DateUtils {
    public static void main(String[] args) {
        Timestamp time = Timestamp.from(Instant.now());
        LocalDateTime localDateTime = time.toLocalDateTime();
//        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String format = localDateTime.format(pattern);
        System.out.println(format);
    }

    @Test
    public void format2Second(){
        String alarmTimeStr = "2020-08-06 21:15:30";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse(alarmTimeStr,dtf);
        long secondTime = parse.atZone(ZoneId.systemDefault()).toEpochSecond();
//        long secondTime = LocalDateTime.from(parse).atZone(ZoneId.systemDefault()).toEpochSecond();
        System.out.println(secondTime);
    }

    @Test
    public void second2Format(){
        long second2 = 1596719730;

        String format = LocalDateTime
                .ofInstant(
                        Instant.ofEpochSecond(second2),
                        ZoneId.systemDefault())
                .format(
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(format);

    }

    public Long format2Second(String alarmTimeStr,String dtformat){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dtformat);
        LocalDateTime parse = LocalDateTime.parse(alarmTimeStr,dtf);
        long secondTime = parse.atZone(ZoneId.systemDefault()).toEpochSecond();
        return secondTime;
    }

    @Test
    public void tt(){
        List<String> alarmTimeList = new ArrayList<>();
        alarmTimeList.add("2020-08-06 21:15:30");
        alarmTimeList.add("2020-08-06 22:15:30");
        alarmTimeList.add("2020-08-06 23:15:30");
        alarmTimeList.add("2020-08-04 23:15:30");
        alarmTimeList.add("2020-08-05 23:15:30");
        if (null != alarmTimeList){
            List<String> myList = alarmTimeList.parallelStream().map(dataStr ->{
                if (StringUtils.isNotBlank(dataStr)){
                    long second = format2Second(dataStr,"yyyy-MM-dd HH:mm:ss");
                    System.out.println(Thread.currentThread().getName() + " : " + second);
                    return String.valueOf(second);
                }else {
                    return dataStr;
                }
            }).collect(Collectors.toList());
            System.out.println(myList);
        }

    }

    @Test
    public void beforeOneHourToNowDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("一个小时前的时间：" + df.format(calendar.getTime()));
        System.out.println("当前的时间：" + df.format(new Date()));
        Long second = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        System.out.println(second);
    }
}
