package algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序是简单的排序算法，最多交换次数为 n +(n-1) + (n-2) + (n-3)+1 = (n+1)*n /2
 * 可以分为向左冒小泡和向右冒大泡
 * 以及两种常见的优化策略
 *
 * @author mti1301
 * @since 2015/6/30.
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 6, 1, 5, 9};
        new BubbleSort().bubbleSort_optimizeWithSwapPos(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void bubbleSort_maxBubbleToRight(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        for (int i = nums.length - 1; i >= 0; --i) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int bubble = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = bubble;
                }
            }
        }
    }

    public void bubbleSort_minBubbleToLeft(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            for (int j = nums.length - 1; j > i; --j) {
                if (nums[j - 1] > nums[j]) {
                    int bubble = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = bubble;
                }
            }
        }
    }

    /**
     * 冒泡排序优化算法--标志位 标志不发生交换即 排序完成
     *
     * @param nums
     */
    public void bubbleSort_optimizeWithFlag(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            boolean swap = false;
            for (int j = nums.length - 1; j > i; --j) {
                // 和小泡向左冒类似，只不过是从后向前扫描而已
                if (nums[j - 1] > nums[j]) {
                    int bubble = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = bubble;
                    swap = true;
                }
            }
            if (!swap) {
                // 如果泡已经沉底了，不再交换了那么说明排序完成
                break;
            }
        }
    }

    /**
     * 经过若干次冒泡，[0,i]之间是有序的，记录上次扫描过程中最后一次交换的位置 lastSwapPos，
     * 则[i,lastSwapPos]之间的元素也是有序的，否则，会继续交换的。
     *
     * @param nums 待排序的数组
     */
    public void bubbleSort_optimizeWithSwapPos(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int lastSwapPos = 0;
        int lastSwapPos_temp = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            lastSwapPos = lastSwapPos_temp;
            for (int j = nums.length - 1; j > lastSwapPos; --j) {
                if (nums[j - 1] > nums[j]) {
                    int bubble = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = bubble;
                    lastSwapPos_temp = j;
                }
            }
            if (lastSwapPos == lastSwapPos_temp) {
                break;
            }
        }
    }
}
