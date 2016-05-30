import java.util.*;

public class Bin {
	private int capacity;
	private ArrayList<Integer> bin;
	private int lowerBound;
	private int upperBound;

	public Bin(int size, int lower, int upper){
		capacity = size;
		lowerBound = lower;
		upperBound = upper;
		bin = new ArrayList<Integer>(size);
	}

	public void add(int num){
		if(bin.size() >= capacity){			
			throw new IllegalStateException("Bin is already full");
		}
		bin.add(num);
		System.out.println(num + " is added");
	}

	public int getLowerBound(){
		return this.lowerBound;
	}

	public int getUpperBound(){
		return this.upperBound;
	}

	public static void main (String args[]){
		int[] nums = {1, 23, 45, 66, 98, 12, 34, 48};

		int low = 0;
		int high = 99;
		int k = 3;
		int size = (high - low + 1) % k == 0? (high - low + 1) / k : (high - low + 1) / k + 1;
		// System.out.println(size);
		// Bin mybin = new Bin(size, 0, 100);
		// mybin.Add(7);
		
		Bin [] bins = new Bin[k];
		int lower = low;
		int upper = 0;
		for(int i = 0; i < k; i++){
			lower = low + i * size;
			upper = lower + size - 1; 
			bins[i] = new Bin(size, lower, upper);
			System.out.println(i);
			System.out.println("Lower bound: " + bins[i].getLowerBound());
			System.out.println("Upper bound: " + bins[i].getUpperBound()); 
		}

		for(int i = 0; i < nums.length; i++){
			int tmp = (nums[i] - low + 1) / size;
			bins[tmp].add(nums[i]);
			System.out.println("Bin #" + tmp);
		}					
	}
}