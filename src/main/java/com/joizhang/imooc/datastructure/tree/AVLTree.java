package com.joizhang.imooc.datastructure.tree;

import com.joizhang.imooc.datastructure.ArrayList;

/**
 * 平衡二叉树
 * <p>
 * 对于任意一个节点，左子树和右子树的高度差不能超过1
 *
 * @author joizhang
 */
public class AVLTree<E extends Comparable<E>> implements Tree<E>  {

    private class Node {
        E e;

        Node left;

        Node right;

        int height;

        Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
            this.height = 1;
        }
    }

    private Node root;

    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 判断该二叉树是否是一个二分搜索树
     */
    public boolean isBST() {
        ArrayList<E> list = new ArrayList<>(size);
        inOrder(root, list);
        for (int i = 1; i < list.getSize(); i++) {
            if (list.get(i - 1).compareTo(list.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 通过中序遍历二分搜索树获得有序列表
     */
    private void inOrder(Node node, ArrayList<E> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.addLast(node.e);
        inOrder(node.right, list);
    }

    /**
     * 判断该二叉树是否是一个平衡二叉树
     */
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        int balanceFactor = Math.abs(getBalanceFactor(node));
        if (balanceFactor > 1) {
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }

    public int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    /**
     * 获得 node 的平衡因子
     */
    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    @Override
    public void add(E e) {
        root = add(root, e);
    }

    /**
     * 递归的向以 node 为根的二分搜索树中插入元素 e
     *
     * @return 返回插入新节点后二分搜索树的根
     */
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        } else {
            node.e = e;
        }
        // 更新 height
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        // 计算平衡因子，维护平衡
        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor > 1) {
            if (getBalanceFactor(node.left) >= 0) {
                // LL
                // 右旋转
                return rightRotate(node);
            } else {
                // LR
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        } else if (balanceFactor < -1) {
            if (getBalanceFactor(node.right) <= 0) {
                // RR
                //左旋转
                return leftRotate(node);
            } else {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }

        }
        return node;
    }

    /**
     * <pre>
     * 对节点 y 进行向右旋转操作，返回旋转后新的根节点 x （新插入的节点再在 y 的 LL 导致不平衡）
     *        y                              x
     *       / \                           /   \
     *      x   T4     向右旋转 (y)        z     y
     *     / \       - - - - - - - ->    / \   / \
     *    z   T3                       T1  T2 T3 T4
     *   / \
     * T1   T2
     * </pre>
     */
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node t3 = x.right;
        // 向右旋转
        x.right = y;
        y.left = t3;
        // 更新height
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
        return x;
    }

    /**
     * <pre>
     * 对节点 y 进行向左旋转操作，返回旋转后新的根节点 x （新插入的节点再在 y 的 RR 导致不平衡）
     *     y                             x
     *   /  \                          /   \
     *  T1   x      向左旋转 (y)       y     z
     *      / \   - - - - - - - ->   / \   / \
     *    T2  z                     T1 T2 T3 T4
     *       / \
     *      T3 T4
     * </pre>
     */
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node t2 = x.left;
        // 向左旋转
        x.left = y;
        y.right = t2;
        // 更新height
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
        return x;
    }

    @Override
    public void remove(E e) {

    }

    @Override
    public boolean contains(E e) {
        return getNode(root, e) != null;
    }

    @Override
    public E get(E e) {
        Node node = getNode(root, e);
        return node == null ? null : node.e;
    }

    private Node getNode(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) == 0) {
            return node;
        } else if (e.compareTo(node.e) < 0) {
            return getNode(node.left, e);
        } else {
            return getNode(node.right, e);
        }
    }

}
