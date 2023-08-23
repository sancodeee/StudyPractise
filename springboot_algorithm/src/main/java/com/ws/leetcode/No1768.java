package com.ws.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 交替合并字符串
 */
@Slf4j
public class No1768 {

    @Test
    public void test() {
        String word1 = "1234";
        String word2 = "abcd";
        log.info("合并后的字符串是：{}", mergeAlternately(word1, word2));
    }

    public String mergeAlternately(String word1, String word2) {
        StringBuilder appendWord1 = new StringBuilder().append(word1);
        StringBuilder appendWord2 = new StringBuilder().append(word2);
        StringBuilder result = new StringBuilder();
        if (appendWord1.length() >= appendWord2.length()) {
            for (int i = 0; i < appendWord1.length(); i++) {
                char c1 = appendWord1.charAt(i);
                result.append(c1);
                if (i < appendWord2.length()) {
                    char c2 = appendWord2.charAt(i);
                    result.append(c2);
                }

            }
            return result.toString();
        } else {
            for (int i = 0; i < appendWord2.length(); i++) {
                if (i < appendWord1.length()) {
                    char c1 = appendWord1.charAt(i);
                    result.append(c1);
                }
                char c2 = appendWord2.charAt(i);
                result.append(c2);
            }
            return result.toString();
        }
    }

}
