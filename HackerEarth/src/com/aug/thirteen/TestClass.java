package com.aug.thirteen;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class TestClass {
	
	public static long CalculateNearest(String NumberString){
		
		long NUMBER = Long.parseLong(NumberString);
		
		long currentNumber = (long) Math.sqrt(NUMBER);
		long minimumDifference = NUMBER;
		for(long thisNum=currentNumber;thisNum>1;thisNum--){
			long val = getMinimumDifference(NUMBER,thisNum);
			if(val<minimumDifference){
				if(val==0){return val;}
				minimumDifference=val;
			}
		}
		return minimumDifference;
	}
	
	public static long getMinimumDifference(long NUMBER, long thisNumber){
		long power = 1;
		long minimumDiff=NUMBER;
		long previous;
		long val;
		do{
			power++;
			val = (long) Math.pow(thisNumber, power);
			previous = minimumDiff;
			minimumDiff = findMinimumDifference(val, NUMBER);
			
		}while(val<NUMBER);
		
		if(previous<minimumDiff){
			return previous;
		}else{
			return minimumDiff;
		}
	}
	
	public static long findMinimumDifference(long A,long B){
		if(A>B){
			return A-B;
		}else{
			return B-A;
		}
	}
	
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
        	 String line2 = br.readLine();
             int Q = Integer.parseInt(line2);
             for (int j = 0; j < Q; j++) {
            	 String NumStr = br.readLine();
            	 System.out.println(CalculateNearest(NumStr));
             }
        }

    }
}
