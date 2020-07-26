#### 递归 Recursion

通过函数提来进行循环

    Java代码模板
    public void recur(int level, int param) {
        // terminator 递归终止条件
        if (level > MAX_LEVEL) {
            process result
            return;
        }
        
        // process currrent logic 处理当前层逻辑
        process(levelm, param);
        
        // drill down 下探到下一层
        recur( level : level + 1, newParam);
        
        // restroe current status 清理当前层状态，比如全局变量
        
    }
    
**思维要点**

- 不要人肉进行递归(**最大误区**)
- 找到最近最简单方法，将其拆解成可重复解决的问题(**重复子问题**)
- 数学归纳法思维

#### 分治(Divide)和回溯(Conquer)

分治和回溯本质上是递归  
最优重复性：动态规划    
最近重复性：分治、回溯

**分治**

将问题拆成子问题

代码模板
    
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
        subresult2 = self.divide_conquer(subproblems[1], p2, ...)
        subresult3 - self.divide_conquer(subproblems[2], p2, ...)
        ...
        
        # process and generate the final result
        result = process_result(subresult1, subresult2, subresult3, ...)
        
        # revert the current the final result

**回溯**

"回溯"指的是"状态重置",可以理解为回到过去，恢复现场

回溯法采用**试错**的思想，它尝试**分步**的去解决一个问题。在分步解决问
题的过程中，当它通过尝试发现现有的分步答案不能得到有效的正确的解答的时
候，它将取消上一步甚至是上几步的计算，再通过其它的可能的分步解答再次尝
试寻找问题的答案。

回溯法通常用最简单的递归方法来实现，在反复重复上述的步骤后可能出现两种
情况：

- 找到一个可能存在的正确的答案
- 在尝试了所有可能的分步方法后宣告该问题没有答案

在最坏的情况下，回溯法会导致一次复杂度为指数时间的计算。

**回溯例题**

回溯比较难理解，结合下面例题的讲解，比较好理解。

**从全排列问题开始理解「回溯」算法（深度优先遍历 + 状态重置 + 剪枝）**

以数组 [1, 2, 3] 的全排列为例。
- 我们先写以 1 开头的全排列，它们是：[1, 2, 3], [1, 3, 2]；
- 再写以 2 开头的全排列，它们是：[2, 1, 3], [2, 3, 1]；
- 最后写以 3 开头的全排列，它们是：[3, 1, 2], [3, 2, 1]。

我们只需要按顺序枚举每一位可能出现的情况，已经选择的数字在接下来要确定的数字中不能出现。按照这种策略选取就能够做到不重不漏，把可能的全排列都枚举出来。
![Image text](https://pic.leetcode-cn.com/0bf18f9b86a2542d1f6aa8db6cc45475fce5aa329a07ca02a9357c2ead81eec1-image.png)

**说明：**
1. 每一个结点表示了“全排列”问题求解的不同阶段，这些阶段通过变量的“不同的值”体现；
2. 这些变量的不同的值，也称之为“状态”；
3. 使用深度优先遍历有“回头”的过程，在“回头”以后，状态变量需要设置成为和先前一样；
4. 因此在回到上一层结点的过程中，需要撤销上一次选择，这个操作也称之为“状态重置”；
5. 深度优先遍历，可以直接借助系统栈空间，为我们保存所需要的状态变量，在编码中只需要注意遍历到相应的结点的时候，状态变量的值是正确的，具体的做法是：往下走一层的时候，path 变量在尾部追加，而往回走的时候，需要撤销上一次的选择，也是在尾部操作，因此 path 变量是一个栈。
6. 深度优先遍历通过“回溯”操作，实现了全局使用一份状态变量的效果。

**编码思路：**

1. 首先这棵树除了根结点和叶子结点以外，每一个结点做的事情其实是一样的，即在已经选了一些数的前提，我们需要在剩下还没有选择的数中按照顺序依次选择一个数，这显然是一个递归结构；
2. 递归的终止条件是，数已经选够了，因此我们需要一个变量来表示当前递归到第几层，我们把这个变量叫做 depth；
3. 这些结点实际上表示了搜索（查找）全排列问题的不同阶段，为了区分这些不同阶段，我们就需要一些变量来记录为了得到一个全排列，程序进行到哪一步了，在这里我们需要两个变量：  
（1）已经选了哪些数，到叶子结点时候，这些已经选择的数就构成了一个全排列；  
（2）一个布尔数组 used，初始化的时候都为false表示这些数还没有被选择，当我们选定一个数的时候，就将这个数组的相应位置设置为true，这样在考虑下一个位置的时候，就能够以O(1)的时间复杂度判断这个数是否被选择过，这是一种“以空间换时间”的思想。我们把这两个变量称之为“状态变量”，它们表示了我们在求解一个问题的时候所处的阶段。
4. 在非叶子结点处，产生不同的分支，这一操作的语义是：在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
5. 另外，因为是执行深度优先遍历，从较深层的结点返回到较浅层结点的时候，需要做“状态重置”，即“回到过去”、“恢复现场”，我们举一个例子。

 从 [1, 2, 3] 到 [1, 3, 2] ，深度优先遍历是这样做的，从 [1, 2, 3] 回到 [1, 2] 的时候，需要撤销刚刚已经选择的数 3，因为在这一层只有一个数 3 我们已经尝试过了，因此程序回到上一层，需要撤销对 2 的选择，好让后面的程序知道，选择 3 了以后还能够选择 2。

这种在遍历的过程中，从深层结点回到浅层结点的过程中所做的操作就叫“回溯”。

    public List<List<Integer>> permute(int[] nums) {
        // 首先是特判
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();

        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     List<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(path);
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, len, depth + 1, path, used, res);
                // 注意：这里是状态重置，是从深层结点回到浅层结点的过程，代码在形式上和递归之前是对称的
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

作者：liweiwei1419  
链接：https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/  
来源：力扣（LeetCode）
