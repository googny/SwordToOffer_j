package algorithm.sort;

import java.util.Arrays;

/**
 * 有一个已经有序的数据序列，要求在这个已经排好的数据序列中插入一个数，
 * 但要求插入后此数据序列仍然有序，这个时候就要用到一种新的排序方法——插入排序法,
 * 插入排序的基本操作就是将一个数据插入到已经排好序的有序数据中，
 * 从而得到一个新的、个数加一的有序数据，算法适用于少量数据的排序，
 * 时间复杂度为O(n^2)。是稳定的排序方法。
 *
 * @author mti1301
 * @since 2015/7/1.
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 6, 1, 5, 9};
        new InsertSort().insertSort_binary(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void insertSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        for (int i = 0; i < nums.length - 1; ++i) {
            int toInsertEle = nums[i + 1];
            int cursor = i;
            while (cursor >= 0 && toInsertEle < nums[cursor]) {
                nums[cursor + 1] = nums[cursor];
                cursor--;
            }
            nums[cursor + 1] = toInsertEle;
        }
    }

    /**
     * 二分插入排序
     *
     * @param nums 待排序数组
     */
    public void insertSort_binary(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            int toInsertEle = nums[i];
            int low = 0;
            int high = i - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (toInsertEle < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            for (int j = i; j >= low + 1; j--) {
                nums[j] = nums[j - 1];
            }
            nums[low] = toInsertEle;
        }
    }
}
