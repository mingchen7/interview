// pyramid max sum path
//       1
//      / \
//     3   2
//    / \ / \
//   5   6   4
//  / \ / \ / \
// 7   9   8  10


// sum(i,j) = sum(i-1,j) + val(i,j), if i = 0;
// sum(i,j) = sum(i-1,j-1) + val(i,j), if i = j;
// sum(i,j) = max(sum(i-1,j-1), sum(i-1,j)) + val(i,j), other

