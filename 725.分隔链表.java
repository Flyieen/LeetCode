import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=725 lang=java
 *
 * [725] 分隔链表
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
    思路：遍历出所有节点的个数，然后再分成k组，如果有剩余n，再依次给
    前面的n组每组多分配一个

    注意题目的数组是ListNode数组，意思我们只需要放每个小组的第一个ListNode即可
    */

    /*
    43/43 cases passed (0 ms)
    Your runtime beats 100 % of java submissions
    Your memory usage beats 50.39 % of java submissions (38.6 MB)
    */
    public ListNode[] splitListToParts(ListNode head, int k) {
        int N = 0;
        ListNode cur = head;
        while (cur != null) {
            N++;
            cur = cur.next;
        }
        int mod = N % k;
        int size = N / k;
        ListNode[] ret = new ListNode[k];
        cur = head;
        for (int i = 0; cur != null && i < k; i++) {
            ret[i] = cur;
            int curSize = size + (mod-- > 0 ? 1 : 0); //排前面的要+1
            for (int j = 0; j < curSize - 1; j++) {
                cur = cur.next;
            }
            //截断这个组
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return ret;
    }
}
// @lc code=end

