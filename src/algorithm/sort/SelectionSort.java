package algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序 是基础排序算法，是不稳定的，例如{5,5,3} 第一次排序之后 {5,3,5}
 *
 * @author mti1301
 * @since 2015/6/30.
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 6, 1, 5, 9};
        new SelectionSort().selectSort_withDoubleSelection(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 选择最小值进行排序
     *
     * @param nums 待排序数组
     */
    public void selectionSort_SelectMin(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            int select = nums[min];
            nums[min] = nums[i];
            nums[i] = select;
        }
    }

    /**
     * 选择最大值排序
     *
     * @param nums 待排序数组
     */
    public void selectionSort_SelectMax(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        for (int i = nums.length - 1; i > 0; --i) {
            int max = i;
            for (int j = i - 1; j > -1; --j) {
                if (nums[max] < nums[j]) {
                    max = j;
                }
            }
            int select = nums[max];
            nums[max] = nums[i];
            nums[i] = select;
        }
    }

    /**
     * 双向 选择排序
     *
     * @param nums
     */
    public void selectSort_withDoubleSelection(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int max = low;
            for (int i = low + 1; i <= high; ++i) {
                if (nums[max] < nums[i]) {
                    max = i;
                }
            }
            int tmp = nums[high];
            nums[high] = nums[max];
            nums[max] = tmp;
            high--;

            int min = high;
            for (int i = high; i >= low; i--) {
                if (nums[min] > nums[i]) {
                    min = i;
                }
            }
            tmp = nums[low];
            nums[low] = nums[min];
            nums[min] = tmp;
        }
    }
}
