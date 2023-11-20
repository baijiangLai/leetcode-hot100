package com.lbj;

/**
 * 思路：
 * 1. 使用双指针
 * 2. 确定双指针的位置？ 因为这是要求一个最大，那么此时双指针应该是首尾两个。
 * 3. 面积怎么算？ 长*高
 *    1. 长：尾指针 - 首指针
 *    2. 高度： 选择首指针对应的高度和尾指针高度的最小者。只有这样才能接水
 */
public class ContainerWithMostWater_11 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = {1,8,6,2,5,4,8,3,7};
        int maxArea = solution.maxArea(height);
        System.out.println(maxArea);
    }
    static class Solution {
        public int maxArea(int[] height) {
            int size = height.length;
            int l = 0 , r = size - 1;
            int res = 0;
            while(l != r) {
                if(height[l] < height[r]) {
                    res = Math.max(res, (r - l) * height[l]);
                    l++;
                } else {
                    res = Math.max(res, (r - l) * height[r]);
                    r--;
                }
            }
            return res;
        }
    }
}
