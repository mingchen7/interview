// dp method
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int n = s.length();
        if(n == 0){
            return true;
        }

        //dp[i] = true if there is a solution in prefix text[0..i]
        boolean[] dp = new boolean[n];  

        //try all possible prefixes
        for(int i = 0; i< n; i++){
            //check from dp if current length prefix is a solution
            //if not then the prefix should be present in dictionary
            if(dp[i] == false && wordDict.contains(s.substring(0, i+1))){
                dp[i] = true;
            }

            //if this prefix contains in dictionary the try to extend the prefix up to end of the string
            if(dp[i] == true){
                for(int j = i+1; j < n; j++){
                    //check id dp[j] already computed to a solution , 
                    //other wise we need to check if text[i+1..i] contains in the dict.
                    //so that we can create a longer prefix text[0..j]
                    if(dp[j] == false){
                        dp[j] = wordDict.contains(s.substring(i+1, j+1));
                    }
                }
            }
        }
        return dp[n-1];
    }
}