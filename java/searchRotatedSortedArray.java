public class searchRotatedSortedArray {
	public int findPivot(int[] nums, int low, int high){
		if(high - low == 1){
			if(nums[low] > nums[high]) 
				return high; 
			else 
				return -1; //no pivot was found, the array is not rotated
		}
		
		int mid = (low + high) / 2;
		if(nums[mid] > nums[high]){
			return findPivot(nums, mid, high);
		}
		else{
			return findPivot(nums, low, mid);
		} 		
	} 

	public int search(int[] nums, int target){
		int n = nums.length;
		int pivot = findPivot(nums,0,n-1);
		System.out.print("Pivot is at: " + pivot + "\n");

		if(pivot != -1){
			if(nums[n-1] >= target){
				return BinarySearch(nums, target, pivot, n-1, true);
			}
			else{
				return BinarySearch(nums, target, 0, pivot-1, false);
			}
		}
		else{
			return BinarySearch(nums, target, 0, n-1, true);
		}		
	}

	public int BinarySearch(int[] nums, int target, int low, int high, boolean increase){
		if(high - low == 1){
			if(nums[low] == target)
				return low;
			else if(nums[high] == target)
				return high;
			else
				System.out.println("Target is not found");
				return -1; //target not found
		}

		int mid = (high + low) / 2;
		if(increase == true){ 
			//increasing order
			if(nums[mid] <= target){
				return BinarySearch(nums, target, mid, high, increase);
			}
			else{
				return BinarySearch(nums, target, low, mid, increase);
			}
		}
		else{
			//decreasing order
			if(nums[mid] <= target){
				return BinarySearch(nums, target, low, mid, increase);
			}
			else{
				return BinarySearch(nums, target, mid, high, increase);
			}
		}
	}

	public static void main (String args[]){
		searchRotatedSortedArray test = new searchRotatedSortedArray();
		int[] numbers = {9,8,7,0,1,2,3,4,5,6};
		int target = 0;
		int res = test.search(numbers, target);
		System.out.println(res);
	}
}