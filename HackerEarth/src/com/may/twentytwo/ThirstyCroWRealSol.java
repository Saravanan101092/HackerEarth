package com.may.twentytwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThirstyCroWRealSol {
	public static int ThirstyCrowProblem(int[] input1,int input2,int input3) {
		int n = input2;
		int k = input3;
		int tempk = 0;

		if(input1 == null || k < 0 || k > input1.length || n <= 0 || input1.length != n) {
			return -1;
		}

		if(k==0) {
			return 0;
		}

		for(int i = 0; i < n; i++) {
			if(input1[i] < 0) {
				return -1;
			} else if (input1[i] == 0) {
				if(++tempk==k) {
					return 0;
				}
			}
		}
		Arrays.sort(input1);
		return minStones(input1,k-tempk,tempk);
	}


    public static int minStones(int[] input, int k, int start) {
    	 List<Integer> minStones = new ArrayList<Integer>();
         minStones.add(Integer.MAX_VALUE);
         minStones(input,k,start,0,minStones);
         return minStones.get(0);
    }
    public static void minStones(int[] input, int k,int start, int stones, List<Integer> minStns) {

      if(k==0) {
          if(stones < minStns.get(0)) {
              minStns.set(0, stones);
          }
          return;
      }

      int[] clone = null;
      for(int i = start; i <= input.length-1-(k-1);i++) {
          if(input[i] == 0) {
              continue;
          }
          clone = input.clone();
          //change clone
          int stns = 0;
          int tempk = 0;
          for(int j = clone.length-1; j >= i;j--) {
              if(clone[j] == 0) {
                  continue;
              }
              if(clone[j] <= clone[i]) {
                  stns+=clone[j];
                  clone[j] = 0;
                  if(++tempk == k) {
                	  break;
                  } else {
                	  continue;
                  }
              }
              stns+=clone[i];
              clone[j] -= clone[i];
          }
          minStones(clone,k-tempk,i,stones+stns,minStns);
      }
    }
}
