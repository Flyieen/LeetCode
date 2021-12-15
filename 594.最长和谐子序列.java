/*
 * @lc app=leetcode.cn id=594 lang=java
 *
 * [594] 最长和谐子序列
 */

// @lc code=start
class Solution {
    /*
    注意子序列并没有要求要连续
    哈希表保存序列的次数，然后遍历hash表

    206/206 cases passed (15 ms)
    Your runtime beats 66.55 % of java submissions
    Your memory usage beats 95.88 % of java submissions (38.9 MB)
    */
    public int findLHS(int[] nums) {
        Map<Integer, Integer> countForNum = new HashMap<>();
        for (int num : nums) {
            countForNum.put(num, countForNum.getOrDefault(num, 0) + 1);
        }
        int longest = 0;
        for (int num : countForNum.keySet()) {
            if (countForNum.containsKey(num + 1)) {
                longest = Math.max(longest, countForNum.get(num + 1) + countForNum.get(num));
            }
        }
        return longest;
    }
}
// @lc code=end

