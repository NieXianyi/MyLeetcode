package Stack;

import java.util.Stack;

public class Leetcode20 {
//myself
    public static boolean isValid_my(String s) {
        Stack<Character> stack = new Stack<>();
        String leftBra = "([{";
        String rightBra = ")]}";
        for (char c : s.toCharArray()) {
            if(leftBra.indexOf(c) >= 0 ) {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                char top = stack.peek();
                if (rightBra.indexOf(c) == leftBra.indexOf(top) && rightBra.indexOf(c) != -1) {
                    stack.pop();
                }
            }

        }
        if ( stack.isEmpty()) return true;
        return false;
    }

//最终提交
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            Character c=s.charAt(i);
            if(c=='(' || c=='[' || c=='{')  st.push(c);
            else if(!st.isEmpty() && c==')' &&  st.peek()=='(') st.pop();
            else if(!st.isEmpty() && c==']' &&  st.peek()=='[') st.pop();
            else if(!st.isEmpty() && c=='}' &&  st.peek()=='{') st.pop();
            else return false;
        }
        return st.isEmpty();
    }

//其他方法：
    public boolean isValid_best1(String s) {
        //push brackets one by one
        //once we have a match (open & closed) we pop the stack
        //if the stack is not empty we return false
        Stack<Character> stack = new Stack();
        for(char ch: s.toCharArray()){
            //subtracting one or two from ch and comparing to top of stack because that is the difference between open and closed breackets in the ascii table
            if(!stack.empty() && (stack.peek() == ch - 1 || stack.peek() == ch - 2)){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        return stack.empty();
    }
    // 用了ASCII码括号之间的关系


    public static void main(String[] args) {
        System.out.println( isValid("()"));
        //System.out.println("[".indexOf("([}"));
    }

//这种情况不合法 （[)]
}
