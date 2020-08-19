package com.shik.toyproject.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MyJava {

    public static void main(String[] args) {
        int[] inputArr = new int[9];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            for(int i =0;i<9;i++){
                inputArr[i] = Integer.parseInt(reader.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        int startIdx = 0;
        Arrays.sort(inputArr);
        while (!isRealDwarfs(inputArr, startIdx)) {
            if (startIdx == 9) {
                break;
            }
            startIdx++;
        }
    }

    private static boolean isRealDwarfs(int[] array, int start) {
        int sum;
        int second;
        int preSecond;
        int preStart;
        preStart = array[start];
        array[start] = 0;
        for (second = start + 1; second <9; second++) {
            sum = 0;
            preSecond =array[second];
            array[second] = 0;
            for(int i=0;i<9;i++){
                sum+=array[i];
            }
            if (sum == 100) {
                showArrString(array, start, second);
                return true;
            }else {
                array[second] = preSecond;
            }
        }
        array[start] = preStart;
        return false;
    }

    private static void showArrString(int[] array, int a, int b) {
        for (int i = 0; i < 9; i++) {
            if (i != a && i != b)
                System.out.println(array[i]);
        }
    }
}