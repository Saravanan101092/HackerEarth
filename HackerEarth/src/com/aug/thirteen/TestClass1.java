package com.aug.thirteen;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class TestClass1 {
	
	public static boolean canThey(int N, String[] P_ids, String[] M_ids){
		Set<String> uniqueIDs = new HashSet<String>();
		
		for(int i=0;i<P_ids.length;i++){
			uniqueIDs.add(P_ids[i]);
		}
		for(int i=0;i<M_ids.length;i++){
			uniqueIDs.add(M_ids[i]);
		}
		
		if(uniqueIDs.size()>=N){
			return true;
		}else{
			return false;
		}
	}
	
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int TestCases = Integer.parseInt(line);
        for (int i = 0; i < TestCases; i++) {
        	String npmStr = br.readLine();
        	String[] npmSplit = npmStr.split(" ", -1);
        	int N = Integer.parseInt(npmSplit[0]);
        	int P = Integer.parseInt(npmSplit[1]);
        	int M = Integer.parseInt(npmSplit[2]);
        	
        	int[] P_ids = new int[P];
        	String pids_Str = br.readLine();
        	String[] pids_split = pids_Str.split(" ", -1);
        	
        	int[] M_ids = new int[M];
        	String mids_Str = br.readLine();
        	String[] mids_split = mids_Str.split(" ", -1);
        	
        	if(canThey(N,pids_split,mids_split)){
        		System.out.println("They can");
        	}else{
        		System.out.println("They can't");
        	}
        }

    }
}