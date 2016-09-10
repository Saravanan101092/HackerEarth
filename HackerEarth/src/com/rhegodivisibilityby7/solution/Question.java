package com.rhegodivisibilityby7.solution;

import java.io.*;
import java.util.*;
 
 
class IO
{
	static BufferedReader reader;
	static StringTokenizer tokenizer;
	static PrintWriter writer;
	static void initialize(InputStream in,OutputStream out)
	{
		reader=new BufferedReader(new InputStreamReader(in));
		tokenizer=new StringTokenizer("");
		writer=new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)));
	}
	static String next()
	{
		try
		{
			while(tokenizer==null||!tokenizer.hasMoreElements())
			{
				tokenizer=new StringTokenizer(reader.readLine());
			}
			return (tokenizer.nextToken());
		}
		catch(IOException exc)
		{
			System.out.println("IOException has occured");
			return (null);
		}
	}
	static int nextInt()
	{
		return(Integer.parseInt(next()));
	}
	static long nextLong()
	{
		return(Long.parseLong(next()));
	}
	static short nextShort()
	{
		return(Short.parseShort(next()));
	}
	static void write(char c)
	{
		writer.println(c);
	}
	static void write(String s)
	{
		writer.println(s);
	}
	static void write(long i)
	{
		writer.println(i);
	}
	static void close()
	{
		writer.flush();
		writer.close();
	}
}
 
class SegmentTree
{
	byte remainder[];
	static byte mod7[]={1,3,2,6,4,5};	//powers of 10, modulo 7 (repetitive) 
	int size[],height,numberOfNodes;
	int rangeLeft[],rangeRight[];
	public SegmentTree(String num)
	{
		int length=num.length(),i,j;
		height=guessHeight(length);
		numberOfNodes=(1<<height)-1;
		remainder=new byte[numberOfNodes];
		size=new int[numberOfNodes];
		rangeLeft=new int[numberOfNodes];
		rangeRight=new int[numberOfNodes];
		i=(1<<(height-1))-1;
		while(length--!=0)
		{
			remainder[i+length]=(byte)((((num.charAt(length)-'0'))%7));
			size[i+length]=1;
			rangeLeft[i+length]=length;
			rangeRight[i+length]=length;
		}
		length=num.length();
		for(i=i+length,j=length;i<remainder.length;++i,++j)
		{
			remainder[i]=0;
			size[i]=0;
			rangeLeft[i]=j;
			rangeRight[i]=j;
		}
	
	}
	
	public void buildSegmentTree(int parent)
	{
		int leftChild=(parent<<1)+1,rightChild;
		if(leftChild<numberOfNodes)
		{	rightChild=leftChild+1;
			buildSegmentTree(leftChild);
			buildSegmentTree(rightChild);
			size[parent]=size[leftChild]+size[rightChild];
			remainder[parent]=(byte)(((findRemainder(size[rightChild])*remainder[leftChild])+remainder[rightChild])%7);	//using mod(a+b)=mod(a)+mod(b)
			rangeLeft[parent]=rangeLeft[leftChild];
			rangeRight[parent]=rangeRight[rightChild];
		}
	}
	
	public static byte findRemainder(int s)			//to find the remainder of 10 ^(size of rightChild+1)
	{
		return (mod7[s%6]);
	}
	
	int[] query(int l,int r,int pos)
	{
		int arr[]=new int[2];
		arr[0]=0;
		arr[1]=0;
		if(pos<numberOfNodes)
		{
			if(l<=rangeLeft[pos]&&rangeRight[pos]<=r)
			{
				arr[0]=remainder[pos];
				arr[1]=size[pos];
				//System.out.println("1Node : "+pos+" "+arr[0]);
			}
			else if(!(rangeLeft[pos]>r||rangeRight[pos]<l))
			{
				int larr[]=query(l,r,(pos<<1)+1);
				int rarr[]=query(l,r,(pos<<1)+2);
				arr[0]=(larr[0]*findRemainder(rarr[1])+rarr[0])%7;
				arr[1]=larr[1]+rarr[1];
				//System.out.println("2Node : "+pos+" "+arr[0]);
				//((query(l,r,(pos<<1)+1)+query(l,r,(pos<<1)+2))%7);
			}
		}
		return arr;
	}
	
	static int guessHeight(int n)
	{
		long size=1;
		int h=1;
		while(size<n)
		{
			size=size<<1;
			h++;
		}
		return h;
	}
	
	static void buildSegmentTree(boolean divisible[],int size)
	{
		
	}
}
 
public class Question
{
    public static void main(String args[]) throws  IOException
    {
        Question q=new Question();
        q.solve();
    }
    public void solve()
    {
    	IO.initialize(System.in,System.out);
        int q,l,r;
        String s=IO.next();
        q=IO.nextInt();
        SegmentTree tree=new SegmentTree(s);
        /*for(int i=0;i<tree.numberOfNodes;++i)
        	System.out.print(tree.remainder[i]+" ");
        System.out.println();*/
        tree.buildSegmentTree(0);
        /*for(int i=0;i<tree.numberOfNodes;++i)
        	System.out.print(tree.remainder[i]+" ");
        System.out.println();
        for(int i=0;i<tree.numberOfNodes;++i)
        	System.out.println(tree.rangeLeft[i]+" "+tree.rangeRight[i]);*/
        int arr[];
        while(q--!=0)
        {
        	l=IO.nextInt()-1;
        	r=IO.nextInt()-1;
        	//System.out.println("Query ans "+q+" : "+tree.query(l,r,0)[0]);
        	arr=tree.query(l, r, 0);
        	if(arr[0]==0&&arr[1]!=0)
        		IO.write("YES");
        	else
        		IO.write("NO");
        	
        }
        IO.close();
    }
}
