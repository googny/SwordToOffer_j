package algorithm.search;

/**
 * 把一个数组最开始的若干元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如：数组{3,4,5,1,2}是{1,2,3,4,5}的一个旋转，该数组的最小元素为1
 *
 * @author mti1301
 * @since 2015/7/3.
 */
public class MinNumberInRotatedArray {

    public static void main(String[] args) {
        int[] nums = {6, 7, 2, 3, 4, 5};
        System.out.println(new MinNumberInRotatedArray().minNumberInRotatedArray(nums));
    }

    public int minNumberInRotatedArray(int[] nums) {
        if (nums == null) {
            return Integer.MIN_VALUE;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (end != start + 1) {
            mid = (start + end) / 2;
            if (nums[mid] > nums[start]) {
                start = mid;
            }
            if (nums[mid] < nums[end]) {
                end = mid;
            }
        }
        return nums[end];
    }
}
