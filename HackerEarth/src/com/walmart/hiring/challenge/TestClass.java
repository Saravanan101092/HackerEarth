package com.walmart.hiring.challenge;

import java.io.*;

public class TestClass {
    
    public static String computeBinaryAddition(String Numbers){
        String[] numArray = Numbers.split(" ",-1);
        boolean carryOver=false;
        String Solution="";
        
        numArray[0]=removeLeadingZeroes(numArray[0]);
        numArray[1]=removeLeadingZeroes(numArray[1]);
        int len1 = numArray[0].length();
        int len2 = numArray[1].length();
        int lenDiff=0;
        String first,second;
        if(len1< len2){
            first=numArray[0];
            second=numArray[1];
            lenDiff = len2-len1;
            first=addLeadingZeroes(lenDiff,first);
        }else{
            first=numArray[1];
            second=numArray[0];
            lenDiff = len1-len2;
            first=addLeadingZeroes(lenDiff,first);
        }
        
        int lengthDifference = second.length()-first.length();
        
        int count=first.length()-1;
        while(count>=0){
            if(first.charAt(count) == second.charAt(count)){
                if(first.charAt(count)=='1'){
                    if(carryOver){
                        Solution="1"+Solution;
                    }else{
                        Solution="0"+Solution;
                        carryOver=true;
                    }
                }else{
                    if(carryOver){
                        Solution="1"+Solution;
                    }else{
                        Solution="0"+Solution;
                    }
                }
            }else{
                if(carryOver){
                     Solution="0"+Solution;
                }else{
                     Solution="1"+Solution;
                }
            }
            
            count--;
        }
        
        if(carryOver){
             Solution="1"+Solution;
        }
        return Solution;
    }
    
    public static String addLeadingZeroes(int length,String s){
        for(int i=0;i<length;i++){
            s="0"+s;
        }
        
        return s;
    }
    
    public static String removeLeadingZeroes(String s){
        int count=0; int length=0;
        while(s.charAt(count)=='0'){
            length++;
            count++;
        }
        
        if(length>0){
            return s.substring(length);
        }else{
            return s;
        }
    }
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String s;
    while ((s = in.readLine()) != null) {
        
    System.out.println(computeBinaryAddition(s));
    
    }
  }
}