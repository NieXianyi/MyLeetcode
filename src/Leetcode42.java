package Stack;

import java.util.Stack;

public class Leetcode42 {
    //myself wrong
        public int trap_my(int[] height) {
            if (height ==null || height.length < 2) {
                return 0;
            }
            Stack<Integer> stack = new Stack<>();
            int water = 0;
            for (int i=0; i < height.length; i++) {
                if (stack.isEmpty() || stack.peek() >= height[i]) {
                    stack.push(i);
                } else {
                    int bottomIndex = stack.pop();  //弹出后栈顶的peek是第二小的height的index
                    int minHeight = Math.min(height[stack.peek()], height[i]);
                    water += (minHeight - height[bottomIndex]) * (i-stack.peek() - 1);
                }
            }
            return water;
        }

        //best stack
    /*
    注意 1. 不能用for 因为那样会有index不入栈，会出问题
        2、 考虑corner case 如果左侧没有次小值
    */
        public int trap(int[] height) {
            if (height == null || height.length < 2) return 0;

            Stack<Integer> stack = new Stack<>();
            int water = 0, i = 0;
            while (i < height.length) {
                if (stack.isEmpty() || height[i] <= height[stack.peek()]) {
                    stack.push(i++);
                } else {
                    int pre = stack.pop();
                    if (!stack.isEmpty()) {
                        int minHeight = Math.min(height[stack.peek()], height[i]);
                        water += (minHeight - height[pre]) * (i - stack.peek() - 1);
                    }
                }
            }
            return water;

    }

}
