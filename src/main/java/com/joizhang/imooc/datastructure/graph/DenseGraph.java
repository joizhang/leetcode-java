package com.joizhang.imooc.datastructure.graph;

import com.joizhang.imooc.datastructure.ArrayList;

/**
 * 稠密图 - 邻接矩阵
 *
 * @author joizhang
 */
public class DenseGraph implements Graph {

    /**
     * 节点数
     */
    private final int v;

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
    private final boolean[][] g;

    public DenseGraph(int n, boolean directed) {
        if (n < 0) {
            throw new IllegalArgumentException("Number of vertices must be non-negative.");
        }
        this.v = n;
        this.m = 0;
        this.directed = directed;
        g = new boolean[n][n];
    }

    @Override
    public int V() {
        return v;
    }

    @Override
    public int E() {
        return m;
    }

    @Override
    public void addEdge(int v, int w) {
        boolean valid = (v >= 0 && v < this.v) && (w >= 0 && w < this.v);
        if (!valid) {
            throw new IllegalArgumentException("Argument v and w must bigger than zero and less than vertex number.");
        }
        if (hasEdge(v, w)) {
            return;
        }
        g[v][w] = true;
        if (!directed) {
            g[w][v] = true;
        }
        m++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        boolean valid = (v >= 0 && v < this.v) && (w >= 0 && w < this.v);
        if (!valid) {
            throw new IllegalArgumentException("Argument v and w must bigger than zero and less than vertex number.");
        }
        return g[v][w];
    }

    @Override
    public Iterable<Integer> adj(int v) {
        ArrayList<Integer> adj = new ArrayList<>();
        for (int i = 0; i < this.v; i++) {
            if (g[v][i]) {
                adj.addLast(i);
            }
        }
        return adj;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(v).append(" vertices, ").append(m).append(" edges\n");
        for (int v = 0; v < this.v; v++) {
            for (int w = 0; w < this.v; w++) {
                if (hasEdge(v, w)) {
                    s.append(1).append(" ");
                } else {
                    s.append(0).append(" ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }

}
