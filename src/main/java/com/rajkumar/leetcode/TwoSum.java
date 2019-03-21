package com.rajkumar.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) throws IllegalArgumentException {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i < nums.length; i++) {
            int res = target - nums[i];
            if(map.containsKey(res)) {
                return new int[]{map.get(res), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No sum");
    }

    public static void main(String[] args) {

    }
}
