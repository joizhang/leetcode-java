package com.joizhang.lc.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 114. 二叉树展开为链表
 */
public class Q114FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                // 当前结点的左子树
                TreeNode next = cur.left;
                // 找到当前结点cur的左子树的最右叶子结点为predecessor
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                // 将predecessor.right赋值为当前结点的右子树
                predecessor.right = cur.right;
                // 当前结点的左子树断开连接
                cur.left = null;
                // 将当前结点的右子树设置为左子树
                cur.right = next;
            }
            cur = cur.right;
        }
    }

    public static void main(String[] args) {
        Q114FlattenBinaryTreeToLinkedList test = new Q114FlattenBinaryTreeToLinkedList();
        Codec codec = new Codec();
        TreeNode root = codec.deserialize("[1,2,5,3,4,null,6]");
        test.flatten(root);
        TreeNode cur = root;
        List<Integer> list = new ArrayList<>();
        while (cur != null) {
            list.add(cur.val);
            cur = cur.right;
        }
        System.out.println(list);
    }
}
