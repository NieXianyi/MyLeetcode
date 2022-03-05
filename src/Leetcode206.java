import Related.ListNode;

import java.util.LinkedList;

// pre cur next
// 一句话总结思路：总共三个指针，初始化cur=head，pre=null;
// 当cur不为0时， 初始化next等于cur右一位，用cur.next让该数指向左边的指针pre，然后把pre和cur整体右移一位，继续重复，直到cur为0
//记住 一定要先移pre 再移cur ， 返回pre 就是反转指针

public class Leetcode206 {
    public static ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while(cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


}
