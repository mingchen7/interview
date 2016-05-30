// given a matrix M, return a matrix in which each elements is the sum of all top & left elements in the M.
// E(i,j) = E(i-1,j) + E(i,j-1) - E(i-1. j-1) + matrix(i,j)
public class MatrixSum {
	public int[][] topleftSum (int[][] matrix, int m, int n){		
		int[][] res = new int[m][n];

		// calculate boundary values
		res[0][0] = matrix[0][0];
		for(int row = 1; row <m; row++){
			res[row][0] = res[row-1][0] + matrix[row][0];
		}
		for(int col = 1; col <n; col++){
			res[0][col] = res[0][col-1] + matrix[0][col];
		}

		int i = 1;
		int j = 1;
		// loop over the matrix
		while(i < m || j < n){
			//  ith row 
			for(int col = 1; col < j; col++){
				res[i][col] = res[i-1][col] + res[i][col-1] - res[i-1][col-1] + matrix[i][col];				
			}

			// jth col
			for(int row = 1; row <i ; row++){
				res[row][j] = res[row-1][j] + res[row][j-1] - res[row-1][j-1] + matrix[row][j];
			}

			// entry(i,j)
			res[i][j] = res[i-1][j] + res[i][j-1] -res[i-1][j-1] + matrix[i][j];			
			if(i < m) i++;
			if(j < n) j++;
		}

		return res;
	}

	public static void main (String args[]){
		MatrixSum test = new MatrixSum();
		int[][] m = new int[5][5];
		for(int i=0; i<5;i++){
			for(int j=0; j<5; j++){
				m[i][j] = i*j;
			}
		}

		int[][] ans = test.topleftSum(m, 5, 5);
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++){
				System.out.print(ans[i][j] + ",");
			}
			System.out.print("\n");
		}
	}
}