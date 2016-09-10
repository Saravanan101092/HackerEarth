package com.may.one;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CandidateCode {

	public static int N;
	public static int MaxMinimumAmount =0;
	   public static String[] amount_value(int input1,String[] input2)
	    {
	    	String[] result=null;
	    	N=input1;
	    	int[][] numbers=getArrayInBoard(input1, input2);
	    	Map<Integer,List<String>> minAmountsMap = getMinimumAmounts(numbers);
	    	List<String> resList = minAmountsMap.get(MaxMinimumAmount);
	    	System.out.println(resList);
	    	result = new String[resList.size()];
	    	int i=0;
	    	for(String str : resList){
	    		result[i]=str;
	    		i++;
	    	}
	    	
	    	return result;
	    }
	    
	   public static Map<Integer,List<String>> getMinimumAmounts(final int[][] numbers){
	    Map<Integer,List<String>> minAmountsMap = new HashMap<Integer,List<String>>();	
		   for(int i=0;i<N;i++){
			   for(int j=0;j<N;j++){
				   int minimumAmount=getMinimumAmount(i, j, numbers);
				   if(minAmountsMap.containsKey(minimumAmount)){
					   minAmountsMap.get(minimumAmount).add((i+1)+"#"+(j+1));
				   }else{
					   List<String> aList=new ArrayList<String>();
					   aList.add((i+1)+"#"+(j+1));
					   if(MaxMinimumAmount<minimumAmount){
						   MaxMinimumAmount=minimumAmount;  
					   }
					   minAmountsMap.put(minimumAmount, aList);
				   }
				  
			   }
		   }
		   return minAmountsMap;
	    }
	   
	   public static int getMinimumAmount(int i,int j, final int[][] numbers){
		   int minimumAmount;
		   minimumAmount = numbers[i][j];
		   
		   int res=getNeighbour(i-1, j-1, numbers);
		   if(res!=-1 && res<minimumAmount){
			   minimumAmount=res;
		   }
		   res=getNeighbour(i-1, j, numbers);
		   if(res!=-1 && res<minimumAmount){
			   minimumAmount=res;
		   }
		   res=getNeighbour(i, j-1, numbers);
		   if(res!=-1 && res<minimumAmount){
			   minimumAmount=res;
		   }
		   res=getNeighbour(i+1, j+1, numbers);
		   if(res!=-1 && res<minimumAmount){
			   minimumAmount=res;
		   }
		   res=getNeighbour(i+1, j, numbers);
		   if(res!=-1 && res<minimumAmount){
			   minimumAmount=res;
		   }
		   res=getNeighbour(i, j+1, numbers);
		   if(res!=-1 && res<minimumAmount){
			   minimumAmount=res;
		   }
		   res=getNeighbour(i-1, j+1, numbers);
		   if(res!=-1 && res<minimumAmount){
			   minimumAmount=res;
		   }
		   res=getNeighbour(i+1, j-1, numbers);
		   if(res!=-1 && res<minimumAmount){
			   minimumAmount=res;
		   }
		   return minimumAmount;
	   }
	    
	   public static int getNeighbour(int i,int j, final int[][] numbers){
		   if(i>=0 && j>=0 && i<N && j<N){
			   return numbers[i][j];
		   }else{
			   return -1;
		   }
	   }
	    public static int[][] getArrayInBoard(int input1,String[] input2){
	    	int[][] numbers = new int[input1][input1];
	    	
	    	for(int i=0;i<input1;i++){
	    		String[] temp = input2[i].split("#");
	    		for(int j=0;j<temp.length;j++){
	    			numbers[i][j]=Integer.parseInt(temp[j]);
	    		}
	    	}
	    	
	    	return numbers;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//    	String[] arr = {"12#45#33","94#54#23","98#59#27"};
//    	System.out.println(amount_value(3, arr));
    	String[] arr = {"12#45#33#27","94#54#23#53","98#59#27#62","11#51#67#13"};
    	amount_value(4, arr);
	}

}
