public class reverseString {
	public String reverse(String s){
		int n = s.length();
		if(n == 0) return s;

		char chs[] = s.toCharArray();
		int mid = 0;
		
		//even number
		if(n % 2 == 0){
			mid = n / 2 -1;
			for(int i = 0; i <=mid; i++){
				char tmp = chs[i];
				chs[i] = chs[n-1-i];
				chs[n-1-i] = tmp;
			}
		}
		//odd number
		else{
			mid = n / 2;
			for(int i = 0; i < mid; i++){
				char tmp = chs[i];
				chs[i] = chs[n-1-i];
				chs[n-1-i] = tmp;
			}
		}

		String result = String.valueOf(chs);
		return result;
	}

	public static void main(String agrs[]){
		String input = "abcdefgh";
		reverseString test = new reverseString();
		String ans = test.reverse(input);
		System.out.println(ans);
	}
}