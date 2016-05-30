public class Solution {
    public List<List<String>> groupAnagrams(String[] s) {
        if (s == null || s.length == 0) return new ArrayList<List<String>>();
        
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        Arrays.sort(s);
        for (String str : s) {
            char chs[] = str.toCharArray();
            Arrays.sort(chs);
            String key = String.valueOf(chs);
            if (!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);          
        }
        return new ArrayList<List<String>>(map.values());
    }
}