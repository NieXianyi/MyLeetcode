package Stack;

import java.util.Stack;


// 一句话总结思路：遍历push组，装进stack，pop组1号位时刻等待判断，如果栈顶部和自己的相等，则pop掉那个值，然后用自己下一个去匹配，反复pop直到为空
// https://blog.csdn.net/harryshumxu/article/details/105341502

//时间复杂度O(n) 每个元素最多进栈出栈一次
//空间复杂度O(n) stack最多存储n个元素
public class Offer31 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int j =0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while(!stack.isEmpty() && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
