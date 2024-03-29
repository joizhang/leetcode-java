package com.joizhang.imooc.datastructure.graph;

import com.joizhang.imooc.datastructure.ArrayList;

/**
 * 稀疏图 - 邻接表
 *
 * @author joizhang
 */
public class SparseGraph implements Graph {

    /**
     * 节点数
     */
    private final int n;

    /**
     * 边数
     */
    private int m;

    /**
     * 是否为有向图
     */
    private final boolean directed;

    /**
     * 图的具体数据
     */
    private final ArrayList<Integer>[] g;

    @SuppressWarnings("unchecked")
    public SparseGraph(int n, boolean directed) {
        if (n < 0) {
            throw new IllegalArgumentException("Number of vertices must be non-negative.");
        }
        this.n = n;
        this.m = 0;
        this.directed = directed;
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
    }

    @Override
    public int V() {
        return n;
    }

    @Override
    public int E() {
        return m;
    }

    @Override
    public void addEdge(int v, int w) {
        boolean valid = (v >= 0 && v < n) && (w >= 0 && w < n);
        if (!valid) {
            throw new IllegalArgumentException("Argument v and w must bigger than zero and less than vertex number.");
        }
        g[v].addLast(w);

        // 稀疏图不允许平行边代价会很高

        if (v != w && !directed) {
            g[w].addLast(v);
        }
        m++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        boolean valid = (v >= 0 && v < n) && (w >= 0 && w < n);
        if (!valid) {
            throw new IllegalArgumentException("Argument v and w must bigger than zero and less than vertex number.");
        }
        return g[v].contains(w);
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return g[v];
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(n).append(" vertices, ").append(m).append(" edges\n");
        for (int v = 0; v < n; v++) {
            s.append(v).append(": ");
            for (int w : g[v]) {
                s.append(w).append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }

}
