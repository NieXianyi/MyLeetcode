import Related.ListNode;

import java.util.PriorityQueue;

//题目： 有n个不同升序链表，把他们按顺序合并成一个

//思路：同样用到dummy技巧，虚空指针！
// 新建一个堆，自己控制按val升序排列，把所有的head都放进去；
//循环只要堆不为空，就弹出来最顶上的让p链接，然后只要这个Listnode下一个不是空的就再塞回堆里，让p指针继续前进
//注意考虑corner case 判断length为0 返回空

//时间复杂度：考虑优先队列中的元素不超过 k 个，那么插入和删除的时间代价为 O(logk)，
// 这里最多有 kn 个点，对于每个点都被插入删除各一次，故总的时间代价即渐进时间复杂度为 O(kn×logk)。
//空间复杂度：这里用了优先队列，优先队列中的元素不超过 k 个，故渐进空间复杂度为 O(k)

public class Leetcode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        ListNode dummy = new ListNode(-1), p = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length,
                (ListNode a, ListNode b) -> (a.val - b.val));

        for(ListNode head : lists){
            if(head != null) pq.add(head);
        }

        while(!pq.isEmpty()){
            ListNode curNode = pq.poll();
            p.next = curNode;
            if(curNode.next != null){
                pq.add(curNode.next);
            }
            p = p.next;
        }

        return dummy.next;

    }
}

