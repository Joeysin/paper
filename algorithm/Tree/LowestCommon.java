package com.joeysin.paper.algorithm.Tree;


import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Joeysin on  2018/10/30  10:54.
 * Describe：leadCode 235
 * 找出给出的两个节点的公共祖先节点，自己可以为自己的祖先节点
 */
public class LowestCommon {


    /**
     * Created by Joeysin on  2018/10/30  11:32.
     * Describe：二叉搜索树中找祖先节点
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        int pV = p.val;
        int qV = q.val;
        int rootV = root.val;
        //如果比Root小那么去左树找，反之去右树找。等于得到返回当前节点
        if (Math.max(pV, qV) < rootV) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (Math.min(pV, qV) > rootV) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }


    /**
     * Created by Joeysin on  2018/10/30  11:32.
     * Describe：普通二叉树中寻找祖先节点  leadCode 236
     * 方式一：从Root节点向下找，两条链表都记录下来，然后在对比寻找公共节点
     * 方式二：递归从Root向下寻找:
     * 1.如果root==null返回null
     * 2.recursion left and right   if root==left  return left  if  root==right return right if  root==left && root==right return root
     */
    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        //方法二
        //这个方法会递归Root下的左右子树，最后会把左子树 || 右子树 找到的p,q 节点放在Left,right节点。
        // 其中某个节点找不到的话祖先节点就是另一个节点，因为自身可以为自身的祖先节点。
        // 找找到了的话 祖先节点为Root
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }



    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(5);
        treeNode.left.left = new TreeNode(6);
        treeNode.left.right = new TreeNode(2);
        treeNode.right = new TreeNode(1);
        treeNode.right.left = new TreeNode(0);
        treeNode.right.right = new TreeNode(8);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(1);
        TreeNode node = lowestCommonAncestor2(treeNode, left, right);
        System.out.println(node);
    }
}
