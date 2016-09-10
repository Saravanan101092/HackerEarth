package com.aug.six;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class TestClass1 {
	
	public static int nthSeries(final long[] array){
		
		int result=0;
		int length=1;
		long previousValue=array[0];
		for(int i=1;i<array.length;i++){
			long currentvalue = array[i];
			if(currentvalue==previousValue){
				length++;
			}else{
				result+=factorial(length);
				previousValue=currentvalue;
				length=1;
			}
			
		}
		result+=factorial(length);
		return result;
	}
	
	public static int factorial(int n){
		int fact=0;
		for (int c = 1 ; c <= n ; c++ ){
            fact = fact+c;
		}
		
		return fact;
	}
    public static void main(String args[] ) throws Exception {
        

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int T = Integer.parseInt(line);
        for (int i = 0; i < T; i++) {
        	String lengthStr = br.readLine();
            int length = Integer.parseInt(lengthStr);
            long[] array = new long[length];
            String arrayStr = br.readLine();
            String[] arr = arrayStr.split(" ", -1);
            if(arr.length==length){
            for(int j=0;j<length;j++){
            	array[j]=Long.parseLong(arr[j]);
            }
            
            System.out.println(nthSeries(array));
            }else{
            	System.out.println(0);
            }
            System.gc();
        }

    }
}
