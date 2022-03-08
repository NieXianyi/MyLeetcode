import java.util.*;

//题目: 给数组合并能合并的
// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]

// 按区间长度的start升序排序， 把第一个区间拿出来放在res里，从第二个开始遍历
//如果第二个的start比第一个尾巴last小，合并（更新last位置），否则把他加到res里去
//返回时转化回Array

public class Leetcode56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (int[] a, int[] b) ->{
            return a[0] - b[0];
        });

        res.add(intervals[0]);
        for(int i =1; i< intervals.length; i++){
            int[] last = res.get(res.size()-1);
            if(intervals[i][0] <= last[1]){
                last[1] = Math.max(intervals[i][1], last[1]);

            } else res.add(intervals[i]);
        }
        return res.toArray(new int[0][0]);
    }
}
