/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
    // public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    //     //可以使用递归，但是空间复杂度太高
    //     //208/208 cases passed (0 ms)
    //     // Your runtime beats 100 % of java submissions
    //     // Your memory usage beats 12.96 % of java submissions (37.9 MB)
    //     if(list1 == null){
    //         return list2;
    //     }
    //     if (list2 == null) {
    //         return list1;
    //     }
    //     //返回值更小的节点
    //     if (list1.val < list2.val) {
    //         list1.next = mergeTwoLists(list1.next, list2);
    //         return list1;
    //     } else {
    //         list2.next = mergeTwoLists(list1, list2.next);
    //         return list2;
    //     }
    // }


    /*
    208/208 cases passed (0 ms)
    Your runtime beats 100 % of java submissions
    Your memory usage beats 47.74 % of java submissions (37.8 MB)
    */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //双指针方法，迭代
        //设置一个头结点，方便返回
        //本质上就是把递归转换成循环
        if(list1 == null){
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                cur.next = list1;
                cur = list1;
                list1 = list1.next;
            }else {
                cur.next = list2;
                cur = list2;
                list2 = list2.next;
            }
        }
        cur.next = list1 == null ? list2 : list1;
        return head.next;
    }
}
// @lc code=end

