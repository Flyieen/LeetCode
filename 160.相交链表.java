/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    //两个指针分别走两次，相等的时候就是该节点
    //自己写的代码还是不优雅呀
    /*
    39/39 cases passed (1 ms)
    Your runtime beats 99.98 % of java submissions
    Your memory usage beats 61.58 % of java submissions (41.2 MB)
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // if(headA == null || headB == null ){
        //     return null;
        // }
        // ListNode p1 = headA;
        // ListNode p2 = headB;
        // boolean flag1 = true;
        // boolean flag2 = true;
        // while(p1 != p2){
        //     p1 = p1.next;
        //     p2 = p2.next;
        //     if(p1 == null && flag1 == true){
        //         p1 = headB;
        //         flag1 = false;
        //     }
        //     if(p2 == null && flag2 == true){
        //         p2 = headA;
        //         flag2 = false;
        //     }
        // }
        // return p1;


        /*
        39/39 cases passed (1 ms)
    Your runtime beats 99.98 % of java submissions
    Your memory usage beats 75.9 % of java submissions (41.1 MB)
         */
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            //不用担心不能退出循环，因为两个指针走到最后一定是同时为null
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;

    }
}
// @lc code=end

