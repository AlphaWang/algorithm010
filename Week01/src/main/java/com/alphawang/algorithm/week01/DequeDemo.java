package com.alphawang.algorithm.week01;

import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {

    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        deque.offerFirst("d");
        deque.offerLast("x");
        
        System.out.println(deque);
        
        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);
        
        while (deque.size() > 0) {
//            System.out.println(deque.pop());
//            System.out.println(deque.poll());
            System.out.println(deque.pollFirst()); // return null if empty
//            System.out.println(deque.getFirst()); // throws exception if empty
        }
        System.out.println(deque);
        
    }

}
