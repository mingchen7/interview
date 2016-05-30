import java.util.*;
public class Solution {
    public int titleToNumber(String s) {
        char chs[] = s.toCharArray();
        int res = 0;
        for(int i = 0; i<chs.length; i++){
            char c = chs[i];
            res = res*26 + c - 'A'+1;
        }
        return res;
    }
}