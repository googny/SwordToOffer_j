package algorithm.sort;

/**
 * 归并排序是建立在归并操作上的一种有效的排序算法,
 * 该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
 * 将已有序的子序列合并，得到完全有序的序列；
 * 即先使每个子序列有序，再使子序列段间有序。
 * 若将两个有序表合并成一个有序表，称为二路归并。
 * **稳定排序
 *
 * @author mti1301
 * @since 2015/7/1.
 */
public class MergeSort {
    /**
     * 二路归并
     * 原理：将两个有序表合并和一个有序表
     *
     * @param a      待排序数组
     * @param start1 第一个有序表的起始下标  start1 = start2 -1;
     * @param start2 第二个有序表的起始下标
     * @param end2   第二个有序表的结束小标
     */
    private static void merge(int[] a, int start1, int start2, int end2) {
        int[] tmp = new int[end2 - start1 + 1];
        int i = start1, j = start2, k = 0;
        while (i < start2 && j <= end2) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }
        while (i < start2) {
            tmp[k++] = a[i++];
        }
        while (j <= end2) {
            tmp[k++] = a[j++];
        }
        System.arraycopy(tmp, 0, a, start1, tmp.length);
    }

    /**
     * @param a     待排序数组
     * @param start 开始下标
     * @param len   每次归并的有序集合的长度
     */
    public static void mergeSort(int[] a, int start, int len) {
        int size = a.length;
        int mid = size / (len << 1);
        int c = size & ((len << 1) - 1);
//-------归并到只剩一个有序集合的时候结束算法-------//
        if (mid == 0)
            return;
//------进行一趟归并排序-------//
        for (int i = 0; i < mid; ++i) {
            start = i * 2 * len;
            merge(a, start, start + len, (len << 1) + start - 1);
        }
//-------将剩下的数和倒数一个有序集合归并-------//
        if (c != 0)
            merge(a, size - c - 2 * len, size - c, size - 1);
//-------递归执行下一趟归并排序------//
        mergeSort(a, 0, 2 * len);
    }

//    public static void mergeSort_diy(int[] nums, int start, int end) {
//        if (nums == null || nums.length < 2) {
//            return;
//        }
//        if (end - start < 2) return;
//        int mid = (end + start) / 2;
//        mergeSort_diy(nums, start, mid);
//        mergeSort_diy(nums, mid + 1, end);
//        merge(nums, start, mid + 1, end);
//    }

    public static void main(String[] args) {
        int[] a = new int[]{
                4, 3, 6, 1, 2, 5
        };
        mergeSort(a, 0, 1);
        for (int i = 0; i < a.length; ++i) {
            System.out.print(a[i] + " ");
        }
    }


}
