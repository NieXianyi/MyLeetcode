import Related.*;
import java.util.LinkedList;
import java.util.Queue;


public class Leetcode111 {
    public int minDepth(TreeNode root) {
        if(root ==null) return 0;
        int depth = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                TreeNode cur = q.poll();
                if(cur.left==null && cur.right==null) return depth;
                if(cur.left!=null) q.offer(cur.left);
                if(cur.right!=null) q.offer(cur.right);
            }
            depth++;
        }

        return depth;

    }
}
