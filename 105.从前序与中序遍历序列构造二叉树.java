import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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

/**
     * 203/203 cases passed (1 ms)
    Your runtime beats 99.21 % of java submissions
    Your memory usage beats 84.75 % of java submissions (38.2 MB)
  */
class Solution {
    HashMap<Integer, Integer> inorderArrayMap =  new HashMap<Integer, Integer>();
    int pre[];
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++){
            inorderArrayMap.put(inorder[i], i);
        }
        pre = preorder;
        TreeNode root = buildTree(0, inorder.length -1, 0, preorder.length-1);
        return root;
    }

    //从上到下，所以考虑采用前序遍历
    public TreeNode buildTree(int is, int ie, int ps, int pe){
        if(ie < is || pe < ps){
            return null;
        }
        int root = pre[ps];
        TreeNode node = new TreeNode(root);
        int ri = inorderArrayMap.get(root); //获得根节点的位置
        node.left = buildTree(is,ri - 1,ps + 1,ps + ri - is);
        node.right = buildTree(ri + 1, ie, ps + ri -is + 1, pe);
        return node;
    }
}
// @lc code=end

