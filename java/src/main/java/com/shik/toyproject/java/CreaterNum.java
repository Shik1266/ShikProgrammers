package com.shik.toyproject.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CreaterNum {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String n = null;
        int intNum = 0;
        int zari = 0;
        try {
            n = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        n="1";
        zari = n.length();
        intNum = Integer.parseInt(n);

        if(zari - 1 > 0)
            zari = zari -1;
        int test;

        String bae = "1";
        for(int k=1;k<zari;k++){
            bae +="0";
        }

        for(int i = Integer.parseInt(bae) ; i<intNum;i++){
            test = 0;
            test+=i;

            for(int j =0;j< Integer.toString(i).length();j++){
                int d = Integer.toString(i).charAt(j) - '0';
                test+=d;
            }
            if (test == intNum){
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
