import Related.ListNode;

//题目： 给一个链表返回中间的节点，偶数的话返回中间的下一个
//Input: head = [1,2,3,4,5,6]
//Output: [4,5,6]

//思路： 快慢指针套路，

public class Leetcode876 {
    public ListNode middleNode(ListNode head) {
        ListNode dummy = new ListNode(-1), p = dummy;
        p.next = head;
        ListNode fast = p, slow = p;
        while(fast.next != null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.next;
    }
}
