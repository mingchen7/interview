import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 3) return res;
        Arrays.sort(nums);
        
        int first = 0;
        int second = 0;
        int third = 0;        
        for(first = 0; first < nums.length; first++){
            if(first > 0 && num[first-1] == nums[first]) continue;
            second = first + 1;
            third = nums.length -1;
            int target = 0 - nums[first];            
            while(second < third){
                // found
                if(nums[second]+nums[third] == target){
                    res.add(Arrays.asList(nums[first],nums[second],nums[third]));
                    // jump over duplciate numbers
                    while(second < third && nums[second] == nums[second+1]) second++;
                    while(second < third && nums[third] == nums[third-1]) third--;
                    second++; third--;
                }
                // smaller than the target, move second pointer
                else if(nums[second]+nums[third] < target){
                    second++;
                }
                // larger than the target, move third pointer                
                else{
                    third--;
                }
            }
        }
        return res;
    }
}