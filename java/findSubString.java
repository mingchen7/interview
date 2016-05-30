// Substring with Concatenation of All Words
// ac solution - consice
public List<Integer> findSubstring(String s, String[] words) {
    Map<String, Integer>map = new HashMap<String, Integer>();
    //Runtime = O(wordsSize)
    for (String w : words) map.put(w, map.containsKey(w) ? map.get(w) + 1: 1);// Count the amount for each distinct word

    int len = words[0].length(), allLen = len * words.length; 
    List<Integer> res = new LinkedList<Integer>();
    for (int i = 0; i <= s.length() - allLen; i++) {//Runtime = O(n) * O(validate function) = O(n) * O(n) = O(n^2)
        Map<String, Integer>mapTmp = new HashMap<String, Integer>(map);
        if (validate(s, i, len, allLen, mapTmp))// Validate whether the substring starting with i is a concatenation of each word in words 
            res.add(i);
    }
    return res;
} 

//Runtime = O(n/wordLength * wordLength) = O(n)
private boolean validate(String s, int i, int len, int allLen, Map<String, Integer>map) {
    for (int j = i; j < i + allLen; j+=len) {//Runtime = O(n/wordLength)
        String str = s.substring(j, j + len);// Runtime = O(wordLength)      
        if (map.get(str) == null) return false;
        int count = map.get(str);
        if (count == 1) map.remove(str);
        else map.put(str, count - 1); 

        if (map.isEmpty())// All words are placed concatenately 
            return true;        
    }
    return false;
}  

// my version
import java.util.*;
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int numWords = words.length;
        if(numWords == 0) 
            return new ArrayList<Integer>();
        int wordlength = words[0].length();
        if(s.length() < numWords * wordlength) 
            return new ArrayList<Integer>();
            
        //create hashset
        HashMap<String,Integer> refMap = new HashMap<String,Integer>();
        for(String word:words){
            if(refMap.containsKey(word)){
                refMap.put(word,refMap.get(word)+1);
            }
            else{
                refMap.put(word,1);    
            }
        }
        
        List<Integer> res = new ArrayList<Integer>();
        // loop over s
        char chs[] = s.toCharArray();
        for(int i = 0; i<=chs.length-numWords*wordlength; i++){
            String tmpWord = String.valueOf(Arrays.copyOfRange(chs,i,i+wordlength));
            //System.out.println(tmpWord);
            if(refMap.containsKey(tmpWord)){
                int j = i;
                HashMap<String,Integer> tmpMap = new HashMap<String,Integer>(refMap);                
                tmpMap.put(tmpWord,refMap.get(tmpWord)-1);
                j = j +wordlength;
                for(int k = 1; k < numWords; k++){
                    tmpWord = String.valueOf(Arrays.copyOfRange(chs,j,j+wordlength));                    
                    if(tmpMap.containsKey(tmpWord)){
                        tmpMap.put(tmpWord,tmpMap.get(tmpWord)-1);
                        j = j+wordlength;
                    }
                    else break;
                }
                if(helper(tmpMap)){
                    res.add(i);
                }
            }
        }
        return res;
    }
    
    private boolean helper(HashMap<String,Integer> map){
        for(String word:map.keySet()){
            if(map.get(word) !=0) return false;
        }
        return true;
    }
}


