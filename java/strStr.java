public class Solution {
    public int strStr(String haystack, String needle) {
        int length = needle.length();
        if(length > haystack.length()) return -1;
        for(int i = 0; i <= haystack.length() - length; i++){
            String tmp = haystack.substring(i,i+length);
            if(needle.equals(tmp))
                return i;
        } 
        return -1;
    }
}