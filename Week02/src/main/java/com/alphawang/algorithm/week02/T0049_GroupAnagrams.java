package com.alphawang.algorithm.week02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/group-anagrams/
 */
public class T0049_GroupAnagrams {

    /**
     * 1. 哈希：key = 字符数目数组, value = 原始字符串
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> arrMap = new HashMap<>();
        for (String s : strs) {
            String encode = toArray(s);
            arrMap.computeIfAbsent(encode, k -> new ArrayList<>()).add(s);
        }
        
        return new ArrayList<>(arrMap.values());
    }
    
    private String toArray(String str) {
        int[] array = new int[26];
        for (char c : str.toCharArray()) {
            array[c - 'a']++;
        }
        return Arrays.toString(array);
    }


    public static void main(String[] args) {
        
        T0049_GroupAnagrams sut = new T0049_GroupAnagrams();
        
        /*
        [
          ["ate","eat","tea"],
          ["nat","tan"],
          ["bat"]
        ]
         */
        System.out.println(sut.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
    
}
