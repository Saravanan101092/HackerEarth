package com.aug.six;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestClass {

	private static String[] nodes;
	public static int calculate(String begin, String destination,Graph graph){
		Set<String> unique = new HashSet<String>();
		
		List<Pair> pairs = graph.get(begin);
		return unique.size();
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstline = br.readLine();
        int NoOfNODES = Integer.parseInt(firstline);
        String secondline = br.readLine();
        nodes = secondline.split(" ", -1);
//        Vertex[] vertices = new Vertex[NoOfNODES];
//        for (int i = 0; i < NoOfNODES; i++) {
//        	vertices[i]=new Vertex(nodes[i]);
//        }
        Graph graph = new Graph();
        for(int i=0;i<NoOfNODES-1;i++){
        	String line = br.readLine();
        	String[] temp = line.split(" ", -1);
        	Pair pair = new Pair(temp[0],temp[1]);
        	graph.pairs.add(pair);
        }
        
        String NoOfquery = br.readLine();
        int noOfQueries = Integer.parseInt(NoOfquery);
        
        for(int i=0;i<noOfQueries;i++){
        	String temp = br.readLine();
        	String tmp[]=temp.split(" ", -1);
        	System.out.println(calculate(tmp[0],tmp[1],graph));
        }
        
	}

}

class Graph{
	List<Pair> pairs;
	public Graph(){
		pairs = new ArrayList<Pair>();
	}
	
	public List<Pair> get(String str){
		List<Pair> thislist = new ArrayList<Pair>();
		for(Pair p : pairs){
			if(p.contains(str)){
				thislist.add(p);
			}
		}
		return thislist;
	}
}
class Pair{
	String A;
	String B;
	
	public Pair(String a,String b){
		this.A = a;
		this.B = b;
	}
	public boolean contains(String t){
		if(t.equals(A) || t.equals(B)){
			return true;
		}else{
			return false;
		}
	}
	
	public String get(String t){
		if(t.equals(this.A)){
			return this.B;
		}else if(t.equals(this.B)){
			return this.A;
		}
		return null;
	}
}