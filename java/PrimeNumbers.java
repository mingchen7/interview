//Amazon

public class PrimeNumbers{
	public static void main(String[] args){
        int n = 25;
        for(int i = 2; i < 25; i++){
            if(isPrime(i)){
                System.out.println(i);
            }
        }
	}
    
    //check up to the sqrt root
	public static boolean isPrime(int num){
		if(num < 2){
			return false;
		}
		int sqrt = (int)Math.sqrt(num);
		for(int i=2; i<=sqrt; i++){
			if(num % i == 0){
				return false;       
			}
		}
		return true;
	}    
}