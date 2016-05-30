import java.util.*;

public class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0) return false;
        
        Stack stack = new Stack();
        char chs[] = s.toCharArray();
        for(char c:chs){
            if(c == '(' || c== '[' || c== '{'){
                stack.push(c);
            }
            else
            {
                if(stack.size() == 0) return false;                
                char c2 = (char)stack.pop();
                if(c == ')' && c2 != '(') return false;
                if(c == ']' && c2 != '[') return false;
                if(c == '}' && c2 != '{') return false;
            }
        }
        return stack.size() == 0;
    }
}


import java.util.*;
public class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0) return false;
        final String opening = "({[";
        final String closing = ")}]";
        Stack<Character> stack = new Stack<>();
        for(char c:s.toCharArray()){
            if(opening.indexOf(c) != -1){
                stack.push(c);
            } 
            else{
                if(stack.empty()) return false;
                char c2 = stack.pop();
                if(opening.indexOf(c2) != closing.indexOf(c))
                    return false;
            }
        }
        return stack.empty();
    }
}