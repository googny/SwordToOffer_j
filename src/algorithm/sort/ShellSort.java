package algorithm.sort;

import java.util.Arrays;

/**
 * 希尔排序(Shell Sort)是插入排序的一种。
 * 也称缩小增量排序，是直接插入排序算法的一种更高效的改进版本。
 * 希尔排序是非稳定排序算法。
 * 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；
 * 随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止。
 *
 * @author mti1301
 * @since 2015/7/7.
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] nums = {9, 1, 5, 8, 3, 7, 4, 6, 2};
        new ShellSort().shellSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void shellSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int increment = nums.length;
        do {
            increment = increment / 2;
            for (int i = increment; i < nums.length; i++) {
                if (nums[i] < nums[i - increment]) {
                    int toInsertEle = nums[i];
                    int j = i - increment;
                    for (; j >= 0 && toInsertEle < nums[j]; j -= increment) {
                        nums[j + increment] = nums[j];
                    }
                    nums[j + increment] = toInsertEle;
                }
            }
        } while (increment > 1);
    }
}
