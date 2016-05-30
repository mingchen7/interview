import java.util.*;

public class frogJump {
	private class Bin{
		int min, max;
		public Bin(){
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
		}
	}

	public int jump (int A[], int X, int D){
		if(D >= X){
			return 0;
		}

		int numBins = X / D + 1;

		ArrayList<Bin> bins = new ArrayList<Bin>();
		for(int i = 0; i < numBins; i++){
			bins.add(new Bin());
		}

		bins.get(0).min = 0;
		bins.get(0).max = 0;
		bins.get(numBins-1).min = X;
		bins.get(numBins-1).max = X;

		int numGaps = numBins - 1;

		for(int i = 0; i < A.length; i++){
			// get the index of bins
			int index = A[i] / D;
			System.out.println("index = " + index);
			System.out.println("min = " + bins.get(index).min);
			System.out.println("max = " + bins.get(index).max);

			// get the Max position of previous bin and 
			int prevMax = index == 0? bins.get(0).max : bins.get(index-1).max;
			int nextMin = index == numBins - 1? bins.get(numBins-1).min : bins.get(index+1).min;

			// System.out.println(A[i]);
			// System.out.println(prevMax);
			// System.out.println(nextMin);														

			// check if the current bin is connected with previous bin and the next bin
			boolean conn2Prev = bins.get(index).min - prevMax > D? false : true;
			boolean conn2Next = nextMin - bins.get(index).max > D	? false : true;

			if(conn2Prev == false && A[i] - prevMax <= D){				
				numGaps--;								
			}

			if(conn2Next == false && nextMin - A[i] <= D){
				numGaps--;										
			}

			// update the min and max position
			if(A[i] <= bins.get(index).min){
				bins.get(index).min = A[i];	
			}

			if(A[i] >= bins.get(index).max){
				bins.get(index).max = A[i];	
			}

			if(numGaps == 0){
				return i;
			}

			System.out.println(numGaps);
			System.out.println();
		}

		return -1;

	}

	public static void main(String args[]){
		int X = 7;
		int D = 3;
		int[] A = new int[6];
		A[0] = 1;
		A[1] = 3;
		A[2] = 1;
		A[3] = 4;
		A[4] = 2;
		A[5] = 5;

		frogJump sol = new frogJump();
		int res = sol.jump(A, X, D);
		System.out.println(res);
	}
}