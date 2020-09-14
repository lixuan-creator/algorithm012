## 毕业总结

时间过得很快，之前对算法也只是了解一些排序算法，没有系统学过，两个月的时间不仅刷了题还对学习方法有了新的认识，如五毒神掌、记算法模板、记经典代码等，虽然还有好多题没做，但并不意味着算法之路结束，这仅仅是个开始吧，师傅领进门修行靠个人，今后还要继续修行。

#### 数据结构

- **一维**      
  - **基础**：数组 array，链表 linked list
  - **高级**：栈 stack， 队列 queue，双端队列 deque，集合 set，映射 map (hash) TreeMap、HashMap
- **二维**  
  - **基础**：树 tree，图 graph
  - **高级**：二叉搜索树 binary search tree(red-black tree,AVL)，堆 heap，并查集 disjoint set，字典树 trie
- **特殊**  
  - 位运算 Bitwise，布隆过滤器 BloomFilter
  - LRU Cache

#### 复杂度分析

数据结构 | Access | Search | Insertion | Deletion
---|---|---|---|---
Array | O(1) | O(n) | O(n) | O(n) 
Stack | O(n) | O(n) | O(1) | O(1) 
Queue | O(n) | O(n) | O(1) | O(1) 
Singly-Linked List | O(n) | O(n) | O(1) | O(1)
Doubly-Linked List | O(n) | O(n) | O(1) | O(1)
Skip List | O(logN) | O(logN) | O(logN) | O(logN)
Hash Table | N/A | O(1) | O(1) | O(1)
Binary Search Tree | O(logN) | O(logN) | O(logN) | O(logN)
Cartesian Tree | N/A | O(logN) | O(logN) | O(logN)
B-Tree | O(logN) | O(logN) | O(logN) | O(logN)
Read-Black Tree | O(logN) | O(logN) | O(logN) | O(logN)
Splay Tree | N/A | O(logN) | O(logN) | O(logN)
AVL Tree | O(logN) | O(logN) | O(logN) | O(logN)
KD Tree | O(logN) | O(logN) | O(logN) | O(logN)
## 代码模板

**递归**
```
    public void recur(int level, int param) { 
        // terminator 
        if (level > MAX_LEVEL) { 
        // process result 
            return; 
        } 
         
         // process current logic 
        process(level, param); 
         
         // drill down 
        recur( level: level + 1, newParam); 
         
        // restore current status 
     
    }
```

**分治**
```
    def divide_conquer(problem, param1, param2, ...): 
        # recursion terminator 
        if problem is None: 
         print_result 
         return 
         
        # prepare data 
        data = prepare_data(problem) 
        subproblems = split_problem(problem, data) 
         
        # conquer subproblems 
        subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
        subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
        subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
        … 
        # process and generate the final result 
        result = process_result(subresult1, subresult2, subresult3, …) 
     
        # revert the current level states
```

**二叉树遍历**
```
    1. 前序(Pre-order)：根-左-右
    2. 中序(In-order)：左-根-右
    3. 后序(Post-order)：左-右-根
    // 示例代码
    def preorder(self, root): 
        if root: 
            self.traverse_path.append(root.val) 
            self.preorder(root.left) 
            self.preorder(root.right)
        
    def inorder(self, root):
        if root: 
            self.inorder(root.left) 
            self.traverse_path.append(root.val) 
            self.inorder(root.right)
         
    def postorder(self, root):
        if root: 
            self.postorder(root.left) 
            self.postorder(root.right) 
            self.traverse_path.append(root.val)
```

**深度优先 DFS**
```
    // Java 模板
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();// 结果集
        if (root==null) {
            return allResults;
        }
        travel(root, 0, allResults);// 0代表第0层
        return allResults;
    }

    private void travel(TreeNode root,int level,List<List<Integer>> results){
        // results代表每层结果集，集合大小和层数一样，开辟下一层空间
        if (results.size() == level) {
            results.add(new ArrayList<>());
        }
        
        // 每一层的结果都是一个array，放到new array里
        results.get(level).add(root.val);
        
        if (root.left!=null) {
            travel(root.left, level+1, results);
        }
        if (root.right!=null) {
            travel(root.right,level+1,results);
        }
    }
```

**广度优先 BFS**
```
    // Java 模板
    // 将每一层元素放到队列中，然后将队首出队，存入每层的结果，下一层再放到队列
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();
        if (root == null) {
            return allResults;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();// 队列元素不断增加，size保留初始大小
            List<Integer> results = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                results.add(node.val);
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
            allResults.add(results);
        }
        return allResults;
    }
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
```

**二分查找**
```
    // Java
    public int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1, mid;
        while (left <= right) {
            mid = (right - left) / 2 + left;// 或者mid = (right + left) / 2
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
```

**并查集**
``` 
    // java
    public class UnionFind {
        private int count = 0;
        private int[] parent;
        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            parent[rootP] = rootQ;
            count--;
        }
    
        public int getCount() {
            return count;
        }
    }
```

**字典树Trie**
```
    public class Trie {
        class TireNode {
            private boolean isEnd;
            TireNode[] next;
    
            public TireNode() {
                isEnd = false;
                next = new TireNode[26];
            }
        }
    
        private TireNode root;
        public Trie() {
            root = new TireNode();
        }
    
        public void insert(String word) {
            TireNode node = root;
            char[] words = word.toCharArray();
            for (char c : word.toCharArray()) {
                if (node.next[c-'a'] == null) {
                    node.next[c-'a'] = new TireNode();
                }
                node = node.next[c-'a'];
            }
            node.isEnd = true;
        }
    
        public boolean search(String word) {
            TireNode node = root;
            for (char c : word.toCharArray()) {
                node = node.next[c-'a'];
                if (node == null) {
                    return false;
                }
            }
            return node.isEnd;
        }
    }
```

**DP 模板**
```
    function DP(): 
      Dp = [][] # 三维情况 
      For I = 0 .. M { 
       For j = 0 .. N { 
        Dp[i][j] = _Function(Dp[i’][j’]…) 
       } 
      } 
      Return Dp[M][N]
```

#### 排序算法复杂度

排序方法 | 时间复杂度(平均) | 时间复杂度(最坏) | 时间复杂度(最好) | 空间复杂度 | 稳定性 
---|---|---|---|---|---
插入排序 | O(n^2) | O(n^2) | O(n) | O(1) | 稳定  
希尔排序 | O(n^1.3) | O(n^2) | O(n) | O(1) | 不稳定
选择排序 | O(n^2) | O(n^2) | O(n^2) | O(1) | 不稳定
堆排序 | O(nlog2^n)  | O(nlog2^n) | O(nlog2^n) | O(1) | 不稳定
冒泡排序 | O(n^2) | O(n^2) | O(n) | O(1) | 稳定
快速排序 | O(nlog2^n)  | O(n^2) | O(nlog2^n)  | O(nlog2^n) | 不稳定
归并排序 | O(nlog2^n)  | O(nlog2^n) | O(nlog2^n) | O(n) | 稳定
计数排序 | O(n+k) | O(n+k) | O(n+k) | O(n+k) | 稳定
桶排序 | O(n+k) | O(n^2) | O(n) | O(n+k) | 稳定
基数排序 | O(n*k) | O(n*k) | O(n*k) | O(n+k) | 稳定



## 毕业刷题路线

#### 基础

- [两数之和](http://leetcode-cn.com/problems/two-sum)（简单）
- [有效的括号](http://leetcode-cn.com/problems/valid-parentheses/)（简单）
- [字符串解码](http://leetcode-cn.com/problems/decode-string/)（中等）
- [LRU 缓存机制](http://leetcode-cn.com/problems/lru-cache/submissions/)（困难）
- [实现 Trie（前缀树）](http://leetcode-cn.com/problems/implement-trie-prefix-tree/)（中等）
- [添加与搜索单词 - 数据结构设计](http://leetcode-cn.com/problems/add-and-search-word-data-structure-design/)（中等）
- [单词搜索 II ](http://leetcode-cn.com/problems/word-search-ii/)（困难）
- [找不同](http://leetcode-cn.com/problems/find-the-difference/)（简单）
- [单词规律](http://leetcode-cn.com/problems/word-pattern/)（简单）
- [字符串中的第一个唯一字符](http://leetcode-cn.com/problems/first-unique-character-in-a-string)（简单）
- [无重复字符的最长子串](http://leetcode-cn.com/problems/longest-substring-without-repeating-characters)（中等）
- [最小覆盖子串](http://leetcode-cn.com/problems/minimum-window-substring/)（困难）
- [合并两个有序链表](http://leetcode-cn.com/problems/merge-two-sorted-lists)（简单）
- [环形链表](http://leetcode-cn.com/problems/linked-list-cycle)（简单）
- [环形链表 II ](http://leetcode-cn.com/problems/linked-list-cycle-ii)（中等）
- [反转链表](http://leetcode-cn.com/problems/reverse-linked-list)（简单）
- [反转链表 II ](http://leetcode-cn.com/problems/reverse-linked-list-ii)（中等）
- [旋转链表](http://leetcode-cn.com/problems/rotate-list)（中等）
- [排序链表](http://leetcode-cn.com/problems/sort-list/)
- [链表中倒数第 k 个节点](http://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/)
- [两两交换链表中的节点](http://leetcode-cn.com/problems/swap-nodes-in-pairs)（中等）
- [按奇偶排序数组](http://leetcode-cn.com/problems/sort-array-by-parity/)（简单）
- [按奇偶排序数组 II ](http://leetcode-cn.com/problems/sort-array-by-parity-ii/)（简单）
- [有序数组的平方](http://leetcode-cn.com/problems/squares-of-a-sorted-array/)（简单）
- [山脉数组的峰顶索引](http://leetcode-cn.com/problems/peak-index-in-a-mountain-array)（简单）
- [搜索旋转排序数组](http://leetcode-cn.com/problems/search-in-rotated-sorted-array)（困难）
- [搜索旋转排序数组 II ](http://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/)（中等）
- [寻找旋转排序数组中的最小值](http://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/)（中等）
- [寻找旋转排序数组中的最小值 II ](http://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/)（困难）
- [搜索二维矩阵](http://leetcode-cn.com/problems/search-a-2d-matrix)（中等）
- [等式方程的可满足性](http://leetcode-cn.com/problems/satisfiability-of-equality-equations/)（中等）
- [朋友圈](http://leetcode-cn.com/problems/friend-circles/)（中等）
- [账户合并](http://leetcode-cn.com/problems/accounts-merge/)（中等）

#### 深度优先搜索

- [二叉树的最大深度](http://leetcode-cn.com/problems/maximum-depth-of-binary-tree)（简单）
- [路径总和](http://leetcode-cn.com/problems/path-sum/)（简单）
- [路径总和 II ](http://leetcode-cn.com/problems/path-sum-ii/)（中等）
- [被围绕的区域](http://leetcode-cn.com/problems/surrounded-regions/)（中等）
- [岛屿数量](http://leetcode-cn.com/problems/number-of-islands/)（中等）
- [岛屿的最大面积](http://leetcode-cn.com/problems/max-area-of-island/)（中等）
- [在二叉树中分配硬币](http://leetcode-cn.com/problems/distribute-coins-in-binary-tree/)（中等）

#### 回溯

- [括号生成](http://leetcode-cn.com/problems/generate-parentheses/)（中等）
- [N 皇后](http://leetcode-cn.com/problems/n-queens/)（困难）
- [N 皇后 II ](http://leetcode-cn.com/problems/n-queens-ii/)（困难）
- [解数独](http://leetcode-cn.com/problems/sudoku-solver/) （中等）
- [不同路径 III ](http://leetcode-cn.com/problems/unique-paths-iii/)（困难）
- [单词搜索](http://leetcode-cn.com/problems/word-search/)（中等）

#### 分治

- [搜索二维矩阵 II ](http://leetcode-cn.com/problems/search-a-2d-matrix-ii/)（中等）
- [合并 K 个排序链表](http://leetcode-cn.com/problems/merge-k-sorted-lists)（中等）
- [为运算表达式设计优先级](http://leetcode-cn.com/problems/different-ways-to-add-parentheses)（中等）
- [给表达式添加运算符](http://leetcode-cn.com/problems/expression-add-operators)（困难）
- [数组中的第 K 个最大元素](http://leetcode-cn.com/problems/kth-largest-element-in-an-array)（中等）
- [最接近原点的 K 个点](http://leetcode-cn.com/problems/k-closest-points-to-origin/)（中等）
- [鸡蛋掉落](http://leetcode-cn.com/problems/super-egg-drop/)（困难）

#### 动态规划

- [使用最小花费爬楼梯](http://leetcode-cn.com/problems/min-cost-climbing-stairs)（简单）
- [爬楼梯](http://leetcode-cn.com/problems/climbing-stairs)（简单）
- [不同路径](http://leetcode-cn.com/problems/unique-paths/)（简单）
- [最小路径和](http://leetcode-cn.com/problems/minimum-path-sum/) （中等）
- [最大子序和](http://leetcode-cn.com/problems/maximum-subarray/) （简单）
- [乘积最大子数组](http://leetcode-cn.com/problems/maximum-product-subarray/)（中等）
- [买卖股票的最佳时机](http://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock)（简单）
- [买卖股票的最佳时机 II ](http://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/)（简单）
- [买卖股票的最佳时机 III ](http://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/)（困难）
- [买卖股票的最佳时机 IV ](http://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/)（困难）
- [最佳买卖股票时机含冷冻期](http://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/)（中等）
- [买卖股票的最佳时机含手续费](http://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee)（中等）
- [零钱兑换](http://leetcode-cn.com/problems/coin-change) （中等）
- [零钱兑换 II ](http://leetcode-cn.com/problems/coin-change-2)（中等）
- [编辑距离](http://leetcode-cn.com/problems/edit-distance)（困难）
- [不同的子序列](http://leetcode-cn.com/problems/distinct-subsequences/)（困难）
- [柱状图中最大的矩形](http://leetcode-cn.com/problems/largest-rectangle-in-histogram/)（困难）
- [最大矩形](http://leetcode-cn.com/problems/maximal-rectangle/)（困难）
- [最大正方形](http://leetcode-cn.com/problems/maximal-square/)（中等）
- [最低票价](http://leetcode-cn.com/problems/minimum-cost-for-tickets/)（中等）
- [区域和检索 - 数组不可变](http://leetcode-cn.com/problems/range-sum-query-immutable/)（简单）
- [二维区域和检索 - 矩阵不可变](http://leetcode-cn.com/problems/range-sum-query-2d-immutable/)（中等）
- [最长上升子序列](http://leetcode-cn.com/problems/longest-increasing-subsequence) （中等）
- [鸡蛋掉落](http://leetcode-cn.com/problems/super-egg-drop/)（困难）


## 结语
**Stay Hungry. Stay Foolish.**