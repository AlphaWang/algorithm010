package com.alphawang.algorithm.week04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-ladder/
 * Medium
 */
public class T0127_WordLadder {

    /**
     * 1. DFS
     *    TODO: 未调试成功
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        
        Map<String, List<String>> patterns = initPatterns(wordList);

        Set<String> visited = new HashSet<>(); 
        visited.add(beginWord);
        return dfs(beginWord, endWord, patterns, 0, beginWord.length(), visited, wordList.size());
    }

    private int dfs(String beginWord, String endWord, Map<String, List<String>> patterns, int step, int length, Set<String> visited, int max) {
        if (beginWord.equals(endWord)) {
            return step;
        }
        if (step > max) {
            return 0;
        }
        
        for (int i = 0; i < length; i++) {
            String pattern = toPattern(beginWord, i);
            List<String> matchedWords = patterns.get(pattern);
            if (matchedWords == null) {
                 continue;
            }
            
            int min = Integer.MAX_VALUE;
            for (String matchedWord : matchedWords) {
                if (visited.contains(matchedWord)) {
                    continue;
                }
                visited.add(matchedWord);
                int substep = dfs(matchedWord, endWord, patterns, step + 1, length, visited, max);
                min = Math.min(min, substep);
                visited.remove(matchedWord);
            }
            return min;
        }
        
        return Integer.MAX_VALUE;
    }

    /**
     * 2. BFS
     *    68ms - 55%
     */
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        int length = beginWord.length();
        Map<String, List<String>> patterns = initPatterns(wordList);

        int steps = 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        while(!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for (int s = 0; s < size; s++) {
                System.out.println(String.format("[%s] %s", steps, queue));
                String word = queue.poll();
                
                if (endWord.equals(word)) {
                    return steps;
                }

                for (int i = 0; i < length; i++) {
                    String pattern = toPattern(word, i);
                    List<String> matched = patterns.get(pattern);
                    if (matched == null) {
                        continue;
                    } else {
                        for (String m : matched) {
                            if (!visited.contains(m)) {
                                queue.offer(m);
                                visited.add(m);
                            }

                        }
                    }
                }
            }
            
        }
        return 0;
    }

    private Map<String, List<String>> initPatterns(List<String> wordList) {
        Map<String, List<String>> patterns = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String pattern = toPattern(word, i);
                List<String> matched = patterns.getOrDefault(pattern, new ArrayList<>());
                matched.add(word);
                patterns.put(pattern, matched);
            }
        }
        
        return patterns;
    }


    private String toPattern(String word, int index) {
        char[] pattern = word.toCharArray();
        pattern[index] = '*';
        
        return String.valueOf(pattern);
    }

    public static void main(String[] args) {
        

        /*
         * beginWord = "hit",
         * endWord = "cog",
         * wordList = ["hot","dot","dog","lot","log","cog"]
         *
         * Output: 5
         *
         * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
         * return its length 5.
         */
        test("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));

        /*
         * Input:
         * beginWord = "hit"
         * endWord = "cog"
         * wordList = ["hot","dot","dog","lot","log"]
         *
         * Output: 0
         *
         * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
         */
        test("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log"));

        /*
         * 0
         */
        test("hot", "dog", Arrays.asList("hot", "dog"));
    }
    
    private static void test(String beginWord, String endWord, List<String> wordList) {
        T0127_WordLadder sut = new T0127_WordLadder();
        System.out.println(String.format("%s : %s --> %s", wordList, beginWord, endWord));
        System.out.println(sut.ladderLength2(beginWord, endWord, wordList));
    }


}
