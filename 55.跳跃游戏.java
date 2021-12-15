/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    /*解题思路：
    对于不是最后一个下标的位置，元素有三种情况
    1.元素为0，则这个位置是废的；
    2.元素值不为0，下标+元素值 >= 最后一个下标值 直接return true;
    3.元素值不为0，下标+元素值 < 最后一个下标值，继续
    */
    //递归算法
    // public boolean canJump(int[] nums) {
    //     return recursion(nums, 0);
    // }
    // private boolean recursion(int[] nums, int index){
    //     if(index + nums[index]>=nums.length){
    //         return true;
    //     }
    //     if(nums[index] == 0){
    //         return false;
    //     }
    //     boolean ret = false;
    //     for (int i = index+1; i <= index + nums[index]; i++){
    //         ret = (ret || recursion(nums, i));
    //     }
    //     return ret;
    // }

    /*
    递归算法有很多重复，可以使用dp数组记录下来，进行剪枝
    1.dp:表示改位置能不能到达最后的位置
    2.状态转移方程：
    (1)如果index + nums[index] >= nums.length，dp[index] = true;
    (2)如果nums[index] == 0，dp[index] = false;
    (3)dp[index] = 循环（dp[index] || dp[j]）
    3.base case:dp[nums.length-2] = nums[nums.length-2] > 0 ? true : false; 
    166/166 cases passed (232 ms)
    Your runtime beats 10.16 % of java submissions
    Your memory usage beats 62.52 % of java submissions (39.7 MB)
    */
    // public boolean canJump(int[] nums) {
    //     if(nums.length == 1){
    //         return true;
    //     }
    //     boolean[] dp = new boolean[nums.length - 1];
    //     dp[nums.length - 2] = (nums[nums.length - 2] > 0);
    //     for(int i = nums.length - 2; i >=0; i--){
    //         if(nums[i] + i >= nums.length - 1){
    //             dp[i] = true;
    //             continue;
    //         }
    //         if(nums[i] == 0){
    //             dp[i] = false;
    //             continue;
    //         }
    //         dp[i] = false;
    //         for(int j = i+1; j <= i + nums[i]; j++){
    //             dp[i] = (dp[i] || dp[j]);
    //         }
    //     }
    //     return dp[0];
    // }
    
    /*
    贪心算法：局部最优再取最优就是全局最优
    1.index位置，通过nums[0]+index得到可以到达最大的位置
    2.遍历下一个位置，如果没有超过上一个位置，则最大位置没有变，
    如果变了则更新最大位置
    3.最大位置>=nums.length-1则返回true
    166/166 cases passed (2 ms)
    Your runtime beats 95.33 % of java submissions
    Your memory usage beats 19.47 % of java submissions (39.9 MB)
    */
    public boolean canJump(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        int rightmost = 0;
        for(int i = 0; i < nums.length-1; i++){
            //如果i>rightmost，说明已经已经断了，就算后面能到，前面
            //也无法到这个位置，再继续也没有任何意义了
            if(i > rightmost){
                break;
            }
            
            rightmost = Math.max(rightmost, i + nums[i]);
            if (rightmost >= nums.length - 1) {
                return true;
            }
            
        }
        return false;
    }
}
// @lc code=end

