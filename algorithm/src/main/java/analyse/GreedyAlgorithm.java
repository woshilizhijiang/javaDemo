package analyse;

import org.apache.commons.lang3.StringUtils;

import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 题目：
 * 一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目的宣讲。
 * 给你每一个项目开始的时间和结束的时间(给你一个数组，里面是一个个具体的项目)，
 * 你来安排宣讲的日程，要求会议室进行的宣讲的场次最多。返回这个最多的宣讲场次。
 *
 * 思路 建立小根堆，
 * 荣耀类似算法题：贪心算法
 */
public class GreedyAlgorithm {
    /**
     * 安排会议室，要求时间长优先，时间早优先
     8,10
     9,12
     10,14
     14,19
     17,21
     0,0
     * 贪心算法
     * 寻找局部最优解
     * 这里的定义是时间长的优先，因此先遍历所有安排，找出时间最长的，同长找最早的
     * 再遍历剩下的结果，去掉时间冲突的结果，再排序寻找时间最长的，同长找最早的
     * 递归上述结果
     * @param args
     */
    public static void main(String[] args) {
        List<Meeting> times = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        String[] t = line.split(",");
        while (!"0".equals(t[0]) || !"0".equals(t[1])) {  //以0,* or * ,0做为结束
            Meeting time = new Meeting();
            int t0 = Integer.parseInt(t[0]);
            int t1 = Integer.parseInt(t[1]);
            if(t1 > t0 && 8<=t0 && t0 <= 21 && 8 <= t1 && t1 <= 21){ //会议室8点到21点之间开放,该公司有点剥削员工 996起步的感觉
                time.setStart(t0);
                time.setEnd(t1);
                time.setTime(t1-t0);
                times.add(time);
            }else {
                System.out.println("输出错误，请重新输入！");
                return;
            }
            line = scanner.nextLine();
            t = line.split(",");
        }
        List<Meeting> already = new ArrayList<>();
        times = times.stream()
                .sorted(Comparator
                        .comparing(Meeting::getTime)
                        .thenComparing(Meeting::getStart)
                        .reversed())
                .collect(Collectors.toList());

        sortAndChoose(times,already);
        //输出结果
        System.out.println(already.size());
        for (Meeting meeting: already) {
            System.out.println(meeting.getStart() + " , "+ meeting.getEnd() + "," + meeting.getTime());
        }
    }
    private static void sortAndChoose(List<Meeting> times,List<Meeting> already){
        if(times != null && times.size() > 0) {
            already.add(times.get(0));
            removeConflict(times);
            times = times.stream()
                    .sorted(Comparator
                            .comparing(Meeting::getTime)
                            .thenComparing(Meeting::getStart))
                    .collect(Collectors.toList());
            sortAndChoose(times,already);
        }
    }

    /**
     * 去除冲突的
     * @param meetings
     */
    private static void removeConflict(List<Meeting> meetings){
        if(meetings!=null){
            if(meetings.size()==1){
                meetings.remove(0);
            }else {
                Meeting one = meetings.get(0);
                meetings.remove(0);
                Iterator<Meeting> iterator = meetings.iterator();
                while (iterator.hasNext()){
                    Meeting m = iterator.next();
                    Integer o1 = one.getStart();
                    Integer o2 = one.getEnd();
                    Integer m1 = m.getStart();
                    Integer m2 = m.getEnd();
                    if((o1 <= m1 && m1 < o2)||(o1 < m2 && m2 <= o2)){
                        iterator.remove();
                    }
                }
            }
        }
    }

    static class Meeting{
        private Integer start;
        private Integer end;
        private Integer time;

        public Integer getStart() {
            return start;
        }

        public void setStart(Integer start) {
            this.start = start;
        }

        public Integer getEnd() {
            return end;
        }

        public void setEnd(Integer end) {
            this.end = end;
        }

        public Integer getTime() {
            return time;
        }

        public void setTime(Integer time) {
            this.time = time;
        }
    }
}
