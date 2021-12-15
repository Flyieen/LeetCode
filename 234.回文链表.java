/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /*
    仍然是快慢指针，慢指针走一步，快指针走两步，当快指针走到最后的时候，
    慢指针到中间，然后切开链表反转后续链表。
    然后再比较，不过切开链表又花了时间
    85/85 cases passed (7 ms)
    Your runtime beats 49.62 % of java submissions
    Your memory usage beats 79.13 % of java submissions (48.2 MB)
    */
    // public boolean isPalindrome(ListNode head) {
    //     if (head == null || head.next == null) return true;
    //     ListNode slow = head, fast = head.next;
    //     while (fast != null && fast.next != null) {
    //         slow = slow.next;
    //         fast = fast.next.next;
    //     }
    //     if (fast != null) slow = slow.next;  // 偶数节点，让 slow 指向下一个节点
    //     cut(head, slow);                     // 切成两个链表
    //     return isEqual(head, reverse(slow));
    // }

    // private void cut(ListNode head, ListNode cutNode) {
    //     //切成两个链表
    //     while (head.next != cutNode) {
    //         head = head.next;
    //     }
    //     head.next = null;
    // }

    // private ListNode reverse(ListNode head) {
    //     ListNode newHead = null;
    //     while (head != null) {
    //         ListNode nextNode = head.next;
    //         head.next = newHead;
    //         newHead = head;
    //         head = nextNode;
    //     }
    //     return newHead;
    // }

    // private boolean isEqual(ListNode l1, ListNode l2) {
    //     //包含了奇数和偶数的判断
    //     //不用判断为null的情况
    //     while (l1 != null && l2 != null) {
    //         if (l1.val != l2.val) return false;
    //         l1 = l1.next;
    //         l2 = l2.next;
    //     }
    //     return true;
    // }


    /*
    自己写的版本，不切割链表，只反转后续的链表，然后比较即可
    85/85 cases passed (4 ms)
    Your runtime beats 86.66 % of java submissions
    Your memory usage beats 91.75 % of java submissions (48.1 MB)
    */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        boolean isEven = true;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            if(fast.next.next == null){
                fast = fast.next;
                isEven = false;
                break;
            }
            fast = fast.next.next;
        }
        if (isEven) slow = slow.next;  // 偶数节点，让 slow 指向下一个节点
        //考虑不切开链表可以节省时间
        reverse(slow);
        while(true){
            if(head.val != fast.val){
                return false;
            }
            if(slow == fast){
                break;
            }
            head = head.next;
            fast = fast.next;
        }
        return true;
    }

    private void reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = newHead;
            newHead = head;
            head = nextNode;
        }
    }
}
// @lc code=end

