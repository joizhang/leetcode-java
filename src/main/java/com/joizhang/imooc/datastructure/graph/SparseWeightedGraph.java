package com.joizhang.imooc.datastructure.graph;

import com.joizhang.imooc.datastructure.ArrayList;

/**
 * 带权稀疏图 - 邻接表
 *
 * @param <W>
 * @author joizhang
 */
public class SparseWeightedGraph<W extends Number & Comparable<W>> implements WeightedGraph<W> {

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
    private final ArrayList<Edge<W>>[] g;

    @SuppressWarnings("unchecked")
    public SparseWeightedGraph(int n, boolean directed) {
        if (n < 0) {
            throw new IllegalArgumentException("Number of vertices must be non-negative.");
        }
        this.n = n;
        this.m = 0;
        this.directed = directed;
        this.g = new ArrayList[n];
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
    public void addEdge(Edge<W> e) {
        boolean valid = (e.v() >= 0 && e.v() < n) && (e.w() >= 0 && e.w() < n);
        if (!valid) {
            throw new IllegalArgumentException("Argument v and w must bigger than zero and less than vertex number.");
        }
        g[e.v()].addLast(new Edge<>(e));
        if (e.v() != e.w() && !directed) {
            g[e.w()].addLast(new Edge<>(e.w(), e.v(), e.weight()));
        }
        m++;
    }

    @Override
    public boolean hasEdge(Edge<W> e) {
        boolean valid = (e.v() >= 0 && e.v() < n) && (e.w() >= 0 && e.w() < n);
        if (!valid) {
            throw new IllegalArgumentException("Argument v and w must bigger than zero and less than vertex number.");
        }
        for (int i = 0; i < g[e.v()].getSize(); i++) {
            if (g[e.v()].get(i).equals(e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterable<Edge<W>> adj(int v) {
        return g[v];
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(n).append(" vertices, ").append(m).append(" edges\n");
        for (int v = 0; v < n; v++) {
            s.append(v).append(": ");
            for (Edge<W> w : g[v]) {
                s.append("( to:").append(w.w()).append(",wt:").append(w.weight()).append(")\t");
            }
            s.append("\n");
        }
        return s.toString();
    }
}
