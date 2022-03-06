import java.util.Arrays;
//思路： 左边的和=sum, 右边的和= total - sum + nums[i],相等返回就完事了
//时间复杂度：O(n), 空间复杂度：O(1)

public class Leetcode724 {
    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            sum += nums[i];
            if(sum == total - sum + nums[i]) return i;
        }
        return -1;
    }
}
