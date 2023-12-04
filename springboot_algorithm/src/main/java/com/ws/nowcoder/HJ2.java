package com.ws.nowcoder;

import java.util.Scanner;

/**
 * 计算某字符出现的次数
 */
public class HJ2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String c = scanner.nextLine();

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            String c1 = new String(new char[]{str.charAt(i)});
            if (c.equalsIgnoreCase(c1)) {
                count++;
            }
        }
        System.out.println(count);
    }

}
