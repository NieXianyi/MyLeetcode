import java.util.Arrays;

//题目:能merge就merge，返回剩余的区间数
//Input: intervals = [[1,4],[3,6],[2,8]]
//        Output: 2

//思路： 先按start升序排列，再按last降序排列数组，然后把第一个拿出来做基准
//如果后续末尾比第一个小，则可以合并，res+1; 否则更新末尾

//时间复杂度：O(NlogN)，其中 N 是区间的个数。
//空间复杂度：O(log N)，为排序需要的空间。

public class Leetcode1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        int res = 0;
        Arrays.sort(intervals, (int[] a, int[] b) ->{
            if(a[0] == b[0]) return b[1] - a[1];
            else return a[0] - b[0];
        });

        int last = intervals[0][1];
        for(int i = 1; i<intervals.length; i++){
            if(last >= intervals[i][1]) res++;
            else last = intervals[i][1];
        }
        return intervals.length - res;
    }
}
