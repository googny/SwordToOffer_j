package math;

/**
 * 实现一个函数，输入一个整数，输出该数二进制表示中的1的个数。
 * 注意：输入数字为负数的可能。
 *
 * @author mti1301
 * @since 2015/8/6.
 */
public class NumberOf1 {

    public static void main(String[] args) {
        System.out.println(new NumberOf1().numberof1_1(8));
    }

    public int numberof1(int n) { // 当输入负数时死循环
        int count = 0;
        while (n != 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }

    public int numberof1_1(int n) {
        int flag = 1;
        int count = 0;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag <<= 1;
        }
        return count;
    }

    /**
     * 把一个整数减去1，在和原整数做与运算，会把该整数最右边的一个1变为0。
     * 那么一个整数的二进制表示中有多少个1，就可以进行多少次这样的运算。
     *
     * @param n 待操作的整数
     * @return count
     */
    public int numberof1_2(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }


}
