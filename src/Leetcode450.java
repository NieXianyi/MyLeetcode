//目标：删除一个节点，并且还是BST，返回新的BST
/*
思路：
    如果root是null 返回null
     1.找到被删除结点；
        如果key小于root，往左递归，并把返回值赋改root.left
        如果key大于root, 往右递归，并把返回值赋给root.right
        else（相等） 则找到了
            如果要删除key没有左子树，则返回右子树即可
            如果要删除key没有右子树，则返回左子树即可  （如果两遍都没有可以直接删除返回null，包含在此种情况里）
            else(如果既有左子树，又有右子树)
                2.找到被删除结点右子树中的最小结点
                    新建一个rightSmallest=root.right
                    while rightSmallest 的left不为null的之后就一直往left找，找到最小的那个
                让被删除结点(当前root)的左子树成为最小结点rightSmallest的左子树
                让被删除结点（当前root）的右子树一整坨直接接回上一级上去 即return root.right
* */

import Related.TreeNode;

public class Leetcode450 {
    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(key < root.val) root.left = deleteNode(root.left, key);
        else if(key > root.val) root.right = deleteNode(root.right, key);
        else {
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            else {
                TreeNode rightSmallest = root.right;
                while(rightSmallest.left !=null) rightSmallest = rightSmallest.left;
                rightSmallest.left = root.left;
                return root.right;
            }
        }
        return root;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(1);
        root.left.right.right = new TreeNode(8);
        root.right.right = new TreeNode(7);
        System.out.println(deleteNode(root,3));

    }
}

