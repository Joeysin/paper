package com.joeysin.paper.algorithm.Tree;


import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Joeysin on  2018/10/24  14:09.
 * Describe：计算所有可能的满二叉树
 * 满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。
 */
public class FullBinaryTree {
    static Map<Integer, List<TreeNode>> memo = new HashMap();


    public static List<TreeNode> allPossibleFBT(int N) {
        if (!memo.containsKey(N)) {
            List<TreeNode> ans = new LinkedList();
            if (N == 1) {
                ans.add(new TreeNode(0));
            } else if (N % 2 == 1) {
                for (int x = 0; x < N; ++x) {
                    //remainIndexCount = allIndexCount - currentIndexCount
                    int y = N - 1 - x;
                    for (TreeNode left : allPossibleFBT(x))
                        for (TreeNode right : allPossibleFBT(y)) {
                            TreeNode bns = new TreeNode(0);
                            bns.left = left;
                            bns.right = right;
                            ans.add(bns);
                        }
                }
            }
            memo.put(N, ans);
        }

        return memo.get(N);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(0);
        treeNode.right = new TreeNode(0);
//        treeNode.left.left = new TreeNode(0);
//        treeNode.left.right = new TreeNode(0);
//        treeNode.right.left = new TreeNode(0);
//        treeNode.right.right = new TreeNode(0);

        System.out.println(isSymmetric(treeNode));
    }


    /**
     * Created by Joeysin on  2018/10/26  14:57.
     * Describe：判断树是否「镜像」对称。子左树的左树=子右树的右树
     * 递归法
     */
    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    /**
     * Created by Joeysin on  2018/10/26  16:46.
     * Describe：迭代法
     */
    public static boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1 == null && t2 == null) {
                continue;
            }
            if (t1 == null || t2 == null) {
                return false;
            }
            if (t1.val != t2.val) {
                return false;
            }
            queue.offer(t1.left);
            queue.offer(t2.right);
            queue.offer(t1.right);
            queue.offer(t2.left);
        }
        return true;
    }

    public static Boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }
}
