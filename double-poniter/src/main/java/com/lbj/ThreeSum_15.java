package com.lbj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1. 还是采用双指针的模式，因为是三数之和，那么如果数组大小都没有超过3，那就一定不可能
 * 2. 首先对数据进行排序
 * 3. 定位第一个指针如何落位？
 *  1. 对当前数组进行遍历，每次循环的时候，这个第一个指针位置就必须在当前位置
 *  2. 如果第一个指针所指的数就大于0了，那么必然就无法满足条件，直接结束整个流程
 *  3. 那么此时第二个指针位置=第一个指针位置 + 1，第三个指针位置 = 最后一个索引
 *  4. 如何判定？
 *      1. 只要第二指针不超过第三指针，此时计算三个指针对应位置的数之和
 *      2. 只要为0，首先需要将这三个数添加到结果中
 *      3. 进行去重，
 *          1. 第二指针小于第三指针并且第二指针和第二指针后面的数一样的话，那么就以为着结果数中已经添加了，就不需要再次比较了，因此第二指针向后移动
 *          2. 同样也是这个规则，第三指针和第三指针前面的数一样的话，那么就需要跳过这个数，第三指针前移
 *      4. 如果没有可以去重的，那么意味着二指针和三指针需要朝着对应的方向移动
 *      5. 如果此时三数之和小0，那么意味着二指针对应的数小了，需要移动
 *      6. 如果此时三数之和大0，那么意味着三指针的数大了，也需要移动
 *
 *
 * 总结：
 * 本题不是一个确定的双指针问题，但是可以进行拆解
 * 1. 确定一指针的位置
 * 2. 二指针永远指向的是一指针+1，三指针永远指向长度最末那个
 * 3. 一指针的作用：确定开始，二指针位置：如果累加和小0就找它，三指针位置：如果累加和大0就找它
 *
 */
public class ThreeSum_15 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = solution.threeSum(nums);
        System.out.println(Arrays.toString(lists.toArray()));
    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            int n = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            if(n < 3){
                return res;
            }
            Arrays.sort(nums);
            for(int i = 0; i < n; i++){
                int firstIdx = i;
                if(nums[firstIdx] > 0){
                    break;
                }
                if(firstIdx > 0 && nums[firstIdx] == nums[firstIdx - 1]){
                    continue;
                }
                int secondIdx = firstIdx + 1, thirdIdx = n - 1;
                //此时三个数基本找到了，但是就需要不断的去重
                while(secondIdx < thirdIdx){
                    int sum = nums[firstIdx] + nums[secondIdx] + nums[thirdIdx];
                    if(sum == 0){
                        res.add(Arrays.asList(nums[firstIdx], nums[secondIdx], nums[thirdIdx]));
                        while(secondIdx < thirdIdx && nums[secondIdx] == nums[secondIdx + 1]) secondIdx++;
                        while(secondIdx < thirdIdx && nums[thirdIdx] == nums[thirdIdx - 1]) thirdIdx--;
                        secondIdx++;
                        thirdIdx--;
                    }else if(sum < 0){
                        secondIdx++;
                    }else if(sum > 0){
                        thirdIdx--;
                    }
                }
            }
            return res;
        }
    }
}
