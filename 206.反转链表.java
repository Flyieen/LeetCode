/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
    /**递归时间复杂度为O(n),空间复杂度为O(N)
     * 但是要理解这种思想
     */
    // public ListNode reverseList(ListNode head) {
    //     if(head == null || head.next == null){
    //         return head;
    //     }
    //     ListNode next = head.next;
    //     ListNode newHead = reverseList(next);
    //     //把顺序反过来
    //     next.next = head;
    //     head.next = null;

    //     //返回节点
    //     return newHead;
    // }
    

    //双指针迭代法，时间复杂度O(N)，空间复杂度O(1)
    /*
    28/28 cases passed (0 ms)
    Your runtime beats 100 % of java submissions
    Your memory usage beats 18.3 % of java submissions (38.4 MB)
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            //先保存指向，不然丢了链表的方向
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;

    }
}
// @lc code=end

