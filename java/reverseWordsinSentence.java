import java.util.*;

// using stack, O(n) space
public class Solution {
    public String reverseWords(String s) {
        if(s.length() == 0) return s;
        
        Stack<String> stack = new Stack<String>();
        String[] strs = s.trim().split("\\s+");
        
        for(String word:strs){
            stack.push(word);
            System.out.println(word);
        }        
        
        StringBuffer ans = new StringBuffer();
        while(stack.size()>0){
            String word = stack.pop();
            ans.append(word);
            if(stack.size() > 0){
                ans.append(" ");
            }
        }
        return ans.toString();
    }
}


// better version
// O(1) space
public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.trim();
        for(int i = s.length() - 1, j = i + 1; i >= 0; i--){
            if(i == 0 || s.charAt(i) != ' ' && s.charAt(i-1) == ' ')
                sb.append(s.substring(i, j)).append(' ');
            else if(s.charAt(i) == ' ') 
                j = i;
        }
        return sb.length() > 0 ? sb.deleteCharAt(sb.length() - 1).toString() : "";
    }

// same thing, my version
import java.util.*;
public class Solution {
    public String reverseWords(String s) {
        if(s.length() == 0) return s;
        StringBuilder sb = new StringBuilder();
        s = s.trim();
        int j = s.length() - 1;
        for(int i = j; i >= 0; i--){
            if(i == 0 || s.charAt(i) != ' ' && s.charAt(i-1) == ' '){
                sb.append(s.substring(i,j+1));
                sb.append(" ");
            }
            else if(s.charAt(i) == ' '){
                j = i - 1;
            }
        }
        
        return sb.length() > 0? sb.deleteCharAt(sb.length() - 1).toString() : "";
    }
}    