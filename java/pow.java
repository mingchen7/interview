// divide and conquer version
public class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        boolean inverse = false;
        if(n < 0) inverse = true;
        n = Math.abs(n);
        
        if(n % 2 == 0){
            double tmp = myPow(x, n/2);
            if(inverse)
                return 1 / (tmp*tmp);
            else
                return tmp*tmp;
        }
        else{
            double tmp = myPow(x, (n-1)/2);
            if(inverse)
                return 1 / (x*tmp*tmp);
            else
                return x*tmp*tmp;
        }
    }
}


//bit-manipulaion version
public class Solution {
    public double myPow(double x, int n) {
        long m = n > 0 ? n : -(long)n;
        double ans = 1.0;
        while (m != 0) {
            if ((m & 1) == 1)
                ans *= x;
            x *= x;
            m >>= 1;
        }
        return n >= 0 ? ans : 1 / ans;
    }    
}