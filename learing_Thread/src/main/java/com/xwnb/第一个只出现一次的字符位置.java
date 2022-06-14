package com.xwnb;

import java.util.BitSet;
import java.util.HashMap;

/**
 * Input: abacc
 * Output: b
 */
public class 第一个只出现一次的字符位置 {
    public static void main(String[] args) {
        String str = "abacc";
        HashMap<String, Integer> stringIntegerHashMap = firstWordIndex(str);
        for (String s : stringIntegerHashMap.keySet()) {
            if (stringIntegerHashMap.get(s) == 1) {
                System.out.println(s);
                return;
            }
        }

    }

    /**
     * 使用 HashMap 对出现次数进行统计
     * @param str
     * @return
     */
    public static HashMap<String, Integer> firstWordIndex(String str) {
        int a = 1;
        HashMap<String, Integer> charHash = new HashMap<>(str.length());
        for (int i = 0; i < str.length(); i++) {
            String s = String.valueOf(str.charAt(i));
            if (charHash.containsKey(s)) {
                charHash.put(s, charHash.get(s) + 1);
            } else {
                charHash.put(s, a);
            }
        }
        return charHash;
    }

    /**
     *ASCII 码只有 128 个字符，因此可以使用长度为 128 的整型数组来存储每个字符出现的次数。
     */
    public int FirstNotRepeatingChar(String str) {
        int[] cnts = new int[128];
        for (int i = 0; i < str.length(); i++) {
            cnts[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (cnts[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 考虑到只需要找到只出现一次的字符，那么需要统计的次数信息只有 0,1,更大，使用两个比特位就能存储这些信息。
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar2(String str) {
        BitSet bs1 = new BitSet(128);
        BitSet bs2 = new BitSet(128);
        for (char c : str.toCharArray()) {
            if (!bs1.get(c) && !bs2.get(c)) {
                bs1.set(c);     // 0 0 -> 0 1
            } else if (bs1.get(c) && !bs2.get(c)) {
                bs2.set(c);     // 0 1 -> 1 1
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (bs1.get(c) && !bs2.get(c))  // 0 1
            {
                return i;
            }
        }
        return -1;
    }
}
