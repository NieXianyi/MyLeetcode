package Related;

//二叉树代码
public class BinaryTree<Key extends Comparable<Key>, Value> {
    //记录根结点
    private Node root;
    //记录树中元素的个数
    private int N;
    //获取树中元素的个数
    public int size() {
        return N;
    }
    //向树中添加元素key-value
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }
    //向指定的树x中添加key-value,并返回添加元素后新的树
    private Node put(Node x, Key key, Value value) {
        if (x == null) {
//个数+1
            N++;
            return new Node(key, value, null, null);
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
//新结点的key大于当前结点的key，继续找当前结点的右子结点
            x.right = put(x.right, key, value);
        } else if (cmp < 0) {
//新结点的key小于当前结点的key，继续找当前结点的左子结点
            x.left = put(x.left, key, value);
        } else {
//新结点的key等于当前结点的key，把当前结点的value进行替换
            x.value = value;
        }
        return x;
    }
    //查询树中指定key对应的value
    public Value get(Key key) {
        return get(root, key);
    }
    //从指定的树x中，查找key对应的值
    public Value get(Node x, Key key) {
        if (x == null) {
            throw new java.util.NoSuchElementException("哥们，没有这个数");
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
//如果要查询的key大于当前结点的key，则继续找当前结点的右子结点；
            System.out.println(x.right);
            return get(x.right, key);
        } else if (cmp < 0) {
//如果要查询的key小于当前结点的key，则继续找当前结点的左子结点；
            return get(x.left, key);
        } else {
//如果要查询的key等于当前结点的key，则树中返回当前结点的value。
            return x.value;
        }
    }
    //删除树中key对应的value
    public void delete(Key key) {
        root = delete(root, key);
    }
    //删除指定树x中的key对应的value，并返回删除后的新树
    public Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
//新结点的key大于当前结点的key，继续找当前结点的右子结点
            x.right = delete(x.right, key);
        } else if (cmp < 0) {
//新结点的key小于当前结点的key，继续找当前结点的左子结点
            x.left = delete(x.left, key);
        } else {
//新结点的key等于当前结点的key,当前x就是要删除的结点
//1.如果当前结点的右子树不存在，则直接返回当前结点的左子结点
            N--;

            if (x.right == null) {
                return x.left;
            }
//2.如果当前结点的左子树不存在，则直接返回当前结点的右子结点
            if (x.left == null) {
                return x.right;
            }
//3.当前结点的左右子树都存在
//3.1找到右子树中最小的结点
            Node minNode = x.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }
//3.2删除右子树中最小的结点
            Node n = x.right;
            while (n.left != null) {
                if (n.left.left == null) {
                    n.left = null;
                } else {
                    n = n.left;
                }
            }
//3.3让被删除结点的左子树称为最小结点minNode的左子树，让被删除结点的右子树称为最小结点

            minNode.left = x.left;
            minNode.right = x.right;
//3.4让被删除结点的父节点指向最小结点minNode
            x = minNode;
//个数-1

        }
        return x;
    }
    private class Node {
        //存储键
        public Key key;
        //存储值
        private Value value;
        //记录左子结点
        public Node left;
        //记录右子结点
        public Node right;
        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
