package com.may.eleven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RatProblem {

	static int rectX=0;
	static int rectY=0;
	public static String[] RatsPostions(String[] input1,String[] input2,int input3)
	{
		int[][] rectangle = getRectangle(input2);
		String[] ratpositions = input1;
		for(int i=0;i<input3;i++){
			ratpositions = calculatePositions(rectangle,input1);
		}
		return ratpositions;
	}

	public static int[][] getRectangle(String[] input){
		rectX=input.length;
		rectY = input[0].split("#", -1).length;
		int[][] rectangle = new int[rectX][rectY];
		for(int i=0;i<input.length;i++){
			String[] temp = input[i].split("#", -1);
			for(int j=0;j<temp.length;j++){
				rectangle[i][j] = Integer.parseInt(temp[j]);
			}
		}
		return rectangle;
	}

	public static String[] calculatePositions(int[][] rectangle, String[] ratPositions){
		String[] nextPosition = new String[ratPositions.length];
		for(int i=0;i<ratPositions.length;i++){
			String[] temp = ratPositions[i].split("#", -1);
			int x = Integer.parseInt(temp[0]);
			int y = Integer.parseInt(temp[1]);
			nextPosition[i]=getNextPosition(rectangle, x-1, y-1);
		}
		return nextPosition;
	}
	public static String getNextPosition(int[][] rectangle,int x,int y){
		int current =rectangle[x][y];

		int Uy,rx,Ly,lx;
		
		Uy=y-1;rx=x+1;Ly=y+1;lx=x-1;

		Map<Integer,String> neighbours = new HashMap<Integer,String>();
		int top,right,bottom,left;
		if(lx>=0 && lx<rectX){
			left = getDifference(rectangle[lx][y],current);
			neighbours.put(left, (lx+1)+"#"+(y+1));
		}
		if(Ly>=0 && Ly<rectY){
			bottom = getDifference(rectangle[x][Ly],current);
			neighbours.put(bottom, (x+1)+"#"+(Ly+1));
		}
		if(rx>=0 && rx<rectX){
			right = getDifference(rectangle[rx][y],current);
			neighbours.put(right, (rx+1)+"#"+(y+1));
		}
		if(Uy>=0 && Uy<rectY){
			top = getDifference(rectangle[x][Uy],current);
			neighbours.put(top, (x+1)+"#"+(Uy+1));
		} 
		List<Integer> tempKeys = new ArrayList<Integer>(neighbours.keySet());	Collections.sort(tempKeys);
		int min = tempKeys.get(0);
		return neighbours.get(min);
	}
	public static int getDifference(int a,int b){
		if(a>b){
			return a-b;
		}else{
			return b-a;
		}
	}
	public static void main(String[] args) {

		String[] input1 = {"1#1","2#5","3#3","6#3"};
		String[] input2 = {"2#6#8#6#-7","2#5#-5#-5#0","-1#3#-8#8#7","3#2#0#6#9","2#1#-4#5#8","-5#6#7#4#7"};
		int no = 3;
		RatsPostions(input1,input2,no);
	}

}
