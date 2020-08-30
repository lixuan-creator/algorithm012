#### 位运算

**位运算符**
- << 左移
- \>> 右移

含义 | 运算符 | 示例
---|---|---
按位或(看1) | \| | 0011 \| 1011 => 1011
按位与(看0) | & | 0011 & 1011 => 0011
按位去取反 | ~ | 0011 => 1100
按位异或（相同为零不同为一） | ^ | 0011 ^ 1011 => 1000

**XOR - 异或**

异或：相同为 0，不同为 1。
```
// 异或操作的一些特点：
x ^ 0 = x  
x ^ 1s = ~x // 注意 1s = ~0  
x ^ (~x) = 1s  
x ^ x = 0  
c = a ^ b => a ^ c = b, b ^ c = a // 交换两个数  
a ^ b ^ c = a ^ (b ^ c) = (a ^ b) ^ c // associative
```

**指定位置的位运算**

1. 将 x 最右边的 n 位清零：x & (~0 << n)
2. 获取 x 的第 n 位值（0 或者 1）： (x >> n) & 1
3. 获取 x 的第 n 位的幂值：x & (1 << n)
4. 仅将第 n 位置为 1：x | (1 << n)
5. 仅将第 n 位置为 0：x & (~ (1 << n))
6. 将 x 最高位至第 n 位（含）清零：x & ((1 << n) - 1)

**实战位运算要点**
-  判断奇偶：  
  x % 2 == 1 —> (x & 1) == 1  
  x % 2 == 0 —> (x & 1) == 0  
- x >> 1 —> x / 2.   
  即： x = x / 2; —> x = x >> 1;  
mid = (left + right) / 2; —> mid = (left + right) >> 1;
-  X = X & (X-1) 清零最低位的 1 
-  X & -X => 得到最低位的 1 
-  X & ~X => 0
-  
#### 布隆过滤器 Bloom Filter

一个很长的二进制向量和一系列随机映射函数。布隆过滤器可以用于检索一个元素是否在一个集合中。

**优点**是空间效率和查询时间都远远超过一般的算法

**缺点**是有一定的误识别率和删除困难

**案例**

1. 比特币网络
2. 分布式系统（Map-Reduce） — Hadoop、search engine
3. Redis 缓存
4. 垃圾邮件、评论等的过滤

#### LRU Cache

两个要素： 大小 、替换策略

Hash Table + Double LinkedList

O(1) 查询  
O(1) 修改、更新

**实现**

```
public class LRUCache {
    private Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        map = new LinkedCappedHashMap<>(capacity);
    }

    public int get(int key) {
        if(!map.containsKey(key)) { return -1; }
        return map.get(key);
    }

    public void put(int key, int value) {
        map.put(key,value);
    }
    
    private static class LinkedCappedHashMap<K,V> extends LinkedHashMap<K,V> {
        int maximumCapacity;

        LinkedCappedHashMap(int maximumCapacity) {
            super(16, 0.75f, true);
            this.maximumCapacity = maximumCapacity;
        }

        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > maximumCapacity;
        }
    }
 }
```

#### 排序算法
1. 比较类排序：  
通过比较来决定元素间的相对次序，由于其时间复杂度不能突破
O(nlogn)，因此也称为非线性时间比较类排序。
2. 非比较类排序：  
不通过比较来决定元素间的相对次序，它可以突破基于比较排序的时
间下界，以线性时间运行，因此也称为线性时间非比较类排序。

**初级排序 - O(n^2)**

- **选择排序**（Selection Sort）  
每次找最小值，然后放到待排序数组的起始位置
- **插入排序**（Insertion Sort）  
从前到后逐步构建有序序列；对于未排序数据，在已排序序列中从后
向前扫描，找到相应位置并插入
- **冒泡排序**（Bubble Sort）  
嵌套循环，每次查看相邻的元素如果逆序，则交换

**高级排序 - O(N\*LogN)**
- **快速排序**（Quick Sort）  
数组取标杆 pivot，将小元素放 pivot左边，大元素放右侧，然后依
次对右边和右边的子数组继续快排；以达到整个序列有序。

- **归并排序**（Merge Sort）— 分治  
1. 把长度为n的输入序列分成两个长度为n/2的子序列；  
2. 对这两个子序列分别采用归并排序；  
3. 将两个排序好的子序列合并成一个最终的排序序列 

归并 和 快排 具有相似性，但步骤顺序相反  
归并：先排序左右子数组，然后合并两个有序子数组  
快排：先调配出左右子数组，然后对于左右子数组进行排序

- **堆排序** （Heap Sort） — 堆插入 O(logN)，取最大/小值 O(1)
1. 数组元素依次建立小顶堆
2. 依次取堆顶元素，并删除

**特殊排序 - O(n)**
- **计数排序（Counting Sort）**  
计数排序要求输入的数据必须是有确定范围的整数。将输入的数据值转化为键存
储在额外开辟的数组空间中；然后依次把计数大于 1 的填充回原数组
- **桶排序（Bucket Sort）**  
桶排序 (Bucket sort)的工作的原理：假设输入数据服从均匀分布，将数据分到
有限数量的桶里，每个桶再分别排序（有可能再使用别的排序算法或是以递归方
式继续使用桶排序进行排）
- **基数排序（Radix Sort）**  
基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类
推，直到最高位。有时候有些属性是有优先级顺序的，先按低优先级排序，再按
高优先级排序

```
    /**
     * 1.冒泡排序
     * @param arr
     * @return
     */
    public int[] bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {        // 相邻元素两两对比
                    int temp = arr[j+1];        // 元素交换
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
    /**
     * 2.选择排序
     * @param arr
     * @return
     */
    public int[] selectionSort(int[] arr) {
        int len = arr.length;
        int minIdex,temp;
        for (int i = 0; i < len - 1; i++) {
            minIdex = i;
            for (int j= i+1; j< len; j++) {
                if (arr[j] < arr[minIdex]) {
                    minIdex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIdex];
            arr[minIdex] = temp;
        }
        return arr;
    }
    /**
     * 3.插入排序
     * @param arr
     * @return
     */
    public int[] insertionSort(int[] arr) {
        int len = arr.length;
        int preIndex, current;
        for (int i = 1; i < len; i++) {
            preIndex = i - 1;
            current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
        return arr;
    }
    /**
     * 4.希尔排序
     * @param arr
     * @return
     */
    public int[] shellSort(int[] arr) {
        int len = arr.length;
        // for (var gap = Math.floor(len / 2); gap > 0; gap = Math.floor(gap / 2)) {
        for (int gap = len / 2; gap > 0; gap = gap / 2) {
            // 注意：这里和动图演示的不一样，动图是分组执行，实际操作是多个分组交替执行
            for (int i = gap; i < len; i++) {
                int j = i;
                int current = arr[i];
                while (j - gap >= 0 && current < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j = j - gap;
                }
                arr[j] = current;
            }
        }
        return arr;
    }
    /**
     * 5.归并排序
     * https://leetcode-cn.com/problems/sort-an-array/solution/chao-xiang-xi-de-biao-zhun-kuai-su-pai-xu-jie-fa-j/
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        if(nums == null || nums.length < 2)
            return nums;
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
    public void mergeSort(int[] nums, int left, int right) {	// 需要左右边界确定排序范围
        if (left >= right) {
            return;
        }
        // int mid = (left + right) / 2;
        // Java 里有更优的写法，在 left 和 right 都是大整数时，即使溢出，结论依然正确
        // int mid = (left + right) >>> 1;

        int mid = left + (right - left) / 2;

        mergeSort(nums, left, mid);	// 先对左右子数组进行排序
        mergeSort(nums, mid+1, right);

        merge(nums, left, mid, right);
    }
    public void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];	// 临时数组存放合并结果
        int i = left, j = mid+1;
        int cur = 0;
        while (i <= mid && j <= right) {	//开始合并数组
            // 把当前数组人为地看成左右各一半，然后左右各自从头比较，插入。
            // 能这样做的原因是，左右各一半数组都是有序的？
            if (nums[i] <= nums[j]) { 	// 这里这个 = 号 ， 保证了算法的稳定性，即： 左侧的，依然在左侧
                temp[cur++] = nums[i++];
            } else {
                temp[cur++] = nums[j++];
            }
            // cur++;
        }
        
        // 处理剩下来的那个数组，挨个填进去就好
        while (i <= mid) {
            temp[cur++] = nums[i++];
        }
        while (j <= right) {
            temp[cur++] = nums[j++];
        }

        // 把临时数组挨个填进目标数组的应有位置
        // 保留问题，这里可以不使用额外的存储空间吗？
        for (int k = 0; k < temp.length; k++) {
            nums[left + k] = temp[k];
        }
    }
    /**
     * 6.快速排序
     * @param array
     * @param begin
     * @param end
     */
    public static void quickSort(int[] array, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }
    static int partition(int[] a, int begin, int end) {
        // pivot: 标杆位置，counter: 小于pivot的元素的个数
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (a[i] < a[pivot]) {
                int temp = a[counter]; a[counter] = a[i]; a[i] = temp;
                counter++;
            }
        }
        int temp = a[pivot]; a[pivot] = a[counter]; a[counter] = temp;
        return counter;
    }
    /**
     * 7.堆排序
     * @param array
     * @param length
     * @param i
     */
    static void heapify(int[] array, int length, int i) {
        int left = 2 * i + 1, right = 2 * i + 2;
        int largest = i;
        if (left < length && array[left] > array[largest]) {
            largest = left;
        }
        if (right < length && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = array[i]; array[i] = array[largest]; array[largest] = temp;
            heapify(array, length, largest);
        }
    }
    public static void heapSort(int[] array) {
        if (array.length == 0) return;
        int length = array.length;
        for (int i = length / 2-1; i >= 0; i--)
            heapify(array, length, i);
        for (int i = length - 1; i >= 0; i--) {
            int temp = array[0]; array[0] = array[i]; array[i] = temp;
            heapify(array, i, 0);
        }
    }
    /**
     * 8.计数排序
     * @param arr
     * @return
     */
    public static int[] countingSort(int[] arr) {
        /* 获取序列的最大值 */
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }

        int[] bucket = new int[maxValue + 1];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }

        int sortedIndex = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                arr[sortedIndex++] = i;
            }

        }
        // 其他写法
//        for (int j = 0; j < bucket.length; j++) {
//            while(bucket[j] > 0) {
//                arr[sortedIndex++] = j;
//                bucket[j]--;
//            }
//        }

        return arr;
    }
    /**
     * 9.桶排序
     * @param arr
     * @return
     */
    public static int[] bucketSort(int[] arr, int bucketSize) {
        if (arr == null || arr.length == 0) {
            return arr;
        }

        int minValue = 0, maxValue = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];                // 输入数据的最小值
            } else if (arr[i] > maxValue) {
                maxValue = arr[i];                // 输入数据的最大值
            }
        }

        // 桶的初始化
        int DEFAULT_BUCKET_SIZE = 5;            // 设置桶的默认数量为5
        bucketSize = bucketSize > 0 ? bucketSize : DEFAULT_BUCKET_SIZE;
        int bucketCount = (int)Math.floor((maxValue - minValue) / bucketSize) + 1;
        List<Integer>[] bucks = new ArrayList[bucketCount];
        for (int i = 0; i < bucks.length; i++) {
            bucks[i]=new ArrayList<>();
        }

        // 利用映射函数将数据分配到各个桶中
        for (int i = 0; i < arr.length; i++) {
            bucks[(int)Math.floor((arr[i] - minValue) / bucketSize)].add(arr[i]);
        }

        for (int i = 0; i < bucks.length; i++) {
            Collections.sort(bucks[i]);
        }

        int idx = 0;
        for (int i = 0; i < bucks.length; i++) {
            for (int j = 0; j < bucks[i].size(); j++) {
                arr[idx++]=bucks[i].get(j);
            }
        }

        return arr;
    }
    /**
     * 10.基数排序
     * @param arr
     * @return
     */
    public static int[] radixSort(int[] arr) {

        /* 创建一个10*arr.length的二维数组 */
        int[][] duck = new int[10][arr.length];
        /* 先获取最大值 */
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max) {
                max= (int)(arr[i]+1);
            }
        }

        for (int i = 1; max > 0; i *= 10) {
            /* 记录每个桶的下标 */
            int[] count = new int[10];

            for (int j = 0; j < arr.length; j++) {
                int t = (arr[j] / i) % 10;
                duck[t][count[t]++] = arr[j];
            }
            /* 将桶中的数放回原数组 等待下一位数的排序 */
            for (int j = 0, c = 0; j < 10; j++) {
                for (int k = 0; k < count[j]; k++) {
                    arr[c++] = duck[j][k];
                }
            }

            max /= i;
        }

        return arr;
    }
```