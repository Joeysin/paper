package com.joeysin.paper.algorithm;

/**
 * Created by Joeysin on  2018/10/29  13:44.
 * Describe：验证是否二叉搜索树||二叉排序树
 */
public class ValidSortedTree {


    public static boolean isValidBST(TreeNode root) {
        return check(root, null, null);
    }


    /**
     * Created by Joeysin on  2018/10/29  14:26.
     * Describe：递归
     */
    public static boolean check(TreeNode root, Integer min, Integer max) {

        if (root == null) {
            return true;
        }
        Integer rootV = root.val;

        if (min != null && rootV <= min) {
            return false;
        }
        if (max != null && rootV >= max) {
            return false;
        }
        return check(root.left, min, rootV)
                && check(root.right, rootV, max);
    }

    /**
     * Created by Joeysin on  2018/10/29  14:26.
     * Describe：中序遍历二叉树，并记录前继节点，
     * 左子树中最大的 小于 root 大于 右子树中最小的
     */
    static TreeNode prev = null;

    public static boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        //首先找到最左节点的值
        TreeNode left = root;
        while (left.left != null) {
            left = left.left;
        }
        prev = left;//树种最小的值
        return isValid(root);
    }

    private static boolean isValid(TreeNode root) {
        if (root == null) return true;
        if (!isValid(root.left)) return false;
        if (root != prev && root.val <= prev.val) return false;
        prev = root;
        return isValid(root.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(3);
        treeNode.left.left = new TreeNode(7);
        treeNode.left.right = new TreeNode(2);
        treeNode.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(8);
        System.out.println(isValidBST2(treeNode));

    }
}
