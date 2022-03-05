package Stack;
import java.util.Stack;


//时间复杂度O(n)
public class Leetcode150 {

        //  myself
        public static int evalRPN(String[] tokens) {
            if (tokens == null) {
                throw new IllegalArgumentException("The input tokens is null");
            }
            Stack<Integer> s = new Stack<>();
            for(String element : tokens) {
                if(element.equals("+")) {
                    int num2 = s.pop();  //Details: first out is num2
                    int num1 = s.pop();
                    s.push(num1 + num2);
                } else if(element.equals("-")){
                    int num2 = s.pop();
                    int num1 = s.pop();
                    s.push(num1 - num2);
                } else if(element.equals("*")) {
                    int num2 = s.pop();
                    int num1 = s.pop();
                    s.push(num1 * num2);
                } else if(element.equals("/")) {
                    int num2 = s.pop();
                    int num1 = s.pop();
                    s.push(num1 / num2);
                } else {
                    s.push(Integer.parseInt(element));
                }
            }
            return s.pop();
        }

    public static void main(String[] args) {
        System.out.println(evalRPN(null));
    }
}
