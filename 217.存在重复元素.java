/*
 * @lc app=leetcode.cn id=217 lang=java
 *
 * [217] 存在重复元素
 */

// @lc code=start
class Solution {
    /*
    哈希遍历
    20/20 cases passed (6 ms)
    Your runtime beats 33.93 % of java submissions
    Your memory usage beats 13.81 % of java submissions (45.2 MB)
    */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() < nums.length;
    }
}
// @lc code=end

