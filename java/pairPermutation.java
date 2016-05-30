import java.util.*;

public class pairPermutation {
	public boolean isitPossible(int a, int b, int c, int d){
		if(a > c || b > d){
			return false;
		}		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(a);
		list.add(b);		
		return helper(c, d, list);
	}

	public boolean helper(int targetX, int targetY, ArrayList<Integer> curList){		
		// System.out.println(curList.get(0));
		// System.out.println(curList.get(1));
		if(curList.get(0) == targetX && curList.get(1) == targetY){
			return true;
		}
		
		boolean leftRes = false; 
		boolean rightRes = false;
		int sum = curList.get(0) + curList.get(1);

		if(sum <= targetX && curList.get(1) <= targetY){
			ArrayList<Integer> leftPair = new ArrayList<Integer>();
			leftPair.add(sum);
			leftPair.add(curList.get(1));
			leftRes = helper(targetX, targetY, leftPair);
		}
		
		if(curList.get(0) <= targetX && sum <= targetY){
			ArrayList<Integer> rightPair = new ArrayList<Integer>();
			rightPair.add(curList.get(0));
			rightPair.add(sum);			
			rightRes = helper(targetX, targetY, rightPair);
		}
						
		return leftRes || rightRes;
	}


	public static void main (String args[]){
		pairPermutation sol = new pairPermutation();
		System.out.println(sol.isitPossible(1,4,10,9));
	}
}


// on the hackerrank
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Solution sol = new Solution();
        try {
            InputStreamReader in= new InputStreamReader(System.in);
            BufferedReader input = new BufferedReader(in);
            String str;
            int k = Integer.parseInt(input.readLine());
            while(k > 0){
                str = input.readLine();
                String[] strs = str.split(" ", 4);
                int a = Integer.parseInt(strs[0]);
                int b = Integer.parseInt(strs[1]);
                int x = Integer.parseInt(strs[2]);
                int y = Integer.parseInt(strs[3]);
                
                BigInteger big_a = BigInteger.valueOf(a);
                BigInteger big_b = BigInteger.valueOf(b);
                BigInteger big_x = BigInteger.valueOf(x);
                BigInteger big_y = BigInteger.valueOf(y);
                int gcdStart = big_a.gcd(big_b).intValue();
                int gcdEnd = big_x.gcd(big_y).intValue();
                                                
                if(gcdStart == gcdEnd){
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                } 

                k--;
            }            
        } catch(IOException io){
            io.printStackTrace();
        }           
    }        
}



// Solution 1: using greatest common divisor        
// Suppose the greatest common divisor of a and b is c, then a = m*c, b = n*c, m and n are integers greater than 1
// transform 1: (a+b, b) = (m*c + n*c, n*c)
// transform 2: (a, a+b) = (m*c, m*c + n*c)
// since c is the greatest common divisor, m and n do not have common divisor
// Otherwise, c multiply their common divisor can be even larger
// Therefore, c is also the greatest common divisor of a, b, and a+b 
// In fact, given an integer k, c should also be the gcd of pair(a+kb, b) or pair(a, a+kb)
// So in order to get (c, d) from (a, b), the gcd of a and b should equal to the gcd of c and d.

// BigInteger a_prime = BigInteger.valueOf(a);
// BigInteger b_prime = BigInteger.valueOf(b);
// BigInteger c_prime = BigInteger.valueOf(c);
// BigInteger d_prime = BigInteger.valueOf(d);

// int gcdStart = a_prime.gcd(b_prime).intValue();
// int gcdEnd = c_prime.gcd(d_prime).intValue();

// if(gcdStart == gcdEnd){
//     return "YES";
// }
// else{
//     return "NO";
// }          