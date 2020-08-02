### 搜索-遍历

- 每个节点访问一次
- 每个节点仅仅访问一次  
- 节点访问顺序不限  
 -深度优先：depth first search  
 -广度优先：breadth first search  

#### DFS 深度优先搜索

递归写法

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

    // JavaScript
    const visited = new Set()
    const dfs = node => {
      if (visited.has(node)) return
      visited.add(node)
      dfs(node.left)
      dfs(node.right)
    }

    # Python
    visited = set()

    def dfs(node, visited):
        if node in visited: # terminator
        	# already visited 
        	return 

    	visited.add(node) 

    	# process current node here. 
    	...
    	for next_node in node.children(): 
    		if next_node not in visited: 
    			dfs(next_node, visited)
    
非递归写法

    //C/C++
    //非递归写法：
    void dfs(Node* root) {
      map<int, int> visited;
      if(!root) return ;

      stack<Node*> stackNode;
      stackNode.push(root);

      while (!stackNode.empty()) {
        Node* node = stackNode.top();
        stackNode.pop();
        if (visited.count(node->val)) continue;
        visited[node->val] = 1;

        for (int i = node->children.size() - 1; i >= 0; --i) {
            stackNode.push(node->children[i]);
        }
      }

      return ;
    }

#### BFS 广度优先搜索

    // Java 模板
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

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

#### 贪心算法 Greedy

每一步都选择最优选择，导致全局最优。

**与动态规划不同**  
贪心算法：每个子问题都做出选择，不能回退  
动态规划: 保存以前结果，优回退功能

贪心法可以**解决一些最优化问题**，如：求图中的最小生成树、求哈夫曼编码
等。然而对于工程和生活中的问题，贪心法一般不能得到我们所要求的答案。

一旦一个问题可以通过贪心法来解决，那么贪心法一般是解决这个问题的最
好办法。由于**贪心法的高效性**以及其所求得的答案**比较接近最优结果**，贪心
法也可以用作**辅助算法**或者直接解决一些要求结果**不特别精确的问题**。

例题  
当硬币可选集合固定：Coins = [20, 10, 5, 1]，求最少可以几个硬币拼出总数。 比如 total = 36  
36 = 20 + 10 +5 + 1  
反例  
18 = 9 + 9  
18 = 10 + 1 + 1 +  ...

**适用场景**

问题能够分解成子问题来解决，子问题的最优解能递推到最终问题的最优解。这种子问题最优解称为最优子结构。

#### 二分查找

前提条件：
1. 目标函数单调性（单调递增或者递减）
2. 存在上下界（bounded）
3. 能够通过索引访问（index accessible)

代码模板

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
    
使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方

思路：
- 每次通过二分查找排除有序部分数据
- 重新界定边界值，不要 mid+1 或 mid-1 ，边界设置为 mid，防止将两部分都变成有序部分
- 比较 mid 和 mid+1 位置的数据，nums[mid] > nums[mid+1]时返回坐标


    public static int search(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            // 返回无序位置
            if (nums[mid] > nums[mid+1]) {
                return mid;
            }
            //前半部分有序
            if (nums[start] <= nums[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return mid;
    }
