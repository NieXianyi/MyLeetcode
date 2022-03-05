import Related.TreeNode;

import java.util.*;

// 一句话总结思路： 先创建一个二维数组，一定要记得是在遍历每一层之前创建该层的list
//具体见BFS笔记
//细节：corner case ： 1.root可能为空

public class Leetcode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {


        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list= new ArrayList<>();
            for(int i = 0; i<size; i++){
                TreeNode cur = q.poll();
                list.add(cur.val);
                if(cur.left!=null) q.offer(cur.left);
                if(cur.right!=null) q.offer(cur.right);
            }
            result.add(list);
        }
        return result;

    }
}
