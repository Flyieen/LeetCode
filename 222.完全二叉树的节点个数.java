import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=222 lang=java
 *
 * [222] 完全二叉树的节点个数
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
    /*
    18/18 cases passed (0 ms)
    Your runtime beats 100 % of java submissions
    Your memory usage beats 34.17 % of java submissions (41 MB)
    第一次自己写出整个过程
    */
    public int countNodes(TreeNode root) {
        //个人版本，没有利用完全二叉树的特性
        // if(root == null) {
        //     return 0;
        // }
        // int left = countNodes(root.left);
        // int right = countNodes(root.right);
        // return left+right+1;
        
        /*
        Your runtime beats 100 % of java submissions
        Your memory usage beats 99.23% of java submissions (41 MB)
        */
        //看labuladong的算法小抄，更加优秀
        if(root == null){
            return 0;
        } 
        int left = countLevel(root.left);
        int right = countLevel(root.right);
        if(left == right){
            return countNodes(root.right) + (1<<left);
        }else{
            return countNodes(root.left) + (1<<right);
        }
    }

    private int countLevel(TreeNode root){
        int level = 0;
        while(root != null){
            level++;
            root = root.left;
        }
        return level;
    }
}
// @lc code=end

