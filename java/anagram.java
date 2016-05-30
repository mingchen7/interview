import java.util.*;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i=0; i< s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }
            else{
                map.put(c,1);
            }
        }
        
        int length = s.length();
        for(int i=0;i<t.length();i++){
            char c2 = t.charAt(i);
            if(map.containsKey(c2)==false) return false;
            map.put(c2,map.get(c2)-1);
            if(map.get(c2) >= 0){
                length--;
            }
        }
        
        return length == 0;
    }
}