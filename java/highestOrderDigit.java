public class HighestOrderDigit {
	public int findHighestDigit(int num){
		if(num == 0) return 0;
		int ans = 1;
		while(num != 1){
			num = num >> 1;
			ans = ans << 1;
		}
		return ans;
	}

	public static void main (String args[]){
		HighestOrderDigit test = new HighestOrderDigit();
		System.out.println(test.findHighestDigit(127));
	}
}