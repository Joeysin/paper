package com.joeysin.paper.algorithm.Tree;

import lombok.Data;

@Data
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
