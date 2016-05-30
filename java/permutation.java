/*
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/

// add the number n to all the permutations of 0~n-1
import java.util.*;
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0) return res;
        if(nums.length == 1){
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.add(nums[0]);
            res.add(tmp);
            return res;
        }
        
        List<List<Integer>> curLists = permute(Arrays.copyOfRange(nums,0,nums.length-1));
        int newnum = nums[nums.length-1];
        for(List<Integer> tmpList:curLists){
            for(int i=0; i<=tmpList.size();i++){
                List<Integer> tmp = new ArrayList<Integer>(tmpList);
                tmp.add(i,newnum);
                res.add(tmp);
            }
        }
        return res;
    }
}


// unique permutation
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
