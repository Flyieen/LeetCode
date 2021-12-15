import java.util.Collections;
import java.util.Deque;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
         //迭代算法
         //前序遍历是中左右，后序遍历是左右中，将入栈的顺序调换变成
         //中右左，然后再把res反序输出即可变成左右中
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();
            res.add(node.val);
            if (node.left != null) {
                deque.push(node.left);
            }
            if (node.right != null) {
                deque.push(node.right);
            }
        }

        //用Collections的函数reverse将list倒序
        Collections.reverse(res);
        return res;
    }
}
// @lc code=end

