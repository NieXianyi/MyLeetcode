import Related.TreeNode;

//目标：找BST拥有最小值的节点,返回子树

//一句话看懂：
// 递归：等于root返回，值小于root往左递归，值大于往右递归，开头别忘了null
// 迭代：while root不为空的时候， = 就return，小于cur往左，大于cur往右，注意返回的是cur

public class Leetcode700 {

    //Recursive
     public TreeNode searchBST(TreeNode root, int val) {
         if(root == null) return root;
         if(root.val == val) {
             return root;
         }else if(val < root.val) {
             return searchBST(root.left, val);
         }else {
             return searchBST(root.right, val);
         }
     }

     //Iterative
    public TreeNode searchBST_2(TreeNode root, int val) {
        TreeNode cur = root;
        while(cur != null){
            if(val == cur.val) {
                return cur;
            } else if (val < cur.val){
                cur = cur.left;
            } else{
                cur = cur.right;
            }
        }
        return cur;
    }
}
