/*
 * @lc app=leetcode.cn id=701 lang=java
 *
 * [701] 二叉搜索树中的插入操作
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

//从上到下，考虑采用先序遍历
//不需要处理递归数据，所以递归函数无返回值
/*
还是自己写的submit更好
35/35 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 77.61 % of java submissions (38.9 MB)
 */
// class Solution {
//     boolean flag = true;
//     public TreeNode insertIntoBST(TreeNode root, int val) {
//         if(root == null){
//             return new TreeNode(val);
//         }
//         preOrder(root, val);
//         return root;
//     }
//     private void preOrder(TreeNode root, int val){
//         if(root == null){
//             return;
//         }
//         if(root.val < val){
//             preOrder(root.right, val);
//         }
//         if(root.val > val){
//             preOrder(root.left, val);
//         }
//         if(flag){
//             TreeNode node = new TreeNode(val);
//             if (root.val < val){
//                 root.right = node;
//             }else{
//                 root.left = node;
//             }
//             flag = false;
//         }
        
//     }
// }


/*
35/35 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 36.43 % of java submissions (39.2 MB)
*/
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
// @lc code=end

