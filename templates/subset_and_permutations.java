public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0) {
            return result;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(num);  
        subsetsHelper(result, list, num, 0);
        
        return result;
    }


    private void subsetsHelper(ArrayList<ArrayList<Integer>> result,
        ArrayList<Integer> list, int[] num, int pos) {

        result.add(new ArrayList<Integer>(list));

        for (int i = pos; i < num.length; i++) {
            list.add(num[i]);
            subsetsHelper(result, list, num, i + 1);
            list.remove(list.size() - 1);
        }
    }
}

// duplicate numbers
public class Solution {
    public List<List<Integer>> subset(int[] nums) {
        List<List<Integer>> ans = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return ans;
        }

        List<Integer> path = new ArrayList<Integer>();
        Array.sort(nums);
        dfs(nums, path, 0, ans);
        return ans;
    }

    private void dfs(int[] nums, ArrayList<Integer> path, int index, List<List<Integer>> answer) {
        ans.add(new Arraylist<Integer>(path));

        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i-1]) {
                continue;
            }

            path.add(nums[i]);
            dfs(nums, path, i+1,answer);
            path.remove(path.size() - 1);
        }
    }
}

// permutation with duplicates
public class Solution {
    public ArrayList<ArrayList<Integer>> permutations(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        int[] visited = new int[nums.length];
        ArrayList<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, path, visited, result);
        return result;  
    }

    private void dfs(int[] nums, ArrayList<Integer> path, int[] visited, Arraylist<ArrayList<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<Integer>(path));
        }

        for (int i = 0; i < nums.length; i++) {
            if (i-1 >= 0 && !visited[i-1] && nums[i] == nums[i-1]){
                continue;
            }   

            if (visited[i] == 1) {
                continue;
            }

            visited[i] = 1;
            path.add(nums[i]);
            dfs(nums, path, visited, result);
            path.remove(path.size() - 1);
            visited[i] = 0;
        }
    }
}

