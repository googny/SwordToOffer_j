package datastructure.array;

/**
 * 在一个二维数组中，每一行都是按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序，请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 * <p/>
 * 分析：只要是在有序的数据结构中查找整数，都不会是简单的使用暴力搜索
 *
 * @author googny
 * @since 2015/6/27
 */
public class FindInPartiallySortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 8, 9},
                {2, 4, 8, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(new FindInPartiallySortedMatrix().find(matrix, 7));
    }

    /**
     * 在有序数组（从左->右递增，从上->下递增）中，
     * 查找有无指定的元素
     *
     * @param matrix 有序数组
     * @param target 目标元素
     * @return 查找到返回true，否则返回false
     */
    public boolean find(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int col = cols - 1;
        int row = 0;
        while (row < rows && col >= 0) {
            int cursor = matrix[row][col];
            if (target == cursor) {
                System.out.println("row = " + row + ",col = " + col);
                return true;
            }
            if (target > cursor) {
                ++row;
            } else {
                --col;
            }
        }
        return false;
    }
}
