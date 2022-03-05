import java.util.*;

//- 思路：用Hasmap，key放数值，value放索引
//- 注意：不能和自己匹配，通过将查询放在put前来避免匹配自己

//时间复杂度：O(N)，其中 N 是数组中的元素数量。对于每一个元素x，我们可以 O(1）地寻找 target - x。
//空间复杂度：O(N)，其中 N是数组中的元素数量。主要为哈希表的开销。
public class Leetcode1 {


    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}
