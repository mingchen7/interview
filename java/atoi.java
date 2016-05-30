public class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if(str.length() == 0) return 0;
        
        str = str.toCharArray(str);
        long res = 0;
        int sign = 1;
        if(str[0] = '-') sign = -1;
        else if(str[0] == '+') sign = 1;
        else if(str[0] < '0' || str[0] > '9') return 0;
        else{
            res = res + (int)str[0];   
        }
        
        for(int i = 1; i < str.length(); i++){
            if(str[i] < '0' || str[i] > '9') 
                return (int)sign*res;
            res = res*10 + (int)str[i];
            if(res > Integer.INT_MAX) break;
        }
        if(sign*res > Integer.INT_MAX) return Integer.INT_MAX;
        if(sign*res < Integer.INT_MIN) return Integer.INT_MIN;
        
        return (int)sign*res;
    }
}