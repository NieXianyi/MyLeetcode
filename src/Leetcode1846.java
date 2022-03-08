import java.util.Arrays;

//题目：给一个数组【100，1,1000], 操作：1.降低数值；2.换位置 目标:开头为1，差值为<=1
//brute force贪心
public class Leetcode1846 {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        int res = 1;
        for(int i =1; i<arr.length; i++){
            if(Math.abs(arr[i] - arr[i-1]) > 1) arr[i] = arr[i-1] + 1;
            res = Math.max(res, arr[i]);
        }
        return res;
    }
}
