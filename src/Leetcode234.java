// 用快慢指针解：
//一句话看懂思路：快慢指针遍历，反转链表右半边，重新定义指针，一起往中间走进行判断，最后恢复反转

// 细节：
// 用快慢指针遍历，慢指针走到中间(even： 慢指针指在右半部分的最后一个； odd：慢指针在中间那个；)
// 存下来慢指针的当前位置mark（为之后恢复做准备1）慢指针的向下走一个，把右半段链表反转
//重新分配快慢指针，快指针指向头，慢指针不动留在尾巴上，并保存起来temp(为之后恢复做准备2)，一起往中间走，如果有不相等的则返回false，直到指针指向null；
//反转temp为头的右半段，让mark.next连接上 恢复链表

import Related.ListNode;

import java.util.Stack;

//TimeO(n), Space O(1)
class Leetcode234 {
    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode mark;
        while(fast.next!=null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        mark = slow;   //record the right part last node
        slow = slow.next;

        slow = reverse(slow);
        ListNode temp = slow;  // record the last node
        fast = head;

        while (fast!=null && slow!=null){
            if(fast.val != slow.val){
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }

        mark.next = reverse(temp);   // connect two part
        return true;
    }

    public static ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while(cur!=null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode firstNode = new ListNode(3);
        ListNode secondNode = new ListNode(3);
        ListNode thirdNode = new ListNode(1);
        head.next=firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        System.out.println(isPalindrome(head));
        System.out.println(head.val);
        System.out.println(head.next.val);
        System.out.println(head.next.next.val);
        System.out.println(head.next.next.next.val);
    }
}

class Leetcode234_2 {

    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode dummy = head;
        while (dummy != null) {
            stack.push(dummy.val);
            dummy = dummy.next;
        }
        while (head != null && !stack.isEmpty()) {
            if (stack.pop() == head.val) {
                head = head.next;
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
