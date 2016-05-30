public class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0) return true;
        int low = 0;
        int high = s.length() - 1;
        char chs[] = s.toCharArray();
        while(low < high){
            if(!Character.isLetter(chs[low]) && !Character.isDigit(chs[low])){
                low++;
                continue;
            }
            if(!Character.isLetter(chs[high]) && !Character.isDigit(chs[high])){
                high--;
                continue;
            }
            if(Character.toLowerCase(chs[low]) != Character.toLowerCase(chs[high])){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}