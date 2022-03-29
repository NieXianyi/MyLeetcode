import Related.ListNode;

//找出链表环的节点

//思路： 快慢指针，当快慢指针相遇时，让其中任一个指针指向头节点，
// 然后让它俩以相同速度前进，再次相遇时所在的节点位置就是环开始的位置

//时间复杂度：O(N)：
//两阶段：1.快慢指针相遇的时候，慢指针第一圈没走完就会相遇，所以是O(N)
    //证明：
//空间复杂度：O(1)

public class Leetcode142 {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        if(fast.next == null || fast.next.next == null) return null;
        slow = head;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
