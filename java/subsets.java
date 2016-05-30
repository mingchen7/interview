// loop
public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>>res = new LinkedList<>();
    Arrays.sort(nums);     
    res.add(new LinkedList<Integer>());
    for (int x : nums) {
        List<List<Integer>>curSubs = new LinkedList<>();// Add all subsets ending with x
        for (List<Integer> sub : res) {
            List<Integer> curSub = new LinkedList<Integer>(sub);
            curSub.add(x);
            curSubs.add(curSub);            
        }
        res.addAll(curSubs);
    }
    return res;
}   


// recursive
public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>>res = new LinkedList<List<Integer>>();
    Arrays.sort(nums); 
    DFS(nums, 0, new LinkedList<Integer>(), res);
    return res;
}   

void DFS(int[] nums, int start, List<Integer>curList, List<List<Integer>>res) {
    res.add(new LinkedList<Integer>(curList));// Add all possible subsets to the result         
    for (int i = start; i < nums.length; i++) {
        curList.add(nums[i]);
        DFS(nums, i + 1, curList, res);// Next start should be i + 1
        curList.remove(curList.size() - 1);// Backtracking      
    }
}
