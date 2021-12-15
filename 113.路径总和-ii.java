import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
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

/*
从上到下遍历，考虑使用前序遍历
需要处理返回的值
115/115 cases passed (2 ms)
Your runtime beats 16.89 % of java submissions
Your memory usage beats 5.01 % of java submissions (41.4 MB)
  */
// class Solution {
//     List<List<Integer>> sumList = new ArrayList<>();
//     public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
//         pathRecord(root, targetSum, new ArrayList<Integer>());
//         return sumList;
//     }

//     public void pathRecord(TreeNode root, int targetSum, ArrayList<Integer> list){
//         if(root == null){
//             return;
//         }
//         //复制花了很多时间和空间导致两个复杂度都不行
//         //采用一个队列就可以重复利用一个容器，不能复制了
//         ArrayList<Integer> listSum = (ArrayList<Integer>)list.clone();
//         targetSum -= root.val;
//         listSum.add(root.val);
//         if(root.left == null && root.right == null && targetSum == 0){
//             sumList.add(listSum);
//             return;
//         }
//         if(root.left != null){
//             pathRecord(root.left, targetSum, listSum);
//         }
//         if(root.right != null){
//             pathRecord(root.right, targetSum, listSum);
//         }
        
//     }
// }

/*
115/115 cases passed (1 ms)
Your runtime beats 99.99 % of java submissions
Your memory usage beats 46.77 % of java submissions (38.8 MB)
 */
class Solution {
    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Deque<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ret;
    }

    public void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        //尾部加入
        path.offerLast(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            ret.add(new LinkedList<Integer>(path));
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        //递归完回溯时去掉添加的无用的节点值，恢复要原来的状态
        path.pollLast();
    }
}

// @lc code=end

