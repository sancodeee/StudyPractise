package com.ws.nowcoder;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Scanner;

//字符串最后一个单词的长度
public class HJ1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.nextLine();
        int i = LastStringLength(next);
        System.out.println(i);
        scanner.close();
    }

    //最后一个字符串长度
    public static int LastStringLength(@NotNull String str) {
        String[] split = str.split(" ");
        int i = split.length - 1;
        String s = split[i];
        return s.length();
    }

}
