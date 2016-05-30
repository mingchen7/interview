public class pickCoins {
	public int[] pick (int n){
		int[] coins = new int[4];
		if(n > 25){
			coins[0] = n / 25;
			n = n % 25;
		}
		if(n > 10){
			coins[1] = n / 10;
			n = n % 10;
		}
		if(n > 5){
			coins[2] = n / 5;
			n = n % 5;
		}		
		coins[3] = n;
		return coins;

	}
	public static void main (String args[]){
		pickCoins test = new pickCoins();
		int[] res = test.pick(99);
		for(int num : res){
			System.out.println(num);
		}
	}
}