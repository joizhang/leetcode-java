package com.joizhang.lcof.tree;

import java.util.Deque;
import java.util.LinkedList;

public class Codec {

    public static final String SEP = ",";

    public static final String NULL = "null";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder s = new StringBuilder();
        s.append("[");
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                s.append(NULL).append(SEP);
                continue;
            }
            s.append(cur.val).append(SEP);
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return s.append("]").toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        String[] nodes = data.substring(1, data.length() - 1).split(SEP);
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (i < nodes.length) {
            // 队列中存的都是父节点
            TreeNode parent = queue.poll();
            if (parent == null) {
                continue;
            }
            // 父节点对应的左侧子节点的值
            if (!nodes[i].equals(NULL)) {
                parent.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(parent.left);
            }
            i += 1;
            // 父节点对应的右侧子节点的值
            if (i < nodes.length && !nodes[i].equals(NULL)) {
                parent.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(parent.right);
            }
            i += 1;
        }
        return root;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = codec.deserialize("[1,2,3,null,null,4,5]");
        String s = codec.serialize(root);
        System.out.println(s);
    }
}
