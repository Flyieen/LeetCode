import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=501 lang=java
 *
 * [501] 二叉搜索树中的众数
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

//中序遍历，变成一个整体递增的序列
// class Solution {
//     private int curCnt = 1; //现在的值出现的次数
//     private int maxCnt = 1; //最大值
//     private TreeNode preNode = null;
//     public int[] findMode(TreeNode root) {
//         List<Integer> maxCntNums = new ArrayList<>();
//         inOrder(root, maxCntNums);
//         Integer[] ret = new Integer[maxCntNums.size()];
//         for (int i = 0; i < ret.length; i++) {
//             ret[i] = maxCntNums.get(i);
//         }
//         return ret;
//     }
//     private void inOrder(TreeNode node, List<Integer> nums) {
//         if (node == null) return;
//         inOrder(node.left, nums);
//         if (preNode != null) {
//             if (preNode.val == node.val) curCnt++;
//             else curCnt = 1;
//         }
//         if (curCnt > maxCnt) {
//             maxCnt = curCnt; //说明之前加的都不是众数
//             nums.clear();    //清空ArrayList
//             nums.add(node.val); //把新的值加入
//         } else if (curCnt == maxCnt) {
//             nums.add(node.val);
//         }
//         preNode = node;
//         inOrder(node.right, nums);
//     }
// }

/**
 * 23/23 cases passed (0 ms)
    Your runtime beats 100 % of java submissions
    Your memory usage beats 79.52 % of java submissions (38.8 MB)
 */
class Solution {
    private int curCnt = 0; //现在的值出现的次数
    private int maxCnt = 0; //最大值
    private int curValue = 0; //用一个int值替换node，节省空间
    public int[] findMode(TreeNode root) {
        List<Integer> maxCntNums = new ArrayList<>();
        inOrder(root, maxCntNums);
        int[] ret = new int[maxCntNums.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = maxCntNums.get(i);
        }
        return ret;
    }
    private void inOrder(TreeNode node, List<Integer> nums) {
        if (node == null) return;
        inOrder(node.left, nums);
        if(curValue == node.val){
            curCnt++;
        }else {
            curCnt = 1;
        }
        if (curCnt > maxCnt) {
            maxCnt = curCnt; //说明之前加的都不是众数
            nums.clear();    //清空ArrayList
            nums.add(node.val); //把新的值加入
        } else if (curCnt == maxCnt) {
            nums.add(node.val);
        }
        curValue = node.val;
        inOrder(node.right, nums);
    }
}

// @lc code=end

