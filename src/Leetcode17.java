import java.util.*;

//时间复杂度：因为要对每一个数字考虑所有组合情况，假设有m个三位字母的数，n个四位字母的数，时间复杂度： 3^m + 4^n
//空间复杂度： map是固定数组O(1), removeDuplicate m+n, 回溯的 m+n 到达digits length就会返回
public class Leetcode17 {
    public static void main(String[] args) {
        String digits = "";
        System.out.println(letterCombinations(digits));
    }

    public static String[] map = new String[]{
            "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
    };
    public static List<String> res = new ArrayList<>();



    public static List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return res;
        String newdigits = removeDuplicate(digits);
        System.out.println(newdigits);
        backtrack(newdigits, 0, new StringBuilder());
        return res;
    }

    public static String removeDuplicate(String digits) {  //23334
        StringBuilder newdigits = new StringBuilder();
        if(digits.length() == 1) return digits;
        char lastDigit = ' ';
        for(char digit : digits.toCharArray()){
            if(lastDigit == digit) continue;
            else newdigits.append(digit);
            lastDigit = digit;
        }
        return newdigits.toString();

    }

    //因为需要频繁的拼接字符串，每一次字符串拼接就会新建一个String对象，
    //而之前的String字符串仍然保留在堆区中，浪费时间和内存空间，所以采用StringBuilder
    public static void backtrack(String digits, int start, StringBuilder sb){
        //到达底部 停止回溯
        if(sb.length() == digits.length()){
            res.add(sb.toString());
            return;
        }
        for(int i=start; i<digits.length(); i++){
            int digit = digits.charAt(i) - '0';
            for(char c: map[digit].toCharArray()){
                sb.append(c);
                backtrack(digits, i+1, sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    //backtrack 0
    //0 -> 2 -> abc
        //a, sb ="a"
            // backtrack 1
            // 1 -> 3 -> def:
                // d, sb = "ad"
                    // backtrack 2
                        // return
                    //取消选择： 删除sb最后一个字符 sb = "a"
                // e,  sb = "ae"
                    // backtrack 2
}
