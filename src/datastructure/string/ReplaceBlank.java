package datastructure.string;

/**
 * 请实现一个函数，把字符串中的每个空格替换成"%20".
 * 例如输入"We are happy." 则输出"We%20are%20happy."
 *
 * @author googny
 * @since 2015/6/28
 */
public class ReplaceBlank {

    public void replaceBlank(char[] string, int originalLength) {
        if (string == null) return;
        int blankLength = 0;
        for (int i = originalLength - 1; i >= 0; --i) {
            if (string[i] == ' ') {
                ++blankLength;
            }
        }

        int requireLength = originalLength + blankLength * 2;
        if (requireLength > string.length) {
            return;
        }
        requireLength--;
        for (int i = originalLength - 1; i >= 0; --i) {
            if (string[i] != ' ') {
                string[requireLength--] = string[i];
            } else {
                string[requireLength--] = '0';
                string[requireLength--] = '2';
                string[requireLength--] = '%';
            }
        }
    }
}
