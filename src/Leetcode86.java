//一句话总结思路：创建两对头尾指针 大链表和小链表，遍历链表，小则放到小的中，大放到大的中，最后首尾相接

//细节:
// 遍历链表，用一个next的指针来辅助遍历，因为要把每一个node与其他断开连接
// 注意如果存放大的和存放小的的链表都可能为空

import Related.ListNode;

public class Leetcode86 {
    //Myself
    public ListNode partition_my(ListNode head, int x) {
        ListNode smallHead = null,
                smallTail = null,
                largeHead = null,
                largeTail = null,
                next =null;
        while(head != null) {

            next = head.next;  //辅助遍历
            head.next =null;  //disconnect each node

            if(head.val < x){
                if(smallHead == null){
                    smallHead = head;
                    smallTail = head;
                } else {
                    smallTail.next = head;
                    smallTail = head;
                }
            } else {
                if(largeHead == null){
                    largeHead = head;
                    largeTail = head;
                } else {
                    largeTail.next = head;
                    largeTail = head;
                }
            }
            head = next;
        }

        if(smallHead != null) {
            smallTail.next = largeHead;
            return smallHead;
        } else if (largeHead != null) {
            return largeHead;
        } else {
            return null;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode fdum = new ListNode(0), bdum = new ListNode(0),
                front = fdum, back = bdum, curr = head;
        while (curr != null) {
            if (curr.val < x) {
                front.next = curr;
                front = curr;
            } else {
                back.next = curr;
                back = curr;
            }
            curr = curr.next;
        }
        front.next = bdum.next;
        back.next = null;
        return fdum.next;
    }
}


