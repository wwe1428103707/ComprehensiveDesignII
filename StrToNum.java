package com.example.a24107.computeapplication2;
import  java.text.ParseException;
/**
 * Created by 24107 on 2017/12/8.
 */

public class StrToNum {
    /**
     * 从左往右遍历，先把括号找出来，再计算括号中的值，去掉括号，再计算*和/，再计算+和-，
     */

    //public static int kuoCount = 0;
    public static int[] kuoweizhi;
    public static String str = "5×((2+2)+2)+((2+2)÷2)";
    //5×((2+2)+2)+2+2÷2

    public static void main(String[] args){
        String answer = LeftToRightCompute(str);
        System.out.println(answer);
    }

    public static  void Swap(int a,int b){
        int temp=a;
        a=b;
        b=temp;
    }

    public static String LeftToRightCompute(String str) {
        int numcount = -1;
        float firstnum = 1;
        float answer = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9'||str.charAt(i)=='.') {
                if (numcount==-1) {
                    numcount = i;
                }
                firstnum = Float.parseFloat(str.substring(numcount, i+1));
                answer = firstnum;
                //return answer;
            }
            else {
                switch (str.charAt(i)) {
                    case '+'://当我加的时候，其实是加后面的整个结果
                        numcount = -1;
                        answer=firstnum + Float.parseFloat(LeftToRightCompute(str.substring(i + 1)));
                        return answer+"";
                    //break;
                    case '-'://当我减的时候，其实是减后面的整个结果
                        numcount = -1;
                        answer=firstnum - Float.parseFloat(LeftToRightCompute(str.substring(i + 1)));
                        return answer+"";
                    //break;
                    case '×'://当我乘的时候，其实是乘第一个数
                        numcount = -1;
                        float secondnummulti = Float.parseFloat(FirstnumLeftToRight(str.substring(i+1)));
                        float answer1 = firstnum * secondnummulti;
                        String newstringmuti="";
                        if(str.charAt(i+1)=='('){
                            int kuocount=1;
                            i=i+2;
                            //int temp=i;
                            for (;i<str.length();i++){
                                if(str.charAt(i)=='('){
                                    kuocount++;
                                }
                                else if(str.charAt(i)==')'){
                                    kuocount--;
                                }
                                if(kuocount==0){
                                    newstringmuti = str.substring(i+1);
                                    break;
                                }
                            }
                        }
                        else if (secondnummulti==(int)secondnummulti) {
                            newstringmuti = str.substring(i + 1 + Float.toString(secondnummulti).length()-2);
                        }
                        else{
                            newstringmuti = str.substring(i + 1 + Float.toString(secondnummulti).length());
                        }
                        newstringmuti = answer1+ newstringmuti;
                        answer = Float.parseFloat(LeftToRightCompute(newstringmuti));
                        return answer+"";
                        //break;
                    case '÷'://当我除的时候，其实是除第一个数
                        numcount = -1;
                        float secondnumchu = Float.parseFloat(FirstnumLeftToRight(str.substring(i+1)));
                        float answer2 = firstnum / secondnumchu;
                        String newstringchu="";
                        if(str.charAt(i+1)=='('){
                            int kuocount=1;
                            i=i+2;
                            //int temp=i;
                            for (;i<str.length();i++){
                                if(str.charAt(i)=='('){
                                    kuocount++;
                                }
                                else if(str.charAt(i)==')'){
                                    kuocount--;
                                }
                                if(kuocount==0){
                                    newstringchu = str.substring(i);
                                    break;
                                }
                            }
                        }
                        else if (secondnumchu==(int)secondnumchu) {
                            newstringchu = str.substring(i + 1 + Float.toString(secondnumchu).length()-2);
                        }
                        else{
                            newstringchu = str.substring(i + 1 + Float.toString(secondnumchu).length());
                        }
                        newstringchu = answer2+ newstringchu;
                        answer = Float.parseFloat(LeftToRightCompute(newstringchu));
                        return answer+"";
                    case '(':
                        int temp=i;
                        int kuocount=1;//检测这个字符串是否到头或者有区域外的括号如(a+b)+(c+d)
                        i=i+1;
                        for (;i<str.length();i++){
                            if(str.charAt(i)=='('){
                                kuocount++;
                            }
                            else if(str.charAt(i)==')'){
                                kuocount--;
                            }
                            if(kuocount==0){
                                float answer3= Float.parseFloat(LeftToRightCompute(str.substring(temp+1,i)));//但str本身并未被改变
                                return LeftToRightCompute(answer3+str.substring(i));
                            }
                        }
                        //break;
                    case ')':
                        //continue;
                }
            }
        }
        return answer+"";
    }

    public static String FirstnumLeftToRight(String str) {
        System.out.println(str);
        int numcount = -1;
        float firstnum = 0;
        if (str.charAt(0)=='('){
            int i=0;
            float answer=0;
            int temp=i;
            int kuocount=1;//检测这个字符串是否到头或者有区域外的括号如(a+b)+(c+d)
            i=i+1;
            for (;i<str.length();i++){
                if(str.charAt(i)=='('){
                    kuocount++;
                }
                else if(str.charAt(i)==')'){
                    kuocount--;
                }
                if(kuocount==0){
                    float answer3= Float.parseFloat(LeftToRightCompute(str.substring(temp+1,i)));//但str本身并未被改变
                    return answer3+"";
                }
            }
            /*
            int i=0;
            int temp=i;
            int kuocount=1;//检测这个字符串是否到头或者有区域外的括号如(a+b)+(c+d)
            i=i+1;
            for (;i<str.length();i++){
                if(str.charAt(i)=='('){
                    kuocount++;
                }
                else if(str.charAt(i)==')'){
                    kuocount--;
                }
                if(kuocount==0){
                    StringBuffer sb=new StringBuffer();
                    sb.append(str).replace(temp,i+1,"");
                    str=sb.toString();
                    System.out.println(sb.toString());
                    System.out.println(str);
                }
            }
            */
            return answer+"";
        }
        else {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9'||str.charAt(i)=='.') {
                    if (numcount==-1) {
                        numcount = i;
                    }
                        firstnum = Float.parseFloat(str.substring(numcount, i + 1));
                }
                else {
                    return firstnum+"";
                }
            }
        }
        return firstnum+"";
    }
}
