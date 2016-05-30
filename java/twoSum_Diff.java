// Find a pair with given difference and sum
// modification of twoSum
// a + b  = sum; abs(a-b) = diff;
// use two hashmap to store the value of (sum - b) and (diff+b), (-diff+b)

import java.util.*;

public class twoSum_Diff {
	public int[] twoSum (int[] nums, int sum, int diff){
		int[] ans = {0,0};
		HashMap<Integer,Integer> sumMap = new HashMap<Integer,Integer>();
		HashMap<Integer,Integer> diffMap = new HashMap<Integer,Integer>();
		if(nums.length < 2) return ans;

		for(int i = 0; i < nums.length; i++){
			if(sumMap.containsKey(nums[i]) && diffMap.containsKey(nums[i])){
				if(sumMap.get(nums[i]) == diffMap.get(nums[i])){
					ans[0] = sumMap.get(nums[i]);
					ans[1] = i;	
				}
				
			}
			else{
				sumMap.put(sum - nums[i], i);
				diffMap.put(diff + nums[i], i);
				diffMap.put(-1*diff + nums[i], i);
			}
		}
		return ans;
	}
	public static void main (String args[]){
		twoSum_Diff myclass = new twoSum_Diff();
		int[] numbers = {3,1,7,10,8,2};
		int sum = 10;
		int diff = 4;
		int[] res = myclass.twoSum(numbers, sum, diff);
		System.out.print(res[0] + ", " + res[1] + "\n");
	}
}