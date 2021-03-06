package com.alphawang.algorithm.week01;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/plus-one/
 * Easy
 */
public class T0066_PlusOne {

    /**
     * 从后往前遍历 +1
     * 0 ms
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] + 1;
            if (digits[i] < 10) {
                return digits;
            }

            digits[i] = digits[i] % 10;
        }

        // 可继续优化：走到这一步，表示一定要进位，且后面的数字一定是全零
        if (digits[0] == 0) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            System.arraycopy(digits, 0, res, 1, digits.length);
            return res;
        }

        return digits;
    }

    /**
     * 优化全9的情况
     */
    public int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] + 1;
            if (digits[i] < 10) {
                return digits;
            }

            digits[i] = digits[i] % 10;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;

        return digits;
    }

    public static void main(String[] args) {
        T0066_PlusOne sut = new T0066_PlusOne();
        
        int[] nums = new int[] {1, 2, 3};
        System.out.println(Arrays.toString(sut.plusOne2(nums))); //[1, 2, 4]

        nums = new int[] {4,3,2,1};
        System.out.println(Arrays.toString(sut.plusOne2(nums))); //[4, 3, 2, 2]

        nums = new int[] {9, 9, 9};
        System.out.println(Arrays.toString(sut.plusOne2(nums))); //[1, 0, 0, 0]
    }

}
