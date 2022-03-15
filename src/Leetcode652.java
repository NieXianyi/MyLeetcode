import Related.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//测试用例中如果使用中序序列化二叉树，TreeA:
//   0
//  /
// 0
//TreeB:
//  0
//   \
//    0
//They both have same in-order serialization "#0#0#" if we just use "#" to represent null.序列化后的结果是相同的。序列化二叉树注意避免中序遍历。

//用递归，就必须知道以当前节点以它为根的这棵二叉树长什么样，还需要知道以其它节点为根的二叉树长什么样，才能进行比较
//
//要解决以当前节点为根的二叉树长什么样，就得用序列化它的结构
//
//要知道以当前节点为根的二叉树长什么样，用后序遍历最是佳的方式
//要知道以其它节点为根的二叉树长什么样，就得要把序列化二叉树的结构的结果存储起来

//Time and space complexity = O(n^2) wheer n is the number of nodes in the tree
// 因为总共有n各节点，每个节点都要序列化n次计算 n^2,  总共有n个节点，每个节点要拼接n^2次

// https://leetcode-cn.com/problems/find-duplicate-subtrees/solution/shuang-bian-ha-xi-ju-shuo-zhe-yang-shi-j-wpvf/

public class Leetcode652 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(4);
        TreeNode root1 = new TreeNode(0);
        root1.right = new TreeNode(0);
        System.out.println(findDuplicateSubtrees(root1));


    }

    public static HashMap<String,Integer> record = new HashMap<>();
    public static List<TreeNode> res = new ArrayList<>();

    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        posOrderTraverse(root);
        return res;
    }

    public static String posOrderTraverse(TreeNode root){
        if(root == null) return "#";

        String left = posOrderTraverse(root.left);
        String right = posOrderTraverse(root.right);

        String subTree = left + "," + right + "," + root.val;
        int freq = record.getOrDefault(subTree,0);
        record.put(subTree, freq + 1);
        if( freq == 2) res.add(root);

        return subTree;
        //"#,＃,4,＃,2"-> {Integer@765} 2
        //"#,＃,4"-> {Integer@767} 3
        //"＃,＃,4,＃,2,#,#,4,3"-> fInteger@769) 1
        //"＃,＃,4,#,2,#,#,4,#,2,＃,#,4,3,1"-> {Integer@769) 1
    }
}

class uID{
    HashMap<String, Integer> IDRecord = new HashMap<>();    //key: 序列化的子树，  value: 每一种子树对应的ID
    HashMap<Integer, Integer> freqRecord = new HashMap<>();  		//key: 每一个子树对应的ID， value： 每一个子树出现的的次数
    List<TreeNode> res = new ArrayList<>();
    int treeID = 0;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root){
        posOrderTraverse(root);
        return res;
    }

    private int posOrderTraverse(TreeNode root){

        if ( root == null ) return 0;

        int left =  posOrderTraverse(root.left);
        int right = posOrderTraverse(root.right);

        String subTree  = left + "," +  right + ","  + root.val;

        if ( !IDRecord.containsKey(subTree) ) 	IDRecord.put(subTree, treeID++);

        int ID = IDRecord.get(subTree);
        int freq = freqRecord.getOrDefault(ID, 0);
        freqRecord.put(ID, freq + 1);

        if (freqRecord.get(ID) == 2) res.add(root);

        return ID;
    }
}
