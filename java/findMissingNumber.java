// (0^1^2^3^4) ^ (0^1^3^4) = (0^1^3^4) ^ (0^1^3^4) ^ 2 = 0 ^ 2 = 2
// number ^ 0 = number 
// number ^ number = 0
public class Solution {
    public int missingNumber(int[] nums) {
        if(nums.length == 0) return 0;
        int x1 = 0;
        int x2 = 0;
        for(int num:nums){
            x1 = x1 ^ num;
        }
        for(int i = 1;i<= nums.length;i++){
            x2 = x2 ^ i;
        }
        return (x1^x2);
    }
}