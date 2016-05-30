public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        while(left != right){
            if(numbers[left] == target - numbers[right]){
                int[] ans = {left+1, right+1};
                return ans;
            }
            else if(numbers[left] + numbers[right] < target){
                left++;
            }
            else{
                right--;
            }
        }
        int[] ans = {0,0};
        return ans;
    }
}