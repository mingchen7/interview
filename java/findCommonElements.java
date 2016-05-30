import java.util.*;

public class findCommonElements{
	public ArrayList<Integer> CommonElements(int[] a, int[] b){
		HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
		for(int num:a){
			if(map.containsKey(num)){
				map.put(num, map.get(num)+1);
			}
			else{
				map.put(num,1);
			}
		}

		ArrayList<Integer> result = new ArrayList<Integer>();		
		for(int num:b){
			if(map.containsKey(num)){
				result.add(num);
			}
		}
		return result;
	}

	public static void main(String args[]){
		int[] array1 = {1,2,3,4,5,6,7,8,9,10};
		int[] array2 = {2,4,6,8,10};
		findCommonElements test = new findCommonElements();
		ArrayList<Integer> ans = test.CommonElements(array1, array2);
		for(int num : ans){
			System.out.print(num + ",");
		}
		System.out.print("\n");
	}	
}