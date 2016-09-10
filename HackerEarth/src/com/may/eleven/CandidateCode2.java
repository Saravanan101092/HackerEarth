package com.may.eleven;

import java.io.*;
public class CandidateCode2 
{ 
	static int r,c;
    static int[][]arr,min_dir;
    static String err[];
    public static String[] RatsPostions(String[] pos,String[] grid,int k)
    {
        err=new String[1];
        try
        {
            r=grid.length;
            if(r == 0)
            {
                err [0] = "Invalid Input...!";
                return err;
            }
            c=grid[0].split("#").length;
            int n=pos.length;
            if(n == 0)
            {
                err [0] = "No Rats...!";
                return err;
            }
            if(k < 1)
            return pos;
            int[][]rats=new int[n][2];
            arr=new int[r][c];
            min_dir=new int[r][c];
            String[]str;
            for(int i=0;i<n;i++)
            {
                if(pos[i].contains("#"))
                {
                    str=pos[i].split("#");
                    try
                    {
                        rats[i][0]=Integer.parseInt(str[0])-1;
                        rats[i][1]=Integer.parseInt(str[1])-1;
                    }
                    catch(ArrayIndexOutOfBoundsException e)
                    {
                        err [0] = "Invalid Initial Rat Positions...!";
                        return err;
                    }
                }
                else
                {
                    err [0] = "Invalid Input...!";
                    return err;
                }
            }
            for(int i=0;i<r;i++)
            {
                str=grid[i].split("#");
                for(int j=0;j<c;j++)
                {                
                    arr[i][j]=Integer.parseInt(str[j]);
                }
            }
            for(int i=0;i<n;i++)
            {
                pos[i]=get_final_pos(rats[i][0],rats[i][1],k);
            }
        }
        catch(NumberFormatException e)
        {
            err[0]="Invalid Input Format...Number Format Error";
            return err;
        }
        catch(Exception e)
        {
            err[0]="Processing Error";
            return err;
        }
        return pos;
    }
    static String get_final_pos(int i,int j,int k)
    {
        int[][]path=new int[r][c];
        int n=1;
        while(path[i][j]==0&&k-->0)
        {
            path[i][j]=n++;
            if(min_dir[i][j]==0)
            {
                min_dir[i][j]=find_min(i,j);
            }
            switch(min_dir[i][j])
            {
                case 1:i--;break;
                case 2:j++;break;
                case 3:i++;break;
                case 4:j--;
            }            
        }        
        n-=path[i][j];
        k%=n;
        while(k-->0)
        {
            switch(min_dir[i][j])
            {
                case 1:i--;break;
                case 2:j++;break;
                case 3:i++;break;
                case 4:j--;
            }
        }
        return (i+1)+"#"+(j+1);
    }
    static int find_min(int i,int j)
	{
		int min = 999,dir=0,t;boolean isMinSet=false;        
		if(i>0)
		{
			t=arr[i][j]-arr[i-1][j];
			t=t<0?-t:t;
			if(isMinSet){
				if(t<min)
				{
					min=t;
					dir=1;
				}
			}else{
				isMinSet=true;
				min=t;
				dir=1;
			}
		}
		if(j+1<c)
		{
			t=arr[i][j]-arr[i][j+1];
			t=t<0?-t:t;
			if(isMinSet){
				if(t<min)
				{
					min=t;
					dir=2;
				}
			}else{
				isMinSet=true;
				min=t;
				dir=2;
			}
		}
		if(i+1<r)
		{
			t=arr[i][j]-arr[i+1][j];
			t=t<0?-t:t;
			if(isMinSet){
				if(t<min)
				{
					min=t;
					dir=3;
				}
			}else{
				isMinSet=true;
				min=t;
				dir=3;
			}
		}
		if(j>0)
		{
			t=arr[i][j]-arr[i][j-1];
			t=t<0?-t:t;
			if(isMinSet){
				if(t<min)
				{
					min=t;
					dir=4;
				}
			}else{
				isMinSet=true;
				min=t;
				dir=4;
			}
		}
		return dir;
	}  
	public static void main(String[] args) {

		String[] input1 = {"1#1","2#5","3#3","6#3"};
		String[] input2 = {"2#6#8#6#-7","2#5#-5#-5#0","-1#3#-8#8#7","3#2#0#6#9","2#1#-4#5#8","-5#6#7#4#7"};
		int no = 3;
		RatsPostions(input1,input2,no);
	}

}

