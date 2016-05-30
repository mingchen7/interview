public class LoveLetter {
	public int convert (String s){
		if(s == null || s.length() == 0){
			return 0;
		}

		int len = s.length();
		int mid = len / 2;
		int left, right;
		if(len % 2 == 0){
			left = mid - 1;
			right = mid;
		}
		else{
			left = mid -1;
			right = mid + 1;
		}

		int count = 0;
		while(left >= 0 && right < len){
			int delta = Math.abs(s.charAt(left) - s.charAt(right));
			count = count + delta;
			left--;
			right++;
		}
		return count;
	}

	public static void main (String args[]){
		LoveLetter sol = new LoveLetter();
		String s = "aaaaaabaaaaa";
		System.out.println(sol.convert(s));
	}
}