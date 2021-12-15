/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start
class Solution {
    /*
    力扣上没有纯0-1背包问题，所以要转化问题
    整个数组的和为sum
    给一个可装载sum/2的背包和N个物品，每个物品的重量为nums[i]，
    现在让你装物品，是否存在一种装法，能够恰好使得背包装满

    动态规划五部：
    1、dp[i][j]:对于前i个物品，能装入背包的最大值
    2、转移方程：
    //装入或不装入背包，看看能够存在一种情况恰好能装满
    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-nums[i]])
    3、base case：dp[..][0] = 0 dp[0][..]=0
    4、遍历方向：从左上到右下
    5、举例：

    117/117 cases passed (33 ms)
    Your runtime beats 39.7 % of java submissions
    Your memory usage beats 5.12 % of java submissions (48.4 MB)
    */
    // public boolean canPartition(int[] nums) {
    //     if(nums.length == 1){
    //         return false;
    //     }
    //     int sum = 0;
    //     for (int num : nums){
    //         sum += num;
    //     }
    //     if(sum % 2 != 0){
    //         return false;
    //     }
    //     sum /= 2;
    //     int[][] dp = new int [nums.length+1][sum+1];
    //     for(int i = 1; i <= nums.length; i++){
    //         for(int j = 1; j <= sum; j++){
    //             if (j < nums[i - 1]){
    //                 dp[i][j] = dp[i - 1][j];
    //             }else{
    //                 dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i - 1]] + nums[i - 1]);
    //             }
    //         }
    //     }
    //     return dp[nums.length][sum] == sum;
        
    // }
    

    /*状态压缩，注意这里j要从后往前遍历
    因为没有了dp[i-1][j-nums[i-1]] 中的i-1用来标识，如果只是从前往后
    就会导致在dp[i][j-nums[i-1]]的基础上再加，会导致重复加

    117/117 cases passed (19 ms)
    Your runtime beats 82.48 % of java submissions
    Your memory usage beats 66.9 % of java submissions (37.8 MB)
    */
    // public boolean canPartition(int[] nums) {
    //     if(nums.length == 1){
    //         return false;
    //     }
    //     int sum = 0;
    //     for (int num : nums){
    //         sum += num;
    //     }
    //     if(sum % 2 != 0){
    //         return false;
    //     }
    //     sum /= 2;
    //     int[] dp = new int[sum+1];
    //     for(int i = 0; i < nums.length; i++){
    //         for(int j = sum; j >= nums[i]; j--){//注意这里已经进行了判断
    //             dp[j] = Math.max(dp[j], dp[j-nums[i]]+nums[i]);
    //         }
    //     }
    //     return dp[sum] == sum;
    // }
    

    /*
    117/117 cases passed (28 ms)
    Your runtime beats 52.3 % of java submissions
    Your memory usage beats 77.4 % of java submissions (37.7 MB)
    */
    public boolean canPartition(int[] nums) {
        if(nums.length == 1){
            return false;
        }
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        if(sum % 2 != 0){
            return false;
        }
        sum /= 2;
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        for(int i = 0; i < nums.length; i++){
            for(int j = sum; j >= nums[i]; j--){//注意这里已经进行了判断
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }
        return dp[sum];
    }
}
// @lc code=end

