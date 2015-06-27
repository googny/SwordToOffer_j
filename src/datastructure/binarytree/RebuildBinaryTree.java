package datastructure.binarytree;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果都不含重复数字。
 * 例如：输入前序遍历序列为{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
 * 则重建出二叉树，并输出它的头结点
 * <p/>
 * 扩展：
 * ① 如果去除不包含重复数字的假设呢？
 * ② 如果给出任意两种遍历，能否重建出二叉树？
 *
 * @author googny
 * @since 2015/6/27
 */
public class RebuildBinaryTree {

    public static void main(String[] args) {
        int[] fList = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] mList = {4, 7, 2, 1, 5, 3, 8, 6};
        System.out.println(new RebuildBinaryTree().construct(fList, mList));
    }

    /**
     * 根据前序遍历和中序遍历重建二叉树,利用递归遍历
     *
     * @param fList 前序遍历序列
     * @param mList 中序遍历序列
     * @return 重建出二叉树的根节点
     */
    public BinaryTreeNode construct(int[] fList, int[] mList) {
        // 假设fList 和 mList 同为null或同长度
        if (fList == null || fList.length == 0) return null;
        BinaryTreeNode root = new BinaryTreeNode(fList[0]);

        int cur = fList.length;
        for (int i = 0; i < mList.length; i++) {
            if (root.val == mList[i]) {
                cur = i;
            }
        }
        int[] leftFList = new int[cur];
        int[] leftMList = new int[cur];
        System.arraycopy(fList, 1, leftFList, 0, cur);
        System.arraycopy(mList, 0, leftMList, 0, cur);
        root.left = construct(leftFList, leftMList);

        int[] rightFList = new int[fList.length - cur - 1];
        int[] rightMList = new int[mList.length - cur - 1];
        System.arraycopy(fList, cur + 1, rightFList, 0, fList.length - cur - 1);
        System.arraycopy(mList, cur + 1, rightMList, 0, mList.length - cur - 1);
        root.right = construct(rightFList, rightMList);

        return root;
    }
}

class BinaryTreeNode {
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int val) {
        this.val = val;
    }
}
