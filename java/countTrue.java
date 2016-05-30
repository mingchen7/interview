public class countTrue {
	public int countTrue (boolean[] A){
		int count = 0;
		for(int i = 0; i < A.length; i++){
			if((i == 0 && A[i] == true) || (A[i] == true && A[i-1] == false)){
				count++;
			}
		}
		return count;
	}
	public static void main (String args[]){
		countTrue test = new countTrue();
		boolean[] data = {true,true,true,false,false,true,false,true,false,false,true,true,true};
		System.out.println(test.countTrue(data));	
	}
}