/* 
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].

Show Company Tags
Show Tags
Show Similar Problems
*/

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (nums.length ==0) return ans;
        List<Integer> l0 = new ArrayList<Integer>();
        l0.add(nums[0]);
        ans.add(l0);
        for (int i = 1; i< nums.length; ++i){
            List<List<Integer>> new_ans = new ArrayList<List<Integer>>(); 
            for(List<Integer> l: ans){
                for(int j = 0; j <= i; ++j){
                    List<Integer> new_l = new ArrayList<Integer>(l);
                    new_l.add(j,nums[i]);
                    new_ans.add(new_l); 
                    // IMPORTANT: avoid duplicate permutation
                    // if the original index replaced by j, i.e., j+1, has the same number as nums[i], then skip
                    // pay attention to the boundary of j, as j is now the index of the new inserted number 
                    if(j < new_l.size()-1 && new_l.get(j+1) == nums[i]){
                        break;
                    }
                }    
            }
            ans = new_ans;
        }
        return ans;
    }
}
