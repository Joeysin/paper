package com.joeysin.paper.algorithm.Tree;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Joeysin on  2018/10/30  15:01.
 * Describe：二叉树遍历
 * 前中后序遍历,区别是根的位置（前，中，后），也就意味着是左，有，根节点谁先获取
 * 中序遍历SortedTree后的结果是排好序的
 */
public class IteratorBT {
    private static Queue<Object> queue = new ConcurrentLinkedQueue();

    /**
     * Created by Joeysin on  2018/10/30  15:01.
     * Describe：前序遍历 根-左-右
     */
    public static void prevIterator(TreeNode root) {
        if (root == null) return;
        queue.offer(root.val);
        prevIterator(root.left);
        prevIterator(root.right);
    }

    /**
     * Created by Joeysin on  2018/10/30  15:02.
     * Describe：中序 左-根-在右
     */
    public static void middleIterator(TreeNode root) {
        if (root == null) return;
        middleIterator(root.left);
        queue.offer(root.val);
        middleIterator(root.right);
    }

    /**
     * Created by Joeysin on  2018/10/30  15:02.
     * Describe：后续 左-右-根
     */
    public static void behindIterator(TreeNode root) {
        if (root == null) return;
        behindIterator(root.left);
        behindIterator(root.right);
        queue.offer(root.val);
    }

    /**
     * Created by Joeysin on  2018/10/30  11:38.
     * Describe：遍历二叉树--递归法
     */
    public static void iteratorBT(TreeNode root) {
        if (root == null) return;
        queue.offer(root.val);
        iteratorBT(root.left);
        iteratorBT(root.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(6);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(0);
        treeNode.left.right = new TreeNode(4);
        treeNode.right = new TreeNode(8);
        treeNode.right.left = new TreeNode(7);
        treeNode.right.right = new TreeNode(9);
        behindIterator(treeNode);
        queue.stream().forEach(System.out::println);
    }
}
