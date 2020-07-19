
**哈希表**

哈希表也叫**散列表**，根据关键码的值直接访问，关键码映射表位置，快速查找。映射函数叫**散列函数**，存放记录的数组叫做**哈希表**(散列表)

**Map**：key-value对，key不重复
- new HashMap() / new TreeMap()
- map.set(key, value)
- map.get(key)
- map.has(key)
- map.size()
- map.clear()

**Set**：不重复元素的集合
- new HashSet() / new TreeSet()
- set.add(value)
- set.delete(value)
- set.hash(value)

**二叉树**

Linked List 是特殊化的 Tree

Tree 是特殊化的 Graph

代码示例

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null; 
        } 
    }
    
二叉树遍历 Pre-order/In-order/Post-order

1. 前序（Pre-order）：根-左-右
2. 中序（In-order）：左-根-右
3. 后序（Post-order）：左-右-根

**二叉搜索树 Binary Search Tree**

二叉搜索树，也称二叉排序树、有序二叉树（Ordered Binary Tree）、排序二叉树（Sorted Binary Tree），是指一棵空树或者具有下列性质的二叉树：

1. 左子树上**所有结点**的值均小于它的根结点的值
2. 右子树上**所有结点**的值均大于它的根结点的值
3. 以此类推：左、右子树也分别为二叉查找树

中序遍历：升序排列

常见操作
1. 查询O(logn)
2. 插入新节点O(logn)
3. 删除O(logn)

**堆 Heap**

Heap：可以迅速找到一堆数中**最大值或最小值**的数据结构

根节点最大叫**大顶堆或大根堆**，最小叫做**小顶堆或小根堆**

常见堆：二叉堆、斐波那契堆

假设大顶堆常见操作：
- find-max: O(1)  
- delete-max: O(logN)  
- insert(creat)：O(logN) or O(1)  

二叉对性质  
通过完全二叉树实现(不是二叉搜索树)

二叉堆(大顶)
- 是一个完全树
- 树中任意节点的值总是>=子节点值

二叉堆实现细节
1. 一般是数组实现
2. 假设第一个元素在数组中索引是0，父子节点关系：
- 索引为i的左孩子为(2*i+1)
- 索引为i的左孩子为(2*i+2)
- 索引为i的父节点为floor((i-1)/2)

**Insert**插入操作,时间复杂度O(logN)
1. 新元素一律先插入堆尾部
2. 依次向上调整堆(一直到根)

HeapifyUp

**DeleteMax**删除堆顶O(logN)

1. 将堆尾部元素替换到顶部(堆顶直接删除)
2. 依次从根部向下调整

HeapifyDown

注：二叉堆是堆的一种常见实现，不是最优。(工程中常用优先队列priority_queue)
   
   
