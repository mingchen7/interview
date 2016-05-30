import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = {0,0};
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        if(nums.length < 2) return ans;
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i])==true){
                ans[0] = map.get(nums[i]);
                ans[1] = i+1;
                return ans;
            }
            else{
                map.put(target-nums[i],i+1);
            }
        }
        return ans;
    }
}