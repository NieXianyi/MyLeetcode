package Related;

import Related.TreeNode;
//目标： 插入值进BST，返回整颗新树
//思路： 同700，如果用Iterative，记得用cur和prev控制，当cur等于null时，来判断插在prev左还是右

public class Leetcode701 {

    //Recursive
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        if(val < root.val){
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }

    //Iterative
    public TreeNode insertIntoBST_2(TreeNode root, int val) {
        if(root == null){
            root = new TreeNode(val);
            return root;
        }
        TreeNode cur = root;
        TreeNode prev = null;
        while(cur != null){
            prev = cur;
            if(val < cur.val) cur = cur.left;
            else cur = cur.right;
        }
        if(val < prev.val) prev.left = new TreeNode(val);
        else prev.right = new TreeNode(val);
        return root;
    }

}
