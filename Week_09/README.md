#### 动态规划

**DP 顺推模板**

```
 function DP(): 
    dp = [][] # ⼆维情况 
    for i = 0 .. M { 
        for j = 0 .. N { 
            dp[i][j] = _Function(dp[i’][j’]…) 
        } 
    } 
 return dp[M][N];
```
**关键点**

动态规划 和 递归或者分治 没有根本上的区别（关键看有无最优的子结构）

拥有共性：找到重复子问题

差异性：最优子结构、中途可以淘汰次优解

**不同路径2的状态转移方程式** 

用dp(i, j) 来表示从坐标 (i, j) 的路径总和，f(i, j) 表示是否有障碍物  
如果 f(i, j) = 0 表示没有障碍物，**dp(i, j) = dp(i-1, j) + dp(i, j-1)**  
f(1, j) = 1 表示有障碍物，**dp(i, j) = 0**; 

#### 字符串

**遍历**
```
// Java
 Stirng x= "abcd";
 for (int i=0; i<x.size(); i++) {
     char ch = x.charAt(i);
     System.out.print(ch);
 }
```
**比较**
```
// Java
Stirng x= new String("abcd");
Stirng y= new String("abcd");
x==y //false
x.equals(y) // true
x.equalsIgnoreCase(y) //true
```
**高级字符串算法**  
- 最长子序列   
  https://leetcode-cn.com/problems/longest-common-subsequence/
```
  dp[i][j] = dp[i-1][j-1] + 1 (if s1[i-1] == s2[j-1])  
  else dp[i][j] = max(dp[i-1][j], dp[i][j-1])  
```
- 最长子串  
  https://leetcode-cn.com/problems/longest-palindromic-substring/
```
  dp[i][j] = dp[i-1][j-1] + 1  (if s1[i-1] == s2[j-1])  
  else dp[i][j] = 0
```
- 编辑距离  
  https://leetcode-cn.com/problems/longest-palindromic-substring/
```
 // 动态规划
  定义P(i, j)
  P(i, j) = true s[i, j] 是回文串
          = false s[i, j] 不是回文串
          
  P(i, j) = (P(i+1, j-1)) && S[i]==S[j])
```
- 不同的子序列  
  https://leetcode-cn.com/problems/distinct-subsequences/
```
  dp[i][j]代表T前i字符串可以由s前j字符串组成的最多个数
  当S[j] == T[i], dp[i][j] = dp[i-1][j-1] + dp[i][j-1]
  当S[j] != T[i], dp[i][j] = dp[i][j-1]
```

**字符串匹配算法**
1. 暴力法
2. Rabin-Karp算法
3. KMP算法
