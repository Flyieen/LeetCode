import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
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

//采用中序遍历，看下一个值是否是大于上一个值
/**
 * 80/80 cases passed (2 ms)
    Your runtime beats 19.63 % of java submissions
    Your memory usage beats 9.2 % of java submissions (38.3 MB)
 */
//暴力解法，把中序遍历结果存到list中，遍历list看是否有序
// class Solution {
//     List<Integer> list = new ArrayList<Integer>();
//     public boolean isValidBST(TreeNode root) {
//         if(root == null){
//             return false;
//         }
//         boolean flag = true;
//         isTrue(root);
//         int value = list.get(0);
//         for(int i = 1; i < list.size(); i++){
//             if(list.get(i) <= value){
//                 flag = false;
//             }
//             value = list.get(i);
//         }
//         return flag;
//     }

//     public void isTrue(TreeNode root){
//         if(root == null){
//             return;
//         }
//         isTrue(root.left);
//         list.add(root.val);
//         isTrue(root.right);
//     }
// }


/**
 * 自己写的第二个版本，本质上就是用一个数字记录最小的值，然后看
 * 后一节点的值是否大于前一个节点的值
 * 80/80 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 99 % of java submissions (37.5 MB)
 */
class Solution {
    boolean ret = true;
    boolean flag = true;
    int value = 0;
    boolean flag2 = true;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return false;
        }
        isTrue(root);
        return ret;
    }

    public void isTrue(TreeNode root){
        if(root == null){
            return;
        }
        isTrue(root.left);
        if(flag){
            value = root.val;
            flag = false;   
        }
        
        if(flag == false && root.val <= value){
            ret = false;
        }
        if(flag2 == true  && root.val <= value){
            flag2 = false;
            ret = true;
        }
        value = root.val;
        isTrue(root.right);
    }
}

/*
long类型太大了，占内存
80/80 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 54.63 % of java submissions (38 MB)
 */
// class Solution {
//     long pre = Long.MIN_VALUE;
//     public boolean isValidBST(TreeNode root) {
//         if (root == null) {
//             return true;
//         }
//         // 访问左子树
//         if (!isValidBST(root.left)) {
//             return false;
//         }
//         // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
//         if (root.val <= pre) {
//             return false;
//         }
//         pre = root.val;
//         // 访问右子树
//         return isValidBST(root.right);
//     }
// }

// @lc code=end

