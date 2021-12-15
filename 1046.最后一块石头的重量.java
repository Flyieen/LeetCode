import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1046 lang=java
 *
 * [1046] 最后一块石头的重量
 */

// @lc code=start
class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 0){
            return stones[0];
        }
        Arrays.sort(stones);
        int n = stones.length;
        int pre = n-2, post = n-1;
        while(pre >= 0){
            if(stones[pre] == stones[post]){
                pre -= 2;
                post -= 2;
                continue;
            }else {
                stones[pre] = stones[post] - stones[pre];
                Arrays.sort(stones);
                pre--;
                post--;
            }
        }
        return post < 0 ? 0 : stones[0];

    }

    //官方采用最大堆，priorityQueue调库
}
// @lc code=end

