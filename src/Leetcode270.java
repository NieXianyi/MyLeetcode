//目标： BST找最接近的点，返回的是BST最接近的那个整数值

//思路： 同700的思路一样，别忘了创建一个double的最大值用来初始化 两数之间的差值
    //递归的话，别忘了递归返回值是void，因为只需要这个helper函数来,同时两个初始变量得放在两个函数最外头
import Related.TreeNode;

public class Leetcode270 {

    //Iterative
    public int closestValue(TreeNode root, double target) {
        double min = Double.MAX_VALUE;
        int res = 0;
        TreeNode cur = root;

        while(cur!=null){
            if(Math.abs(cur.val - target) < min){
                min = Math.abs(cur.val - target);
                res = cur.val;
            }
            if(target < cur.val) cur=cur.left;
            else cur = cur.right;
        }
        return res;
    }

    //Recursive
    double min = Double.MAX_VALUE;
    int res = 0;
    public int closestValue_2(TreeNode root, double target) {
        BST_Search(root, target);
        return res;
    }
    public void BST_Search(TreeNode root, double target){
        if(root == null) return;
        if(Math.abs(root.val - target) < min){
            min = Math.abs(root.val - target);
            res = root.val;
        }
        if(target < root.val) BST_Search(root.left, target);
        else BST_Search(root.right, target);
    }

}
