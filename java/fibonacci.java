public class Fibonacci{
	int max = 1000;
	long[] fib = new long[max];

	//recursion version
	public long fibonacciNum(int i){
		if (i == 0) return 0;
		if (i == 1) return 1;

		if (fib[i] != 0) return fib[i];
		fib[i] = fibonacciNum(i-1) + fibonacciNum(i-2);
		return fib[i];
	}

	//loop version
	public long fibonacciNum2(int i){
		if (i == 0) return 0;
		if (i == 1) return 1;

		long num1 = 0;
		long num2 = 1;
		long tmp;

		while(i>2){
			tmp = num1 + num2;
			num1 = num2;
			num2 = tmp;			
			i--;
		}

		return num2;

	}

	public static void main(String args[]){
		Fibonacci fib = new Fibonacci();
		for(int i = 0; i < 50; i++){
			System.out.println(i);
			System.out.println(fib.fibonacciNum(i));
		}

		System.out.println(fib.fibonacciNum2(50));
		
		//double ans = Math.pow(2,31);
		//System.out.println(ans);
	}
}