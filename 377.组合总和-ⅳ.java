/*
 * @lc app=leetcode.cn id=377 lang=java
 *
 * [377] 组合总和 Ⅳ
 */

// @lc code=start
class Solution {
    /*
    完全背包问题：和零钱问题Ⅱ对应，那个问题是组合问题
    排列和组合的区别就在于顺序不同的序列是否会被视作不同的组合
    如果求组合数就是外层for循环遍历物品，内层for遍历背包。
    如果求排列数就是外层for遍历背包，内层for循环遍历物品。

    如果把遍历nums（物品）放在外循环，遍历target的作为内循环的话，
    举一个例子：计算dp[4]的时候，结果集只有
    {1,3} 这样的集合，不会有{3,1}这样的集合，因为nums遍历放在外层，
    只能出现在1后面！

    15/15 cases passed (1 ms)
    Your runtime beats 96.79 % of java submissions
    Your memory usage beats 84.79 % of java submissions (35.5 MB)
    */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i = 0; i <= target; i++){
            for(int j = 0; j < nums.length; j++){
                if(i >= nums[j]){
                    dp[i] += dp[i- nums[j]]; 
                }
            }
        }
        return dp[target];
    }
}
// @lc code=end

