public class LongestCommonString {
	public String LongestCommonString(String s1, String s2){
		int m = s1.length();
		int n = s2.length();
		char[] a = s1.toCharArray();
		char[] b = s2.toCharArray();
		int[][] table = new int[m][n]; // table to store lengths of substrings
		int imax = -1;
		int jmax = -1;
		int max_length = 0;

		// filling boundary values
		for(int j = 0; j < n; j++){
			if(a[0] == b[j]) table[0][j] = 1;
			else table[0][j] = 0;
		}

		for(int i = 0; i < m; i++){
			if(a[i] == b[0]) table[i][0] = 1;
			else table[i][0] = 0;	
		}

		// filling main table
		for(int i = 1; i < m; i++){
			for(int j = 1; j < n; j++)
			{
				if(a[i] == b[j]){
					table[i][j] = table[i-1][j-1] + 1;		
					if(table[i][j] > max_length){
						max_length = table[i][j];
						imax = i;
						jmax = j;
					}				
				}
				else{
					table[i][j] = 0;
				}				
			}
		}

		//System.out.println(imax);
		//System.out.println(jmax);

		// recovery
		StringBuffer sb = new StringBuffer();
		while(imax >=0 && jmax >= 0 && table[imax][jmax] != 0){
			sb = sb.append(a[imax]);
			imax--;
			jmax--;
		}
		String res = sb.reverse().toString();
		//System.out.println(max_length);
		return res;

	}

	public static void main(String args[]){
		String s1 = "GeeksforGeeks";
		String s2 = "GeeksQuiz";
		LongestCommonString lcs = new LongestCommonString();
		String s = lcs.LongestCommonString(s1, s2);
		System.out.println(s);
	}
}