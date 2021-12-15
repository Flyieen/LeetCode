import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=513 lang=java
 *
 * [513] 找树左下角的值
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
    Your runtime beats 70.57 % of java submissions
    Your memory usage beats 6.9 % of java submissions (38.3 MB)
     */
    // public int findBottomLeftValue(TreeNode root) {
    //     /*本质上就是层序遍历，最下层从左边开始遍历，最左下的是第一个
    //     叶子节点，所以queue会为空，调出循环，就找到了该节点
    //     */
    //     Queue<TreeNode> queue = new LinkedList<TreeNode>();
    //     queue.add(root);
    //     while(!queue.isEmpty()){
    //         root = queue.poll();
    //         if(root.right != null){
    //             queue.offer(root.right);  //因为是一个栈，我们要找左边的，就需要先把右节点放入
    //         }
    //         if(root.left != null){
    //             queue.offer(root.left);
    //         }
    //     }
    //     return root.val;
    // }

    private int Deep = -1;
    private int value = 0;
    public int findBottomLeftValue(TreeNode root) {
        value = root.val;
        findLeftValue(root,0);
        return value;
    }

    //找最深的那一层，从上到下，应该采用前序遍历（中左右
    //需要遍历整棵树，所以递归函数不能有返回值
    private void findLeftValue (TreeNode root,int deep) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (deep > Deep) {
                value = root.val;
                Deep = deep;
            }
        }
        //先递归遍历左子树，同样深度选左子树的值
        if (root.left != null) findLeftValue(root.left,deep + 1);
        if (root.right != null) findLeftValue(root.right,deep + 1);
    }


}
// @lc code=end

