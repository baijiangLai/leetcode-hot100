package com.lbj;
import java.util.Arrays;

/**
 * 解决思路：官方建议是双指针解决，
 * 1. 首先要明确这两个指针应该是什么位置，是否是像传统的收尾指针？
 * 2. 确定好指针位置（找0），那么此时指针就应该分为找0指针和不找0的指针
 * 3. 如何进行交换？
 *    1. 移动哪个指针？ 由于此题需要不断的去找非0的元素，并且最终非0的相对位置不能改变，那么只能移动非0的指针
 *    2. 当非0指针找到一个元素的时候，此时元素一定是非0的，那么此时就交换0指针，这样就确保了0元素一定是在非0元素后面；交换完成之后，由于0已经开始移动了，那么此时0指针也需要向后移动
 *    3. 如果当前非0指针找到的是0元素，那么接着向后移动即可，直至到边界
 */

public class MoveZero_283 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0,1,0,3,12};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    static class Solution {
        public void moveZeroes(int[] nums) {
            int size = nums.length;
            int notZeroIdx = 0, zeroIdx = 0;
            while (notZeroIdx < size) {
                if (nums[notZeroIdx] != 0) {
                    swap(nums, zeroIdx, notZeroIdx);
                    zeroIdx++;
                }
                notZeroIdx++;
            }

        }

        private void swap(int[] nums, int l, int r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
    }
}
