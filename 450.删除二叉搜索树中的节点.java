/*
 * @lc app=leetcode.cn id=450 lang=java
 *
 * [450] 删除二叉搜索树中的节点
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
//先序遍历
//https://leetcode-cn.com/problems/delete-node-in-a-bst/solution/miao-dong-jiu-wan-shi-liao-by-terry2020-tc0o/
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return root;
        }
        if(root.val < key){
            root.right = deleteNode(root.right, key);
        }
        else if(root.val > key){
            root.left = deleteNode(root.left, key);
        }
        else{ //当前结点就是要删除的结点
            //1.该节点无左节点
            if(root.left == null){
                return root.right;
            }
            //2.删除结点无右子结点
            if(root.right == null){
                return root.left;
            }
            //3.左右结点都有
            TreeNode node = root.right;
            while(node.left != null){  // 寻找欲删除节点右子树的最左节点
                node= node.left;
            }
            node.left = root.left;   // 将欲删除节点的左子树成为其右子树的最左节点的左子树
            root = root.right;   // 欲删除节点的右子顶替其位置，节点被删除
        }
        return root;
    }
}
// @lc code=end

