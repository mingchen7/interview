public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        HashSet<Character> set = new HashSet<Character>();
        
        int leftBound = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                while (leftBound < i && s.charAt(leftBound) != s.charAt(i)) {
                    set.remove(s.charAt(leftBound));
                    leftBound ++;
                }
                leftBound ++;
            } else {
                set.add(s.charAt(i));
                max = Math.max(max, i - leftBound + 1);
            }
        }
        
        return max;
    }
}



/*
public class LongestSubstringRepeatingCharacter {
	public int Substring (String s){
		char chs[] = s.toCharArray();
		int max_length = 0;
		int index = 0;
		int start = 0;
		int end = 0;
		for(int i = 0; i < chs.length-1; i++){
			if(i != 0 && chs[i] != chs[i-1]){
				start = i;
			}

			if(chs[i] != chs[i+1]){
				end = i;
				int length = end - start + 1;
				if(length > max_length){
					max_length = length;
					index = start;
				}
			}
		}
		return index;
	}

	public static void main (String args[]){
		LongestSubstringRepeatingCharacter test = new LongestSubstringRepeatingCharacter();
		System.out.println(test.Substring("abcccccdeeeeeeefffffffffgsjkdj"));
	}
}
*/