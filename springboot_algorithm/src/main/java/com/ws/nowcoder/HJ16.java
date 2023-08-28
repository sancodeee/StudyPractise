package com.ws.nowcoder;

import java.util.Scanner;

public class HJ16 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int sum = in.nextInt();
        int num = in.nextInt();
        in.nextLine();
        //价格、满意度、所属
        int [][] items = new int[num][3];
        int [][] appendix = new int[num][2];

        for (int i = 0; i < num; i++) {
            items[i][0] = in.nextInt();
            items[i][1] = in.nextInt();
            items[i][2] = in.nextInt();
        }

        System.out.println(items);

    }
}
