package com.xwnb.leetcode;

import java.util.HashMap;

/**
 * @author Jxiaowei
 */
public class L1_TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,3,1,5};
        int[] ints = new L1_TwoSum().twoSum(nums, 7);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }


    /**
     *              给出的有两个参数(数组和目标参数) 正推算---数组中两个数相加得到target，需要循环遍历时间复杂度：O(n)^2
     *                                         反推算---target-数组中数字
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] indexs = new int[2];

        //建立k-v，一一对应的哈希表
        HashMap<Integer, Integer> hash = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])){
                indexs[0] = i;
                indexs[1] = hash.get(nums[i]);
            }
            //讲数据存入 ，key为补数，value为下标
            hash.put(target-nums[i],i);
        }
        return indexs;
    }
}
