public class Solution {
    public int countPrimes(int n) {
        boolean isComposite[] = new boolean[n];// isComposite[i]: If i is a composite number
        int count = 0;
        for (int i = 2; i < n; i++) {  
            if (!isComposite[i]) { 
                count++; 
                if (i < Math.sqrt(n))
                    for (int j = i * i; j < n; j += i)  
                        isComposite[j] = true;// Mark j as a composite number
            }
        }
        return count;
    }  
}