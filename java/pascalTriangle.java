import java.util.*;
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numRows <= 0) return res;
        //initialization
        List<Integer> firstrow = new ArrayList<Integer>();
        firstrow.add(1);
        res.add(firstrow);
        
        List<Integer> lastrow;
        for(int i = 1; i < numRows; i++){
            ArrayList<Integer> newrow = new ArrayList<Integer>();
            lastrow = res.get(i-1);
            for(int j = 0; j < lastrow.size();j++){
                int num = lastrow.get(j);
                if(j == 0){
                    newrow.add(num);
                }
                else{
                    newrow.add(num + lastrow.get(j-1));    
                }
                if(j == lastrow.size()-1)
                    newrow.add(num);
            }
            res.add(newrow);
        }
        return res;
    }
}