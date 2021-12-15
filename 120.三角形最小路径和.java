import java.util.List;

/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */

// @lc code=start
class Solution {
    /*解题思路
    1、dp：dp表示从这个节点向下的最小路径和
    2、状态转移方程：dp[i] = Math.min(左边和，右边和)
    3、base case: 最后一层的元素
    空间优化：可以在原始元素上修改，不需要单独设置dp

    44/44 cases passed (8 ms)
    Your runtime beats 9.85 % of java submissions
    Your memory usage beats 42.96 % of java submissions (38.2 MB)
    */
    // public int minimumTotal(List<List<Integer>> triangle) {
    //     if(triangle.size() == 1){
    //         return triangle.get(0).get(0);
    //     }
    //     for(int i = triangle.size() - 2; i >= 0; i--){
    //         for(int j = 0; j < triangle.get(i).size(); j++){
    //             List<Integer> list = triangle.get(i);
    //             int min = Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1));
    //             list.set(j, list.get(j) + min);
    //         }
    //     }
    //     return triangle.get(0).get(0);
    // }

    //设置了一个dp数组保存
    /*
    不太明白为什么设置了一个额外数组保存就可以提高这么多
    1、考虑是数组取值和赋值快很多
    2、至于为什么上个解法费空间，不明白
    44/44 cases passed (3 ms)
    Your runtime beats 83.89 % of java submissions
    Your memory usage beats 55.82 % of java submissions (38.1 MB)
    */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
// @lc code=end

