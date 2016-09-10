package com.may.fifteen;

public class CandidateCode {

	 public static int distributeCadbury(int input1,int input2,int input3,int input4)
	    {
		 int noOfChildren = 0;
		 for(int i = input1; i<=input2;i++){
			 for(int j= input3; j<=input4;j++){
				 noOfChildren+=distributeChildren(i,j);
			 }
		 }
		 return noOfChildren;
	    }
	 public static int distributeChildren(int i,int j){
		 int total=1;
		 while(i!=j){
			 if(i>j){
				 i-=j;
			 }else{
				 j-=i;
			 }
			 total++;
		 }
		 return total;
	 }
	public static void main(String[] args) {
		System.out.println(distributeCadbury(5, 6, 3, 4));
	}

}
