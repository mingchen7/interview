public class findSecondLargestNumber{
	public int SecondLargestNumber(int[] nums){
		int first = Integer.MIN_VALUE;
		int second = Integer.MIN_VALUE;
		for(int num: nums){
			if(num > first){
				second = first;
				first = num;
			}
			else if(num > second){
				second = num;
			}
			else{
				continue;
			}			
		}
		return second;
	}

	public int ThirdLargestNumber(int[] nums){
		int first = Integer.MIN_VALUE;
		int second = Integer.MIN_VALUE;
		int third = Integer.MIN_VALUE;
		for(int num:nums){
			if(num > first){
				third = second;
				second = first;
				first = num;
			}
			else if(num > second){
				third = second;
				second = num;
			}
			else if(num > third){
				third = num;
			}
			else{
				continue;
			}
		}

		return third;
	}

	public static void main(String args[]){
		findSecondLargestNumber test = new findSecondLargestNumber();
		int[] numbers = {1,2,3,4,5,6,7,8,9,10};		
		int secondLargest = test.SecondLargestNumber(numbers);
		int thirdLargest = test.ThirdLargestNumber(numbers);
		System.out.println(secondLargest);
		System.out.println(thirdLargest);
	}
}