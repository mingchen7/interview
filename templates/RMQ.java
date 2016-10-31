// Range Minimum/Maximum Query with Sparse Table Algorithm 
// query time O(1) with extra space O(n Log n).

// The idea is to precompute minimum of all subarrays of size 2j where j varies from 0 to Log n. 
// Like method 1, we make a lookup table. 
// Here lookup[i][j] contains minimum of range starting from i and of size 2j. 
// For example lookup[0][3] contains minimum of range [0, 7] (starting with 0 and of size 23)


// Filling the table
// If arr[lookup[0][3]] <=  arr[lookup[4][7]], 
// then lookup[0][7] = lookup[0][3]
If arr[lookup[i][j-1]] <= arr[lookup[i+2j-1-1][j-1]]
   lookup[i][j] = lookup[i][j-1]

// If arr[lookup[0][3]] >  arr[lookup[4][7]], 
// then lookup[0][7] = lookup[4][7]
Else 
   lookup[i][j] = lookup[i+2j-1-1][j-1] 


// Query
// For any arbitrary range [l, R], we need to use ranges which are in powers of 2. 
// The idea is to use closest power of 2. 
// We always need to do at most comparison (compare minimum of two ranges which are powers of 2). 
// One range starts with L and and ends with “L + closest-power-of-2″. 
// The other range ends at R and starts with “R – same-closest-power-of-2 + 1″. 
// For example, if given range is (2, 10), we compare minimum of two ranges (2, 9) and (3, 10).   


// For (2,10), j = floor(Log2(10-2+1)) = 3
j = floor(Log(R-L+1))

// If arr[lookup[0][7]] <=  arr[lookup[3][10]], 
// then RMQ(2,10) = lookup[0][7]
If arr[lookup[L][j]] <= arr[lookup[R-(int)pow(2,j)+1][j]]
   RMQ(L, R) = lookup[L][j]

// If arr[lookup[0][7]] >  arr[lookup[3][10]], 
// then RMQ(2,10) = lookup[3][10]
Else 
   RMQ(L, R) = lookup[i+2j-1-1][j-1]