package Stack;

import java.util.Stack;

public class Leetcode227 {
    //  前数    |      后数      |
    //       上次运算符       本次运算符
    //myself
    //一句话看懂思路：遍历字符串，用stack来存紧挨着运算符的上一个数，当字符串遍历到本次运算符时，再操作上一个运算符前后的数
    //（因为遍历到下一个操作符时，上一个操作符后的数才刚算好被存起来）
    // +就把上一个操作符后面的数push进去，-就带负号push进去，*/就pop出来乘除好了再push进去，最后遍历stack加起来

    //注意：第一个必被push进去，所以初始化上次运算符为+； 最后一个找不到上一个操作符，只需要控制遍历到最后一位的时候运算前一个操作符就行
    //对于空格，continue就好，但是注意空格是最后一位的时候不能continue
    public static int calculate(String s) {          //时间复杂度O(n), 空间复杂度O(n)
        if (s == null || s.length() == 0 ) return 0;
        Stack<Integer> stack = new Stack();
        int num = 0;
        int result = 0;
        char lastOperator = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i!=s.length()-1 && c == ' ') continue;
            if (Character.isDigit(c))  num = num*10 + (c - '0'); //char->int
            if (c=='+'||c=='-'||c=='*'||c=='/'&& c!=' '||i==s.length()-1 ){
                if(lastOperator == '+') stack.push(num);
                if(lastOperator == '-') stack.push(-num);
                if(lastOperator == '*') stack.push(stack.pop() * num);
                if(lastOperator == '/') stack.push(stack.pop() / num);
                lastOperator = c;
                num = 0;
            }
        }
        for (int i : stack) {
            result += i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(calculate(" 4/2  "));
    }
}
