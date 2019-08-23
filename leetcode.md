
## Binary Search

## Divide-and-Conquer

## Two-pointers

## BFS

## DFS
[combination sum](https://www.lintcode.com/problem/combination-sum/)  
[string permutation II](https://www.lintcode.com/problem/string-permutation-ii/description)  
[k sum II](https://www.lintcode.com/problem/k-sum-ii/description)  
[N queens](https://www.lintcode.com/problem/n-queens/description)  
[letter combinations of a phone number](https://www.lintcode.com/problem/letter-combinations-of-a-phone-number/description)  
[word search II](https://www.lintcode.com/problem/word-search-ii/description)  
[word ladder II](https://www.lintcode.com/problem/word-ladder-ii/description)  
BFS+DFS

## Hash and Heap
[LRU cache](https://www.lintcode.com/problem/lru-cache/)  
[insert delete get random O(1)](https://www.lintcode.com/problem/insert-delete-getrandom-o1/description)  
follow up：如果有duplicates，需要在hashmap里存indices的list，且array中存(value, index in indices list)。删除时可以从indices list中删掉最后一个index，并在用最后一个num盖掉被删除位置时更新对应index。实现较为复杂。
[first unique number in data stream I/II](https://www.lintcode.com/problem/first-unique-number-in-data-stream/description)  
hashmap+linked list  

[ugly number II](https://www.lintcode.com/problem/ugly-number-ii/description)  
容易想到用heap的做法，但是O(n)的做法很难想到。用三个指针track分别x2，x3，x5能拿到最大的数（小于当前last），新的last在三者x2，x3，x5的最小中产生。   
[k closest points](https://www.lintcode.com/problem/k-closest-points/description)
[top k largest numbers II](https://www.lintcode.com/problem/top-k-largest-numbers-ii/description)  
[merge k sorted lists](https://www.lintcode.com/problem/merge-k-sorted-lists/description)  
python的heap只能存tuple(val, node)，在val相同时会比较node而报错，不太好写。用merge sort更好做。


## Memorize search and DP
[triangle](https://www.lintcode.com/problem/triangle/)  
[wildcard matching](https://www.lintcode.com/problem/wildcard-matching/)  
[regular expression matching](https://www.lintcode.com/problem/regular-expression-matching/)  
[word pattern](https://www.lintcode.com/problem/word-pattern-ii/description)  
无法使用记忆化，太多状态影响结果。  
[word break/word break II/work break III](https://www.lintcode.com/problem/word-break/)  

[stone game](https://www.lintcode.com/problem/stone-game/description)  
[card game](https://www.lintcode.com/problem/card-game/description)  
[knight shortest path I & II](https://www.lintcode.com/problem/knight-shortest-path/)  
[Longest Increasing Subsequence](https://www.lintcode.com/problem/longest-increasing-subsequence/)  
[Russian Doll Envelopes](https://www.lintcode.com/problem/russian-doll-envelopes/)  
[Largest Divisible Subset](https://www.lintcode.com/problem/largest-divisible-subset/)  
