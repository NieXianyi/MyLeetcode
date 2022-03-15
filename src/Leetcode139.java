import java.util.*;


//题目：给定的输入是一个字符串s，一个列表能不能把字符串拆成字典里的单词：
//Input: s = "leetcode", wordDict = ["leet","code"]
//        Output: true
//Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//        Output: false

// 1.用动态规划  dp[i] 代表 0-(i-1)位置上的字符是否可以被拆成合格的单词
//从第二个字母开始遍历字符串，对于每次一遍历如果j可以分隔，即j前半部分单词也满足，后半部分也满足，则返回true
//动态转移方程： base case: dp[0]  = true;
//                        dp[i]  = dp[j] && if s [j, i-1]  in wordDict;


//时间复杂度分析：O(n3) n是字符串的长度  dp总共有O(n)个状态要计算，每个状态都要拆分O(n)次, subString的时间复杂度也是O(n)
//空间复杂度：dp[]数组长度为O(n)
//将 wordDict 构建为一个 Set 应该能提高 contains 方法的匹配效率，于是有了下面的改进


public class Leetcode139 {

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        System.out.println("Please enter the number of word in wordDict");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i<num; i++){
            System.out.println("Please enter the" + i + "th word");
            Scanner sc2 = new Scanner(System.in);
            String str = sc2.next();
            wordDict.add(str);
        }
        System.out.println("Please enter the test String");
        Scanner sc3= new Scanner(System.in);
        String s = sc3.next();
        System.out.println(wordBreak1(s,wordDict));
    }

    public static boolean wordBreak1(String s, List<String> wordDict) {
        Set<String> record = new HashSet<>(wordDict);
        int maxLen = maxAndMin(wordDict)[0];
        int minLen = maxAndMin(wordDict)[1];
        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;

        for(int i = minLen; i <= s.length(); i++){
            for(int j = Math.max(0, i - maxLen); j<i-minLen; j++){
                if(dp[j] && record.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    private static int[] maxAndMin(List<String> wordDict){
        int max = 0, min = 0;
        for(String str : wordDict) {
            max = Math.max(max, str.length());
            min = Math.min(min, str.length());

        }
        return new int[]{max, min};
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        //dp[i]代表位于index[0,(i-1)]的字符串能否被拆开成合格的单词
        //base case: dp[0] = true 长度为0的默认满足条件
        Set<String> record = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;

        for(int i = 1; i <= s.length(); i++){      //i等于几，就是视觉上哪段字符串，比如说i=4， 就是指leetcode 中的leet
            for(int j = 0; j<i; j++){
                if(dp[j] && record.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}


class DFS{
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] visited = new boolean[s.length() + 1];
        return dfs(s, 0, wordDict, visited);
    }
    private boolean dfs(String s, int start, List<String> wordDict, boolean[] visited) {
        for (String word : wordDict) {
            int nextStart = start + word.length();
            if (nextStart > s.length() || visited[nextStart]) {
                continue;
            }

            if (s.indexOf(word, start) == start) {
                if (nextStart == s.length() || dfs(s, nextStart, wordDict, visited)) {
                    return true;
                }
                visited[nextStart] = true;
            }
        }
        return false;
    }
}