public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        long t = 1;
        // find the number of digits
        while (x / t != 0) {
            t *= 10;
        }

        int base = (int) (t / 10);
    
        while (x != 0) {
            int last = x % 10;
            int first = x / base;
            if (last != first)
                return false;
            x = (x % base) / 10;  // take out both the highest and lowest digit
            base /= 100; 
        }
        return true;
    }
}