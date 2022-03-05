//一句话总结思路： 创造一个hashmap，用node的构造方法clone链表，以成对的方式存进去
// 让cur对应的value的next和random等于 cur.next对应的value即可

// 细节： 新建一个cur 两次回到head 因为要遍历两次 返回head对应的头结点就行
import java.util.HashMap;

//时间复杂度是O(n),空间复杂度O(n)
public class Leetcode138 {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> container = new HashMap<>();
        Node cur = head;
        while(cur != null) {
            Node newnode =new Node(cur.val);
            container.put(cur, newnode);
            cur = cur.next;
        }
        cur = head;
        while(cur != null) {
            container.get(cur).next = container.get(cur.next);
            container.get(cur).random = container.get(cur.random);
            cur =cur.next;
        }
        return container.get(head);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}