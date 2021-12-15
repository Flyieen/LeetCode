/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 复制带随机指针的链表
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    /*
    结题思路：
    第一步，在每个节点的后面插入复制的节点。
    第二步，对复制节点的 random 链接进行赋值，只需要复制random并向后移动一位
    第三步：拆分
    http://www.cyc2018.xyz/%E7%AE%97%E6%B3%95/%E5%89%
    91%E6%8C%87%20Offer%20%E9%A2%98%E8%A7%A3/35.%20%E5%A4%8D
    %E6%9D%82%E9%93%BE%E8%A1%A8%E7%9A%84%E5%A4%8D%E5%88%B6.html#题目描述
    */
    /*
    19/19 cases passed (0 ms)
    Your runtime beats 100 % of java submissions
    Your memory usage beats 86.59 % of java submissions (37.8 MB)
    */
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node cur = head;
        while(cur != null){
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        //处理random，不能顺便拆分呢，因为有可能弄到前面
        Node pre = head;
        cur = head.next;
        while(true){
            cur.random = pre.random == null ? null : pre.random.next;
            pre = cur.next;
            if(pre == null){
                break;
            }
            cur = pre.next;
        }
        //同样的过程，人家的代码多优雅
        // cur = pHead;
        // while (cur != null) {
        //     RandomListNode clone = cur.next;
        //     if (cur.random != null)
        //         clone.random = cur.random.next;
        //     cur = clone.next;
        // }
        //拆分
        pre = head;
        cur = head.next;
        Node newHead = cur;
        while (true) {
            pre.next = cur.next;
            pre = cur.next;
            if(pre == null){
                break;
            }
            cur.next = pre.next;
            cur = pre.next;
        }
        return newHead;
    }
}
// @lc code=end

