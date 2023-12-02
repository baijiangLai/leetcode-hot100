package com.lbj;

import java.util.*;

public class GroupAnagrams_49 {
    public static void main(String[] args) {

    }
    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for(int i = 0; i < strs.length; i++) {
                char[] chars = strs[i].toCharArray();
                Arrays.sort(chars);
                String sortStr = new String(chars);
                List<String> list = map.getOrDefault(sortStr, new ArrayList<>());
                list.add(strs[i]);
                map.put(sortStr, list);
            }
            return new ArrayList<>(map.values());
        }
    }
}
