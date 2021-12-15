/*
 * @lc app=leetcode.cn id=957 lang=java
 *
 * [957] N 天后的牢房
 */

// @lc code=start
class Solution {
    /* 
    首先，第一个和最后一个最后一定是0，所以只用考虑中间的牢房

    动态规划：
    该方法会超时，本来我们也不需要整个dp
    1、dp[j]：第j个值第i次的值
    2、转移方程：dp[j] = cells[j-1] == cells[j+1] ? 1 : 0;
    3、初值：dp[0] = 0, dp[7] = 0;
    */
    // public int[] prisonAfterNDays(int[] cells, int n) {
    //     int[] dp = new int[8];
    //     for(int i = 1; i <= n; i++){
    //         for(int j = 1; j < cells.length-1; j++){
    //             dp[j] = cells[j-1] == cells[j+1] ? 1 : 0;
    //         }
    //         for(int j = 0; j < 8; j++){
    //             cells[j] = dp[j];
    //         }
    //     }
    //     return cells;
    // }
    
    /* 仍然会超时*/
    // public int[] prisonAfterNDays(int[] cells, int n) {
    //     int dp0 = 0;
    //     int dp1 = 0;
    //     for(int i = 1; i <= n; i++){
    //         for(int j = 1; j < 7; j++){
    //              //先把结果存在来
    //             dp1 = cells[j-1] == cells[j+1] ? 1 : 0;
    //              //改变cells[j-1]
    //             cells[j-1] = dp0;
    //             dp0 = dp1;
    //         }
    //          //因为循环不会改变cells[6]，需要手动修改
    //         cells[6] = dp1;
    //          //dp0不归为0的话下一轮cells[j-1]=dp0会出问题
    //         dp0 = 0;
    //         if(i == 1){
    //             cells[7] = 0; 
    //         }
    //     }
    //     return cells;
    // }
    

    /*
    对于长度为8的数组一共有256中情况，所以一定会出现循环
    我们可以当状态循环出现的时候记录下循环的周期 t 然后
    跳过 t 的倍数的天数。

    算法：实现一个简单的模拟，每次迭代一天的情况。对于每一天，我们
    减少剩余的天数 N，然后将监狱状态改变成
    （state -> nextDay(state)）。
    如果我们到达一个已经访问的状态，并且知道距当前过去了多久，
    设为 t，那么由于这是一个循环，可以让 N %= t
    
    267/267 cases passed (2 ms)
    Your runtime beats 63.49 % of java submissions
    Your memory usage beats 97.14 % of java submissions (38.2 MB)
    */
    public int[] prisonAfterNDays(int[] cells, int N) {
        //用hashMap存储可能出现的情况，如果出现重复就不需要再算了
        Map<Integer, Integer> seen = new HashMap();

        // state  = integer representing state of prison
        int state = 0;
        for (int i = 0; i < 8; ++i) {
            //将[0,1,0,1,1,0,0,1]转变成01011001，运算起来方便
            if (cells[i] > 0)
                state ^= 1 << i;
        }

        // While days remaining, simulate a day
        while (N > 0) {
            // If this is a cycle, fast forward by
            // seen.get(state) - N, the period of the cycle.
            if (seen.containsKey(state)) {
                N %= seen.get(state) - N;
            }
            seen.put(state, N);

            if (N >= 1) {
                N--;
                state = nextDay(state);
            }
        }

        // Convert the state back to the required answer.
        int[] ans = new int[8];
        for (int i = 0; i < 8; ++i) {
            if (((state >> i) & 1) > 0) {
                ans[i] = 1;
            }
        }

        return ans;
    }

    public int nextDay(int state) {
        int ans = 0;

        // We only loop from 1 to 6 because 0 and 7 are impossible,
        // as those cells only have one neighbor.
        for (int i = 1; i <= 6; ++i) {
            if (((state >> (i-1)) & 1) == ((state >> (i+1)) & 1)) {
                ans ^= 1 << i;
            }
        }

        return ans;
    }
}
// @lc code=end

