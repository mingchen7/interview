public class Solution {
    public String addBinary(String a, String b) {
        int numDigits = Math.max(a.length(),b.length());
        char[] res = new char[numDigits];
        int digit = 1;
        int carry = 0;
        boolean carrybit = false;
        while(digit <= numDigits){
            char c1, c2;
            if(digit <= a.length()) c1 = a.charAt(a.length() - digit);
            else c1 = '0';
            if(digit <= b.length()) c2 = b.charAt(b.length() - digit);
            else c2 = '0';
            // adding
            if(c1 == '0' && c2 == '0'){
                res[numDigits-digit] = '0';
            }
            else if((c1 == '1' && c2 == '0') || (c1 =='0' && c2=='1')){
                res[numDigits-digit] = '1';
            }
            else{
                res[numDigits-digit] = '0';
                carrybit = true;
            }
            // carry-bit  
            if(carry > 0){
                if(res[numDigits-digit] == '0'){
                    res[numDigits-digit] = '1';    
                    carry--;
                }
                else{
                    res[numDigits-digit] = '0';    
                }
            }
            if(carrybit==true){
                carry++;
                carrybit = false;
            }
            digit++;
        }
        if(carry != 0) return String.valueOf('1') + String.valueOf(res);
        else return String.valueOf(res);
    }
}