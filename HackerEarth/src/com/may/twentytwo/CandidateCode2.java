package com.may.twentytwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CandidateCode2 {

	public static int ThirstyCrowProblem(int[] input1,int input2,int input3) {
        int noOfPots = input2;
        int noOfPotsToBeOverloaded = input3;
        int potsThatAreFull = 0;

        if(input1 == null || noOfPotsToBeOverloaded < 0 || noOfPotsToBeOverloaded > input1.length || noOfPots <= 0 || input1.length != noOfPots) {
            return -1;
        }

        if(noOfPotsToBeOverloaded==0) {
            return 0;
        }
        
        for(int i = 0; i < noOfPots; i++) {
            if(input1[i] < 0) {
                return -1;
            } else if (input1[i] == 0) {
                if(++potsThatAreFull==noOfPotsToBeOverloaded) {
                    return 0;
                }
            }
        }
        Arrays.sort(input1);
        return minStones(input1,noOfPotsToBeOverloaded-potsThatAreFull,potsThatAreFull);
    }


    public static int minStones(int[] input, int noOfPotsToBeFilledYet, int start) {
         List<Integer> minStones = new ArrayList<Integer>();
         minStones.add(Integer.MAX_VALUE);
         minStones(input,noOfPotsToBeFilledYet,start,0,minStones);
         return minStones.get(0);
    }
    public static void minStones(int[] input, int noOfPotsToBeFilledYet,int potsThatAreFullAlready, int stones, List<Integer> minStns) {

      if(noOfPotsToBeFilledYet==0) {
          if(stones < minStns.get(0)) {
              minStns.set(0, stones);
          }
          return;
      }

      int[] clone = null;
      for(int i = potsThatAreFullAlready; i <= input.length-1-(noOfPotsToBeFilledYet-1);i++) {
          if(input[i] == 0) {
              continue;
          }
          clone = input.clone();
          //change clone
          int currentStones = 0;
          int tempk = 0;
          for(int j = clone.length-1; j >= i;j--) {
              if(clone[j] == 0) {
                  continue;
              }
              if(clone[j] <= clone[i]) {
                  currentStones+=clone[j];
                  clone[j] = 0;
                  if(++tempk == noOfPotsToBeFilledYet) {
                      break;
                  } else {
                      continue;
                  }
              }
              currentStones+=clone[i];
              clone[j] -= clone[i];
          }
          minStones(clone,noOfPotsToBeFilledYet-tempk,i,stones+currentStones,minStns);
      }
    }
	public static void main(String[] args) {
		int[] input1 = {3,15,7,34,10,12,25};
		System.out.println(ThirstyCrowProblem(input1, 7, 4));
	}

}
