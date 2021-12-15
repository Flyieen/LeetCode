/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
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
    //双指针删的去就可以啦
    /*
    166/166 cases passed (0 ms)
    Your runtime beats 100 % of java submissions
    Your memory usage beats 35.98 % of java submissions (38.1 MB)
     */
    public ListNode deleteDuplicates(ListNode head) {
        //事实上用一个cur和cur.next即可
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur != null){
            if(pre.val == cur.val){
                cur = cur.next;
                pre.next = cur;
                continue;
            }
            pre = pre.next;
            cur = cur.next;
        }
        return head;
    }
}
// @lc code=end

