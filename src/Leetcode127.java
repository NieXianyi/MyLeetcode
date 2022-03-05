import java.util.*;
public class Leetcode127 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        System.out.println(list);
        System.out.println(ladderLength("hit","cog",list));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        Set<String> wordSet = new HashSet<>(wordList);

        q.offer(beginWord);
        int step = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i<size; i++) {
                String cur = q.poll();
                if(cur == endWord) {
                    return step+1;
                }
                for(String word : wordList){
                    if(wordCompare(cur,word) && wordSet.contains(word)) {
                        q.offer(word);
                        wordSet.remove(word);
                    }

                }
            }
            step++;

        }
        return 0;
    }

    public static boolean wordCompare(String origin, String newword){
        int i=0;
        int num =0;
        for (char c : origin.toCharArray()){
            if (c != newword.charAt(i))
                num += 1;
            i++;
        }
        return num==1? true: false;
    }
}
