import Related.ListNode;

//题目：判断链表是否成环

//思路：快慢指针，如果相等返回true
//时间复杂度： O(n)，n是链表中的节点数；
//空间复杂度： O(1),只用了两个指针


public class Leetcode141 {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;

    }
}
