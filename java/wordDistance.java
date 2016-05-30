// brute-force
import java.util.*;
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        List<Integer> idx1 = new ArrayList<Integer>();
        List<Integer> idx2 = new ArrayList<Integer>();
        for(int i=0; i<words.length; i++){
            if(words[i].equals(word1))
                idx1.add(i);
            if(words[i].equals(word2))
                idx2.add(i);
        }
        int min = Integer.MAX_VALUE;
        for(int i:idx1){
            for(int j:idx2){
                if(Math.abs(i-j) < min){
                    min = Math.abs(i-j);
                }
            }
        }
        return min;
    }
}

// two pointers version
import java.util.*;
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int p1 = -1*words.length;
        int p2 = -1*words.length;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1)){
                p1 = i;
                min = Math.min(min, i-p2);
            }
            if(words[i].equals(word2)){
                p2 = i;
                min = Math.min(min, i-p1);
            }
        }
        return min;
    }
}