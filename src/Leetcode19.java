import Related.ListNode;

//题目：remove倒数第n个节点，返回新链表
// Input: head = [1,2,3,4,5], n = 2
//Output: [1,2,3,5]

//思路： 同样用dummy技巧，p = dummy, 避免删除的是第一个头结点返回空的情况
// 先把原链表连接到p上，用两个指针，p1指针先走n+1步，然后两个指针一起往前走直到p1为空
//此时p2停在要删除节点的前一个节点上(如果p1先走n步 p2恰好可以停留在要删除的节点上) 操作一下 返回dummy.next

//Time complexity : O(L). The algorithm makes two traversal of the list, first to calculate list length L
//and second to find the (L- n) th node. There are 2L -n operations and time complexity is O(L).
//Space complexity:O(1).

public class Leetcode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1), p = dummy;
        p.next = head;
        ListNode p1 = p;
        for(int i = 0; i< n +1; i++) p1 = p1.next;
        ListNode p2 = p;
        while(p1!=null){
            p1 = p1.next;
            p2 = p2.next;  //此时p2是要被删除的前一个节点
        }

        p2.next = p2.next.next;
        return dummy.next;

    }
}
