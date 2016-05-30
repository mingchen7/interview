public class myCountSort {
	public int[] countSort(int[] nums, int k){
		int[] table = new int[k];
		int[] index = new int[k];
		int[] newnums = new int[nums.length];
		// counting occurrence of each element
		for(int num:nums){
			table[num] += 1;
		}

		/*
		for(int i = 0; i < table.length; i++){
			System.out.print(i + ": " + table[i]+"\n");
		}		
		*/

		// calculate the idx of each element
		int rank = 0;		
		for(int i = 0; i< index.length; i++){
			rank = rank + table[i];
			index[i] = rank;
		}

		/*
		for(int i = 0; i < index.length; i++){
			System.out.print(i + ": " + index[i]+"\n");
		}
		System.out.print("\n");
		*/

		// output the numbers
		for(int i = nums.length-1; i >= 0; i--){
			//System.out.println(nums[i]);			
			newnums[--index[nums[i]]] = nums[i];			
		}

		return newnums;
	}

	public static void main(String args[]){
		int[] sequence = {88,93,97,92,96,99,92,89,93,97,90,94,92,95};
		myCountSort test = new myCountSort();
		int[] ans = test.countSort(sequence,100);
		for(int num:ans){
			System.out.print(num + ",");
		}
		System.out.print("\n");
	}
}