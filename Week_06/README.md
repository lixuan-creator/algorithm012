
#### 递归代码模板

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
        recur(level : level + 1, newParam);
        
        // restore current status
        
    } 
```

#### 分治代码模板

```
    private static int divide_conquer(Problem problem, ) {
        
        // recursion teminator
        if (problem == null) {
            int res = process_last_result();
            return res;
        }
        
        subProblems = split_problem(problem);
        
        // conquer subproblems
        res0 = divide_conquer(subProblem[0]);
        res1 = divide_conquer(subProblem[1]);
        
        // process and generate the final result
        result = process_result(res0, res1);
        
        // revert the current level states
        
        return result;
    }

```

**触感**
1. 人肉递归低效、很累
2. 找到最近最简方法，将其拆解成可重复解决的问题
3. 数学归纳法思维（抵制人肉递归的诱惑）

本质：寻找重复性 —> 计算机指令集

#### 动态规划(Dynamic programming)

Simplifying a complicated problem by breaking it down into simpler sub-problems(in a recursive manner)  
将一个复杂问题分解成简单子问题

Divide&Conquer + Optimal substructure   
分治+最优子结构
 
**关键点**
- 动态规划 和 递归或者分治 没有根本上的区别（关键看有无最优的子结构）
- 共性：找到重复子问题
- 差异性：动态规划有最优子结构、中途可以淘汰次优解

一般动态规划是求最优解、求最大值、求最少的方式

**路径计数：动态规划关键点**
1. 最优子结构 opt[n] = best_of(opt[n-1], opt[n-2], …)
2. 储存中间状态：opt[i]
3. 递推公式（美其名曰：状态转移方程或者 DP 方程）  
   Fib: opt[i] = opt[n-1] + opt[n-2]  
   二维路径：opt[i,j] = opt[i+1][j] + opt[i][j+1] (且判断a[i,j]是否空地）

**动态规划小结**
1. 打破自己的思维惯性，形成机器思维
2. 理解复杂逻辑的关键
3. 也是职业进阶的要点要领

**mit 动态规划**
1. define subProblems 找到子问题
2. guess(path of solution) DP方程式
3. relate subProblems solution 合并子问题解
4. recurse & memoize or build DP table bottom-up 递归、记忆化搜索或者建立DP方程式表格
5. solve original problem







