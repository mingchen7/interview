
## Binary Search
[classic binary search](https://www.lintcode.com/problem/classical-binary-search/description)  
[search in a sorted array](https://www.lintcode.com/problem/search-in-a-big-sorted-array/description)  
[find k closest elements](https://www.lintcode.com/problem/find-k-closest-elements/description)  
[maximum number in a mountain sequence](https://www.lintcode.com/problem/maximum-number-in-mountain-sequence/description)  
[find minimum in rotated sorted array](https://www.lintcode.com/problem/find-minimum-in-rotated-sorted-array/description)  
[search in rotated sorted array](https://www.lintcode.com/problem/find-minimum-in-rotated-sorted-array/description)  
[find peak element](https://www.lintcode.com/problem/find-peak-element/)  
[median of k sorted array](https://www.lintcode.com/problem/median-of-k-sorted-arrays/description)  
根据数值进行二分而非index。证明二分所得的数在所给的数组中很重要 - 二分的判断条件是kth smallest，会一直判断至满足条件且在数组中的那个值。

## Divide-and-Conquer
[minimum subtree](https://www.lintcode.com/problem/minimum-subtree/description)  
[binary tree path](https://www.lintcode.com/problem/binary-tree-paths/description)  
[lowest common ancestor I/II/III](https://www.lintcode.com/problem/lowest-common-ancestor-of-a-binary-tree/description)  
TODO: [kth smallest element in BST](https://www.lintcode.com/problem/kth-smallest-element-in-a-bst/description)  
TODO: [binary search tree iterator](https://www.lintcode.com/problem/binary-search-tree-iterator/description)  
TODO: [closest binary search tree value I/II](https://www.lintcode.com/problem/closest-binary-search-tree-value/description)  
TODO: [search range in a BST](https://www.lintcode.com/problem/search-range-in-binary-search-tree/description)  

## Two-pointers
### 背向指针
[valid palindrome I/II](https://www.lintcode.com/problem/valid-palindrome/description)  
[two sum unique pairs](https://www.lintcode.com/problem/two-sum-unique-pairs/description)  
TODO: [two sum less than/equal to target](https://www.lintcode.com/problem/two-sum-less-than-or-equal-to-target/description)  
TODO: [two sum greater than target](https://www.lintcode.com/problem/two-sum-greater-than-target/description)  
TODO: [two sum closest to target](https://www.lintcode.com/problem/two-sum-closest-to-target/description)  
TODO: [3 sum closest](https://www.lintcode.com/problem/two-sum-closest-to-target/description)  
[3 sum](https://www.lintcode.com/problem/3sum/)  
TODO: [4 sum](https://www.lintcode.com/problem/4sum/)  
[triangle count](https://www.lintcode.com/problem/triangle-count/description)  


### Partition类
[partition array](https://www.lintcode.com/problem/partition-array/description)  
TODO: [quick select](https://www.lintcode.com/problem/kth-smallest-numbers-in-unsorted-array/description)  
[interleaving positive and negative numbers](https://www.lintcode.com/problem/interleaving-positive-and-negative-numbers/description)  
[sort letters by case](https://www.lintcode.com/problem/sort-letters-by-case/description)  
[sort colors](https://www.lintcode.com/problem/sort-colors/description)  
partition成三个部分  

[rainbow sort](https://www.lintcode.com/problem/sort-colors-ii/description)  
本质是个divide and conquer


### 同向双指针 (滑动窗口，快慢指针)
[move zeros](https://drive.google.com/drive/my-drive)  
TODO: [intersection of two linked list](https://www.lintcode.com/problem/intersection-of-two-linked-lists/description)  
TODO: [linked list cycle I/II](https://www.lintcode.com/problem/linked-list-cycle/description)  


## BFS
[binary tree level order traversal I/II](https://leetcode.com/problems/binary-tree-level-order-traversal/)  
[serialize and deserialize](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/)  
[binary tree zigzag level order traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)  
[clone graph](https://leetcode.com/problems/clone-graph/)  
[word ladder](https://www.lintcode.com/problem/word-ladder/description)  
这题leetcode和lintcode对end word是否包含稍有不同。

[number of islands](https://www.lintcode.com/problem/number-of-islands/description)  
[knight shortest path](https://www.lintcode.com/problem/knight-shortest-path/description)  
[topological sorting](https://www.lintcode.com/problem/topological-sorting/)  
[course schedule I/II](https://www.lintcode.com/problem/course-schedule/description)  
[alien dictionary](https://www.lintcode.com/problem/alien-dictionary/description)  


BFS time complexity: O(N+M)， N为点数，M为边数。


## DFS
[combination sum](https://www.lintcode.com/problem/combination-sum/)  
[string permutation II](https://www.lintcode.com/problem/string-permutation-ii/description)  
[k sum II](https://www.lintcode.com/problem/k-sum-ii/description)  
[N queens](https://www.lintcode.com/problem/n-queens/description)  
[letter combinations of a phone number](https://www.lintcode.com/problem/letter-combinations-of-a-phone-number/description)  
[word search II](https://www.lintcode.com/problem/word-search-ii/description)  
[word ladder II](https://www.lintcode.com/problem/word-ladder-ii/description)  
可以有多种解法：  
1) DFS搜所有解，再筛选出所有最短路径  
2) BFS先搜最短路径，再用DFS搜并根据最短路径剪枝  
3) (optimal) BFS从终点开始搜，记录距离。用DFS开始搜，每一步仅考虑往距离变小的方向搜(distance-1)  

## Data Structures

### Hash and heap
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

TODO: [trapping rain water I/II](https://www.lintcode.com/problem/trapping-rain-water/description)  
技巧：矩阵从外向内遍历
TODO: [data stream median](https://www.lintcode.com/problem/find-median-from-data-stream/description)    
TODO: [sliding window median](https://www.lintcode.com/problem/sliding-window-median/description)  

**Heap解说**

indexing: 左右子节点2*i+1 / 2*i+2， 父节点(i-1) / 2
add(): O(logn)  
pop(): O(logn)  
remove(): O(n)，可借用hash+heap优化至O(logn)  
top(): O(1)  
heapify(): O(n)

```
def sift_up(id):
  while (parent(id) > -1):
    parent_id = parent(id)
    if heap.get(parent_id) < heap.get(id):
      break
    else:
      swap(id, parent_id)
    id = parent_id    
```

```
def sift_down(id):
  while lson(id) < heap.size():
    left_id = lson(id)
    right_id = rson(id)
    if right_id > heap.size() or heap.get(left_id) < heap.get(right_id):
      son = left_id
    else:
      son = right_id

    if heap.get(id) < heap.get(son):
      break
    else:
      swap(id, son)
    id = son    
```

### Stack

### Deque
TODO: [sliding window maximum](https://www.lintcode.com/problem/sliding-window-maximum/description)  
维护一个递减队列，队列头为当前window的max。  

TODO: [sliding window matrix maximum](https://www.lintcode.com/problem/sliding-window-matrix-maximum/description)  

### Trie
[implement Trie](https://www.lintcode.com/problem/implement-trie-prefix-tree/description)  
TODO: [add and search word](https://www.lintcode.com/problem/add-and-search-word-data-structure-design/description)  


### UnionFind
[find the connected component in the undirected graph](https://www.lintcode.com/problem/connected-component-in-undirected-graph/description)  
经典的连通块问题，但用BFS/DFS也都可以做，感觉用union find反而写更多。

TODO: [find the weak connected component in the directed graph](https://www.lintcode.com/problem/find-the-weak-connected-component-in-the-directed-graph/description)  
TODO: [number of islands II](https://www.lintcode.com/problem/number-of-islands-ii/)  
TODO: [graph valid tree](https://www.jiuzhang.com/solutions/graph-valid-tree/)  
TODO: [surrounded regions](https://www.lintcode.com/problem/surrounded-regions/description)  


```
class UnionFind(object):

    def __init__(self, labels):
        self.father = {}
        for x in labels:
            self.father[x] = x

    # amortized time complexity O(1)
    def compress_find(self, x):
        parent = self.father[x]
        while parent != self.father[parent]:
            parent = self.father[parent]

        while x != self.father[x]:
            next_val = self.father[x]
            self.father[x] = parent
            x = next_val

        return parent

    # amortized time complexity O(1)
    def union(self, x, y):
        father_x = self.compress_find(x)
        father_y = self.compress_find(y)

        if father_x != father_y:
            self.father[father_x] = father_y
```

### Sweep line
TODO: [number of airlines in the sky](https://www.lintcode.com/problem/number-of-airplanes-in-the-sky/)  
TODO: [building outline](https://www.lintcode.com/en/problem/building-outline/)  
涉及到heap的删除操作。


## Memorize search and DP
[longest palindromic substring](https://www.lintcode.com/problem/longest-palindromic-substring/description)  
[triangle](https://www.lintcode.com/problem/triangle/)  
[wildcard matching](https://www.lintcode.com/problem/wildcard-matching/)  
按pattern为`?`, `*`分类讨论。当pattern为`*`时，可以选择match 0个或者1个字符。

[regular expression matching](https://www.lintcode.com/problem/regular-expression-matching/)  
需要注意与wildcard matching不同的是，`*`在匹配是必须有一个前缀字符，而非任意多个字符。

[word pattern](https://www.lintcode.com/problem/word-pattern-ii/description)  
无法使用记忆化，太多状态影响结果。  
注意：若用i,j index的搜法，需用str[j:].startwith()而非str[j:].startwith()。  

[word break/word break II/work break III](https://www.lintcode.com/problem/word-break/)  
I: 用记忆化搜索过不了(memory exceed)，用dp数组记录前i个字符是否可以被break。dp[i]为前面dp[j] = True and s[i-j:i]在字典中。小优化：只需搜最大word length范围内。  
II: 需要用记忆化搜索，裸搜过不了。dfs返回当前s所有可能的sentence，然后对每个sentence加上前缀，组成新的解。
III: 和II几乎一样，只求方案数量。忽略大小写。  

[palindrome partitioning](https://www.lintcode.com/problem/palindrome-partitioning/description)  
类似记忆化搜索，但效果甚微。

[stone game](https://www.lintcode.com/problem/stone-game/description)  
根据范围进行记忆化搜索。f[i,j] = min(f[i,k] + f[k+1,j] + sum[i,j]) for i <= k < j。
需要注意边界条件，f[i,i] = 0而非A[i]。这题用传统DP需要考虑i,j从哪里开始，比较麻烦。

[card game](https://www.lintcode.com/problem/card-game/description)  
这题用普通DP很难想，需要以profit和cost值形成矩阵，更新规则也比较复杂。用记忆化搜索需要记忆三元组状态(index, profit, cost)，按每张牌取与不取来搜索。

[knight shortest path I & II](https://www.lintcode.com/problem/knight-shortest-path/)  
八个方向(I)不能用记忆化搜索，会导致循环依赖爆栈，只能用BFS。 四个方向(II)用BFS或DFS皆可。  

[Longest Increasing Subsequence](https://www.lintcode.com/problem/longest-increasing-subsequence/)  
O(n^2): dp[i]为以nums[i]为结尾的最长LIS。dp[i] = max(dp[k] + 1 if nums[k] < nums[i], for 0<=k<i)  
O(nlogn): 比较难想到，用一个辅助数组B，下标为LIS的长度，值为对应LIS的结尾的最小数。用二分在B上搜索第一个大于nums[i]的数并更新。因为B的初始值都为max int, 开始会不断往后更新。若二分找到小于i的index，则说明对应的LIS有更小的结尾数，即nums[i]。

[Russian Doll Envelopes](https://www.lintcode.com/problem/russian-doll-envelopes/)  
这题O(n^2)过不了，需要借助二分搜。先按信封第一维排序，然后在第二维中找LIS。二分方法类似LIS，借用辅助数组。

[Largest Divisible Subset](https://www.lintcode.com/problem/largest-divisible-subset/)  
与LIS类似，dp[i]为以nums[i]结尾的最大集合，若nums[i] % nums[j] == 0则进行更新。回溯需要用一个father数组记录上一个跳过来的点。
