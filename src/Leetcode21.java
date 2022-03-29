import Related.ListNode;
//题目： 两个有序的链表，合并成一个
//list1 = [1,2,4], list2 = [1,3,4]
//Output: [1,1,2,3,4,4]

//思路： 用dummy头结点技巧，新建一个值为-1的dummy，让p =dummy
//对于两个链表一样的部分：谁大p.next连谁，让后移动该链表的指针
// 对于多出来的部分，直接让当前部分整体连接在p后头

//时间复杂度：Time complexity : O(n + m)
// the time complexity is linear in the combined size of the lists
//Space complexity : O(n + m)
public class Leetcode21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1), p = dummy;
        ListNode p1 = l1; ListNode p2 = l2;

        while(p1!=null & p2!=null){
            if(p1.val < p2.val){
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }

        if(p1!=null){
            p.next = p1;
        }

        if(p2 !=null){
            p.next = p2;
        }

        return dummy.next;
    }
}
