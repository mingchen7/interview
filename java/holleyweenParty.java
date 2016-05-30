public class holleyweenParty {	
	public int maxServe(int cuts){
		int res = 0;
		int delta = 0;
		for(int k = 0; k <= cuts; k++){			
			res = res + delta;			
			if(k % 2 != 0){
				delta++;
			}
		}					
		return res;
	}

	public long maxServe2(int k){
		return k/2 * (k - k/2);
	}

	public static void main (String args[]){
		holleyweenParty sol = new holleyweenParty();
		for(int i = 0; i < 10; i ++){
			System.out.println(sol.maxServe2(i));	
		}		
	}
}
