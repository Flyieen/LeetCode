/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
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
    public ListNode swapPairs(ListNode head) {
        //还是用双指针吧，别难为自己用递归了
        //构建头结点是为了最终返回，因为head已经被改变位置了，不再是头结点
        //像这种凡是涉及到head改变的都要构造一个头结点
        /*
        55/55 cases passed (0 ms)
        Your runtime beats 100 % of java submissions
        Your memory usage beats 98.59 % of java submissions (35.6 MB)
         */
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode pre = node;
        while (pre.next != null && pre.next.next != null) {
            ListNode l1 = pre.next, l2 = pre.next.next;
            ListNode next = l2.next;
            l1.next = next;
            l2.next = l1;
            pre.next = l2;
    
            pre = l1;
        }
        return node.next;
    }
}
// @lc code=end

