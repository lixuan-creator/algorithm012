#### 字典树
- **数据结构**

1. 字典树，即 Trie 树，又称单词查找树或键树，是一种树形结构。典型应用是用于统计和排序大量的字符串（但不仅限于
字符串），所以经常被搜索引擎系统用于文本词频统计。
2. 它的优点是：最大限度地减少无谓的字符串比较，查询效率比哈希表高。

- **核心思想**
1. 结点本身不存完整单词
2. 从根结点到某一结点，路径上经过的字符连接起来，为该结点对应的字符串
3. 每个结点的所有子结点路径代表的字符都不相同

- **基本性质**
1. Trie 树的核心思想是空间换时间
2. 利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的

#### 并查集
- makeSet(s)：建立一个新的并查集，其中包含 s 个单元素集合。
- unionSet(x, y)：把元素 x 和元素 y 所在的集合合并，要求 x 和 y 所在的集合不相交，如果相交则不合并。
- find(x)：找到元素 x 所在的集合的代表，该操作也可以用于判断两个元素是否位于同一个集合，
只要将它们各自的代表比较一下就可以了。
```
    // Java 代码模板
    class UnionFind { 
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
    }
```

#### 初级搜索

1. 朴素搜索
2. 优化方式：不重复（fibonacci）、剪枝（生成括号问题）
3. 搜索方向：
   DFS: depth first search 深度优先搜索
   BFS: breadth first search 广度优先搜索
   **双向搜索**、**启发式搜索**

**DFS模板**
```
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResults= new ArrayList();
        
        if (root == null) {
            return allResults;
        }
        
        travel(root, 0, allResults);
        return allResults;
    }
    
    public void travel(TreeNode root, int level, List<List<Integer>> allResults) {
        if (allResults.size() == level) {
            allResults.add(new ArrayList<>);
        }
        
        allResults.get(level).add(root.val);
        
        if (root.left != null) {
            level(left, level+1, allResults);
        }
        if (root.right != null) {
            level(right, level+1, allResults);
        }        
    }
```

**BFS模板**
```
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();
        if (root == null) {
            return allResults;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
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
    
```

**回溯法**

回溯法采用试错的思想，它尝试分步的去解决一个问题。在分步解决问题的过程中，当
它通过尝试发现现有的分步答案不能得到有效的正确的解答的时候，它将取消上一步甚
至是上几步的计算，再通过其它的可能的分步解答再次尝试寻找问题的答案。

回溯法通常用最简单的递归方法来实现，在反复重复上述的步骤后可能出现两种情况：
- 找到一个可能存在的正确的答案
- 在尝试了所有可能的分步方法后宣告该问题没有答案

在最坏的情况下，回溯法会导致一次复杂度为指数时间的计算。

**启发式搜索 Heuristic Search (A\*)**

基于 BFS 代码
```
    def BFS(graph, start, end):
        queue = [] 
        queue.append([start]) 
        visited.add(start)
        while queue: 
            node = queue.pop() # can we add more intelligence here ? 
            visited.add(node) 
            process(node) 
            nodes = generate_related_nodes(node) 
            queue.push(nodes)
```

**A\* search**
```
    def AstarSearch(graph, start, end):
        pq = collections.priority_queue() # 优先级 —> 估价函数
        pq.append([start]) 
        visited.add(start)
        while pq:
            node = pq.pop() # can we add more intelligence here ? 
            visited.add(node)
            process(node) 
            nodes = generate_related_nodes(node) 
            unvisited = [node for node in nodes if node not in visited] 
            pq.push(unvisited)
```
**估价函数**

启发式函数： h(n)，它用来评价哪些结点最有希望的是一个我们要找的结
点，h(n) 会返回一个非负实数,也可以认为是从结点n的目标结点路径的估
计成本。

启发式函数是一种告知搜索方向的方法。它提供了一种明智的方法来猜测
哪个邻居结点会导向一个目标。

#### 高级树、AVL树、红黑树

**二叉树遍历**

1. 前序(Pre-order)：根-左-右
2. 中序(In-order)：左-根-右
3. 后序(Post-order)：左-右-根

```
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

**二叉搜索树 Binary Search Tree**

二叉搜索树，也称二叉搜索树、有序二叉树（Ordered Binary Tree）、排
序二叉树（Sorted Binary Tree），是指一棵空树或者具有下列性质的二叉树：
1. 左子树上所有结点的值均小于它的根结点的值；
2. 右子树上所有结点的值均大于它的根结点的值；
3. 以此类推：左、右子树也分别为二叉查找树。 （这就是 重复性！）
中序遍历：升序排列

**AVL树**
- 平衡二叉搜索树
- Balance Factor（平衡因子）：是它的左子树的高度减去它的右子树的高度（有时相反）。
  balance factor = {-1, 0, 1}
- 通过旋转操作来进行平衡：左旋、右旋、左右旋、右左旋

不足：结点需要存储额外信息、且调整次数频繁

**红黑树**

红黑树是一种近似平衡的二叉搜索树（Binary Search Tree），它能够确保任何一
个结点的左右子树的高度差小于两倍。具体来说，红黑树是满足如下条件的二叉
搜索树：
- 每个结点要么是红色，要么是黑色
- 根结点是黑色
- 每个叶结点（NIL结点，空结点）是黑色的。
- 不能有相邻接的两个红色结点
- 从任一结点到其每个叶子的所有路径都包含相同数目的黑色结点。

**关键性质**：从根到叶子的最长的可能路径不多于最短的可能路径的两倍长。
