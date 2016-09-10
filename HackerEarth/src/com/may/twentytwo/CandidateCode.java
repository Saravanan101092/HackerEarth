package com.may.twentytwo;

import java.util.Arrays;

public class CandidateCode {

	public static int ThirstyCrowProblem(int[] input1,int input2,int input3)
	{
		int length = input1.length;
		
		if(input3==0){
			return 0;
		}
		if(length == input2){
			int[] tempOs = new int[length];
			for(int i=0;i<length;i++){
				if(input1[i]>0){
					tempOs[i] = input1[i];
				}else{
					return -1;
				}
			}
					input1.clone();
			Arrays.sort(tempOs);
			int mid = tempOs[(input3-1)];

			int remaining = length - input3;
			int noOfStones = mid*remaining + mid;

			for(int i=0;i<(input3 - 1);i++){
				noOfStones+=tempOs[i];
			}
			return noOfStones;
		}else{
			return -1;
		}
	}
	public static void main(String[] args) {
		//		int[] input1 = {5,58};
		//		System.out.println(ThirstyCrowProblem(input1, 2, 1));

		int[] input1 = {3,15,7,34,10,12,25};
		System.out.println(ThirstyCrowProblem(input1, 1, 4));
	}

}
