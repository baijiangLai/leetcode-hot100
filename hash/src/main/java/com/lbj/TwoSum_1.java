package com.lbj;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
    public static void main(String[] args) {

    }
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int i =  0; i < nums.length; i++){
                if(!map.containsKey(target - nums[i])) {
                    // 2, 0
                    map.put(nums[i], i);
                } else {
                    return new int[]{i, map.get(target - nums[i])};
                }
            }
            return new int[0];
        }
    }
}
