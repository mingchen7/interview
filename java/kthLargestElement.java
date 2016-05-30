
public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int ans = KthLargest(nums, 0, n-1, k);
        return ans;
    }
    
    public int KthLargest(int[] nums, int lo, int hi, int k){
        int p = partition(nums, lo, hi);
        int rank = p - lo + 1;  // get the rank of current pivot position

        if(rank == k) return nums[p];   // only compare rank and k
        else if(rank > k){
            return KthLargest(nums,lo,p-1,k);
        }
        else{
            return KthLargest(nums,p+1,hi,k-rank);
        }   
    }
    
    public int partition(int[] nums, int lo, int hi){
        int pivot = nums[hi];
        int i = lo;
        int tmp;
        for(int j = lo; j < hi; j++){
            if(nums[j] >= pivot){
                tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i = i + 1;
            }
        }
        tmp = nums[hi];
        nums[hi] = nums[i];
        nums[i] = tmp;
        return i;
    }

    public static void main(String args[]){
        int[] nums = {1,4,7,2,5,8,3,6,10,9};
        int k = 4;
        int n = nums.length;
        KthLargestElement test = new KthLargestElement();
        
        int ans = test.findKthLargest(nums,k);
        System.out.println(ans);

    }
}