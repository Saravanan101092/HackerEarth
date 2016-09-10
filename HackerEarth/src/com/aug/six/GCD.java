package com.aug.six;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GCD {


	public static int findGCD(int a, int b){
		int r;
		while(b != 0)
		{
			r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

	public static int[] findMultiples(int a, int b, int gcd){

		int ta,tb,i,j;
		ta=a;tb=b;i=1;j=1;
		
		while(!checkCondition(ta, tb, gcd)){
			if(ta>tb){
				j++;
				tb*=j;
			}else{
				i++;
				ta*=i;
			}
		}
		
		return getSol(a,b,i,j,gcd);
	}
	
	public static int[] getSol(int a,int b,int i,int j,int gcd){
		int[] output = new int[2];
		if((a*i + b*j) ==gcd){
			output[0]=i;
			output[1]=j;
		}else if((a*i - b*j) == gcd){
			output[0]=i;
			output[1]=-j;
		}else if((b*j - a*i)== gcd){
			output[0]=-i;
			output[1]=j;
		}
		
		return output;
	}
	public static boolean checkCondition(int a, int b, int gcd){
		if(a>b){
			if((a-b)==gcd ){
				return true;
			}
		}else{
			if((b-a)==gcd){
				return true;
			}
		}
		if(a+b == gcd){return true;}
		return false;
	}
	public static int[] coins_value(int[] input1)
	{
		int[] output = new int[2];
		if(input1.length==2 && input1[0]>=0 && input1[1]>=0){
			int GCD = findGCD(input1[0], input1[1]);
			if(GCD==1 && ((input1[0]-input1[1])==1 || (input1[0]-input1[1])==-1)){
				output = findMultiples(input1[0], input1[1], GCD);
			}else if(GCD!=1){
				output = findMultiples(input1[0], input1[1], GCD);
			}
		}else{
			return output;
		}
		return output;
	}

	public static void main(String[] args) throws IOException {
		
//		FileWriter writer = new FileWriter(new File("E:/output.txt"));
//		int[] input = new int[2];
//		for(int i=0;i<=1000;i++){
//			for(int j=0;j<=1000;j++){
//				input[0]=i;
//				input[1]=j;
//				
//				writer.write("input="+input[0]+","+input[1]);
//				int[] output = coins_value(input);
//				writer.write("\t output="+output[0]+","+output[1]+"\n");
//				System.out.println(i+" "+j);
//			}
//		}
//		writer.close();
		int[] output = coins_value(new int[]{2,7});
	}

}
