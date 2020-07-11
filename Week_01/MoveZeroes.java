package com.algorithm.week01;

/**
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class MoveZeroes {
    /**
     * 简单易懂
     * 这里参考了快速排序的思想，快速排序首先要确定一个待分割的元素做中间点x，然后把所有小于等于x的元素放到x的左边，大于x的元素放到其右边。
     * 这里我们可以用0当做这个中间点，把不等于0(注意题目没说不能有负数)的放到中间点的左边，等于0的放到其右边。
     * 这的中间点就是0本身，所以实现起来比快速排序简单很多，我们使用两个指针i和j，只要nums[i]!=0，我们就交换nums[i]和nums[j]
     * 链接：https://leetcode-cn.com/problems/move-zeroes/solution/dong-hua-yan-shi-283yi-dong-ling-by-wang_ni_ma/
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     */
    public static void moveZeroes(int[] nums) {
        if (nums == null) {
            return ;
        }
        //第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
        int j = 0;
        for (int i=0;i<nums.length;++i) {
            if(nums[i]!=0) {
                nums[j++] = nums[i];
            }
        }
        //非0元素统计完了，剩下的都是0了
        //所以第二次遍历把末尾的元素都赋为0即可
        for (int i=j;i<nums.length;++i) {
            nums[i] = 0;
        }
    }


    /**
     * 经典
     * 没怎么接触算法，双下标思路很神奇
     * 自己写两个数组，也能写，不巧
     * 有些东西自己确实写不出来，看别人的，学会了，也能带来很大提升
     * 思路清楚了，默写还是很简单的
     *
     * 定义一个非零的指针 j=0，循环遍历数组用指针j记录非零值nums[j] = num[i];
     * 判断两个指针i与j是否相等，这里两个指针初始值都为0，j指针只有在非零的情况下会j++；
     * 因此可以判断j指针对应的值都为非零的数据，且保存原有顺序；
     * 所以，原有数组继续遍历情况下，nums[i]都为0。
     * 链接：https://leetcode-cn.com/problems/move-zeroes/solution/yi-dong-ling-by-yijiaoqian/
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     */
    public static void moveZeroes2(int[] nums){
        int j = 0;
        for (int i = 0; i< nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if(i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
