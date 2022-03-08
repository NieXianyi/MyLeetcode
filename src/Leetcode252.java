import java.util.Arrays;
//看时间安排有没有冲突
//Input: intervals = [[0,30],[5,10],[15,20]]
//Output: false

//思路，先按start排序，从第二个开始遍历，如果后一个的start比前一个的last小，返回false

public class Leetcode252{
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) -> {
            return a[0] - b[0];
        });

        for(int i = 1; i<intervals.length; i++){
            if(intervals[i][0] < intervals[i-1][1]) return false;
        }
        return true;

    }
}
