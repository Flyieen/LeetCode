import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=108 lang=java
 *
 * [108] 将有序数组转换为二叉搜索树
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

//二分法递归还原
/*
31/31 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 25.34 % of java submissions (38.3 MB)
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        //题目已经说了数组长度最小为1
        int length = nums.length;
        if(length == 1){
            return new TreeNode(nums[0]);
        }
        TreeNode root = new TreeNode(nums[length / 2]);
        root.left = dichotomy(nums, 0, length / 2 - 1);
        root.right = dichotomy(nums, length / 2 + 1, length - 1);
        return root;
    }

    private TreeNode dichotomy(int[] nums, int start, int end){
        if (start > end) {
            return null;
        }
        int mid = (end - start)/2 + start;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dichotomy(nums, start, mid - 1);
        root.right = dichotomy(nums, mid + 1, end);
        return root;
    }
}

/**
 * 别人的解法，相当简单易懂，还是要加油呀，自己写的太啰嗦了
 */
// class Solution {
//     public TreeNode sortedArrayToBST(int[] nums) {
//         return dfs(nums, 0, nums.length - 1);
//     }

//     private TreeNode dfs(int[] nums, int lo, int hi) {
//         if (lo > hi) {
//             return null;
//         } 
//         // 以升序数组的中间元素作为根节点 root。
//         int mid = lo + (hi - lo) / 2;
//         TreeNode root = new TreeNode(nums[mid]);
//         // 递归的构建 root 的左子树与右子树。
//         root.left = dfs(nums, lo, mid - 1);
//         root.right = dfs(nums, mid + 1, hi); 
//         return root;
//     }
// }

// @lc code=end

