//一个大小为n的数组，里面的数都属于范围[0, n-1]，有不确定的重复元素，找到至少一个重复元素，要求O(1)空间和O(n)时间。
public class FindDuplicate{
	public int findDuplicate(int a[], int n){
		int i;
		for(i = 0; i < n; i++){
			while(i != a[i]){
				// found duplicate
				if(a[i] == a[a[i]]) return a[i];
				// swap a[i] and a[a[i]]
				int tmp = a[i];
				a[i] = a[a[i]];
				a[a[i]] = tmp;
			}

		}
		return -1; // no duplicate
	}
	
	public static void main(Strings args[]){
		
	}
}
