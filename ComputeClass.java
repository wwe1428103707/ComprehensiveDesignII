package com.example.a24107.computeapplication2;

/**
 * Created by 24107 on 2017/12/8.
 */

public class ComputeClass {
    public static float plusFunction(float a,float b){
        return a+b;
    }

    public static float jianFunction(float a,float b){
        return a-b;
    }

    public static float multiFunction(float a,float b){
        return a*b;
    }

    public static float chuFuntion(float a,float b){
        return a/b;
    }


    public static void main(String[] args){
        String str = "169.11";
        float str2 = 111;
        int a = 20;
        float b = 0;
        b = Float.parseFloat(str.substring(0,1));
        System.out.println(str+str2);
    }
}
