public class NumOfBit1 {
	public int numOfBit1(int number) {
		int count = 0;
		while(number != 0){
			if(number % 2 != 0){
				count++;
			}
			number = number >> 1;
		}
		return count;
	}
	public static void main (String args[]){
		NumOfBit1 test = new NumOfBit1();
		System.out.println(test.numOfBit1(100));
	}
}


// accepted and faster version
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        int ref = 1;
        for(int i = 0; i < 32; i++){
            if((n & ref) != 0){
                count++;
            }
            ref = ref << 1;
        }
        return count;
    }
}