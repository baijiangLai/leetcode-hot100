package com.lbj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals_56 {
    public static void main(String[] args) {

    }
    static class Solution {
        public int[][] merge(int[][] intervals) {
            int n = intervals.length;
            Arrays.sort(intervals,new Comparator<int[]>(){
                public int compare(int[] v1, int[] v2){
                    return v1[0] - v2[0];
                }
            });
            List<int[]> res = new ArrayList<>();
            for(int i = 0; i < n; i++){
                int left = intervals[i][0], right = intervals[i][1];
                //现在的情况是第一次添加或者结果列表前一个的右边小于现在的左边，那么就直接进行合并
                if(res.size() == 0 || res.get(res.size() - 1)[1] < left){
                    res.add(new int[]{left, right});
                }else {
//                否则，就是前一个的右边大于现在的左边，那么右边的边界就是当前的右边和前一个右边的最大的
                    res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], right);
                }
            }
            return res.toArray(new int[res.size()][]);
        }
    }
}
