import java.util.*;
public class NumOfBST {
	public int NumOfBST(int[] numbers){
		if(numbers.length == 1) return 1;
		if(numbers.length == 2) return 2;
		int res = 0;
		int n = numbers.length;
		for(int i = 0; i < n; i++){
			if(i == 0){
				res = res + NumOfBST(Arrays.copyOfRange(numbers,1,n));
				System.out.print("head: " + res + "\n");
			}
			else if(i == n-1){
				res = res + NumOfBST(Arrays.copyOfRange(numbers,0,n-1));
				System.out.print("tail: " + res + "\n");	
			} 

			else{
				res = res + NumOfBST(Arrays.copyOfRange(numbers,0,i)) * NumOfBST(Arrays.copyOfRange(numbers,i+1,n));	
				System.out.print("Mid: " + res + "\n");
			}			
		}
		return res;
	}

	public static void main (String args[]){
		NumOfBST test = new NumOfBST();
		int[] numbers = {1,2,3};
		System.out.println(test.NumOfBST(numbers));
	}
}