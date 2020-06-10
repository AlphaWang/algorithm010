package com.alphawang.algorithm.week01;

import java.util.Arrays;

public class T0026_RemoveDuplicatesFromSortedArray {

    /**
     * 1. 开辟新数组，遍历原数组 并拷贝非重复元素到新数组
     * 2. 双指针遍历，遇到非重复的元素则拷贝到index+1指针处
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                nums[++index] = nums[i];
            }
        }

        return ++index;
    }
    
    public static void main(String[] args) {
        T0026_RemoveDuplicatesFromSortedArray sut = new T0026_RemoveDuplicatesFromSortedArray();

        int[] nums = new int[] {1,2};
        System.out.println(sut.removeDuplicates(nums)); // 2
        System.out.println(Arrays.toString(nums)); // [1, 2]

        nums = new int[] {1,2,3};
        System.out.println(sut.removeDuplicates(nums)); // 3
        System.out.println(Arrays.toString(nums)); // [1, 2, 3]
        
        nums = new int[] {1,1,2};
        System.out.println(sut.removeDuplicates(nums)); // 2
        System.out.println(Arrays.toString(nums)); // [1, 2, ..]

        nums = new int[] {1,1,2, 2};
        System.out.println(sut.removeDuplicates(nums)); // 2
        System.out.println(Arrays.toString(nums)); // [1, 2, ..]

        nums = new int[] {1,1,2, 3};
        System.out.println(sut.removeDuplicates(nums)); // 3
        System.out.println(Arrays.toString(nums)); // [1, 2, 3..]

        nums = new int[] {0,0,1,1,1,2,2,3,3,4};
        System.out.println(sut.removeDuplicates(nums)); // 5
        System.out.println(Arrays.toString(nums)); // [0, 1, 2, 3, 4, ..]
    }

}
