package com.lbj;

/**
 * 本题是一个经典的dp题目：
 * 1. 定义：dp[i]表示到第i个位置最大的子数组和
 * 2. 那么dp[i] = Math.max(dp[i - 1] + num[i], nums[i])
 * 3. 最终的结果一定是表中最大的那个数，由于可能存在负数，因此，dp[n - 1]不是最大的那个数，最大的数应该是每次比较的时候dp[i]和结果最大的数比较而来的
 */
public class MaximumSubarray_53 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int maxSubArray = solution.maxSubArray(nums);
        System.out.println(maxSubArray);
    }

    static class Solution {
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            dp[0] = nums[0];
            int res = nums[0];
            for(int i = 1; i < n; i++) {
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }
}
