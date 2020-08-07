package com.alphawang.algorithm.week09;

public class T0344_ReverseString {

    public void reverseString(char[] s) {
        if (s == null || s.length <= 1) {
            return;
        }
        
        int left = 0, right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        test(new char[] {'h', 'e', 'l', 'l', 'o'});
    }
    
    private static void test(char[] s) {
        System.out.println(String.valueOf(s));
        new T0344_ReverseString().reverseString(s);
        System.out.println(String.format("-> %s", String.valueOf(s)));
    }
}
